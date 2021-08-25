package com.example.keycloakauthpractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //Following are the objects for the widgets on the xml file
    private EditText emailTxt;
    private EditText passwordTxt;

    private AppCompatButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning the ids to the objects
        emailTxt=findViewById(R.id.email_login);
        passwordTxt=findViewById(R.id.password_login);
        loginBtn=findViewById(R.id.loginBtn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAcessToken();
            }
        });


    }



    //Following will be the method, to get the acess token
    public void getAcessToken(){

        //Getting the service, with get data service class
        GetDataService service=RetrofitClinetInstance.getRetrofitInstance().create(GetDataService.class);

        //Getting the username and password
        String password=  passwordTxt.getText().toString();
        String username= emailTxt.getText().toString();

        Call<AcessToken> call= service.getAcessToken("Login","password","bb268a38-4d9d-4683-a00e-78bcf0a7e6c6",
                "openid", username,password);

        call.enqueue(new Callback<AcessToken>() {
            @Override
            public void onResponse(Call<AcessToken> call, Response<AcessToken> response) {
                if (response.isSuccessful()){


                    //Now, adding teh next activity
                    Intent i=new Intent(getApplicationContext(),MenuActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Some Error Occured"+response.errorBody(), Toast.LENGTH_LONG).show();
                    Log.e("Error",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<AcessToken> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error: "+t, Toast.LENGTH_LONG).show();
                Log.e("Error","Error: "+t);

            }
        });

    }
}