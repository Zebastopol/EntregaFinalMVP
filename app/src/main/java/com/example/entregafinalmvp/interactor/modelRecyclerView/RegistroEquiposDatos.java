package com.example.entregafinalmvp.interactor.modelRecyclerView;

import android.graphics.Bitmap;

public class RegistroEquiposDatos {

    private Bitmap b1;
    private Bitmap b2;
    private String codigo;
    private String nombre;
    private String fecha;
    private String marca;
    private String modelo;
    private String bolso;
    private String cargador;
    private String encendido;
    private String touchpad;
    private String usb;
    private String monitor;
    private String audio;
    private String manual;
    private String garantia;




    public RegistroEquiposDatos(Bitmap b1, Bitmap b2, String codigo, String nombre, String fecha, String marca, String modelo,
                                String bolso, String cargador, String encendido, String touchpad, String usb, String monitor,
                                String audio, String manual, String garantia){
        this.b1 = b1;
        this.b2 = b2;
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.marca = marca;
        this.modelo= modelo;
        this.bolso = bolso;
        this.cargador = cargador;
        this.encendido= encendido;
        this.touchpad = touchpad;
        this.usb      = usb;
        this.monitor  = monitor;
        this.audio    = audio;
        this.manual   = manual;
        this.garantia = garantia;
    }

    public Bitmap getB1() {
        return b1;
    }

    public void setB1(Bitmap b1) {
        this.b1 = b1;
    }

    public Bitmap getB2() {
        return b2;
    }

    public void setB2(Bitmap b2) {
        this.b2 = b2;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getBolso() {
        return bolso;
    }

    public void setBolso(String bolso) {
        this.bolso = bolso;
    }

    public String getCargador() {
        return cargador;
    }

    public void setCargador(String cargador) {
        this.cargador = cargador;
    }

    public String getMarca() { return marca;     }

    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo;  }

    public void setModelo(String modelo) { this.modelo = modelo;  }

    public String getEncendido() { return encendido;   }

    public void setEncendido(String encendido) { this.encendido = encendido;  }

    public String getTouchpad() { return touchpad; }

    public void setTouchpad(String touchpad) { this.touchpad = touchpad;  }

    public String getUsb() { return usb;  }

    public void setUsb(String usb) { this.usb = usb;  }

    public String getMonitor() { return monitor;    }

    public void setMonitor(String monitor) { this.monitor = monitor; }

    public String getAudio() { return audio; }

    public void setAudio(String audio) { this.audio = audio; }

    public String getManual() { return manual; }

    public void setManual(String manual) { this.manual = manual;   }

    public String getGarantia() {  return garantia;  }

    public void setGarantia(String garantia) { this.garantia = garantia;  }
}
