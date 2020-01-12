package com.omagrahari.wiproassignment.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.omagrahari.wiproassignment.BuildConfig;
import com.omagrahari.wiproassignment.R;
import com.omagrahari.wiproassignment.entity.ResponseComments;
import com.omagrahari.wiproassignment.network.ApiReference;
import com.omagrahari.wiproassignment.util.Utils;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.omagrahari.wiproassignment.FlickrApplicaiton.getFlickrApplication;

/**
 * Created by omprakash on 13,January,2020
 */
public class DetailsRepository {
    Application application;
    MutableLiveData<ResponseComments> commentsMutableLiveData = new MutableLiveData<>();


    @Inject
    ApiReference apiReference;


    public DetailsRepository(Application application) {
        this.application = application;

        getFlickrApplication().getComponent().inject(this);
    }

    public MutableLiveData<ResponseComments> getComments(String id) {
        if (!Utils.isNetworkConnected(application.getApplicationContext())) {
            Toast.makeText(application.getApplicationContext(), application.getApplicationContext().getString(R.string.error_no_internet), Toast.LENGTH_LONG).show();
            return commentsMutableLiveData;
        }

        apiReference.getComments(BuildConfig.FLICKR_KEY, id).enqueue(new Callback<ResponseComments>() {
            @Override
            public void onResponse(Call<ResponseComments> call, Response<ResponseComments> response) {
                Log.d("CHECKPOINT", "CHECK RESP::" + response.toString());
                if (response.code() == 200) {
                    ResponseComments responseComments = response.body();
                    commentsMutableLiveData.postValue(responseComments);
                }
            }

            @Override
            public void onFailure(Call<ResponseComments> call, Throwable t) {
                Log.d("CHECKPOINT", "CHECK ERROR::" + t.getLocalizedMessage());
            }
        });

        return commentsMutableLiveData;
    }

}
