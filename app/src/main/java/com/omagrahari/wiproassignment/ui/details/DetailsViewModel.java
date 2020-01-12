package com.omagrahari.wiproassignment.ui.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.omagrahari.wiproassignment.entity.ResponseComments;
import com.omagrahari.wiproassignment.repository.DetailsRepository;

/**
 * Created by omprakash on 13,January,2020
 */
public class DetailsViewModel extends ViewModel {
    private DetailsRepository detailsRepository;

    public DetailsViewModel(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    public LiveData<ResponseComments> getComments(String id) {
        return detailsRepository.getComments(id);
    }
}
