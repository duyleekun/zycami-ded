/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;

public final class FreezableUtils {
    public static ArrayList freeze(ArrayList arrayList) {
        int n10 = arrayList.size();
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n10);
        n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = ((Freezable)arrayList.get(i10)).freeze();
            arrayList2.add(object);
        }
        return arrayList2;
    }

    public static ArrayList freeze(Freezable[] freezableArray) {
        int n10;
        int n11 = freezableArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        for (n11 = 0; n11 < (n10 = freezableArray.length); ++n11) {
            Object object = freezableArray[n11].freeze();
            arrayList.add(object);
        }
        return arrayList;
    }

    public static ArrayList freezeIterable(Iterable object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = ((Freezable)object.next()).freeze();
            arrayList.add(object2);
        }
        return arrayList;
    }
}

