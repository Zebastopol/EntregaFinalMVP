package com.example.entregafinalmvp.interfaces.registrouser;

import android.content.Context;

public interface RegistroInteractor {
    void registrar(String nombre, String user, String pass, RegistroPresenter presenter, Context context);
}
