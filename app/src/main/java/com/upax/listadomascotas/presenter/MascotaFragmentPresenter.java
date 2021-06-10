package com.upax.listadomascotas.presenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upax.listadomascotas.view.activities.DetalleFragment;
import com.upax.listadomascotas.view.activities.views.MascotaFragmentView;

public class MascotaFragmentPresenter implements MascotaFragmentView {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void obtenerDatosAPI() {

    }

    @Override
    public void muestraToast(String mensaje) {

    }

    @Override
    public void llenaRecyclerView() {

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void reemplazaFragment(DetalleFragment fragment, int position) {

    }
}
