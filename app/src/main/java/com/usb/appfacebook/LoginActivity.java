package com.usb.appfacebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.usb.appfacebook.modelo.Credencial;

public class LoginActivity extends AppCompatActivity {

    private EditText usertext;
    private EditText passtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usertext=findViewById(R.id.usertext);
        passtext=findViewById(R.id.passtext);
    }


    public void validar(View view){
        Credencial credencial=new Credencial();
        String user=usertext.getText().toString();
        String pass=passtext.getText().toString();
        SharedPreferences preferencias=getSharedPreferences("datos",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();

        int ret=credencial.validar(user,pass);
        if(ret==1){
            editor.putString("entrada","SI");
            Intent intent=new Intent(this,WelcomeActivity.class);
           // Log.d("entrada",preferencias.getString("entrada",null));
            startActivity(intent);
            finishAffinity();
        }
        else if(ret==0){
            editor.putString("entrada","NO");
            Toast.makeText(this,"Acceso Invalido!!",Toast.LENGTH_SHORT).show();
        }
        editor.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.acerca:
               String mensaje="Desarrollador por El equipo de\n" +
                       "complementaria 2";
                    Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}