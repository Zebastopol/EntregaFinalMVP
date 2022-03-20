package com.example.entregafinalmvp.interactor.registroequipo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.entregafinalmvp.interactor.bd.ConexionBD;
import com.example.entregafinalmvp.interfaces.registroequipo.RegistroEquipoInteractor;
import com.example.entregafinalmvp.presenter.registroequipo.RegistroEquipoPresenterImpl;

public class RegistroEquipoInteractorImpl implements RegistroEquipoInteractor {

    @Override
    public void registrar(String codigo, String nombre, String fecha,
                          String bolso, String cargador, RegistroEquipoPresenterImpl presenter, Context contexto) {
        if(codigo.equals("")){
            presenter.setErrorCodigo();
        }
        else if(nombre.equals("")){
            presenter.setErrorNombre();
        }
        else {
            //registrar en SQLite
            ConexionBD conexion = new ConexionBD(contexto, "administracion", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("nombre", nombre);
            registro.put("fecha", fecha);
            registro.put("bolso", bolso);
            registro.put("cargador", cargador);

            long x = bd.insert("registroequipo", null, registro);

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
}
