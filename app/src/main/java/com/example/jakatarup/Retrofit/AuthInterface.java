package com.example.jakatarup.Retrofit;

import com.example.jakatarup.Models.Responses;
import com.example.jakatarup.Models.Token;
import com.example.jakatarup.Models.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthInterface {

    @FormUrlEncoded
    @POST("login")
    Call<Token> getToken(@Field("username") String user,
                         @Field("password") String pass);

    @FormUrlEncoded
    @POST("register")
    Call<Responses> register(
            @Field("name") String name,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("jabatan") String jabatan,
            @Field("upt") String upt,
            @Field("phone") String phone,
            @Field("score") int score
    );

    @GET("user")
    Call<User> getUser(@Query("api_token") String token);
}
