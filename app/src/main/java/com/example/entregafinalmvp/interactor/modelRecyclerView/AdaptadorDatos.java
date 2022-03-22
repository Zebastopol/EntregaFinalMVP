package com.example.entregafinalmvp.interactor.modelRecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
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

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDatos.ViewHolderDator holder, int position) {
        Bitmap bit1 = listDatos.get(position).getB1();
        Bitmap bit2 = listDatos.get(position).getB2();
        String cod = listDatos.get(position).getCodigo();
        String nom = listDatos.get(position).getNombre();
        String fec = listDatos.get(position).getFecha();
        String bol = listDatos.get(position).getBolso();
        String car = listDatos.get(position).getCargador();

        holder.imagen1.setImageBitmap(bit1);
        holder.imagen2.setImageBitmap(bit2);
        holder.codigo.setText(cod);
        holder.nombre.setText(nom);
        holder.fecha.setText(fec);
        holder.bolso.setText(bol);
        holder.cargador.setText(car);

    }

    @Override
    public int getItemCount() { return listDatos.size(); }

    public class ViewHolderDator extends RecyclerView.ViewHolder {
        ImageView imagen1;
        ImageView imagen2;
        TextView codigo;
        TextView nombre;
        TextView fecha;
        TextView bolso;
        TextView cargador;

        public ViewHolderDator(@NonNull View itemView) {
            super(itemView);
            imagen1 = itemView.findViewById(R.id.img1);
            imagen2 = itemView.findViewById(R.id.img2);
            codigo = itemView.findViewById(R.id.txtCodigoIngreso);
            nombre = itemView.findViewById(R.id.txtNombreIngreso);
            fecha = itemView.findViewById(R.id.txtFechaIngreso);
            bolso = itemView.findViewById(R.id.txtBolsoEquipoL);
            cargador = itemView.findViewById(R.id.txtCargadorEquipoL);
        }
    }
}
