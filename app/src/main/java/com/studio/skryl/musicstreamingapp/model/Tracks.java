package com.studio.skryl.musicstreamingapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracks {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("duration")
    @Expose
    private Integer duration;

    @SerializedName("preview")
    @Expose
    private String preview;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getPreview() {
        return preview;
    }
}
