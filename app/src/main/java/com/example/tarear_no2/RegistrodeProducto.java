package com.example.tarear_no2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarear_no2.utilidades.Assets;


public class RegistrodeProducto extends AppCompatActivity {

EditText codigo, nombre, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrode_producto);
        this.codigo = findViewById(R.id.editTextCodigo);
        this.nombre = findViewById(R.id.editTextNombreProducto);
        this.precio = findViewById(R.id.editTextPrecio);
    }

    private void registrarProducto(){
        try {
            Connection conexion= new Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION);
            SQLiteDatabase sqLiteDatabase= conexion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Assets.CAMPO_CODIGO_PRODUCTO, codigo.getText().toString());
            values.put(Assets.CAMPO_NOMBRE_PRODUCTO, nombre.getText().toString());
            values.put(Assets.CAMPO_PRECIO_PRODUCTO, precio.getText().toString());

            long result= sqLiteDatabase.insert(Assets.TABLA_PRODUCTO, Assets.CAMPO_CODIGO_PRODUCTO, values);
            Toast.makeText(getApplicationContext(),"Producto Registrado", Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Error al Guardar",Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnGuardar:
                this.registrarProducto();
                break;
            case R.id.btnPrincipal:
                intent = new Intent(this, MainActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }


}