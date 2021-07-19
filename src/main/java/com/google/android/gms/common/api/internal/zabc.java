/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabr;
import java.lang.ref.WeakReference;

public final class zabc
extends zabr {
    private WeakReference zahm;

    public zabc(zaaw zaaw2) {
        WeakReference<zaaw> weakReference;
        this.zahm = weakReference = new WeakReference<zaaw>(zaaw2);
    }

    public final void zas() {
        zaaw zaaw2 = (zaaw)this.zahm.get();
        if (zaaw2 == null) {
            return;
        }
        zaaw.zaa(zaaw2);
    }
}

