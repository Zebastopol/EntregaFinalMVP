package com.example.entregafinalmvp.interfaces.registrouser;

import android.content.Context;

public interface RegistroPresenter {
    void registrar(String nombre, String user, String pass, Context context);
    void error();
    void exito();
    void setErrorNombre();
    void setErrorUser();
    void setErrorPassword();
}
