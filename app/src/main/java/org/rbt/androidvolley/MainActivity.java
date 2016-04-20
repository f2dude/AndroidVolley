package org.rbt.androidvolley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rbt.readresponses.ImageResponse;
import org.rbt.readresponses.JsonArrayResponse;
import org.rbt.readresponses.JsonResponse;
import org.rbt.readresponses.StringResponse;

public class MainActivity extends AppCompatActivity implements StringResponse, ImageResponse, JsonResponse, JsonArrayResponse {

    private static final String URL = "http://www.google.com";
    private static final String IMAGE_URL = "http://i.imgur.com/7spzG.png";
    private static final String Image_Loader_URL = "http://developer.android.com/images/training/system-ui.png";
    private static final String SAMPLE_JSON_URL = "http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo";
    private TextView textView;
    private ImageView imageView;
    private NetworkImageView networkImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        networkImageView = (NetworkImageView) findViewById(R.id.networkImageView);

        //Create a simple request
//        SingletonInstance.getInstance(this).addToRequestQueue(SimpleStringRequest.getInstance().initiateRequest(this, this, URL));

        //Create network cache request, explicit request queue has to be created because cache object needs to passed in it.
//        NetworkCacheRequest.getInstance().initiateRequest(this, this, URL);

        //Create a single image request
//        SingletonInstance.getInstance(this).addToRequestQueue(SimpleImageRequest.getInstance().initiateRequest(this, this, IMAGE_URL));

        //Image Loader
//        ImageLoader imageLoader = SingletonInstance.getInstance(this).getImageLoader();
//        imageLoader.get(Image_Loader_URL, ImageLoader.getImageListener(imageView, R.drawable.default_image, R.drawable.error_image));

        //Network Image View
//        ImageLoader imageLoader = SingletonInstance.getInstance(this).getImageLoader();
//        networkImageView.setImageUrl(Image_Loader_URL, imageLoader);

        //Using Lru image caching mechanism
//        networkImageView.setImageUrl(Image_Loader_URL, SingletonInstance.getInstance(this).getImageLoaderWithLruCache());

        //Json object request
//        SingletonInstance.getInstance(this).addToRequestQueue(SimpleJsonRequest.getInstance().initiateRequest(this, this, SAMPLE_JSON_URL));

        //Json array request
//        SingletonInstance.getInstance(this).addToRequestQueue(SimpleJsonArrayRequest.getInstance().initiateRequest(this, this, SAMPLE_JSON_URL));
    }

    @Override
    public void stringResponse(String response) {
        textView.setText("Response is :::::" + response.substring(0, 500));
    }

    @Override
    public void errorResponse(VolleyError error) {
        textView.setText("That didn't work!!!");
    }

    @Override
    public void imageResponse(Bitmap response) {
        imageView.setImageBitmap(response);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Cancelling a simple request with the help of a tag
//        SimpleStringRequest.getInstance().cancelRequest(SingletonInstance.getInstance(this).getRequestQueue());

        //Cancelling a network cache request with the help of a tag
//        NetworkCacheRequest.getInstance().cancelRequest();

        //Cancelling a single image request with the help of a tag
//        SimpleImageRequest.getInstance().cancelRequest(SingletonInstance.getInstance(this).getRequestQueue());

        //cancelling a json object request
//        SimpleJsonRequest.getInstance().cancelRequest(SingletonInstance.getInstance(this).getRequestQueue());

        //cancelling a json array request
//        SimpleJsonArrayRequest.getInstance().cancelRequest(SingletonInstance.getInstance(this).getRequestQueue());
    }

    @Override
    public void jsonObjectResponse(JSONObject response) {
        textView.setText(response.toString());
    }

    @Override
    public void readJsonArrayResponse(JSONArray response) {
        textView.setText(response.toString());
    }
}
