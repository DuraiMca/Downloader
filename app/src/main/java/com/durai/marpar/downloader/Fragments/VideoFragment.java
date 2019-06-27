package com.durai.marpar.downloader.Fragments;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durai.marpar.downloader.Adapters.VideoAdapter;
import com.durai.marpar.downloader.Fragments.ModelImages.VideoModel;
import com.durai.marpar.downloader.R;

import java.io.File;
import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;


public class VideoFragment extends Fragment {
    RecyclerView recyclerView;
    VideoAdapter adapter;
    VideoModel model;
    ArrayList<VideoModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        recyclerView = view.findViewById(R.id.videoRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new VideoAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);

        File downloadsFolder = new File((Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp/Media/.Statuses/"));
        //   File whatsappMediaDirectoryName = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp/Media/.Statuses/");

        if (downloadsFolder.exists()) {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files = downloadsFolder.listFiles();

            //LOOP THRU THOSE FILES GETTING NAME AND URI
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                Log.i(TAG, "startProcess: " + file.getName());
                if (file.getName().endsWith(".mp4")) {
                    model = new VideoModel(Uri.fromFile(file));

                    list.add(model);
                    adapter.update(getContext());
                }
            }
        }


        return view;
    }

}
