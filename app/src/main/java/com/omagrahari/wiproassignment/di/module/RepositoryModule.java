package com.omagrahari.wiproassignment.di.module;

import android.app.Application;

import com.omagrahari.wiproassignment.repository.DetailsRepository;
import com.omagrahari.wiproassignment.repository.FlickrRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omprakash on 12,January,2020
 */
@Module
public class RepositoryModule {
    @Singleton
    @Provides
    public FlickrRepository providesFlickrRespository(Application application) {
        return new FlickrRepository(application);
    }

    @Singleton
    @Provides
    public DetailsRepository providesDetailsRespository(Application application) {
        return new DetailsRepository(application);
    }

}
