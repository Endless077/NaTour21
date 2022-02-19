package com.example.test.Sandbox.Other;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.test.Entity.Utente;

public class LocalUser {

    public static void setLocalUser(Context c, Utente utente) {
        SharedPreferences sharedPreferences = c.getSharedPreferences("local_user",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", utente.getUsername());
        editor.putString("email", utente.getEmail());
        editor.putString("nome", utente.getNome());
        editor.putString("cognome", utente.getCognome());
        editor.putString("photolnk", utente.getPhotolnk());
        editor.commit();
    }

    public static Utente getLocalUser(Context c) {
        Utente utente = new Utente();
        SharedPreferences sharedPreferences = c.getSharedPreferences("local_user",MODE_PRIVATE);
        utente.setUsername(sharedPreferences.getString("username","Default Username"));
        utente.setEmail(sharedPreferences.getString("email","Default Email"));
        utente.setNome(sharedPreferences.getString("nome","Default Name"));
        utente.setCognome(sharedPreferences.getString("cognome","Default Cognome"));
        utente.setPhotolnk(sharedPreferences.getString("photolnk","Default Photo"));
        return utente;
    }

    public static void deleteLocalUser(Context c) {
        SharedPreferences sharedPreferences = c.getSharedPreferences("local_user",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

}
