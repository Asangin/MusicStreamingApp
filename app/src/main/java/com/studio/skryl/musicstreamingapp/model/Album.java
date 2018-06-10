package com.studio.skryl.musicstreamingapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {
    @SerializedName("data")
    private List<Tracks> albums;
}
