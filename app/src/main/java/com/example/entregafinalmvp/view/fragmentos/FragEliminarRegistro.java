package com.example.entregafinalmvp.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.entregafinalmvp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragEliminarRegistro#} factory method to
 * create an instance of this fragment.
 */
public class FragEliminarRegistro extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eliminar, container, false);
    }
}