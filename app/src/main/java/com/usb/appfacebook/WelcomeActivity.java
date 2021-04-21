package com.usb.appfacebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void cerrarSesion(){
        SharedPreferences preferencias=getSharedPreferences("datos",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("entrada","NO");
        editor.commit();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finishAffinity();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cerrar:
                cerrarSesion();
             break;
        }
        return super.onOptionsItemSelected(item);
    }
}