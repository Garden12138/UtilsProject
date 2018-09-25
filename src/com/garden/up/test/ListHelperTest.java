package com.garden.up.test;

import com.garden.up.utils.ListHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * List工具测试类
 * Created by Garden on 2018/9/25.
 */
public class ListHelperTest {

    @Test
    public void deleteSameElementTest(){
        ListHelper<String> lh = new ListHelper<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        List<String> newList = lh.deleteSameElement(list);
        for (String e : newList) {
            System.err.println(e);
        }
    }

}
