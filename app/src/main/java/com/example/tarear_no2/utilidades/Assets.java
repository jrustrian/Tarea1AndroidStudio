package com.example.tarear_no2.utilidades;

public class Assets {
    public static int DB_VERSION=1;
    public static String DB_NAME="BD_INVENTARIO1";

    public static String TABLA_PRODUCTO= "PRODUCTO";
    public static String CAMPO_CODIGO_PRODUCTO="COD_PRODUCTO";
    public static String CAMPO_NOMBRE_PRODUCTO="NOMBRE";
    public static String CAMPO_PRECIO_PRODUCTO="PRECIO";

    public static final String CREAR_TABLA_PRODUCTO="CREATE TABLE " + TABLA_PRODUCTO +
            "("+ CAMPO_CODIGO_PRODUCTO+" TEXT primary key,"
            + CAMPO_NOMBRE_PRODUCTO+" TEXT,"
            + CAMPO_PRECIO_PRODUCTO+" REAL)";
}
