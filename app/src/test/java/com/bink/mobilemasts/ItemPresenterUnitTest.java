package com.bink.mobilemasts;

import com.bink.mobilemasts.models.ListItem;
import com.bink.mobilemasts.presenters.ItemPresenter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cyan on 02/03/2018.
 */

public class ItemPresenterUnitTest {
    @Test
    public void test_get_count () {
        ItemPresenter itemPresenter = new ItemPresenter();

        itemPresenter.add(new ListItem("", ""));
        assertEquals(1, itemPresenter.getCount());
    }
}
