package com.studio.skryl.musicstreamingapp.model;

import com.google.gson.annotations.SerializedName;

public class Track {
    @SerializedName("id")
    private int mID;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("preview")
    private String mStreamURL;

    @SerializedName("picture_medium")
    private String mArtworkURL;

    public int getmID() {
        return mID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmStreamURL() {
        return mStreamURL;
    }

    public String getmArtworkURL() {
        return mArtworkURL;
    }
}
