package com.durai.marpar.downloader.Fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durai.marpar.downloader.Adapters.ImagesAdapter;
import com.durai.marpar.downloader.Fragments.ModelImages.ImageModel;
import com.durai.marpar.downloader.R;
import java.io.File;
import java.util.ArrayList;


import static android.support.constraint.Constraints.TAG;


public class ImagesFragment extends Fragment {


    RecyclerView recyclerView;
    Context context;

    ImagesAdapter imagesAdapter;
    ArrayList<ImageModel> imageModels = new ArrayList<>();
    ImageModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_images, container, false);
        recyclerView = view.findViewById(R.id.imageRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        imagesAdapter = new ImagesAdapter(getContext(), imageModels);
        recyclerView.setAdapter(imagesAdapter);
        startProcess();


        return view;
    }


    public void startProcess() {



        File downloadsFolder = new File((Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/.thumbnails"));


        if (downloadsFolder.exists())

        {


            File[] files = downloadsFolder.listFiles();


            for (int i = 0; i < files.length; i++) {
                File file = files[i];

                if (file.getName().endsWith(".jpg")) {
                    model = new ImageModel(Uri.fromFile(file), file.getName());
                    Log.i(TAG, "startProcess: " + Uri.fromFile(file));
                    imageModels.add(model);
                    imagesAdapter.update(getContext());
                    //  getContext().startService(new Intent(getContext(),bg.class));


                }
            }


        }


    }
}











