package com.example.entregafinalmvp.presenter.registroequipo;

import android.content.Context;

import com.example.entregafinalmvp.interactor.registroequipo.RegistroEquipoInteractorImpl;
import com.example.entregafinalmvp.interfaces.registroequipo.RegistroEquipoInteractor;
import com.example.entregafinalmvp.interfaces.registroequipo.RegistroEquipoPresenter;
import com.example.entregafinalmvp.interfaces.registroequipo.RegistroEquipoView;

public class RegistroEquipoPresenterImpl implements RegistroEquipoPresenter {
        RegistroEquipoView vista;
        RegistroEquipoInteractor interactor;

        public RegistroEquipoPresenterImpl(RegistroEquipoView vista) {
            this.vista = vista;
            this.interactor = new RegistroEquipoInteractorImpl();
        }

        @Override
        public void registrarEquipo(String codigo, String nombre, String fecha,
                              String marca, String modelo,
                              String bolso, String cargador, String encendido, String touchpad,
                              String usb, String monitor, String audio, String manual,
                              String garantia, Context context) {
            interactor.registrarEquipo(codigo, nombre, fecha, marca, modelo,
                                bolso, cargador, encendido,touchpad,
                                usb,monitor, audio, manual, garantia,this, context);
        }



    @Override
        public void exito() {
            vista.exito();
        }

        @Override
        public void error() {
            vista.error();
        }

        @Override
        public void setErrorCodigo() {
            vista.setErrorCodigo();
        }

        @Override
        public void setErrorNombre() {
            vista.setErrorNombre();
        }
}


