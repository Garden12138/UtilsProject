package com.garden.up.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *  List工具类
 * Created by Garden on 2018/9/25.
 */
public class ListHelper<T> {

    /**
     * 集合list去重，list里面的对象需要重写equals和hashcode方法
     * @param list
     * @return
     */
    public List<T> deleteSameElement(List<T> list){
        Map<Object,Object> map = new HashMap<Object,Object>();
        for (T t : list) {
            map.put(t.hashCode(),t);
        }
        list.clear();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            list.add((T) map.get(it.next()));
        }
        return list;
    }

}
