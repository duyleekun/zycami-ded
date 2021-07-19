/*
 * Decompiled with CFR 0.151.
 */
package androidx.transition;

import java.util.ArrayList;

public class Transition$ArrayListManager {
    private Transition$ArrayListManager() {
    }

    public static ArrayList add(ArrayList arrayList, Object object) {
        boolean bl2;
        if (arrayList == null) {
            arrayList = new ArrayList<Object>();
        }
        if (!(bl2 = arrayList.contains(object))) {
            arrayList.add(object);
        }
        return arrayList;
    }

    public static ArrayList remove(ArrayList arrayList, Object object) {
        if (arrayList != null) {
            arrayList.remove(object);
            boolean bl2 = arrayList.isEmpty();
            if (bl2) {
                arrayList = null;
            }
        }
        return arrayList;
    }
}

