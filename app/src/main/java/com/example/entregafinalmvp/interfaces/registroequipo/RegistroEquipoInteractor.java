package com.example.entregafinalmvp.interfaces.registroequipo;

import android.content.Context;

import com.example.entregafinalmvp.presenter.registroequipo.RegistroEquipoPresenterImpl;

public interface RegistroEquipoInteractor {
    void registrarEquipo(String codigo, String nombre,
                   String fecha,  String marca, String modelo,
                   String bolso, String cargador,
                   String encendido, String touchpad,
                   String usb, String monitor, String audio,
                   String manual, String garantia,
                   RegistroEquipoPresenterImpl presenter, Context context);
}
