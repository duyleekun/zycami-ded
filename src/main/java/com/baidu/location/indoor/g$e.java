/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package com.baidu.location.indoor;

import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.f.h;
import com.baidu.location.f.i;
import com.baidu.location.indoor.g;
import java.util.List;

public class g$e {
    public final /* synthetic */ g a;
    private double b = -1.0;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private double l;
    private double m;
    private double n;
    private double o;
    private int p;
    private int q;
    private h r;
    private long s;
    private int t;
    private int u;

    public g$e(g g10) {
        double d10;
        long l10;
        this.a = g10;
        this.c = l10 = 0L;
        this.d = l10;
        this.e = l10;
        this.f = l10;
        this.g = l10;
        this.h = l10;
        this.i = l10;
        this.j = l10;
        this.k = l10;
        this.l = d10 = 0.0;
        this.m = d10;
        this.n = d10;
        this.o = d10;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = l10;
        this.t = 0;
        this.u = 0;
    }

    public static /* synthetic */ long a(g$e g$e) {
        return g$e.c;
    }

    private void a() {
        double d10;
        long l10;
        this.b = -1.0;
        this.c = l10 = 0L;
        this.d = l10;
        this.f = l10;
        this.g = l10;
        this.h = l10;
        this.i = l10;
        this.j = l10;
        this.k = l10;
        this.l = d10 = 0.0;
        this.m = d10;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = l10;
        this.t = 0;
        this.u = 0;
        this.e = l10;
    }

    private void a(double d10, double d11, double d12, long l10) {
        this.j = l10;
        this.u = 0;
    }

