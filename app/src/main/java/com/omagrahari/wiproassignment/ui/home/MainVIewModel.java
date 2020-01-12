package com.omagrahari.wiproassignment.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.omagrahari.wiproassignment.entity.ResponsePhotos;
import com.omagrahari.wiproassignment.repository.FlickrRepository;

/**
 * Created by omprakash on 12,January,2020
 */
public class MainVIewModel extends ViewModel {
    LiveData<ResponsePhotos> photosMutableLiveData = new MutableLiveData<>();
    FlickrRepository flickrRepository;
    public int page = 0;
    public boolean lastPage = false;

    public MainVIewModel(FlickrRepository flickrRepository) {
        this.flickrRepository = flickrRepository;
    }

    public void init() {
        photosMutableLiveData = new MutableLiveData<>();
        requestPhotos();
    }

    public LiveData<ResponsePhotos> getPhotos() {
        return flickrRepository.getPhotos();
    }

    public boolean requestPhotos() {
        if (!lastPage) {
            page = page + 1;
            flickrRepository.requestPhotos(page);

            return true;
        } else
            return false;
    }
}
