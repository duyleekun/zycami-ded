/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import java.util.Arrays;
import java.util.Set;

public abstract class InvalidationTracker$Observer {
    public final String[] mTables;

    public InvalidationTracker$Observer(String string2, String ... stringArray) {
        int n10 = stringArray.length + 1;
        String[] stringArray2 = Arrays.copyOf(stringArray, n10);
        this.mTables = stringArray2;
        int n11 = stringArray.length;
        stringArray2[n11] = string2;
    }

    public InvalidationTracker$Observer(String[] stringArray) {
        int n10 = stringArray.length;
        stringArray = Arrays.copyOf(stringArray, n10);
        this.mTables = stringArray;
    }

    public boolean isRemote() {
        return false;
    }

    public abstract void onInvalidated(Set var1);
}

