package com.phone.jhe.cobamhs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.phone.jhe.cobamhs.adapter.MahasiswaAdapter;
import com.phone.jhe.cobamhs.model.Mahasiswa;
import com.phone.jhe.cobamhs.model.MahasiswaResult;
import com.phone.jhe.cobamhs.network.ApiClient;
import com.phone.jhe.cobamhs.network.MahasiswaService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* ImageView lvCobaGambar = (ImageView) findViewById(R.id.iv_coba_gambar);*/

      /*  int SDK_INT = Build.VERSION.SDK_INT;
        if(SDK_INT>8){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try{
                URL url = new URL("https://picsum.photos/200/300/?random");
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                lvCobaGambar.setImageBitmap(bmp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
*/
       /* Picasso.with(this).load("https://picsum.photos/200/300/?random").into(lvCobaGambar);*/

        //membuat pojo
     /*   Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.setNama("Siti Jum'atun");
        mahasiswa1.setNim("3.34.15.0.21");
        mahasiswa1.setEmail("sitijumatun@gmail.com");
        mahasiswa1.setFoto("https://picsum.photos/200/300/?random");

        Mahasiswa mahasiswa3 = new Mahasiswa();
        mahasiswa3.setNama("Nana Sunana");
        mahasiswa3.setNim("3.34.15.0.23");
        mahasiswa3.setEmail("nana@gmail.com");
        mahasiswa3.setFoto("https://picsum.photos/200/300/?random");

        Mahasiswa mahasiswa2 = new Mahasiswa(
                "Roni Apriantoro",
                "3.34.15.0.22",
                "roni28@gmail.com",
                "https://picsum.photos/200/300/?random"
        );*/

    /*    ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
        mahasiswa.add(mahasiswa1);
        mahasiswa.add(mahasiswa2);
        mahasiswa.add(mahasiswa3);*/

    //sumber data dari API
        MahasiswaService mService = ApiClient.getRetrofit().create(MahasiswaService.class);

        Call<MahasiswaResult> mahasiswas = mService.getMahasiswas();
        mahasiswas.enqueue(new Callback<MahasiswaResult>() {
            @Override
            public void onResponse(Call<MahasiswaResult> call, Response<MahasiswaResult> response) {
                tampilkan(response.body().getMahasiswas());
                Toast.makeText(getApplicationContext(),"Jumlah mahasiswa : "+response.body().getMahasiswas().size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MahasiswaResult> call, Throwable t) {

            }
        });

        //mengambil data gson


       /* MahasiswaAdapter userAdapter = new MahasiswaAdapter(this,0,mahasiswa);*/

        /*lvUser.setAdapter(userAdapter);*/






    }
    private void tampilkan(List<Mahasiswa> mahasiswas){

        MahasiswaAdapter userAdapter = new MahasiswaAdapter(this, 0, mahasiswas);


        // 3. Tampilan Aplikasi
        ListView lvUser = (ListView) findViewById(R.id.lv_user);
        lvUser.setAdapter(userAdapter);
    }

}
