/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.KeyValueFormatter;
import com.google.common.flogger.backend.KeyValueHandler;
import com.google.common.flogger.backend.Tags$1;
import com.google.common.flogger.backend.Tags$Builder;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public final class Tags {
    private static final SortedSet EMPTY_SET;
    private static final Tags EMPTY_TAGS;
    private static final Comparator VALUE_COMPARATOR;
    private Integer hashCode = null;
    private final SortedMap map;
    private String toString = null;

    static {
        Object object = new Tags$1();
        VALUE_COMPARATOR = object;
        object = new TreeSet();
        EMPTY_SET = Collections.unmodifiableSortedSet(object);
        SortedMap sortedMap = new SortedMap();
        sortedMap = Collections.unmodifiableSortedMap(sortedMap);
        EMPTY_TAGS = object = new Tags(sortedMap);
    }

    private Tags(SortedMap sortedMap) {
        this.map = sortedMap;
    }

    public /* synthetic */ Tags(SortedMap sortedMap, Tags$1 tags$1) {
        this(sortedMap);
    }

    public static /* synthetic */ SortedSet access$200() {
        return EMPTY_SET;
    }

    public static /* synthetic */ Comparator access$300() {
        return VALUE_COMPARATOR;
    }

    public static /* synthetic */ Tags access$400() {
        return EMPTY_TAGS;
    }

    public static Tags$Builder builder() {
        Tags$Builder tags$Builder = new Tags$Builder();
        return tags$Builder;
    }

    public static Tags empty() {
        return EMPTY_TAGS;
    }

    public SortedMap asMap() {
        return this.map;
    }

    public void emitAll(KeyValueHandler keyValueHandler) {
        boolean bl2;
        Iterator iterator2 = this.map.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Iterator iterator3 = iterator2.next();
            String string2 = (String)iterator3.getKey();
            boolean bl3 = (iterator3 = (Set)iterator3.getValue()).isEmpty();
            if (!bl3) {
                iterator3 = iterator3.iterator();
                while (bl3 = iterator3.hasNext()) {
                    Object e10 = iterator3.next();
                    keyValueHandler.handle(string2, e10);
                }
                continue;
            }
            bl2 = false;
            iterator3 = null;
            keyValueHandler.handle(string2, null);
        }
    }

    public boolean equals(Object object) {
        SortedMap sortedMap;
        boolean bl2;
        boolean bl3 = object instanceof Tags;
        if (bl3 && (bl2 = (object = ((Tags)object).map).equals(sortedMap = this.map))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        Integer n10 = this.hashCode;
        if (n10 == null) {
            int n11 = this.map.hashCode();
            this.hashCode = n10 = Integer.valueOf(n11);
        }
        return this.hashCode;
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Tags merge(Tags object) {
        boolean bl2;
        SortedSet<Object> sortedSet;
        Object object2;
        boolean bl3;
        boolean bl4 = ((Tags)object).isEmpty();
        if (bl4) {
            return this;
        }
        bl4 = this.isEmpty();
        if (bl4) {
            return object;
        }
        SortedMap sortedMap = new SortedMap();
        Object object3 = this.map.entrySet().iterator();
        while (bl3 = object3.hasNext()) {
            boolean bl5;
            object2 = object3.next();
            sortedSet = ((Tags)object).map;
            Object object4 = object2.getKey();
            if ((sortedSet = (SortedSet)sortedSet.get(object4)) != null && !(bl5 = (object4 = (SortedSet)object2.getValue()).containsAll(sortedSet))) {
                object4 = (Collection)object2.getValue();
                bl5 = sortedSet.containsAll((Collection<?>)object4);
                if (bl5) {
                    object2 = object2.getKey();
                    sortedMap.put(object2, sortedSet);
                    continue;
                }
                SortedSet sortedSet2 = (SortedSet)object2.getValue();
                object4 = new TreeSet(sortedSet2);
                object4.addAll(sortedSet);
                object2 = object2.getKey();
                sortedSet = Collections.unmodifiableSortedSet(object4);
                sortedMap.put(object2, sortedSet);
                continue;
            }
            sortedSet = object2.getKey();
            object2 = object2.getValue();
            sortedMap.put(sortedSet, object2);
        }
        object = ((Tags)object).map.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = this.map;
            object3 = (Map.Entry)object.next();
            sortedSet = object3.getKey();
            bl3 = object2.containsKey(sortedSet);
            if (bl3) continue;
            object2 = object3.getKey();
            object3 = object3.getValue();
            sortedMap.put(object2, object3);
        }
        sortedMap = Collections.unmodifiableSortedMap(sortedMap);
        object = new Tags(sortedMap);
        return object;
    }

    public String toString() {
        CharSequence charSequence = this.toString;
        if (charSequence == null) {
            charSequence = new StringBuilder();
            String string2 = "[ ";
            String string3 = " ]";
            KeyValueFormatter keyValueFormatter = new KeyValueFormatter(string2, string3, (StringBuilder)charSequence);
            this.emitAll(keyValueFormatter);
            keyValueFormatter.done();
            charSequence = ((StringBuilder)charSequence).toString();
            this.toString = charSequence;
        }
        return this.toString;
    }
}

