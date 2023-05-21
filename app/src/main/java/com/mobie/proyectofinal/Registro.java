package com.mobie.proyectofinal;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {

    Button registrar, regresar;
    EditText usuario, contraseña;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1", null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        registrar = findViewById(R.id.register);
        regresar = findViewById(R.id.back);
        usuario = findViewById(R.id.new_user);
        contraseña = findViewById(R.id.new_password);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                helper.insert(String.valueOf(usuario.getText()), String.valueOf(contraseña.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(), "Usuario creado con exito", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });
    }
}