/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.huawei.hms.framework.network.grs.d;

import android.os.SystemClock;

public class d$a {
    private long a;
    private long b;

    public d$a(long l10, long l11) {
        this.a = l10;
        this.b = l11;
    }

    public boolean a() {
        long l10 = SystemClock.elapsedRealtime();
        long l11 = this.b;
        long l12 = (l10 -= l11) - (l11 = this.a);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

