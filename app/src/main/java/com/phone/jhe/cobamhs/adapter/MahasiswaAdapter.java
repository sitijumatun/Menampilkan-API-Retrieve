package com.phone.jhe.cobamhs.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone.jhe.cobamhs.R;
import com.phone.jhe.cobamhs.model.Mahasiswa;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {
    public MahasiswaAdapter(@NonNull Context context, int resource, @NonNull List<Mahasiswa> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mahasiswa,parent,false);
        }

        Mahasiswa nama = getItem(position);
        TextView tvnama = convertView.findViewById(R.id.iv_nama);
        tvnama.setText(nama.getNama());


        TextView tvnim = convertView.findViewById(R.id.iv_nim);
        tvnim.setText(nama.getNim());

        TextView tvemail = convertView.findViewById(R.id.iv_email);
        tvemail.setText(nama.getEmail());

        ImageView tvfoto = convertView.findViewById(R.id.iv_foto);
        Log.e("CRUD", "Foto: http://192.168.43.228/laravel/LaraSort/public/foto/" + nama.getFoto());
        Picasso.with(convertView.getContext()).load("http://192.168.43.228/laravel/LaraSort/public/foto/" +nama.getFoto()).into(tvfoto);

        return convertView;
    }
}
