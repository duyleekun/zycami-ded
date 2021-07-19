/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.tencent.liteav.basic.util;

import android.os.SystemClock;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.concurrent.TimeUnit;

public class c {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private long e;

    public c(String string2, int n10) {
        int n11;
        this.a = string2;
        long l10 = n10;
        long l11 = TimeUnit.SECONDS.toMillis(1L);
        this.b = n11 = (int)Math.max(l10, l11);
        this.b();
    }

    public void a() {
        int n10 = this.c;
        int n11 = 1;
        this.c = n10 += n11;
        long l10 = SystemClock.elapsedRealtime();
        long l11 = this.e;
        long l12 = 0L;
        long l13 = l11 - l12;
        n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        if (n10 == 0) {
            long l14;
            this.e = l14 = SystemClock.elapsedRealtime();
        } else {
            l12 = l10 - l11;
            long l15 = this.b;
            long l16 = l12 - l15;
            n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n10 >= 0) {
                Object object;
                n10 = this.c;
                int n12 = this.d;
                float f10 = n10 - n12;
                n12 = 1148846080;
                float f11 = 1000.0f;
                f10 *= f11;
                l11 = l10 - l11;
                float f12 = l11;
                f10 /= f12;
                int n13 = 2;
                f12 = 2.8E-45f;
                Object[] objectArray = new Object[n13];
                String string2 = this.a;
                objectArray[0] = string2;
                objectArray[n11] = object = Float.valueOf(f10);
                object = "FPSMeter";
                String string3 = "meter name: %s fps: %.2f";
                TXCLog.i((String)object, string3, objectArray);
                this.e = l10;
                this.d = n10 = this.c;
            }
        }
    }

    public void b() {
        this.c = 0;
        this.d = 0;
        this.e = 0L;
    }
}

