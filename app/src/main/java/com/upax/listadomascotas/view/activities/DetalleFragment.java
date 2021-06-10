package com.upax.listadomascotas.view.activities;

import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.upax.listadomascotas.R;
import com.upax.listadomascotas.data.model.Mascota;

import java.util.List;


public class DetalleFragment extends Fragment {
    private static final String BASE_IMAGE = "https://cdn2.thedogapi.com/images/";
    View v;
    TextView tvDetalleName;
    TextView tvDetalleOrigin;
    TextView tvDetalleTemperament;
    ImageView ivDetalleImagen;
    int id;
    String imageUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detalle, container, false);
        tvDetalleName = (TextView)v.findViewById(R.id.tvDetalleName);
        tvDetalleOrigin = (TextView)v.findViewById(R.id.tvDetalleOrigin);
        tvDetalleTemperament = (TextView)v.findViewById(R.id.tvDetalleTemperament);
        ivDetalleImagen = (ImageView)v.findViewById(R.id.ivDetalleImagen);

        if(getArguments() != null){
            id = getArguments().getInt("id");
            List<Mascota> mascotas = (List<Mascota>)getArguments().getSerializable("mascotas");
            Log.d("id", String.valueOf(id));
            for (int i = 0; i < mascotas.size(); i++){
                if (mascotas.get(i).getId() == id){
                    tvDetalleName.setText(mascotas.get(i).getName());
                    tvDetalleOrigin.setText(mascotas.get(i).getOrigin());
                    tvDetalleTemperament.setText(mascotas.get(i).getTemperament());
                    imageUrl = BASE_IMAGE + mascotas.get(i).getReference_image_id() + ".jpg";
                }
            }
            Picasso.with(getActivity().getBaseContext())
                    .load(imageUrl)
                    .placeholder(android.R.drawable.sym_def_app_icon)
                    .error(android.R.drawable.sym_def_app_icon)
                    .into(ivDetalleImagen);
        }
        return v;
    }
}