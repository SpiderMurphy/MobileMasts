package com.bink.mobilemasts;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bink.mobilemasts.adapters.AdapterListItem;
import com.bink.mobilemasts.adapters.AdapterViewPager;
import com.bink.mobilemasts.models.ListItem;
import com.bink.mobilemasts.models.Mast;
import com.bink.mobilemasts.models.PageModel;
import com.bink.mobilemasts.presenters.ItemPresenter;
import com.bink.mobilemasts.utils.MastParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // View pager
    private ViewPager mViewPager;

    // Tab layout
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tabs);

        setSupportActionBar(toolbar);

        setupViewAdapter();
    }

    /**
     * Setups top rentals view page
     *
     * @param view
     */
    public void setupTopRentals(View view){
        // Recycler view
        RecyclerView recyclerView = view.findViewById(R.id.rw_list);

        // Header view
        View headerView = view.findViewById(R.id.header_view);
        headerView.setVisibility(View.VISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));

        final ItemPresenter presenter = new ItemPresenter();

        try {
            List<Mast> mastList = MastParser.readFromCsv(new InputStreamReader(getAssets().open("masts.csv")),
                    ((mast, t1) -> mast.getLeaseYears() > t1.getLeaseYears() ? -1 : (mast.getLeaseYears() < t1.getLeaseYears() ? 1 : 0)));

            for(Mast mast : mastList){
                if(presenter.getCount() == 5)
                    break;

                presenter.add(new ListItem<>(mast.getPropertyName(), String.valueOf(mast.getLeaseYears() + "\t years"), Integer.valueOf(mast.getLeaseYears())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdapterListItem adapterListItem = new AdapterListItem(presenter);
        recyclerView.setAdapter(adapterListItem);
    }

    /**
     * Setups tenants view page
     *
     * @param view
     */
    private void setupTenants(View view){
        RecyclerView recyclerView = view.findViewById(R.id.rw_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));

        ItemPresenter presenter = new ItemPresenter();

        try {
            List<Mast> mastList = MastParser.readFromCsv(new InputStreamReader(getAssets().open("masts.csv")),
                    ((mast, t1) -> mast.getLeaseYears() > t1.getLeaseYears() ? -1 : (mast.getLeaseYears() < t1.getLeaseYears() ? 1 : 0)));

            Map<String, Integer> map = new HashMap<>();

            for(Mast mast : mastList) {
                Integer count = map.get(mast.getTenantName());

                if(map.size() < 5) {
                    if (count == null)
                        map.put(mast.getTenantName(), 1);
                }

                if(count != null)
                    map.put(mast.getTenantName(), count+1);
            }

            for(Map.Entry<String, Integer> entry : map.entrySet())
                presenter.add(new ListItem<>(entry.getKey(), String.valueOf(entry.getValue()) + "\t masts", null));

            AdapterListItem adapterListItem = new AdapterListItem(presenter);
            recyclerView.setAdapter(adapterListItem);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Setups view pager
     */
    private void setupViewAdapter(){
        AdapterViewPager adapterViewPager = new AdapterViewPager(this);

        adapterViewPager.add(new PageModel(R.layout.content_page, R.string.rentals_desc, this::setupTopRentals));
        adapterViewPager.add(new PageModel(R.layout.content_page, R.string.tenants_desc, this::setupTenants));

        mViewPager.setAdapter(adapterViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
