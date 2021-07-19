/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zam;
import java.util.concurrent.ExecutorService;

public final class zabh {
    private static final ExecutorService zahw;

    static {
        zal zal2 = zam.zacv();
        NumberedThreadFactory numberedThreadFactory = new NumberedThreadFactory("GAC_Executor");
        zahw = zal2.zaa(2, numberedThreadFactory, 9);
    }

    public static ExecutorService zabb() {
        return zahw;
    }
}

