package com.durai.marpar.downloader.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.durai.marpar.downloader.Fragments.ModelImages.ImageModel;
import com.durai.marpar.downloader.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.viewholder> {

    Context context;
    ArrayList<ImageModel> imageModels = new ArrayList<>();

    public ImagesAdapter(Context context, ArrayList<ImageModel> imageModels) {
        this.context = context;
        this.imageModels = imageModels;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.imagerow, viewGroup, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder viewholder, int i) {
        Log.i(TAG, "onBindViewHolder: " + imageModels.get(i).getName());
        Log.i(TAG, "onBindViewHolder: " + imageModels.get(i).getUri().toString());

        Picasso.get().load(imageModels.get(i).getUri()).into(viewholder.imageView);

    }

    @Override
    public int getItemCount() {
        return imageModels.size();
    }

    public void update(Context context) {
        this.context = context;
    }

    class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.photos);


        }
    }
}
