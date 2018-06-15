package com.studio.skryl.musicstreamingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.studio.skryl.musicstreamingapp.data.network.ApiMusicInterface;
import com.studio.skryl.musicstreamingapp.model.Album;
import com.studio.skryl.musicstreamingapp.model.Track;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    
}
