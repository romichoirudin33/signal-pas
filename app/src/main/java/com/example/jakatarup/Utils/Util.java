package com.example.jakatarup.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class Util {

    public String TAG = "respon";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // shared pref mode
    int PRIVATE_MODE = 0;
    // Shared preferences file name
    private static final String PREF_NAME = "token_login";
    private static final String TOKEN = "token", IS_LOGIN="status";
    private static final String USER_ID = "user_id";
    private static final String NAME = "name";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String ROLE = "role";
    private static final String PICTURE = "avatar.png";

    ProgressDialog dialog;

    public Util(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void simpanToken(String token) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public void simpanUser(Integer user_id, String name, String email, String picture){
        editor.putString(USER_ID, String.valueOf(user_id));
        editor.putString(NAME, name);
        editor.putString(EMAIL, email);
        editor.putString(PICTURE, picture);
        editor.commit();
    }

    public String getUserId() {
        return pref.getString(USER_ID, null);
    }

    public String getToken() {
        return pref.getString(TOKEN, null);
    }

    public String getName() {
        return pref.getString(NAME, null);
    }

    public boolean cekLogin() { return pref.getBoolean(IS_LOGIN, false);}

    public void LogoutSession(){
        editor.clear();
        editor.commit();
    }

    public void showDialog(String pesan){
        dialog = ProgressDialog.show(_context,"Proses", pesan);
    }

    public void hideDialog(){
        dialog.dismiss();
    }

    public void pindahActivity(Class<?> tujuan) {
        _context.startActivity(new Intent(_context, tujuan));
    }
}
