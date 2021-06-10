package com.upax.listadomascotas.view.activities.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upax.listadomascotas.view.activities.DetalleFragment;

public interface MascotaFragmentView {
    View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    void obtenerDatosAPI();
    void muestraToast(String mensaje);
    void llenaRecyclerView();
    void onItemClick(int position);
    void reemplazaFragment(DetalleFragment fragment, int position);
}
