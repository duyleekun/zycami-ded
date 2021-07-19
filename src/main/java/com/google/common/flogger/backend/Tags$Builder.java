/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.Tags;
import com.google.common.flogger.util.Checks;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class Tags$Builder {
    private final SortedMap map;

    public Tags$Builder() {
        TreeMap treeMap;
        this.map = treeMap = new TreeMap();
    }

    private void addImpl(String string2, Object object) {
        TreeSet<Object> treeSet = this.map;
        Object object2 = Checks.checkMetadataIdentifier(string2);
        if ((treeSet = (SortedSet)treeSet.get(object2)) == null || treeSet == (object2 = Tags.access$200())) {
            object2 = Tags.access$300();
            treeSet = new TreeSet<Object>((Comparator<Object>)object2);
            object2 = this.map;
            object2.put(string2, treeSet);
        }
        treeSet.add(object);
    }

    public Tags$Builder addTag(String string2) {
        Object object = this.map;
        Object object2 = Checks.checkMetadataIdentifier(string2);
        if ((object = (Set)object.get(object2)) == null) {
            object = this.map;
            object2 = Tags.access$200();
            object.put(string2, object2);
        }
        return this;
    }

    public Tags$Builder addTag(String string2, double d10) {
        Double d11 = d10;
        this.addImpl(string2, d11);
        return this;
    }

    public Tags$Builder addTag(String string2, long l10) {
        Long l11 = l10;
        this.addImpl(string2, l11);
        return this;
    }

    public Tags$Builder addTag(String object, String string2) {
        if (string2 != null) {
            this.addImpl((String)object, string2);
            return this;
        }
        object = new IllegalArgumentException("tag values cannot be null");
        throw object;
    }

    public Tags$Builder addTag(String string2, boolean bl2) {
        Boolean bl3 = bl2;
        this.addImpl(string2, bl3);
        return this;
    }

    public Tags build() {
        boolean bl2;
        SortedMap sortedMap = this.map;
        boolean bl3 = sortedMap.isEmpty();
        if (bl3) {
            return Tags.access$400();
        }
        sortedMap = new SortedMap();
        Object object = this.map.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            SortedSet sortedSet = object.next();
            Object k10 = sortedSet.getKey();
            sortedSet = (SortedSet)sortedSet.getValue();
            TreeSet treeSet = new TreeSet(sortedSet);
            sortedSet = Collections.unmodifiableSortedSet(treeSet);
            sortedMap.put(k10, sortedSet);
        }
        sortedMap = Collections.unmodifiableSortedMap(sortedMap);
        object = new Tags(sortedMap, null);
        return object;
    }

    public String toString() {
        return this.build().toString();
    }
}

