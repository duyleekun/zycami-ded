/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationListener
 *  android.os.Bundle
 */
package com.baidu.location.f;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.location.f.f;
import com.baidu.location.f.g;
import com.baidu.location.h.l;

public class f$f
implements LocationListener {
    public final /* synthetic */ f a;

    private f$f(f f10) {
        this.a = f10;
    }

    public /* synthetic */ f$f(f f10, g g10) {
        this(f10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onLocationChanged(Location object) {
        float f10;
        int n10;
        float f11;
        int n11;
        if (object == null) {
            return;
        }
        double d10 = Math.abs(object.getLatitude());
        long l10 = 4645040803167600640L;
        double d11 = 360.0;
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object2 > 0) return;
        d10 = Math.abs(object.getLongitude());
        double d13 = d10 - d11;
        Object object3 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object3 > 0) {
            return;
        }
        f f12 = this.a;
        long l11 = object.getTime();
        long l12 = 1000L;
        f.a(f12, l11 /= l12);
        f12 = this.a;
        l11 = System.currentTimeMillis();
        f.b(f12, l11);
        f12 = this.a;
        long l13 = f.c(f12);
        l10 = 0L;
        d11 = 0.0;
        long l14 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
        if (l14 != false) {
            f12 = this.a;
            l11 = System.currentTimeMillis();
            f f13 = this.a;
            l12 = f.c(f13);
            f.c(f12, l11 -= l12);
        }
        f12 = this.a;
        l11 = System.currentTimeMillis();
        f.d(f12, l11);
        int n12 = f.a;
        if (n12 == 0) {
            try {
                Bundle bundle = object.getExtras();
                String string2 = "satellites";
                n11 = bundle.getInt(string2);
            }
            catch (Exception exception) {}
        }
        if (n11 == 0) {
            boolean bl2;
            System.currentTimeMillis();
            f12 = this.a;
            f.d(f12);
            f11 = object.getAccuracy();
            n10 = 1112014848;
            f10 = 50.0f;
            float f14 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (f14 > 0 && !(bl2 = l.m)) {
                return;
            }
        }
        f12 = this.a;
        n10 = 1;
        f10 = Float.MIN_VALUE;
        f.a(f12, n10 != 0);
        f.b(this.a, object);
        f f15 = this.a;
        boolean bl3 = false;
        f11 = 0.0f;
        f12 = null;
        f.b(f15, false);
    }

    public void onProviderDisabled(String string2) {
        f.b(this.a, null);
        f.a(this.a, false);
    }

    public void onProviderEnabled(String string2) {
    }

    public void onStatusChanged(String string2, int n10, Bundle bundle) {
        block3: {
            f f10;
            block4: {
                block1: {
                    int n11;
                    block2: {
                        if (n10 == 0) break block1;
                        n11 = 1;
                        if (n10 == n11) break block2;
                        n11 = 2;
                        if (n10 == n11) {
                            f f11 = this.a;
                            f.b(f11, false);
                        }
                        break block3;
                    }
                    f10 = this.a;
                    long l10 = System.currentTimeMillis();
                    f.e(f10, l10);
                    f10 = this.a;
                    f.b(f10, n11 != 0);
                    break block4;
                }
                f10 = this.a;
                boolean bl2 = false;
                f.b(f10, null);
            }
            f10 = this.a;
            f.a(f10, false);
        }
    }
}

