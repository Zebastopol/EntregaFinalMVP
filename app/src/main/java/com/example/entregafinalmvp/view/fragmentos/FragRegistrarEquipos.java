package com.example.entregafinalmvp.view.fragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entregafinalmvp.R;
import com.example.entregafinalmvp.interfaces.registroequipo.RegistroEquipoPresenter;
import com.example.entregafinalmvp.presenter.registroequipo.RegistroEquipoPresenterImpl;
import com.example.entregafinalmvp.view.actividades.otraActividad;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragRegistrarEquipos extends AppCompatActivity {

    //Campos de texto del formulario

    TextView txtFecha;
    EditText txtCodigoIngreso, txtNombreIngreso;
    Switch swBolso, sw1Bolso, sw2Encendido
            ,sw3TouchPad, sw4Usb, sw5Monitor,sw6Audio;
    //variables para trabajar con los nombres de las fotos
    String f = "";                                          //botones para tomar foto 1, foto 2 y registro
    ImageView img1, img2;                                   //ImageView para fotos
    Button btnFoto1, btnFoto2, btnRegistrarEquipo;
    RadioButton rd1SiCargador, rd2NoCargador, rd3SiGarantia
            ,rd4RdNoGarantia, rd5SiManual, rd6NoManual;

    RegistroEquipoPresenter presenter;                      //presentador MVP

    ImageButton btnReturn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_registro_equipo, container, false);

        //para traer la fecha actual
        Calendar calendar = Calendar.getInstance(); // Returns instance with current date and time set
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        f = formatter.format(calendar.getTime());
        txtFecha.setText(f);

        //campos de texto formulario
        txtFecha = v.findViewById(R.id.txtFechaIngreso);
        txtCodigoIngreso = v.findViewById(R.id.txtCodigoIngreso);
        txtNombreIngreso = v.findViewById(R.id.txtNombreIngreso);

        //switch
        swBolso = v.findViewById(R.id.sw1Bolso);
        sw2Encendido = v.findViewById(R.id.sw2Encendido);
        sw3TouchPad  = v.findViewById(R.id.sw3Touchpad);
        sw4Usb       = v.findViewById(R.id.sw4Usb);
        sw5Monitor   = v.findViewById(R.id.sw5Monitor);
        sw6Audio     = v.findViewById(R.id.sw6Audio);




        //radio cargador
        rd1SiCargador = v.findViewById(R.id.rd1SiCargador);
        rd2NoCargador = v.findViewById(R.id.rd2NoCargador);
        rd3SiGarantia = v.findViewById(R.id.rd3SiGarantia);
        rd4RdNoGarantia = v.findViewById(R.id.rd4NoGarantía);
        rd5SiManual     = v.findViewById(R.id.rd5SiManual);
        rd6NoManual     = v.findViewById(R.id.rd6Manual);


        //presentador
        presenter = new RegistroEquipoPresenterImpl(this);



        //ImageView para fotos
        btnFoto1 = v.findViewById(R.id.btnFoto1);
        btnFoto2 = v.findViewById(R.id.btnFoto2);

        //btn para registrar
        btnRegistrarEquipo = v.findViewById(R.id.btnRegistrarEquipo);

        //btn return Nav
        btnReturn = v.findViewById(R.id.btnReturn);

        //ImageView para fotos
        img1 = v.findViewById(R.id.img1);
        img2 = v.findViewById(R.id.img2);

        btnFoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((otraActividad) getActivity()).permisosCamara1(img1);
            }
        });

        btnFoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((otraActividad) getActivity()).permisosCamara2(img2);
            }
        });

        btnRegistrarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarRegistro();
            }
        });

        return v;
    }

        btnReturn.setOnClickListener(new View.OnClickListener()
                @Override
                public void onClick(View view){
                        solicitarRegistro();
                }
    )

    @Override
    public void exito() {
        Toast.makeText(getContext(), "REGISTRO OK", Toast.LENGTH_SHORT).show();
        ((OtraActividad) getActivity()).permisosAlmacenamiento(txtCodigoIngreso.getText().toString());
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "No se pudo registrar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorCodigo() {
        txtCodigo.setError("Complete el campo código");
    }

    @Override
    public void setErrorNombre() {
        txtNombre.setError("Complete el campo nombre");
    }

    public void solicitarRegistro() {
        String bolso = "NO";
        String cargador = "NO";

        if (rdSiCargador.isChecked()) {
            cargador = "SI";
        }
        if (swBolso.isChecked()) {
            bolso = "SI";
        }

        presenter.registrar(txtCodigo.getText().toString(), txtNombre.getText().toString(), f, bolso, cargador, getContext());
    }

    public static void mostrarImagen(ImageView img, Bitmap bitmap) {
        img.setImageBitmap(bitmap);
    }


}