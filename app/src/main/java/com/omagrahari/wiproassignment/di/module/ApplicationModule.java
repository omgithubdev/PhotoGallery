package com.omagrahari.wiproassignment.di.module;

import android.app.Application;

import com.omagrahari.wiproassignment.FlickrApplicaiton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omprakash on 12,January,2019
 */
@Module
public class ApplicationModule {
    FlickrApplicaiton flickrApplicaiton;

    public ApplicationModule(FlickrApplicaiton flickrApplicaiton) {
        this.flickrApplicaiton = flickrApplicaiton;
    }

    @Singleton
    @Provides
    public Application providesApplication() {
        return flickrApplicaiton;
    }
}
