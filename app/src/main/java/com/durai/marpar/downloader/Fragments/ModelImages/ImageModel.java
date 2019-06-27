package com.durai.marpar.downloader.Fragments.ModelImages;

import android.net.Uri;

public class ImageModel {
    public ImageModel(Uri uri, String name) {
        this.uri = uri;
        this.name = name;
    }

    Uri uri;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
