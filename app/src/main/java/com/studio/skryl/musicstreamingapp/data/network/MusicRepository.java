package com.studio.skryl.musicstreamingapp.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.studio.skryl.musicstreamingapp.util.Config;
import com.studio.skryl.musicstreamingapp.model.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicRepository {

    private ApiMusicInterface apiMusicInterface;
    private static MusicRepository musicRepository;

    private MusicRepository(){
        // TODO dagger handle it
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiMusicInterface = retrofit.create(ApiMusicInterface.class);
    }

    public synchronized static MusicRepository getInstance() {
        // TODO dagger handle it
        if (musicRepository == null) {
            if (musicRepository == null) {
                musicRepository = new MusicRepository();
            }
        }
        return musicRepository;
    }

    public LiveData<Data> getPlaylist (int id, final int limit) {
        final MutableLiveData<Data> liveMusicData = new MutableLiveData<>();

        apiMusicInterface.getPlaylist(id, limit).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()) {
                    liveMusicData.setValue(response.body());
                } else {
                    Log.e("TAG", "Error.  " +  response.code());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                new NetworkError(t).logingError();
                liveMusicData.setValue(null);

            }
        });
        return liveMusicData;
    }
}
