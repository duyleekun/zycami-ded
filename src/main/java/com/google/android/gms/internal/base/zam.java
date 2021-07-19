/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.base;

import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zao;

public final class zam {
    private static final zal zarp;
    private static volatile zal zarq;

    static {
        zao zao2 = new zao(null);
        zarp = zao2;
        zarq = zao2;
    }

    public static zal zacv() {
        return zarq;
    }
}

