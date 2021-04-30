package com.usb.appfacebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abrir();
    }

    public void abrir(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                abrirInterfaz();
            }
        },3000);
    }

    public void abrirInterfaz(){
        SharedPreferences preferencias=getSharedPreferences("datos",
                                                   Context.MODE_PRIVATE );

        Intent intent=new Intent(getBaseContext(),LoginActivity.class);

        if(preferencias.getString("entrada","").equals("SI")){
           intent=new Intent(getBaseContext(),WelcomeActivity.class);
        }


        startActivity(intent);
        finishAffinity();

    }


}