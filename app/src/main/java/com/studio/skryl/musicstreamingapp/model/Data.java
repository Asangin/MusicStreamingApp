package com.studio.skryl.musicstreamingapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("data")
    @Expose
    private List<Tracks> tracks;

    public List<Tracks> getTracks() {
        return tracks;
    }
}
