/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.huawei.hms.framework.network.grs.c.b;

import android.os.SystemClock;
import java.util.concurrent.Future;

public class b {
    private Future a;
    private long b;

    public b(Future future) {
        long l10;
        this.a = future;
        this.b = l10 = SystemClock.elapsedRealtime();
    }

    public Future a() {
        return this.a;
    }

    public boolean b() {
        long l10 = SystemClock.elapsedRealtime();
        long l11 = this.b;
        long l12 = (l10 -= l11) - (l11 = 300000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

