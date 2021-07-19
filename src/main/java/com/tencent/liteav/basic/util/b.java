/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.tencent.liteav.basic.util;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.d;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class b {
    private static final long a = TimeUnit.SECONDS.toMillis(2);
    private final long b;
    private final int c;
    private RandomAccessFile d;
    private RandomAccessFile e;
    private long f;
    private float g;
    private float h;
    private long i;
    private long j;
    private float k;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public b() {
        Object object;
        int n10;
        long l10;
        String string2 = "r";
        this.f = l10 = 0L;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = l10;
        this.j = l10;
        this.k = 0.0f;
        this.b = l10 = TXCTimeUtil.getClockTickInHz();
        this.c = n10 = Runtime.getRuntime().availableProcessors();
        Object object2 = Locale.ENGLISH;
        int n11 = 1;
        Object object3 = new Object[n11];
        int n12 = Process.myPid();
        object3[0] = object = Integer.valueOf(n12);
        object = "/proc/%d/stat";
        object2 = String.format((Locale)object2, (String)object, (Object[])object3);
        super((String)object2, string2);
        try {
            this.d = object3;
        }
        catch (IOException iOException) {
            super();
            object = "open /proc/[PID]/stat failed. ";
            ((StringBuilder)object3).append((String)object);
            object2 = iOException.getMessage();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object3 = "CpuUsageMeasurer";
            TXCLog.e((String)object3, (String)object2);
        }
        object3 = "/proc/stat";
        try {
            object2 = new RandomAccessFile((String)object3, string2);
        }
        catch (IOException iOException) {
            return;
        }
        this.e = object2;
    }

    private static String[] a(RandomAccessFile object) {
        if (object == null) {
            return null;
        }
        long l10 = 0L;
        try {
            ((RandomAccessFile)object).seek(l10);
            object = ((RandomAccessFile)object).readLine();
        }
        catch (IOException iOException) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "read line failed. ";
            charSequence.append(string2);
            object = iOException.getMessage();
            charSequence.append((String)object);
            object = charSequence.toString();
            charSequence = "CpuUsageMeasurer";
            TXCLog.e((String)charSequence, (String)object);
            object = null;
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        return ((String)object).split("\\s+");
    }

    private void b() {
        Object object = com.tencent.liteav.basic.util.b.a(this.d);
        if (object != null) {
            int n10 = ((String[])object).length;
            int n11 = 52;
            float f10 = 7.3E-44f;
            if (n10 >= n11) {
                long l10;
                float f11;
                int n12;
                long l11;
                long l12;
                int n13;
                int n14;
                String string2 = object[13];
                long l13 = Long.parseLong(string2);
                long l14 = Long.parseLong(object[14]);
                l13 += l14;
                String string3 = object[15];
                l14 = Long.parseLong(string3);
                l13 += l14;
                int n15 = 16;
                float f12 = 2.24E-44f;
                l14 = Long.parseLong(object[n15]);
                float f13 = l13 += l14;
                n10 = 1148846080;
                float f14 = 1000.0f;
                f13 *= f14;
                f10 = this.b;
                long l15 = (long)(f13 /= f10);
                object = com.tencent.liteav.basic.util.b.a(this.e);
                if (object != null && (n14 = ((String[])object).length) >= (n13 = 8)) {
                    n14 = 1;
                    String string4 = object[n14];
                    l12 = Long.parseLong(string4);
                    l11 = Long.parseLong(object[2]);
                    l12 += l11;
                    l11 = Long.parseLong(object[3]);
                    l12 += l11;
                    int n16 = 4;
                    String string5 = object[n16];
                    long l16 = Long.parseLong(string5);
                    l12 += l16;
                    int n17 = 5;
                    long l17 = Long.parseLong(object[n17]);
                    l12 += l17;
                    l17 = Long.parseLong(object[6]);
                    l12 += l17;
                    n12 = 7;
                    f11 = 9.8E-45f;
                    String string6 = object[n12];
                    l17 = Long.parseLong(string6);
                    l12 += l17;
                    String string7 = object[n16];
                    l17 = Long.parseLong(string7);
                    object = object[n17];
                    l11 = Long.parseLong((String)object);
                    l17 += l11;
                    f13 = (float)l12 * f14;
                    l12 = this.b;
                    float f15 = l12;
                    l11 = (long)(f13 / f15);
                    f13 = (float)l17 * f14;
                    f14 = l12;
                    l10 = (long)(f13 /= f14);
                } else {
                    l10 = TXCTimeUtil.getTimeTick();
                    n14 = this.c;
                    l12 = n14;
                    l10 = l11 = l10 * l12;
                }
                l12 = this.i;
                l12 = l11 - l12;
                f10 = l15;
                f12 = this.g;
                f12 = f10 - f12;
                n12 = 1120403456;
                f11 = 100.0f;
                f12 *= f11;
                float f16 = l12;
                this.h = f12 /= f16;
                long l18 = this.j;
                l18 = l10 - l18;
                this.k = f12 = (float)(l12 -= l18) * f11 / f16;
                this.g = f10;
                this.j = l10;
                this.i = l11;
                this.f = l10 = TXCTimeUtil.getTimeTick();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int[] a() {
        synchronized (this) {
            int n10;
            long l10 = TXCTimeUtil.getTimeTick();
            long l11 = this.f;
            l10 -= l11;
            l11 = a;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 >= 0) {
                this.b();
            }
            l12 = 2;
            int[] nArray = new int[l12];
            int n11 = 0;
            float f10 = this.h;
            float f11 = 10.0f;
            nArray[0] = n10 = (int)(f10 *= f11);
            n11 = 1;
            f10 = this.k * f11;
            nArray[n11] = n10 = (int)f10;
            return nArray;
        }
    }

    public void finalize() {
        super.finalize();
        com.tencent.liteav.basic.util.d.a(this.d);
        com.tencent.liteav.basic.util.d.a(this.e);
        TXCLog.i("CpuUsageMeasurer", "measurer is released");
    }
}

