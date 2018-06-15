package com.studio.skryl.musicstreamingapp.data.network;

import com.studio.skryl.musicstreamingapp.model.Album;

import rx.android.schedulers.AndroidSchedulers;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ApiMusic {
    private final ApiMusicInterface apiMusicInterface;

    public ApiMusic(ApiMusicInterface apiMusicInterface) {
        this.apiMusicInterface = apiMusicInterface;
    }

    public Subscription getAlbumObserver (final  GetTracksListCallback callback, int id, int limit) {
        return apiMusicInterface.getRecentAlbums(id, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends Album>>() {
                    @Override
                    public Observable<? extends Album> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<Album>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(Album album) {
                        callback.onSuccess(album);
                    }
                });
    }

    public interface GetTracksListCallback {
        void onSuccess(Album album);

        void onError(NetworkError networkError);
    }

}
