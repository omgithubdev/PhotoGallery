package com.omagrahari.wiproassignment;

import android.app.Application;

import com.omagrahari.wiproassignment.di.ActivityComponent;
import com.omagrahari.wiproassignment.di.DaggerActivityComponent;
import com.omagrahari.wiproassignment.di.module.ApplicationModule;

/**
 * Created by omprakash on 12,January,2020
 */
public class FlickrApplicaiton  extends Application {
    ActivityComponent activityComponent;
    public static FlickrApplicaiton flickrApplicaiton;

    @Override
    public void onCreate() {
        super.onCreate();

        flickrApplicaiton = this;

        activityComponent = DaggerActivityComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static FlickrApplicaiton getFlickrApplication() {
        return flickrApplicaiton;
    }

    public ActivityComponent getComponent() {
        return activityComponent;
    }
}
