package com.durai.marpar.downloader.Fragments.ModelImages;

import android.net.Uri;

public class VideoModel {
    Uri uri;


    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public VideoModel(Uri uri) {
        this.uri = uri;

    }
}
