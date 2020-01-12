package com.omagrahari.wiproassignment.ui.details;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.omagrahari.wiproassignment.repository.DetailsRepository;

import javax.inject.Inject;

/**
 * Created by omprakash on 13,January,2020
 */
public class DetailsViewModelFactory implements ViewModelProvider.Factory {
    private DetailsRepository detailsRepository;

    @Inject
    DetailsViewModelFactory(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DetailsViewModel(detailsRepository);
    }
}
