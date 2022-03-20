package com.example.entregafinalmvp.interfaces.registroequipo;

import android.content.Context;

public interface RegistroEquipoInteractor {
    void registrar(String codigo, String nombre,
                   String fecha, String bolso, String cargador,
                   RegistroEquipoPresenterImpl presenter, Context contexto);
}
