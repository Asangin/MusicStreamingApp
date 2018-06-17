package com.studio.skryl.musicstreamingapp.data.network;

import com.studio.skryl.musicstreamingapp.model.Data;
import com.studio.skryl.musicstreamingapp.model.Track;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiMusicInterface {

    // https://api.deezer.com/track/3135556

    @GET("/track/{id}")
    Call<Track> getRecentTrack (@Path("id") int id);

    // https://api.deezer.com/playlist/1362526495/tracks?index=0&limit=10

    @GET("/playlist/{id}/tracks?index=0")
    Observable<Data> getRecentAlbums (@Path("id") int id, @Query("limit") int limit);

    @GET("/playlist/{id}/tracks?index=0")
    Call<Data> getPlaylist (@Path("id") int id, @Query("limit") int limit);

}
