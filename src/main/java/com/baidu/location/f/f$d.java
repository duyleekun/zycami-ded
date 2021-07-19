/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GpsSatellite
 *  android.location.GpsStatus
 *  android.location.GpsStatus$Listener
 */
package com.baidu.location.f;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import com.baidu.location.f.f;
import com.baidu.location.f.g;
import java.util.ArrayList;

public class f$d
implements GpsStatus.Listener {
    public final /* synthetic */ f a;
    private long b = 0L;

    private f$d(f f10) {
        this.a = f10;
    }

    public /* synthetic */ f$d(f f10, g g10) {
        this(f10);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onGpsStatusChanged(int var1_1) {
        block16: {
            var2_2 = f.f(this.a);
            if (var2_2 == null) {
                return;
            }
            var3_3 = 2;
            var4_4 = 0;
            var5_5 = 0.0f;
            var6_6 = null;
            var7_7 = 0;
            if (var1_1 == var3_3) {
                f.b(this.a, null);
                var8_9 = this.a;
                f.a(var8_9, false);
                f.a = 0;
                f.a(0);
                return;
            }
            var3_3 = 4;
            if (var1_1 != var3_3) {
                return;
            }
            var8_8 = this.a;
            var1_1 = (int)f.a((f)var8_8);
            if (var1_1 == 0) {
                return;
            }
            try {
                var8_8 = this.a;
                var8_8 = f.l((f)var8_8);
                if (var8_8 == null) {
                    var8_8 = this.a;
                    var2_2 = f.f((f)var8_8);
                    var2_2 = var2_2.getGpsStatus(null);
                    f.a((f)var8_8, (GpsStatus)var2_2);
                } else {
                    var8_8 = this.a;
                    var8_8 = f.f((f)var8_8);
                    var2_2 = this.a;
                    var2_2 = f.l((f)var2_2);
                    var8_8.getGpsStatus((GpsStatus)var2_2);
                }
                var8_8 = this.a;
                var8_8 = f.l((f)var8_8);
                var8_8 = var8_8.getSatellites();
                var8_8 = var8_8.iterator();
                var2_2 = this.a;
                var9_10 = System.currentTimeMillis();
                f.f((f)var2_2, var9_10);
                var2_2 = this.a;
                var2_2 = f.g((f)var2_2);
                var2_2.clear();
                var2_2 = this.a;
                var2_2 = f.h((f)var2_2);
                var2_2.clear();
                var2_2 = this.a;
                var2_2 = f.i((f)var2_2);
                var2_2.clear();
                var2_2 = this.a;
                var2_2 = f.j((f)var2_2);
                var2_2.clear();
                var3_3 = 0;
                var2_2 = null;
lbl62:
                // 4 sources

                while ((var4_4 = var8_8.hasNext()) != 0) {
                    var6_6 = var8_8.next();
                    var6_6 = (GpsSatellite)var6_6;
                    var11_11 = new ArrayList();
                    var12_12 = var6_6.getPrn();
                    var13_13 = var6_6.getAzimuth();
                    var14_14 = Float.valueOf(var13_13);
                    var11_11.add(var14_14);
                    var13_13 = var6_6.getElevation();
                    var14_14 = Float.valueOf(var13_13);
                    var11_11.add(var14_14);
                    var13_13 = var6_6.getSnr();
                    var14_14 = Float.valueOf(var13_13);
                    var11_11.add(var14_14);
                    var4_4 = var6_6.usedInFix();
                    var15_15 = 32;
                    var13_13 = 4.5E-44f;
                    var16_16 = 1.0f;
                    var17_17 = 1;
                    if (var4_4 != 0) {
                        ++var7_7;
                        var6_6 = Float.valueOf(var16_16);
                        var11_11.add(var6_6);
                        if (var12_12 >= var17_17 && var12_12 <= var15_15) {
                            ++var3_3;
                        }
                        break block16;
                    }
                    var4_4 = 0;
                    var5_5 = 0.0f;
                    var6_6 = null;
                    var6_6 = Float.valueOf(0.0f);
                    var11_11.add(var6_6);
                    break block16;
                }
                ** GOTO lbl162
            }
            catch (Exception v0) {
                return;
            }
        }
        var5_5 = var12_12;
        {
            block20: {
                block19: {
                    block18: {
                        block17: {
                            var6_6 = Float.valueOf(var5_5);
                            var11_11.add(var6_6);
                            if (var12_12 < var17_17 || var12_12 > var15_15) break block17;
                            var6_6 = Float.valueOf(var16_16);
                            var11_11.add(var6_6);
                            var6_6 = this.a;
                            var6_6 = f.g((f)var6_6);
lbl113:
                            // 4 sources

                            while (true) {
                                var6_6.add(var11_11);
                                ** GOTO lbl62
                                break;
                            }
                        }
                        var4_4 = 201;
                        var5_5 = 2.82E-43f;
                        if (var12_12 < var4_4) break block18;
                        var4_4 = 235;
                        var5_5 = 3.3E-43f;
                        if (var12_12 > var4_4) break block18;
                        var4_4 = 0x40000000;
                        var5_5 = 2.0f;
                        var6_6 = Float.valueOf(var5_5);
                        var11_11.add(var6_6);
                        var6_6 = this.a;
                        var6_6 = f.h((f)var6_6);
                        ** GOTO lbl113
                    }
                    var4_4 = 65;
                    var5_5 = 9.1E-44f;
                    if (var12_12 < var4_4) break block19;
                    var4_4 = 96;
                    var5_5 = 1.35E-43f;
                    if (var12_12 > var4_4) break block19;
                    var4_4 = 0x40400000;
                    var5_5 = 3.0f;
                    var6_6 = Float.valueOf(var5_5);
                    var11_11.add(var6_6);
                    var6_6 = this.a;
                    var6_6 = f.i((f)var6_6);
                    ** GOTO lbl113
                }
                var4_4 = 301;
                var5_5 = 4.22E-43f;
                if (var12_12 < var4_4) ** GOTO lbl62
                var4_4 = 336;
                var5_5 = 4.71E-43f;
                if (var12_12 > var4_4) ** GOTO lbl62
                var4_4 = 0x40800000;
                var5_5 = 4.0f;
                var6_6 = Float.valueOf(var5_5);
                var11_11.add(var6_6);
                var6_6 = this.a;
                var6_6 = f.j((f)var6_6);
                ** continue;
lbl162:
                // 1 sources

                var8_8 = new ArrayList();
                var6_6 = this.a;
                var6_6 = f.g((f)var6_6);
                var8_8.addAll(var6_6);
                var6_6 = this.a;
                var6_6 = f.h((f)var6_6);
                var8_8.addAll(var6_6);
                var6_6 = this.a;
                var6_6 = f.i((f)var6_6);
                var8_8.addAll(var6_6);
                var6_6 = this.a;
                var6_6 = f.j((f)var6_6);
                var8_8.addAll(var6_6);
                var6_6 = this.a;
                f.a((f)var6_6, var8_8);
                var8_8 = this.a;
                var12_12 = 1;
                var15_15 = 0;
                var13_13 = 0.0f;
                var14_14 = null;
                var16_16 = 0.0f;
                var17_17 = 0;
                var18_18 = true;
                var19_19 = -1.0f;
                var11_11 = var8_8;
                var6_6 = f.a((f)var8_8, (boolean)var12_12, false, false, false, var18_18, var19_19);
                f.b((f)var8_8, (ArrayList)var6_6);
                var8_8 = this.a;
                var6_6 = f.k((f)var8_8);
                f.b = var8_8 = f.c((f)var8_8, (ArrayList)var6_6);
                if (var3_3 > 0) {
                    f.a(var3_3);
                }
                if (var7_7 <= 0) break block20;
                var20_20 = System.currentTimeMillis();
lbl202:
                // 2 sources

                while (true) {
                    this.b = var20_20;
                    f.a = var7_7;
                    ** GOTO lbl214
                    break;
                }
            }
            var20_20 = System.currentTimeMillis();
            var9_10 = this.b;
        }
        cfr_temp_0 = (var20_20 -= var9_10) - (var9_10 = (long)100);
        var1_1 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var1_1 <= 0) ** GOTO lbl214
        {
            var20_20 = System.currentTimeMillis();
            ** continue;
lbl214:
            // 2 sources

            var20_20 = System.currentTimeMillis();
            f.a(var20_20);
            return;
        }
    }
}

