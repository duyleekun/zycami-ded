/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package com.chad.library.adapter.base.delegate;

import android.util.SparseIntArray;
import f.h2.t.f0;
import f.h2.t.u;
import java.util.List;

public abstract class BaseMultiTypeDelegate {
    private boolean autoMode;
    private SparseIntArray layouts;
    private boolean selfMode;

    public BaseMultiTypeDelegate() {
        this(null, 1, null);
    }

    public BaseMultiTypeDelegate(SparseIntArray sparseIntArray) {
        f0.q(sparseIntArray, "layouts");
        this.layouts = sparseIntArray;
    }

    public /* synthetic */ BaseMultiTypeDelegate(SparseIntArray sparseIntArray, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            sparseIntArray = new SparseIntArray();
        }
        this(sparseIntArray);
    }

    private final void checkMode(boolean bl2) {
        if (bl2 ^= true) {
            return;
        }
        String string2 = "Don't mess two register mode".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private final void registerItemType(int n10, int n11) {
        this.layouts.put(n10, n11);
    }

    public final BaseMultiTypeDelegate addItemType(int n10, int n11) {
        this.selfMode = true;
        boolean bl2 = this.autoMode;
        this.checkMode(bl2);
        this.registerItemType(n10, n11);
        return this;
    }

    public final BaseMultiTypeDelegate addItemTypeAutoIncrease(int ... nArray) {
        String string2 = "layoutResIds";
        f0.q(nArray, string2);
        this.autoMode = true;
        int n10 = this.selfMode;
        this.checkMode(n10 != 0);
        n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            this.registerItemType(i10, n11);
        }
        return this;
    }

    public abstract int getItemType(List var1, int var2);

    public final int getLayoutId(int n10) {
        Object object = this.layouts;
        int n11 = object.get(n10);
        boolean bl2 = n11 != 0;
        if (bl2) {
            return n11;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("ViewType: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" found layoutResId\uff0cplease use registerItemType() first!");
        String string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }
}

