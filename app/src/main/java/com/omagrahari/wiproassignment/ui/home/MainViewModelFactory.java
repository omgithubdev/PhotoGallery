package com.omagrahari.wiproassignment.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.omagrahari.wiproassignment.repository.FlickrRepository;

import javax.inject.Inject;

/**
 * Created by omprakash on 12,January,2020
 */
public class MainViewModelFactory implements ViewModelProvider.Factory {
    private FlickrRepository flickrRepository;

    @Inject
    public MainViewModelFactory(FlickrRepository flickrRepository) {
        this.flickrRepository = flickrRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainVIewModel(flickrRepository);
    }
}
