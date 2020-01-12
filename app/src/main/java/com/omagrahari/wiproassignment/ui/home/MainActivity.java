package com.omagrahari.wiproassignment.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omagrahari.wiproassignment.R;
import com.omagrahari.wiproassignment.databinding.ActivityMainBinding;
import com.omagrahari.wiproassignment.entity.Photos;
import com.omagrahari.wiproassignment.entity.ResponsePhotos;
import com.omagrahari.wiproassignment.ui.home.adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.omagrahari.wiproassignment.FlickrApplicaiton.getFlickrApplication;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Inject
    MainViewModelFactory viewModelFactory;
    MainVIewModel vIewModel;

    PhotoAdapter photoAdapter;

    List<Photos> photosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getFlickrApplication().getComponent().inject(this);

        vIewModel = new ViewModelProvider(this, viewModelFactory).get(MainVIewModel.class);
        vIewModel.init();

        init();
        initObserver();

        setListener();
    }

    private void init() {
        photosList = new ArrayList<>();
        photoAdapter = new PhotoAdapter(photosList);
        binding.rvPhotos.setAdapter(photoAdapter);
    }

    private void initObserver() {
        vIewModel.getPhotos().observe(this, new Observer<ResponsePhotos>() {
            @Override
            public void onChanged(ResponsePhotos responsePhotos) {
                Log.d("CHECKPOINT", "CHECK OBSERVER::" + responsePhotos);
                if (responsePhotos != null) {
                    if (vIewModel.page >= responsePhotos.getPhotos().getPages())
                        vIewModel.lastPage = true;

                    binding.progressCircular.setVisibility(View.GONE);
                    photosList.addAll(responsePhotos.getPhotos().getPhotoList());
                    photoAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void setListener() {
        binding.rvPhotos.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) //check for scroll down
                {
                    final int visibleThreshold = 2;

                    GridLayoutManager layoutManager = (GridLayoutManager) binding.rvPhotos.getLayoutManager();
                    int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
                    int currentTotalCount = layoutManager.getItemCount();

                    if (currentTotalCount <= lastItem + visibleThreshold) {
                        //show your loading view
                        // load content in background
                        if (vIewModel.requestPhotos()) {
                            binding.progressCircular.setVisibility(View.VISIBLE);
                        } else {
                            binding.tvEnd.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }
}
