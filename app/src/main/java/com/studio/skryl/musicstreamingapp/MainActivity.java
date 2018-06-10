package com.studio.skryl.musicstreamingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.studio.skryl.musicstreamingapp.model.Album;
import com.studio.skryl.musicstreamingapp.model.Track;
import com.studio.skryl.musicstreamingapp.model.Tracks;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Album album = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SCService scService = retrofit.create(SCService.class);
        /*
        scService.getRecentTrack(3135556).enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if (response.isSuccessful()) {
                    Track track = response.body();
                    Toast.makeText(MainActivity.this, track.getmStreamURL().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("tag", "Network Error" + t.getMessage());

            }
        });
*/
        scService.getRecentAlbums(1362526495, 10).enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                if (response.isSuccessful()){
                    album = response.body();
                    Log.d("tsg", album.toString());




                } else {
                    Toast.makeText(MainActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("tag", "Network Error" + t.getMessage());
            }
        });


    }

    private void showMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
