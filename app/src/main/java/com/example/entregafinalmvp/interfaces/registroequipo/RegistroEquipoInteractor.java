package com.example.entregafinalmvp.interfaces.registroequipo;

import android.content.Context;

import com.example.entregafinalmvp.presenter.registroequipo.RegistroEquipoPresenterImpl;

public interface RegistroEquipoInteractor {
    void registrar(String codigo, String nombre,
                   String fecha, String bolso, String cargador,
                   RegistroEquipoPresenterImpl presenter, Context contexto);
}
