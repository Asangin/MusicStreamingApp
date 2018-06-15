package com.studio.skryl.musicstreamingapp.data.network;

import android.util.Log;

public class NetworkError extends Throwable{
    private final Throwable error;

    public NetworkError(Throwable error) {
        super(error);
        this.error = error;
    }

    public void logingError() {
        Log.e("TAG", error.getMessage());
    }
}
