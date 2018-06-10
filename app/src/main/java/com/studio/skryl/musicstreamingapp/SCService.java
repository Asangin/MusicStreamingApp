package com.studio.skryl.musicstreamingapp;

import com.studio.skryl.musicstreamingapp.model.Album;
import com.studio.skryl.musicstreamingapp.model.Track;
import com.studio.skryl.musicstreamingapp.model.Tracks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SCService {

    // https://api.deezer.com/track/3135556

    // https://api.deezer.com/playlist/1362526495/tracks?index=0&limit=10

    @GET("/track/{id}")
    Call<Track> getRecentTrack (@Path("id") int id);

    @GET("/playlist/{id}/tracks?index=0")
    Call<Album> getRecentAlbums (@Path("id") int id, @Query("limit") int limit);

}
