package com.example.entregafinalmvp.interfaces.registroequipo;

import android.content.Context;

public interface RegistroEquipoPresenter {
    void registrarEquipo(String codigo, String nombre, String fecha,
                   String marca, String modelo,
                   String bolso, String cargador, String encendido,
                   String touchpad,String usb, String monitor,
                   String audio, String manual, String garantia,
                   Context context);
    void exito();
    void error();
    void setErrorCodigo();
    void setErrorNombre();
}
