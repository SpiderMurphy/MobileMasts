package com.bink.mobilemasts.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bink.mobilemasts.models.PageModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyan on 02/03/2018.
 */

public class AdapterViewPager extends PagerAdapter {
    // Pages list
    private List<PageModel> mPageModels;

    // Context
    private WeakReference<Context> mContext;

    public AdapterViewPager(Context context){
        this.mContext = new WeakReference<>(context);
        this.mPageModels = new ArrayList<>();
    }

    public void add(PageModel pageModel){
        mPageModels.add(pageModel);
    }

    @Override
    public int getCount() {
        return mPageModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Page model by index
        PageModel model = mPageModels.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext.get());
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(mPageModels.get(position).getLayoutResourceId(), container, false);

        // Calls view presenter method
        if(model.getViewListener() != null)
            model.getViewListener().onSetupView(viewGroup);

        container.addView(viewGroup);

        return viewGroup;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.get().getString(mPageModels.get(position).getTitleId());
    }

    /**
     * Setups inflated view
     */
    public interface ViewListener {
        /**
         * Gets called everytime views get inflated by pager
         *
         * @param view
         * inflated view
         */
        void onSetupView(View view);
    }
}