    private void a(Location location, boolean bl2) {
        float f10;
        int n10;
        float f11;
        long l10;
        g$e g$e = this;
        this.k = l10 = System.currentTimeMillis();
        double d10 = location.getLongitude();
        double d11 = location.getLatitude();
        double d12 = this.l;
        long l11 = 0L;
        double d13 = 0.0;
        double d14 = d12 - d13;
        Object object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object != false) {
            float[] fArray = new float[2];
            d13 = this.m;
            Location.distanceBetween((double)d13, (double)d12, (double)d11, (double)d10, (float[])fArray);
            float f12 = fArray[0];
            float f13 = 20.0f;
            object = f12 == f13 ? 0 : (f12 < f13 ? -1 : 1);
            if (object < 0) {
                object = this.p + 1;
                this.p = (int)object;
            } else {
                this.p = 0;
            }
            f12 = fArray[0];
            f13 = 5.0f;
            object = f12 == f13 ? 0 : (f12 < f13 ? -1 : 1);
            if (object < 0) {
                object = g$e.q + 1;
                g$e.q = (int)object;
            } else {
                g$e.q = 0;
            }
        }
        g$e.l = d10;
        g$e.m = d11;
        Object object2 = location.hasSpeed();
        if (object2 != 0) {
            f11 = location.getSpeed();
            n10 = 0x40400000;
            f10 = 3.0f;
            float f14 = f11 - f10;
            object2 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object2 > 0) {
                g$e.h = l10 = System.currentTimeMillis();
            }
        }
        f11 = location.getAccuracy();
        n10 = 1112014848;
        f10 = 50.0f;
        float f15 = f11 - f10;
        object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
        g$e.t = object2 < 0 && !bl2 ? (object2 = g$e.t + 1) : 0;
        object2 = g$e.t;
        n10 = 10;
        f10 = 1.4E-44f;
        if (object2 > n10) {
            l10 = System.currentTimeMillis();
            l11 = g$e.c;
            l10 -= l11;
            l11 = 30000L;
            d13 = 1.4822E-319;
            object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object2 > 0) {
                g g10 = g$e.a;
                g10.d();
            }
        }
    }

    public static /* synthetic */ void a(g$e g$e, double d10, double d11, double d12, long l10) {
        g$e.a(d10, d11, d12, l10);
    }

    public static /* synthetic */ void a(g$e g$e, Location location, boolean bl2) {
        g$e.a(location, bl2);
    }

    private boolean a(double d10, double d11, double d12) {
        int n10;
        g$e g$e = this;
        Object object = com.baidu.location.indoor.g.a(this.a);
        Object object2 = ((g$e)object).c();
        boolean bl2 = true;
        if (object2 == 0) {
            return bl2;
        }
        long l10 = System.currentTimeMillis();
        long l11 = this.f;
        long l12 = 0L;
        double d13 = 0.0;
        object2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object2 != 0) {
            l11 = l10 - l11;
            l12 = 10000L;
            d13 = 4.9407E-320;
            object2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (object2 > 0) {
                return bl2;
            }
        }
        if ((object2 = g$e.q) >= (n10 = 5)) {
            l12 = 4624633867356078080L;
            d13 = 15.0;
            double d14 = d12 - d13;
            object2 = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
            if (object2 < 0) {
                l12 = g$e.c;
                l10 -= l12;
                l12 = 20000L;
                d13 = 9.8813E-320;
                object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (object2 > 0) {
                    object = new float[2];
                    d13 = g$e.o;
                    double d15 = g$e.n;
                    Location.distanceBetween((double)d13, (double)d15, (double)d11, (double)d10, (float[])object);
                    Object object3 = object[0];
                    float f10 = 30.0f;
                    object2 = object3 == f10 ? 0 : (object3 > f10 ? 1 : -1);
                    if (object2 > 0) {
                        return bl2;
                    }
                }
            }
        }
        return false;
    }

    private boolean a(BDLocation object, double d10, String string2) {
        long l10;
        long l11;
        int n10;
        int n11;
        long l12;
        long l13;
        int n12;
        long l122;
        this.i = l122 = System.currentTimeMillis();
        this.b = d10;
        this.n = d10 = ((BDLocation)object).getLongitude();
        this.o = d10 = ((BDLocation)object).getLatitude();
        Object object2 = "wifi";
        int n112 = string2.equals(object2);
        if (n112) {
            this.c = l122;
        }
        if (n112 = string2.equals(object2 = "gps")) {
            this.e = l122;
        }
        if (n112 = this.e()) {
            this.f = l122;
        }
        object2 = this.a;
        double d11 = ((BDLocation)object).getLongitude();
        double d12 = ((BDLocation)object).getLatitude();
        boolean n122 = ((g)object2).a(d11, d12);
        com.baidu.location.indoor.g.e((g)object2, n122);
        object = this.a;
        boolean bl2 = com.baidu.location.indoor.g.o((g)object);
        n112 = 1;
        if (bl2 || (n12 = com.baidu.location.indoor.g.n((g)(object = this.a))) == n112) {
            this.g = l122;
        }
        long l14 = this.s;
        long l15 = 0L;
        d12 = 0.0;
        long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        long l17 = 10000L;
        long l18 = 30000L;
        if (l16 != false && (l13 = (l12 = (l14 = l122 - l14) - l18) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            l14 = this.j;
            long l19 = (l14 = l122 - l14) - l17;
            Object object3 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            if (object3 < 0) {
                l14 = this.k;
                long l20 = (l14 = l122 - l14) - l17;
                Object object4 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object4 < 0) {
                    return false;
                }
            }
        }
        if ((n11 = this.t) > (n10 = 10)) {
            l14 = this.c;
            long l21 = (l14 = l122 - l14) - l18;
            Object object5 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object5 > 0) {
                return false;
            }
        }
        l14 = this.g;
        long l22 = (l14 = l122 - l14) - l17;
        Object object6 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
        if (object6 > 0) {
            l14 = this.c;
            long l23 = (l14 = l122 - l14) - l18;
            Object object7 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
            if (object7 > 0) {
                return false;
            }
        }
        if ((l11 = (l10 = (l14 = this.f) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            l122 -= l14;
            l14 = 60000L;
            d11 = 2.9644E-319;
            Object object8 = l122 == l14 ? 0 : (l122 < l14 ? -1 : 1);
            if (object8 > 0) {
                return false;
            }
        }
        return n112 != 0;
    }

    public static /* synthetic */ boolean a(g$e g$e, double d10, double d11, double d12) {
        return g$e.a(d10, d11, d12);
    }

    public static /* synthetic */ boolean a(g$e g$e, BDLocation bDLocation, double d10, String string2) {
        return g$e.a(bDLocation, d10, string2);
    }

    public static /* synthetic */ long b(g$e g$e) {
        return g$e.e;
    }

    private boolean b() {
        int n10;
        System.currentTimeMillis();
        Object object = this.a;
        int n11 = com.baidu.location.indoor.g.c((g)object);
        if (n11 == 0 && (n11 = this.p) >= (n10 = 3)) {
            object = com.baidu.location.f.i.a().h();
            String string2 = "&wifio";
            n11 = (int)(((String)object).contains(string2) ? 1 : 0);
            n10 = 1;
            if (n11 != 0 || (n11 = com.baidu.location.indoor.g.n((g)(object = this.a))) == n10) {
                this.u = n10;
                return n10 != 0;
            }
        }
        return false;
    }

    private boolean c() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15 = System.currentTimeMillis();
        long l16 = this.h;
        l16 = l15 - l16;
        long l17 = 10000L;
        Object object = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
        long l18 = 30000L;
        if (object < 0) {
            l14 = this.c;
            long l19 = (l14 = l15 - l14) - l18;
            object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            if (object > 0) {
                return false;
            }
        }
        l14 = this.k;
        long l20 = (l14 = l15 - l14) - l17;
        object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        return object >= 0 || (object = (l13 = (l17 = this.j) - (l14 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false || (object = (l12 = (l17 = l15 - l17) - (l14 = 16000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0 || (l11 = (l10 = (l15 -= (l17 = this.c)) - l18) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0;
    }

    public static /* synthetic */ boolean c(g$e g$e) {
        return g$e.b();
    }

    private void d() {
        Object object;
        h h10 = com.baidu.location.f.i.a().q();
        List list = h10.a;
        if (list == null) {
            return;
        }
        long l10 = System.currentTimeMillis();
        h h11 = this.r;
        if (h11 == null || (object = h10.b(h11)) == 0) {
            long l11 = this.s;
            long l12 = 10000L;
            long l13 = (l11 = l10 - l11) - l12;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object < 0) {
                this.d = l10;
            }
            this.s = l10;
            this.r = h10;
        }
    }

    public static /* synthetic */ void d(g$e g$e) {
        g$e.a();
    }

    private boolean e() {
        long l10;
        int n10 = this.u;
        int n11 = 1;
        if (n10 == n11) {
            return false;
        }
        n10 = (int)(this.c() ? 1 : 0);
        if (!n10) {
            return false;
        }
        double d10 = this.b;
        long l11 = 4627730092099895296L;
        double d11 = 25.0;
        double d12 = d10 - d11;
        n10 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
        if (n10 > 0) {
            return false;
        }
        long l12 = System.currentTimeMillis();
        l11 = this.i;
        l12 -= l11;
        l11 = 30000L;
        d11 = 1.4822E-319;
        n10 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
        if (n10 > 0) {
            return false;
        }
        this.f = l10 = System.currentTimeMillis();
        return n11 != 0;
    }

    public static /* synthetic */ boolean e(g$e g$e) {
        return g$e.e();
    }

    public static /* synthetic */ void f(g$e g$e) {
        g$e.d();
    }

    public static /* synthetic */ long g(g$e g$e) {
        return g$e.f;
    }

    public static /* synthetic */ double h(g$e g$e) {
        return g$e.b;
    }
}

