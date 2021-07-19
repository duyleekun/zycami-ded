/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Handler
 */
package com.baidu.location.indoor;

import android.location.Location;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.q$a;
import com.baidu.location.indoor.q$b;

public class q {
    private q$a a;
    private long b = 450L;
    private BDLocation c;
    private q$b d = null;
    private q$b e = null;
    private q$b f;
    private q$b g;
    private q$b h;
    private q$b i;
    private BDLocation j;
    private long k;
    private boolean l;
    private Handler m;
    private Runnable n;
    private Runnable o;

    public q() {
        Object object;
        q$b q$b;
        this.f = q$b = new q$b(this);
        this.g = q$b = new q$b(this);
        this.h = q$b = new q$b(this);
        this.i = q$b = new q$b(this);
        this.j = null;
        this.k = -1;
        this.l = false;
        this.m = object = new Handler();
        super(this);
        this.n = object;
        super(this);
        this.o = object;
    }

    public static /* synthetic */ long a(q q10, long l10) {
        q10.k = l10;
        return l10;
    }

    private q$b a(q$b q$b) {
        q$b q$b2 = this.d;
        if (q$b2 != null && q$b != null) {
            q$b = q$b2.a(q$b);
            this.i = q$b2 = this.i.b(q$b);
            q$b2 = this.h;
            q$b q$b3 = this.f;
            q$b2 = q$b2.a(q$b3);
            q$b q$b4 = this.h;
            this.f = q$b3 = new q$b(this, q$b4);
            this.h = q$b3 = new q$b(this, q$b);
            q$b = q$b.a(0.2);
            q$b3 = this.i.a(0.01);
            q$b2 = q$b2.a(-0.02);
            return q$b.b(q$b3).b(q$b2);
        }
        return null;
    }

    public static /* synthetic */ q$b a(q q10) {
        return q10.e;
    }

    public static /* synthetic */ q$b a(q q10, q$b q$b) {
        return q10.a(q$b);
    }

    public static /* synthetic */ q$a b(q q10) {
        return q10.a;
    }

    public static /* synthetic */ q$b b(q q10, q$b q$b) {
        q10.e = q$b;
        return q$b;
    }

    public static /* synthetic */ long c(q q10) {
        return q10.k;
    }

    public static /* synthetic */ long d(q q10) {
        return q10.b;
    }

    public static /* synthetic */ BDLocation e(q q10) {
        return q10.c;
    }

    public static /* synthetic */ Runnable f(q q10) {
        return q10.o;
    }

    public static /* synthetic */ Handler g(q q10) {
        return q10.m;
    }

    public static /* synthetic */ BDLocation h(q q10) {
        return q10.j;
    }

    public void a() {
        boolean bl2 = this.l;
        if (!bl2) {
            return;
        }
        this.l = false;
        Handler handler = this.m;
        Runnable runnable = this.o;
        handler.removeCallbacks(runnable);
        this.b();
    }

    public void a(long l10) {
        this.b = l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(BDLocation bDLocation) {
        q q10 = this;
        Object object = bDLocation;
        synchronized (this) {
            q$b q$b;
            double d10 = bDLocation.getLatitude();
            double d11 = bDLocation.getLongitude();
            this.c = bDLocation;
            Object object2 = q$b;
            double d12 = d10;
            double d13 = d11;
            this.d = q$b = new q$b(this, d10, d11);
            object2 = this.e;
            if (object2 == null) {
                object2 = q$b;
                this.e = q$b = new q$b(this, d10, d11);
            }
            if ((object2 = q10.j) == null) {
                q10.j = object2 = new BDLocation((BDLocation)object);
            } else {
                double d14 = ((BDLocation)object2).getLatitude();
                BDLocation bDLocation2 = q10.j;
                d12 = bDLocation2.getLongitude();
                d13 = bDLocation.getLatitude();
                double d15 = bDLocation.getLongitude();
                int n10 = 2;
                Object object3 = 2.8E-45f;
                object = new float[n10];
                d10 = d14;
                d11 = d12;
                Location.distanceBetween((double)d14, (double)d12, (double)d13, (double)d15, (float[])object);
                float f10 = 0.0f;
                object3 = object[0];
                f10 = 10.0f;
                n10 = (int)(object3 == f10 ? 0 : (object3 > f10 ? 1 : -1));
                if (n10 > 0) {
                    object = q10.j;
                    ((BDLocation)object).setLatitude(d13);
                    object = q10.j;
                    d10 = d15;
                    ((BDLocation)object).setLongitude(d15);
                } else {
                    d10 = d15;
                    object = q10.j;
                    d14 += d13;
                    d13 = 2.0;
                    ((BDLocation)object).setLatitude(d14 /= d13);
                    object = q10.j;
                    d12 = (d12 + d15) / d13;
                    ((BDLocation)object).setLongitude(d12);
                }
            }
            return;
        }
    }

    public void b() {
        q$b q$b;
        this.k = -1;
        this.e = null;
        this.d = null;
        this.f = q$b = new q$b(this);
        this.g = q$b = new q$b(this);
        this.h = q$b = new q$b(this);
        this.i = q$b = new q$b(this);
    }

    public boolean c() {
        return this.l;
    }
}

