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
        public void registrar(String codigo, String nombre, String fecha, String bolso, String cargador, Context contexto) {
            interactor.registrar(codigo, nombre, fecha, bolso, cargador, this, contexto);
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


