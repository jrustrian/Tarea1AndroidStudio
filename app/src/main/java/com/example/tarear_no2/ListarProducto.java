package com.example.tarear_no2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tarear_no2.utilidades.Assets;

import java.util.ArrayList;

public class ListarProducto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_producto);

        try {

            ListView lvListaProducto = findViewById(R.id.lvListaProducto);

            ArrayAdapter arrayAdapter;
            ArrayList<String> listaProductos = new ArrayList<>();
            Connection conexion= new Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION);
            SQLiteDatabase sqLiteDatabase= conexion.getReadableDatabase();

            String query = "SELECT * FROM "+ Assets.TABLA_PRODUCTO;



            Cursor result= sqLiteDatabase.rawQuery( query,null);


            while ( result.moveToNext()){

                listaProductos.add("\n Cod:  "+result.getString(0)+
                        "\n Nombre:  "+result.getString(1)+
                        "\n Precio:  "+result.getString(2));
            }


            arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, listaProductos);
            lvListaProducto.setAdapter(arrayAdapter);

            Toast.makeText(getApplicationContext(),"Lista Mostrada", Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Error no se Puede mostrar lista",Toast.LENGTH_LONG).show();
        }
    }



    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnRegresar:
                intent = new Intent(this, MainActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}