package com.bink.mobilemasts.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bink.mobilemasts.R;
import com.bink.mobilemasts.databinding.AdapterListItemBinding;
import com.bink.mobilemasts.models.ListItem;
import com.bink.mobilemasts.presenters.ItemPresenter;

/**
 * Created by Cyan on 02/03/2018.
 */

public class AdapterListItem extends RecyclerView.Adapter<AdapterListItem.ViewHolder> {
    // Items presen
    private ItemPresenter mPresenter;

    public AdapterListItem(ItemPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterListItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.adapter_list_item, parent, false);

        ViewHolder holder = new ViewHolder(itemBinding.getRoot());
        holder.setItemBinding(itemBinding);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mPresenter.onBindViewHolder(position, holder);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ItemPresenter.HolderListener {
        // Item binding
        private AdapterListItemBinding mItemBinding;

        public AdapterListItemBinding getItemBinding() {
            return mItemBinding;
        }

        public void setItemBinding(AdapterListItemBinding mItemBinding) {
            this.mItemBinding = mItemBinding;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindItem(ListItem item) {
            mItemBinding.setItem(item);
        }
    }
}
