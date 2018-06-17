package com.studio.skryl.musicstreamingapp.data.network;

import com.studio.skryl.musicstreamingapp.model.Data;

import rx.android.schedulers.AndroidSchedulers;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ApiMusicObserverExample {
    private final ApiMusicInterface apiMusicInterface;

    public ApiMusicObserverExample(ApiMusicInterface apiMusicInterface) {
        this.apiMusicInterface = apiMusicInterface;
    }

    public Subscription getAlbumObserver (final  GetTracksListCallback callback, int id, int limit) {
        return apiMusicInterface.getRecentAlbums(id, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends Data>>() {
                    @Override
                    public Observable<? extends Data> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<Data>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(Data data) {
                        callback.onSuccess(data);
                    }
                });
    }

    public interface GetTracksListCallback {
        void onSuccess(Data data);

        void onError(NetworkError networkError);
    }

}
