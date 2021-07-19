/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.data;

import com.huawei.hms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Arrays;

public final class FreezableUtils {
    public static ArrayList freeze(ArrayList arrayList) {
        return FreezableUtils.freezeIterable(arrayList);
    }

    public static ArrayList freeze(Freezable[] freezableArray) {
        return FreezableUtils.freezeIterable(Arrays.asList(freezableArray));
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

