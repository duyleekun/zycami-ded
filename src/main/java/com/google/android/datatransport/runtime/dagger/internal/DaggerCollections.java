/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 0x40000000;

    private DaggerCollections() {
    }

    private static int calculateInitialCapacity(int n10) {
        int n11 = 3;
        if (n10 < n11) {
            return n10 + 1;
        }
        n11 = 0x40000000;
        if (n10 < n11) {
            return (int)((float)n10 / 0.75f + 1.0f);
        }
        return -1 >>> 1;
    }

    public static boolean hasDuplicates(List list) {
        int n10 = list.size();
        boolean bl2 = false;
        int n11 = 2;
        if (n10 < n11) {
            return false;
        }
        HashSet hashSet = new HashSet(list);
        int n12 = list.size();
        if (n12 != (n10 = hashSet.size())) {
            bl2 = true;
        }
        return bl2;
    }

    public static HashSet newHashSetWithExpectedSize(int n10) {
        n10 = DaggerCollections.calculateInitialCapacity(n10);
        HashSet hashSet = new HashSet(n10);
        return hashSet;
    }

    public static LinkedHashMap newLinkedHashMapWithExpectedSize(int n10) {
        n10 = DaggerCollections.calculateInitialCapacity(n10);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        return linkedHashMap;
    }

    public static List presizedList(int n10) {
        if (n10 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }
}

