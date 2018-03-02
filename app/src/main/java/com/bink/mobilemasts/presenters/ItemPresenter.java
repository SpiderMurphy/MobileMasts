package com.bink.mobilemasts.presenters;

import com.bink.mobilemasts.models.ListItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Cyan on 02/03/2018.
 */

public class ItemPresenter {
    // List items
    private final List<ListItem> mItems;

    public ItemPresenter() {
        mItems = new LinkedList<>();
    }

    /**
     * Get items count
     *
     * @return
     */
    public int getCount(){
        return mItems.size();
    }

    /**
     * Add item to the list
     *
     * @param item
     */
    public void add(ListItem item){
        mItems.add(item);
    }

    /**
     * Used to bind data to view holder
     *
     * @param position
     * item's index
     *
     * @param holder
     * holder to bind item on
     */
    public void onBindViewHolder(int position, HolderListener holder){
        holder.bindItem(mItems.get(position));
    }

    public interface HolderListener {
        /**
         * Binds item to view
         *
         * @param item
         * item to be binded
         */
        void bindItem(ListItem item);
    }
}
