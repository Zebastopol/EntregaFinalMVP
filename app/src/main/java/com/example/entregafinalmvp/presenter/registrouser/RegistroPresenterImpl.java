package com.example.entregafinalmvp.presenter.registrouser;

import android.content.Context;

import com.example.entregafinalmvp.interactor.registrouser.RegistroInteractorImpl;
import com.example.entregafinalmvp.interfaces.registrouser.RegistroInteractor;
import com.example.entregafinalmvp.interfaces.registrouser.RegistroPresenter;
import com.example.entregafinalmvp.interfaces.registrouser.RegistroView;

public class RegistroPresenterImpl implements RegistroPresenter {

    RegistroView        vista;
    RegistroInteractor  interactor;

    public RegistroPresenterImpl(RegistroView vista){
        this.vista = vista;
        interactor = new RegistroInteractorImpl();
    }

    @Override
    public void registrar(String nombre, String user, String pass, Context context){
        interactor.registrar(nombre, user, pass, this, contexto);
    }
    @Override
    public void error() {
        vista.error();
    }

    @Override
    public void exito() {
        vista.exito();
    }

    @Override
    public void setErrorNombre() {
        vista.setErrorNombre();
    }

    @Override
    public void setErrorUser() {
        vista.setErrorUser();
    }

    @Override
    public void setErrorPassword() {
        vista.setErrorPassword();
    }
}
