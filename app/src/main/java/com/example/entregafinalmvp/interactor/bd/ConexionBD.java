package com.example.entregafinalmvp.interactor.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBD extends SQLiteOpenHelper {
    public ConexionBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
                bd.execSQL("create table usuarios(user text primary key,nombre text, pass text)");
                bd.execSQL("create table equipos(codigo int primary key, marca text" +
                            ", modelo text, fecha text, cargador text, manual text, garantia text"+
                            ", encendido text, monitor text, audio text, touchpad text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
