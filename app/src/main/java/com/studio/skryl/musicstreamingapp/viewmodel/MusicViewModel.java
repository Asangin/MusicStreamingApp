package com.studio.skryl.musicstreamingapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.studio.skryl.musicstreamingapp.data.network.MusicRepository;
import com.studio.skryl.musicstreamingapp.model.Data;

public class MusicViewModel extends AndroidViewModel{

    private final LiveData<Data> playlistLiveData;

    public MusicViewModel (Application application) {
        super(application);
       playlistLiveData = MusicRepository.getInstance().getPlaylist(1362526495, 10);
    }

    public LiveData<Data> getPlaylistLiveData(){
        return playlistLiveData;
    }


}
