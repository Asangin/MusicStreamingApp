package com.studio.skryl.musicstreamingapp.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.studio.skryl.musicstreamingapp.R;
import com.studio.skryl.musicstreamingapp.model.Artist;
import com.studio.skryl.musicstreamingapp.model.Tracks;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
        holder.bind(tracksList.get(position));
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
        private TextView songTitle;
        private TextView songDuration;
        private TextView songRank;
        private ImageView artistPic;

        private Context context;


        public ViewHolder(View v) {
            super(v);
            view  = v;
            context = v.getContext();
            songTitle = (TextView) v.findViewById(R.id.song_title);
            songDuration = (TextView) v.findViewById(R.id.song_duration);
            songRank = (TextView) v.findViewById(R.id.song_rank);
            artistPic = (ImageView) v.findViewById(R.id.artist_picture);

        }

        public void bind (Tracks tracks) {
            songTitle.setText(tracks.getTitle().toString());
            songDuration.setText(Integer.valueOf(tracks.getDuration()).toString());
            songRank.setText(Integer.valueOf(tracks.getRank()).toString());
            Artist artist = tracks.getArtist();

            Picasso.with(context).load(artist.getPictureMedium()).into(artistPic);

        }

        public Bitmap getBitmapFromURL(String src) {
            try {
                URL url = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return null;
            }
        }



    }


}
