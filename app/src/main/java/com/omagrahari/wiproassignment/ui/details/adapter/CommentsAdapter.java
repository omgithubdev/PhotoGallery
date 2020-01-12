package com.omagrahari.wiproassignment.ui.details.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.omagrahari.wiproassignment.R;
import com.omagrahari.wiproassignment.databinding.LayoutCommentItemBinding;
import com.omagrahari.wiproassignment.entity.Comment;

import java.util.List;

/**
 * Created by omprakash on 13,January,2020
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    List<Comment> commentList;

    public CommentsAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutCommentItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.layout_comment_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder, int position) {
        holder.binding.setComment(commentList.get(position));
        holder.binding.executePendingBindings();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutCommentItemBinding binding;

        public ViewHolder(LayoutCommentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }
}