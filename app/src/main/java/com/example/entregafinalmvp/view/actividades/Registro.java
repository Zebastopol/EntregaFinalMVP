package com.example.entregafinalmvp.view.actividades;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.entregafinalmvp.R;
import com.example.entregafinalmvp.interfaces.registrouser.RegistroView;
import com.example.entregafinalmvp.presenter.registrouser.RegistroPresenterImpl;


public class Registro extends AppCompatActivity implements RegistroView {

   EditText txtNombre, txtUser1, txtPass1;
   Button   btnRegistrar;

   RegistroPresenterImpl presentador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtNombre = findViewById(R.id.txtNombre);
        txtUser1  = findViewById(R.id.txtUser1);
        txtPass1  = findViewById(R.id.txtPass1);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        presentador = new RegistroPresenterImpl(this);

    }

    public void registro(View view) {
        presentador.registrar(txtNombre.getText().toString(),
                txtUser1.getText().toString(),
                txtPass1.getText().toString(), this);
    }


    @Override
    public void exito() {
        Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Error: No se pudo registrar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorNombre() {
        txtNombre.setError("Complete el campo");
    }

    @Override
    public void setErrorUser() {
        txtUser1.setError("Complete el campo");
    }

    @Override
    public void setErrorPassword() {
        txtPass1.setError("Complete el campo");
    }
}