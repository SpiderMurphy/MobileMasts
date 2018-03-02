package com.bink.mobilemasts;

import android.content.Context;
import com.bink.mobilemasts.adapters.AdapterViewPager;
import com.bink.mobilemasts.models.PageModel;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * Created by Cyan on 02/03/2018.
 */

public class PageAdapterUnitTest {
    // Context
    @Mock
    private static Context mContext;

    @BeforeClass
    public static void setup(){

    }

    @Test
    public void test_add_page_model (){
        AdapterViewPager adapter = new AdapterViewPager(mContext);

        adapter.add(new PageModel(0, 0, null));
        assertEquals(adapter.getCount(), 1);
    }
}
