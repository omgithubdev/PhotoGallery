package com.omagrahari.wiproassignment.ui.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.omagrahari.wiproassignment.R;
import com.omagrahari.wiproassignment.databinding.ActivityDetailsBinding;
import com.omagrahari.wiproassignment.entity.Photos;
import com.omagrahari.wiproassignment.entity.ResponseComments;
import com.omagrahari.wiproassignment.ui.details.adapter.CommentsAdapter;

import javax.inject.Inject;

import static com.omagrahari.wiproassignment.FlickrApplicaiton.getFlickrApplication;
import static com.omagrahari.wiproassignment.util.Constants.PARAM_DETAILS;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;
    Photos photos;

    CommentsAdapter commentsAdapter;

    @Inject
    DetailsViewModelFactory viewModelFactory;
    DetailsViewModel viewModel;

    public static void getStartedDetailsActivity(Context context, Photos photos) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(PARAM_DETAILS, photos);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        getFlickrApplication().getComponent().inject(this);

        viewModel = new ViewModelProvider(this, viewModelFactory).get(DetailsViewModel.class);

        if (getIntent() != null) {
            photos = getIntent().getParcelableExtra(PARAM_DETAILS);
            init();

            initObserver();
        } else
            finish();
    }

    private void initObserver() {
        viewModel.getComments(photos.getId()).observe(this, new Observer<ResponseComments>() {
            @Override
            public void onChanged(ResponseComments responseComments) {
                if (responseComments != null && responseComments.getComments() != null) {
                    commentsAdapter = new CommentsAdapter(responseComments.getComments().getComment());
                    binding.rvComments.setAdapter(commentsAdapter);

                    if (responseComments.getComments().getComment().size() != 0) {
                        binding.tvNoComment.setVisibility(View.GONE);
                    }

                } else {

                }
            }
        });
    }

    private void init() {
        binding.setDetails(photos);
        binding.executePendingBindings();
    }
}
