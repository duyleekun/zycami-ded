/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseBooleanArray
 */
package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.util.Assertions;

public class MutableFlags {
    private final SparseBooleanArray flags;

    public MutableFlags() {
        SparseBooleanArray sparseBooleanArray;
        this.flags = sparseBooleanArray = new SparseBooleanArray();
    }

    public void add(int n10) {
        this.flags.append(n10, true);
    }

    public void clear() {
        this.flags.clear();
    }

    public boolean contains(int n10) {
        return this.flags.get(n10);
    }

    public boolean containsAny(int ... nArray) {
        for (int n10 : nArray) {
            if ((n10 = (int)(this.contains(n10) ? 1 : 0)) == 0) continue;
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof MutableFlags;
        if (!bl2) {
            return false;
        }
        object = (MutableFlags)object;
        SparseBooleanArray sparseBooleanArray = this.flags;
        object = ((MutableFlags)object).flags;
        return sparseBooleanArray.equals(object);
    }

    public int get(int n10) {
        int n11;
        n11 = n10 >= 0 && n10 < (n11 = this.size()) ? 1 : 0;
        Assertions.checkArgument(n11 != 0);
        return this.flags.keyAt(n10);
    }

    public int hashCode() {
        return this.flags.hashCode();
    }

    public int size() {
        return this.flags.size();
    }
}

