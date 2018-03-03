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
        assertEquals(0, itemPresenter.getCount());
    }

    @Test
    public void test_add_item () {
        ItemPresenter itemPresenter = new ItemPresenter();
        itemPresenter.add(new ListItem<>("t1", "t1", null));

        assertEquals(1, itemPresenter.getCount());
    }

    @Test
    public void test_sort_list_descending () {
        ItemPresenter itemPresenter = new ItemPresenter();

        itemPresenter.add(new ListItem<>("t1", "t1", 1));
        itemPresenter.add(new ListItem<>("t2", "t2", 2));

        itemPresenter.sort(((item, t1) -> {
            Integer val1 = (Integer) item.getItem();
            Integer val2 = (Integer) t1.getItem();

            return val1 > val2 ? -1 : (val1 < val2 ? 1 : 0);
        }));

        assertEquals("t2", itemPresenter.get(0).getTitle());
    }

    @Test
    public void test_sort_list_ascending (){
        ItemPresenter itemPresenter = new ItemPresenter();

        itemPresenter.add(new ListItem<>("t1", "t1", 2));
        itemPresenter.add(new ListItem<>("t2", "t2", 1));

        itemPresenter.sort(((item, t1) -> {
            Integer val1 = (Integer) item.getItem();
            Integer val2 = (Integer) t1.getItem();

            return val1 > val2 ? 1 : (val1 < val2 ? -1 : 0);
        }));

        assertEquals("t2", itemPresenter.get(0).getTitle());
    }
}
