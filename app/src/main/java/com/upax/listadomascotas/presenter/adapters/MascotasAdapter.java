package com.upax.listadomascotas.presenter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.upax.listadomascotas.R;
import com.upax.listadomascotas.data.model.Mascota;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder> {
    private List<Mascota> mascotas;
    private int rowLayout;
    private Context context;
    private MascotasViewHolder.OnItemListener mOnItemListener;

    public static final  String IMAGE_ULR_BASE = "https://cdn2.thedogapi.com/images/";

    public MascotasAdapter(List<Mascota> mascotas, int rowLayout, Context context, MascotasViewHolder.OnItemListener onItemListener) {
        this.mascotas = mascotas;
        this.rowLayout = rowLayout;
        this.context = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public MascotasAdapter.MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MascotasViewHolder(view, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasAdapter.MascotasViewHolder holder, int position) {
        holder.tvName.setText(mascotas.get(position).getName());
        holder.tvOrigin.setText(mascotas.get(position).getOrigin());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout mascotasLayout;
        TextView tvName;
        TextView tvOrigin;
        OnItemListener onItemListener;

        public MascotasViewHolder(View itemView, OnItemListener onItemListener){
            super(itemView);
            mascotasLayout = (LinearLayout)itemView.findViewById(R.id.layout_mascotas);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvOrigin = (TextView)itemView.findViewById(R.id.tvOrigin);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }

        public interface OnItemListener{
            void onItemClick(int position);
        }
    }
}