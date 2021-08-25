package com.example.keycloakauthpractise;

import com.google.gson.annotations.SerializedName;

public class AcessToken {

    @SerializedName("acess_token")
    private String acessToken;

    @SerializedName("expires_in")
    private Integer expiresIn;

    @SerializedName("refresh_expires_in")
    private Integer refresh_expires_in;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("token_type")
    private String token_type;

    @SerializedName("id_token")
    private String idToken;

    @SerializedName("not-before-policy")
    private Integer notBeforePolicy;

    @SerializedName("session_state")
    private String sessionState;

    @SerializedName("scope")
    private String scope;


    public AcessToken(String acessToken, Integer expiresIn)
    {
        this.acessToken=acessToken;
        this.expiresIn=expiresIn;
    }

}
