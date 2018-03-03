package com.bink.mobilemasts.presenters;

import android.support.annotation.NonNull;

import com.bink.mobilemasts.models.ListItem;

import java.util.Collections;
import java.util.Comparator;
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
     * Gets list item by index
     *
     * @param i
     * @return
     */
    public ListItem get(int i){
        return mItems.get(i);
    }

    /**
     * Sorts list item lists by comparator criteria
     *
     * @param comparator
     */
    public void sort(@NonNull Comparator<ListItem> comparator){
        Collections.sort(mItems, comparator);
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
