package com.studio.skryl.musicstreamingapp.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.studio.skryl.musicstreamingapp.R;
import com.studio.skryl.musicstreamingapp.model.Album;
import com.studio.skryl.musicstreamingapp.view.adapter.RecyclerAdapter;
import com.studio.skryl.musicstreamingapp.viewmodel.MusicViewModel;

public class MusicCollectionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MusicViewModel musicViewModel = ViewModelProviders.of(this).get(MusicViewModel.class);

        observeViewModule(musicViewModel);
    }

    private void observeViewModule(MusicViewModel musicViewModel) {
        musicViewModel.getAlbumLiveData().observe(this, new Observer<Album>() {
            @Override
            public void onChanged(@Nullable Album album) {
                if (album != null) {
                    mAdapter = new RecyclerAdapter(album.getAlbums());
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.music_collection_fragment, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)



        return rootView;
    }
}
