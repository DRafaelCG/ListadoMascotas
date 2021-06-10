package com.upax.listadomascotas.view.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.upax.listadomascotas.R;
import com.upax.listadomascotas.data.api.MascotaServicioAPI;
import com.upax.listadomascotas.data.model.Mascota;
import com.upax.listadomascotas.presenter.adapters.MascotasAdapter;
import com.upax.listadomascotas.view.activities.views.MascotaFragmentView;

import java.io.Serializable;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MascotasFragment extends Fragment implements MascotasAdapter.MascotasViewHolder.OnItemListener, MascotaFragmentView {
    View view;
    private static final String TAG = MascotasFragment.class.getSimpleName();
    private static final String url = "https://api.thedogapi.com/v1/";
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;
    private static final String API_KEY = "4e3150d0-e327-45eb-8089-0920c7bc0028";
    Mascota mascota;
    List<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mascotas, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rVContenedor);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        obtenerDatosAPI();
        return view;
    }

    public void obtenerDatosAPI(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MascotaServicioAPI servicioAPI = retrofit.create(MascotaServicioAPI.class);
        Call<List<Mascota>> call = servicioAPI.getMascotas(API_KEY);
        call.enqueue(new Callback<List<Mascota>>() {
            @Override
            public void onResponse(Call<List<Mascota>> call, Response<List<Mascota>> response) {
                if(response.isSuccessful()) {
                    //Log.d(TAG, "Body: " + response.body());
                    mascotas = response.body();
                    muestraToast("Registros: " + String.valueOf(mascotas.size()));
                    llenaRecyclerView();
                }else {
                    muestraToast("No se obtuvieron datos: " + response.message() + " Codigo: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Mascota>> call, Throwable t) {
                muestraToast("Falló la ejecución del call: " + t.toString());
            }
        });
    }

    public void muestraToast(String mensaje){
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_LONG).show();
    }

    public void llenaRecyclerView(){
        if(mascotas != null){
            recyclerView.setAdapter(new MascotasAdapter(mascotas, R.layout.item_mascota, getActivity().getBaseContext(), this));
        }
    }

    @Override
    public void onItemClick(int position) {
        reemplazaFragment(new DetalleFragment(), position);
    }

    public void reemplazaFragment(DetalleFragment fragment, int position){
        Bundle bundle = new Bundle();
        bundle.putInt("id", mascotas.get(position).getId());
        bundle.putSerializable("mascotas", (Serializable) mascotas);

        fragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentLayout, fragment)
                .addToBackStack(null)
                .commit();
    }
}