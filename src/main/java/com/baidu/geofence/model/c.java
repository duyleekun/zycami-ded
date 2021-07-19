/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package com.baidu.geofence.model;

import android.location.Location;
import com.baidu.geofence.model.DPoint;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.m;
import java.util.ArrayList;
import java.util.List;

public class c {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean a(DPoint var0, List var1_1) {
        var2_2 = var1_1.size();
        var3_3 = (DPoint)var1_1.get(0);
        var4_4 = 1;
        var5_5 = 0;
        for (var6_6 = var4_4; var6_6 <= var2_2; ++var6_6) {
            block12: {
                block13: {
                    block15: {
                        block14: {
                            var7_7 = var0.equals(var3_3);
                            if (var7_7 != 0) {
                                return (boolean)var4_4;
                            }
                            var7_7 = var6_6 % var2_2;
                            var8_8 = (DPoint)var1_1.get(var7_7);
                            var9_9 = var0.getLatitude();
                            var11_10 = var3_3.getLatitude();
                            var13_11 = var8_8.getLatitude();
                            cfr_temp_0 = var9_9 - (var11_10 = Math.min(var11_10, var13_11));
                            var15_12 /* !! */  = (double)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 < 0.0 ? -1 : 1));
                            if (var15_12 /* !! */  < 0) break block12;
                            var9_9 = var0.getLatitude();
                            var11_10 = var3_3.getLatitude();
                            var13_11 = var8_8.getLatitude();
                            cfr_temp_1 = var9_9 - (var11_10 = Math.max(var11_10, var13_11));
                            var15_12 /* !! */  = (double)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 > 0.0 ? 1 : -1));
                            if (var15_12 /* !! */  > 0) break block12;
                            var9_9 = var0.getLatitude();
                            var11_10 = var3_3.getLatitude();
                            var13_11 = var8_8.getLatitude();
                            cfr_temp_2 = var9_9 - (var11_10 = Math.min(var11_10, var13_11));
                            var15_12 /* !! */  = (double)(cfr_temp_2 == 0.0 ? 0 : (cfr_temp_2 > 0.0 ? 1 : -1));
                            if (var15_12 /* !! */  <= 0) break block13;
                            var9_9 = var0.getLatitude();
                            var11_10 = var3_3.getLatitude();
                            var13_11 = var8_8.getLatitude();
                            cfr_temp_3 = var9_9 - (var11_10 = Math.max(var11_10, var13_11));
                            var15_12 /* !! */  = (double)(cfr_temp_3 == 0.0 ? 0 : (cfr_temp_3 < 0.0 ? -1 : 1));
                            if (var15_12 /* !! */  >= 0) break block13;
                            var9_9 = var0.getLongitude();
                            var11_10 = var3_3.getLongitude();
                            var13_11 = var8_8.getLongitude();
                            cfr_temp_4 = var9_9 - (var11_10 = Math.max(var11_10, var13_11));
                            var15_12 /* !! */  = (double)(cfr_temp_4 == 0.0 ? 0 : (cfr_temp_4 < 0.0 ? -1 : 1));
                            if (var15_12 /* !! */  > 0) break block12;
                            var9_9 = var3_3.getLatitude();
                            cfr_temp_5 = var9_9 - (var11_10 = var8_8.getLatitude());
                            var15_12 /* !! */  = (double)(cfr_temp_5 == 0.0 ? 0 : (cfr_temp_5 > 0.0 ? 1 : -1));
                            if (var15_12 /* !! */  == false) {
                                var9_9 = var0.getLongitude();
                                var11_10 = var3_3.getLongitude();
                                var13_11 = var8_8.getLongitude();
                                cfr_temp_6 = var9_9 - (var11_10 = Math.min(var11_10, var13_11));
                                var15_12 /* !! */  = (double)(cfr_temp_6 == 0.0 ? 0 : (cfr_temp_6 > 0.0 ? 1 : -1));
                                if (var15_12 /* !! */  >= 0) {
                                    return (boolean)var4_4;
                                }
                            }
                            if ((var15_12 /* !! */  = (cfr_temp_7 = (var9_9 = var3_3.getLongitude()) - (var11_10 = var8_8.getLongitude())) == 0.0 ? 0 : (cfr_temp_7 > 0.0 ? 1 : -1)) != false) break block14;
                            var9_9 = var3_3.getLongitude();
                            cfr_temp_8 = var9_9 - (var11_10 = var0.getLongitude());
                            var16_13 /* !! */  = (double)(cfr_temp_8 == 0.0 ? 0 : (cfr_temp_8 > 0.0 ? 1 : -1));
                            if (var16_13 /* !! */  == false) {
                                return (boolean)var4_4;
                            }
                            break block15;
                        }
                        var9_9 = var0.getLatitude();
                        var11_10 = var3_3.getLatitude();
                        var9_9 -= var11_10;
                        var11_10 = var8_8.getLongitude();
                        var13_11 = var3_3.getLongitude();
                        var9_9 *= (var11_10 -= var13_11);
                        var11_10 = var8_8.getLatitude();
                        var13_11 = var3_3.getLatitude();
                        var9_9 /= (var11_10 -= var13_11);
                        var11_10 = var3_3.getLongitude();
                        var9_9 += var11_10;
                        var11_10 = Math.abs(var0.getLongitude() - var9_9);
                        cfr_temp_9 = var11_10 - (var13_11 = 2.0E-10);
                        var16_13 /* !! */  = (double)(cfr_temp_9 == 0.0 ? 0 : (cfr_temp_9 < 0.0 ? -1 : 1));
                        if (var16_13 /* !! */  < 0) {
                            return (boolean)var4_4;
                        }
                        var11_10 = var0.getLongitude();
                        cfr_temp_10 = var11_10 - var9_9;
                        var16_13 /* !! */  = (double)(cfr_temp_10 == 0.0 ? 0 : (cfr_temp_10 < 0.0 ? -1 : 1));
                        if (var16_13 /* !! */  >= 0) break block12;
                    }
                    while (true) {
                        ++var5_5;
                        break block12;
                        break;
                    }
                    break block12;
                }
                if ((var15_12 /* !! */  = (cfr_temp_11 = (var9_9 = var0.getLatitude()) - (var11_10 = var8_8.getLatitude())) == 0.0 ? 0 : (cfr_temp_11 > 0.0 ? 1 : -1)) == false && (var15_12 /* !! */  = (cfr_temp_12 = (var9_9 = var0.getLongitude()) - (var11_10 = var8_8.getLongitude())) == 0.0 ? 0 : (cfr_temp_12 < 0.0 ? -1 : 1)) <= 0) {
                    var15_12 /* !! */  = (var6_6 + 1) % var2_2;
                    var17_14 = (DPoint)var1_1.get((int)var15_12 /* !! */ );
                    var18_15 = var0.getLatitude();
                    var20_16 = var3_3.getLatitude();
                    var22_17 = var17_14.getLatitude();
                    cfr_temp_13 = var18_15 - (var20_16 = Math.min(var20_16, var22_17));
                    var24_18 /* !! */  = (double)(cfr_temp_13 == 0.0 ? 0 : (cfr_temp_13 > 0.0 ? 1 : -1));
                    if (var24_18 /* !! */  >= 0) {
                        var18_15 = var0.getLatitude();
                        var20_16 = var3_3.getLatitude();
                        if ((var16_13 /* !! */  = (cfr_temp_14 = var18_15 - (var20_16 = Math.max(var20_16, var22_17 = var17_14.getLatitude()))) == 0.0 ? 0 : (cfr_temp_14 < 0.0 ? -1 : 1)) <= 0) ** continue;
                    }
                    var5_5 += 2;
                }
            }
            var3_3 = var8_8;
        }
        if ((var5_5 %= 2) == 0) {
            return false;
        }
        return (boolean)var4_4;
    }

    public static boolean a(BDLocation bDLocation, ArrayList object) {
        double d10;
        int n10;
        double d11;
        int n11;
        double d12 = 0.0;
        boolean bl2 = false;
        double d13 = d12;
        double d14 = d12;
        DPoint dPoint = null;
        for (int i10 = 0; i10 < (n11 = ((ArrayList)object).size()); ++i10) {
            d11 = ((DPoint)((ArrayList)object).get(i10)).getLatitude();
            d13 += d11;
            DPoint dPoint2 = (DPoint)((ArrayList)object).get(i10);
            d11 = dPoint2.getLongitude();
            d14 += d11;
        }
        d11 = ((ArrayList)object).size();
        d13 /= d11;
        n11 = ((ArrayList)object).size();
        d11 = n11;
        dPoint = new DPoint(d13, d14 /= d11);
        for (int i11 = 0; i11 < (n10 = ((ArrayList)object).size()); ++i11) {
            double d15;
            DPoint dPoint3;
            d14 = ((DPoint)((ArrayList)object).get(i11)).getLatitude();
            double d16 = m.a(d14, d11 = (dPoint3 = (DPoint)((ArrayList)object).get(i11)).getLongitude(), d10 = dPoint.getLatitude(), d15 = dPoint.getLongitude());
            double d17 = d16 - d12;
            Object object2 = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
            if (object2 <= 0) continue;
            d12 = d16;
        }
        int n12 = 2;
        object = new float[n12];
        d13 = bDLocation.getLatitude();
        d14 = bDLocation.getLongitude();
        d11 = dPoint.getLatitude();
        d10 = dPoint.getLongitude();
        Location.distanceBetween((double)d13, (double)d14, (double)d11, (double)d10, (float[])object);
        Object object3 = object[0];
        double d18 = (double)object3;
        double d19 = 500.0;
        double d20 = d18 - (d12 += d19);
        double d21 = d20 == 0.0 ? 0 : (d20 < 0.0 ? -1 : 1);
        if (d21 < 0) {
            bl2 = true;
        }
        return bl2;
    }
}

