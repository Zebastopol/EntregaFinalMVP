package com.example.entregafinalmvp.interactor.registroequipo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.entregafinalmvp.interactor.bd.ConexionBD;
import com.example.entregafinalmvp.interfaces.registroequipo.RegistroEquipoInteractor;
import com.example.entregafinalmvp.presenter.registroequipo.RegistroEquipoPresenterImpl;

public class RegistroEquipoInteractorImpl implements RegistroEquipoInteractor {

    @Override
    public void registrarEquipo(String codigo, String nombre, String fecha,
                          String marca, String modelo,
                          String bolso, String cargador,
                          String encendido,String touchpad,String usb, String monitor,
                          String audio, String manual, String garantia,
                          RegistroEquipoPresenterImpl presenter, Context context) {
        if(codigo.equals("")){
            presenter.setErrorCodigo();
        }
        else if(nombre.equals("")){
            presenter.setErrorNombre();
        }
        else {
            //registrar en SQLite
            ConexionBD conexion = new ConexionBD(context, "administracion", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("nombre", nombre);
            registro.put("fecha", fecha);
            registro.put("marca", marca);
            registro.put("modelo", modelo);
            registro.put("bolso", bolso);
            registro.put("encendido", cargador);
            registro.put("touchpad", cargador);
            registro.put("usb", cargador);
            registro.put("monitor", cargador);
            registro.put("audio", cargador);
            registro.put("manual", cargador);
            registro.put("garantia", cargador);



            long x = bd.insert("equipos", null, registro);

            if(x > 0){
                presenter.exito();
            }
            else{
                presenter.error();
            }

            bd.close();

            presenter.exito();
        }
    }


    }

