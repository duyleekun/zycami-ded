/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.location.GnssStatus$Callback
 *  android.location.LocationManager
 */
package com.baidu.location.f;

import android.location.GnssStatus;
import android.location.LocationManager;
import com.baidu.location.f.f;
import com.baidu.location.f.g;
import java.io.Serializable;
import java.util.ArrayList;

public class f$c
extends GnssStatus.Callback {
    public final /* synthetic */ f a;

    private f$c(f f10) {
        this.a = f10;
    }

    public /* synthetic */ f$c(f f10, g g10) {
        this(f10);
    }

    public void onFirstFix(int n10) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onSatelliteStatusChanged(GnssStatus object) {
        LocationManager locationManager = f.f(this.a);
        if (locationManager == null) {
            return;
        }
        f f10 = this.a;
        long l10 = System.currentTimeMillis();
        f.f(f10, l10);
        int n10 = object.getSatelliteCount();
        f.g(this.a).clear();
        f.h(this.a).clear();
        f.i(this.a).clear();
        f.j(this.a).clear();
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        while (true) {
            block15: {
                Serializable serializable;
                Object object2;
                block12: {
                    float f11;
                    int n15;
                    float f12;
                    int n16;
                    block14: {
                        block13: {
                            block11: {
                                if (n11 >= n10) {
                                    object = new ArrayList();
                                    ArrayList arrayList = f.g(this.a);
                                    ((ArrayList)object).addAll(arrayList);
                                    ArrayList arrayList2 = f.h(this.a);
                                    ((ArrayList)object).addAll(arrayList2);
                                    ArrayList arrayList3 = f.i(this.a);
                                    ((ArrayList)object).addAll(arrayList3);
                                    ArrayList arrayList4 = f.j(this.a);
                                    ((ArrayList)object).addAll(arrayList4);
                                    f.a(this.a, (ArrayList)object);
                                    object2 = object = this.a;
                                    ArrayList arrayList5 = f.a((f)object, true, false, false, false, true, -1.0f);
                                    f.b((f)object, arrayList5);
                                    object = this.a;
                                    ArrayList arrayList6 = f.k((f)object);
                                    f.b = f.c((f)object, arrayList6);
                                    f.a = n12;
                                    f.a(n13);
                                    f.b(n14);
                                    f.a(System.currentTimeMillis());
                                    return;
                                }
                                ++n14;
                                object2 = new ArrayList();
                                n16 = object.getConstellationType(n11);
                                Float f13 = Float.valueOf(object.getAzimuthDegrees(n11));
                                ((ArrayList)object2).add(f13);
                                f13 = Float.valueOf(object.getElevationDegrees(n11));
                                ((ArrayList)object2).add(f13);
                                f12 = object.getCn0DbHz(n11);
                                f13 = Float.valueOf(f12);
                                ((ArrayList)object2).add(f13);
                                n15 = object.usedInFix(n11);
                                float f14 = 1.0f;
                                int n17 = 1;
                                if (n15 != 0) {
                                    ++n12;
                                    f13 = Float.valueOf(f14);
                                    ((ArrayList)object2).add(f13);
                                    if (n16 == n17) {
                                        ++n13;
                                    }
                                } else {
                                    n15 = 0;
                                    f12 = 0.0f;
                                    f13 = Float.valueOf(0.0f);
                                    ((ArrayList)object2).add(f13);
                                }
                                n15 = object.getSvid(n11);
                                f12 = n15;
                                f13 = Float.valueOf(f12);
                                ((ArrayList)object2).add(f13);
                                if (n16 != n17) break block11;
                                serializable = Float.valueOf(f14);
                                ((ArrayList)object2).add(serializable);
                                serializable = f.g(this.a);
                                break block12;
                            }
                            n15 = 5;
                            f12 = 7.0E-45f;
                            if (n16 != n15) break block13;
                            n16 = 0x40000000;
                            f11 = 2.0f;
                            serializable = Float.valueOf(f11);
                            ((ArrayList)object2).add(serializable);
                            serializable = f.h(this.a);
                            break block12;
                        }
                        n15 = 3;
                        f12 = 4.2E-45f;
                        if (n16 != n15) break block14;
                        n16 = 0x40400000;
                        f11 = 3.0f;
                        serializable = Float.valueOf(f11);
                        ((ArrayList)object2).add(serializable);
                        serializable = f.i(this.a);
                        break block12;
                    }
                    n15 = 6;
                    f12 = 8.4E-45f;
                    if (n16 != n15) break block15;
                    n16 = 0x40800000;
                    f11 = 4.0f;
                    serializable = Float.valueOf(f11);
                    ((ArrayList)object2).add(serializable);
                    serializable = f.j(this.a);
                }
                ((ArrayList)serializable).add(object2);
            }
            ++n11;
        }
    }

    public void onStarted() {
    }

    public void onStopped() {
        f.b(this.a, null);
        f.a(this.a, false);
        f.a = 0;
        f.a(0);
    }
}

