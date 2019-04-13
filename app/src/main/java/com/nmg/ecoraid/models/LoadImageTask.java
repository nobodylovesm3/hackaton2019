package com.nmg.ecoraid.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImageTask extends AsyncTask<String, Void, Bitmap>{
    ImageView imageView;
    public LoadImageTask(ImageView imageView) {
        this.imageView=imageView;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        URL url = null;
        Bitmap bitmap = null;
        try {
            url = new URL(urls[0]);
            bitmap = BitmapFactory.decodeStream(url.openStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }

}
