package com.studio.skryl.musicstreamingapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {
    public List<Tracks> getAlbums() {
        return albums;
    }

    @SerializedName("data")
    private List<Tracks> albums;
}
