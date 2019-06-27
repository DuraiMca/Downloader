package com.durai.marpar.downloader.Adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.durai.marpar.downloader.Fragments.ModelImages.VideoModel;
import com.durai.marpar.downloader.R;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.viewholder> {

    Context context;
    ArrayList<VideoModel> list = new ArrayList<>();

    public VideoAdapter(Context context, ArrayList<VideoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.videorow, viewGroup, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder viewholder, int i) {


        viewholder.videoView.setVideoURI(Uri.parse(list.get(i).getUri().toString()));

        viewholder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                viewholder.videoView.start();
            }

        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(Context context) {
        this.context = context;
    }

    class viewholder extends RecyclerView.ViewHolder {
        VideoView videoView;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoplay);
        }
    }
}
