package com.example.jakatarup.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tahanan {

    @SerializedName("user_id")
    @Expose
    private int userId;

    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;

    @SerializedName("ttl")
    @Expose
    private String ttl;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;

    @SerializedName("agama")
    @Expose
    private String agama;

    @SerializedName("kewarganegaraan")
    @Expose
    private String kewarganegaraan;

    @SerializedName("tindak_pidana")
    @Expose
    private String tindakPidana;

    @SerializedName("hukuman")
    @Expose
    private String hukuman;

    @SerializedName("residivis")
    @Expose
    private String residivis;

    @SerializedName("berapa_residivis")
    @Expose
    private String berapaResidivis;

    @SerializedName("score")
    @Expose
    private String score;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getTindakPidana() {
        return tindakPidana;
    }

    public void setTindakPidana(String tindakPidana) {
        this.tindakPidana = tindakPidana;
    }

    public String getHukuman() {
        return hukuman;
    }

    public void setHukuman(String hukuman) {
        this.hukuman = hukuman;
    }

    public String getResidivis() {
        return residivis;
    }

    public void setResidivis(String residivis) {
        this.residivis = residivis;
    }

    public String getBerapaResidivis() {
        return berapaResidivis;
    }

    public void setBerapaResidivis(String berapaResidivis) {
        this.berapaResidivis = berapaResidivis;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
