package com.example.jakatarup.Retrofit;

import com.example.jakatarup.Models.Tahanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TahananInterface {

    @FormUrlEncoded
    @POST("tahanan")
    Call<Tahanan> store(
            @Field("nama_lengkap") String namaLengkap,
            @Field("ttl") String ttl,
            @Field("alamat") String alamat,
            @Field("jenis_kelamin") String jenisKelamin,
            @Field("agama") String agama,
            @Field("kewarganegaraan") String kewarganegaraan,
            @Field("tindak_pidana") String tindakPidana,
            @Field("hukuman") String hukuman,
            @Field("residivis") String residivis,
            @Field("berapa_residivis") int berapaResidivis,
            @Field("score") String score,
            @Field("user_id") int userId
    );

}
