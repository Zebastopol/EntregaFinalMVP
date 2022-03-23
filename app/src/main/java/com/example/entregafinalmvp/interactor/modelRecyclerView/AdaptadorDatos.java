package com.example.entregafinalmvp.interactor.modelRecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entregafinalmvp.R;

import java.util.ArrayList;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderDator> {

    ArrayList<RegistroEquiposDatos> listDatos;
    Context context;

    public AdaptadorDatos(ArrayList<RegistroEquiposDatos> listDatos, Context context) {
        this.listDatos = listDatos;
        this.context   = context;
    }

    @NonNull
    @Override
    public AdaptadorDatos.ViewHolderDator onCreateViewHolderDator(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_registro_equipo,null,false);
        return new  ViewHolderDator(view);
    }

   /* @NonNull
    @Override
    public ViewHolderDator onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }*/

    @NonNull
    @Override
    public ViewHolderDator onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDatos.ViewHolderDator holder, int position) {
        Bitmap bit1 = listDatos.get(position).getB1();
        Bitmap bit2 = listDatos.get(position).getB2();
        String cod = listDatos.get(position).getCodigo();
        String nom = listDatos.get(position).getNombre();
        String fec = listDatos.get(position).getFecha();
        String mar = listDatos.get(position).getMarca();
        String mod = listDatos.get(position).getModelo();
        String bol = listDatos.get(position).getBolso();
        String car = listDatos.get(position).getCargador();
        String enc = listDatos.get(position).getEncendido();
        String tou = listDatos.get(position).getTouchpad();
        String usb = listDatos.get(position).getUsb();
        String mon = listDatos.get(position).getMonitor();
        String aud = listDatos.get(position).getAudio();
        String man = listDatos.get(position).getManual();
        String gar = listDatos.get(position).getGarantia();

        holder.imagen1.setImageBitmap(bit1);
        holder.imagen2.setImageBitmap(bit2);
        holder.codigo.setText(cod);
        holder.nombre.setText(nom);
        holder.fecha.setText(fec);
        holder.marca.setText(mar);
        holder.modelo.setText(mod);
        holder.bolso.setText(bol);
        holder.cargador.setText(car);
        holder.encendido.setText(enc);
        holder.touchpad.setText(tou);
        holder.usb.setText(usb);
        holder.monitor.setText(mon);
        holder.audio.setText(aud);
        holder.manual.setText(man);
        holder.garantia.setText(gar);


    }

    @Override
    public int getItemCount() { return listDatos.size(); }

    public class ViewHolderDator extends RecyclerView.ViewHolder {
        ImageView imagen1;
        ImageView imagen2;
        TextView codigo;
        TextView nombre;
        TextView fecha;
        TextView marca;
        TextView modelo;
        TextView bolso;
        TextView cargador;
        TextView encendido;
        TextView touchpad;
        TextView usb;
        TextView monitor;
        TextView audio;
        TextView manual;
        TextView garantia;







        public ViewHolderDator(@NonNull View itemView) {
            super(itemView);
            imagen1 = itemView.findViewById(R.id.img1);
            imagen2 = itemView.findViewById(R.id.img2);
            codigo = itemView.findViewById(R.id.txtCodigoIngreso);
            nombre = itemView.findViewById(R.id.txtNombreIngreso);
            fecha = itemView.findViewById(R.id.txtFechaIngreso);
            marca = itemView.findViewById(R.id.txtMarca);
            modelo= itemView.findViewById(R.id.txtModelo);
            bolso = itemView.findViewById(R.id.sw1Bolso);
            cargador = itemView.findViewById(R.id.rd1SiCargador);
            encendido= itemView.findViewById(R.id.sw2Encendido);
            touchpad = itemView.findViewById(R.id.sw3Touchpad);
            usb      = itemView.findViewById(R.id.sw4Usb);
            monitor  = itemView.findViewById(R.id.sw5Monitor);
            audio    = itemView.findViewById(R.id.sw6Audio);
            manual   = itemView.findViewById(R.id.rd5SiManual);
            garantia = itemView.findViewById(R.id.rd3SiGarantia);

        }
    }
}
