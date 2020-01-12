package com.omagrahari.wiproassignment.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.omagrahari.wiproassignment.BuildConfig;
import com.omagrahari.wiproassignment.R;
import com.omagrahari.wiproassignment.entity.ResponsePhotos;
import com.omagrahari.wiproassignment.network.ApiReference;
import com.omagrahari.wiproassignment.util.Utils;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.omagrahari.wiproassignment.FlickrApplicaiton.getFlickrApplication;

/**
 * Created by omprakash on 12,January,2020
 */
public class FlickrRepository {
    Application application;

    @Inject
    ApiReference apiReference;

    MutableLiveData<ResponsePhotos> photosMutableLiveData = new MutableLiveData<>();

    public FlickrRepository(Application application) {
        this.application = application;

        getFlickrApplication().getComponent().inject(this);
    }

    public void requestPhotos(int page) {
        if (!Utils.isNetworkConnected(application.getApplicationContext())) {
            Toast.makeText(application.getApplicationContext(), application.getApplicationContext().getString(R.string.error_no_internet), Toast.LENGTH_LONG).show();
            return;
        }

        apiReference.getRecent(BuildConfig.FLICKR_KEY, page).enqueue(new Callback<ResponsePhotos>() {
            @Override
            public void onResponse(Call<ResponsePhotos> call, Response<ResponsePhotos> response) {
                Log.d("CHECKPOINT", "CHECK RESP::" + response.toString());
                if (response.code() == 200) {
                    ResponsePhotos responsePhotos = response.body();
                    photosMutableLiveData.postValue(responsePhotos);
                }
            }

            @Override
            public void onFailure(Call<ResponsePhotos> call, Throwable t) {
                Log.d("CHECKPOINT", "CHECK ERROR::" + t.getLocalizedMessage());
            }
        });
    }

    public MutableLiveData<ResponsePhotos> getPhotos() {
        return photosMutableLiveData;
    }
}
