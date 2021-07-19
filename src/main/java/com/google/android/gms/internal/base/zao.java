/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.base;

import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zan;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class zao
implements zal {
    private zao() {
    }

    public /* synthetic */ zao(zan zan2) {
        this();
    }

    public final ExecutorService zaa(int n10, ThreadFactory threadFactory, int n11) {
        return Executors.newFixedThreadPool(2, threadFactory);
    }
}

