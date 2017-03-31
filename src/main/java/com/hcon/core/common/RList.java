package com.hcon.core.common;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

public class RList {

    public static <T> List<T> removeDuplicate(List<T> original) {
        return newArrayList(newHashSet(original));
    }

    public static boolean isEmpty(Collection c) { return c == null || c.isEmpty(); }

}
