package com.omagrahari.wiproassignment.di;


import com.omagrahari.wiproassignment.di.module.RepositoryModule;
import com.omagrahari.wiproassignment.repository.DetailsRepository;
import com.omagrahari.wiproassignment.repository.FlickrRepository;
import com.omagrahari.wiproassignment.ui.details.DetailsActivity;
import com.omagrahari.wiproassignment.ui.home.MainActivity;
import com.omagrahari.wiproassignment.di.module.ApplicationModule;
import com.omagrahari.wiproassignment.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by omprakash on 12,January,2019
 */
@Singleton
@Component(modules = {ApplicationModule.class, RetrofitModule.class, RepositoryModule.class})
public interface ActivityComponent {

    public void inject(MainActivity mainActivity);

    public void inject(DetailsActivity detailsActivity);

    public void inject(FlickrRepository flickrRepository);

    public void inject(DetailsRepository detailsRepository);
}
