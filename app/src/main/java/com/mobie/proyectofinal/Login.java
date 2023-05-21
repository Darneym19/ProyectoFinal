package com.mobie.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Login extends AppCompatActivity {

    Button registrarse, ingresar;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1", null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registrarse = findViewById(R.id.bt_registro);
        ingresar = findViewById(R.id.bt_ingresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtusuario = findViewById(R.id.usser);
                EditText txtpassword = findViewById(R.id.password);

                try {
                    Cursor cursor = helper.validation(txtusuario.getText().toString(), txtpassword.getText().toString());
                    if (cursor.getCount()>0){
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Usuario o Contraseña Invalido",Toast.LENGTH_LONG).show();
                    }
                txtusuario.setText("");
                txtpassword.setText("");
                txtusuario.findFocus();
                }
                catch (SecurityException e){
                    e.printStackTrace();
                }
            }
        });
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_registro(view);
            }
        });
    }

    public void go_registro(View view){
        Intent i = new Intent(Login.this, Registro.class);
        startActivity(i);
    }
}