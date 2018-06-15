package com.studio.skryl.musicstreamingapp.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.studio.skryl.musicstreamingapp.Config;
import com.studio.skryl.musicstreamingapp.model.Album;

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

    public LiveData<Album> getPlaylist (int id, final int limit) {
        final MutableLiveData<Album> livePlaylist = new MutableLiveData<>();

        apiMusicInterface.getPlaylist(id, limit).enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                if (response.isSuccessful()) {
                    livePlaylist.setValue(response.body());
                } else {
                    Log.e("TAG", "Error.  " +  response.code());
                }
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                new NetworkError(t).logingError();
                livePlaylist.setValue(null);

            }
        });
        return livePlaylist;
    }
}
