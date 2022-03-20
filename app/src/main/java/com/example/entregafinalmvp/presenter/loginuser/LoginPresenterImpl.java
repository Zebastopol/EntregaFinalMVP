package com.example.entregafinalmvp.presenter.loginuser;

import android.content.Context;

import com.example.entregafinalmvp.interactor.loginuser.LoginInteractorImpl;
import com.example.entregafinalmvp.interfaces.loginuser.LoginInteractor;
import com.example.entregafinalmvp.interfaces.loginuser.LoginPresenter;
import com.example.entregafinalmvp.interfaces.loginuser.LoginView;

public class LoginPresenterImpl implements LoginPresenter {
    LoginView vista;
    LoginInteractor interactor;

    public LoginPresenterImpl(LoginView vista) {
        this.vista = vista;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void validarUsuario(String user, String pass, Context contexto) {
        if(vista != null){
            vista.mostrarProgreso();
        }
        interactor.validarUsuario(user, pass, this, contexto);
    }

    @Override
    public void setErrorUser() {
        if(vista != null){
            vista.esconderProgreso();
            vista.setErrorUser();
        }
    }

    @Override
    public void setErrorPassword() {
        if(vista != null){
            vista.esconderProgreso();
            vista.setErrorPassword();
        }
    }

    @Override
    public void exito(String nombre) {
        if(vista != null){
            vista.esconderProgreso();
            vista.exito(nombre);
        }
    }

    @Override
    public void noExiste() {
        vista.noExiste();
        vista.esconderProgreso();
    }
}



