package com.studio.skryl.musicstreamingapp.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studio.skryl.musicstreamingapp.R;
import com.studio.skryl.musicstreamingapp.model.Track;
import com.studio.skryl.musicstreamingapp.model.Tracks;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Tracks> tracksList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerAdapter(List<Tracks> tracksList) {
        this.tracksList = tracksList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        //holder.songTitle().setText();
    }

    @Override
    public int getItemCount() {
        return tracksList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
        }

        public TextView songTitle() {
            return (TextView) view.findViewById(R.id.song_title);
        }

        public TextView songDuration() {
            return (TextView) view.findViewById(R.id.song_duration);
        }
    }
}
