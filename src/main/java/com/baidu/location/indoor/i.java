/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.g$e;
import com.baidu.location.indoor.g$h;
import com.baidu.location.indoor.mapversion.a.a;
import com.baidu.location.indoor.n$a;
import java.util.Date;

public class i
implements n$a {
    public final /* synthetic */ g a;

    public i(g g10) {
        this.a = g10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(double var1_1, double var3_2, double var5_3, long var7_4) {
        var9_5 = this;
        synchronized (this) {
            block81: {
                block80: {
                    block79: {
                        var10_6 = this.a;
                        var11_8 = g.c((g)var10_6);
                        if (var11_8) break block79;
                        return;
                    }
                    var10_6 = this.a;
                    var12_9 /* !! */  = 0.4;
                    g.a((g)var10_6, var12_9 /* !! */ );
                    var10_6 = this.a;
                    var14_10 = g.a((g)var10_6);
                    var15_11 /* !! */  = var1_1;
                    var17_12 /* !! */  = var3_2;
                    g$e.a((g$e)var14_10, var1_1, var3_2, var5_3, var7_4);
                    var10_6 = this.a;
                    var14_10 = g.d((g)var10_6);
                    var10_6 = com.baidu.location.indoor.mapversion.a.a.a((String)var14_10, var1_1, var3_2, var5_3);
                    if (var10_6 == null) ** GOTO lbl222
                    var19_13 = 0;
                    var14_10 = null;
                    var15_11 /* !! */  = (double)var10_6[0];
                    var17_12 /* !! */  = -1.0;
                    var20_14 = var15_11 /* !! */  == var17_12 /* !! */  ? 0 : (var15_11 /* !! */  > var17_12 /* !! */  ? 1 : -1);
                    if (var20_14 == false) ** GOTO lbl222
                    var12_9 /* !! */  = (double)var10_6[0];
                    var21_15 /* !! */  = 0.0;
                    var19_13 = var12_9 /* !! */  == var21_15 /* !! */  ? 0 : (var12_9 /* !! */  > var21_15 /* !! */  ? 1 : -1);
                    if (var19_13 != 0) ** GOTO lbl222
                    var14_10 = this.a;
                    var20_14 = 2;
                    var23_16 = 2.8E-45f;
                    var21_15 /* !! */  = (double)var10_6[var20_14];
                    g.b((g)var14_10, var21_15 /* !! */ );
                    var14_10 = this.a;
                    var24_17 = 1;
                    var25_18 = 1.4E-45f;
                    var17_12 /* !! */  = (double)var10_6[var24_17];
                    g.c((g)var14_10, var17_12 /* !! */ );
                    var14_10 = this.a;
                    var14_10 = g.e((g)var14_10);
                    var19_13 = var14_10.size();
                    var26_19 = 50;
                    if (var19_13 <= var26_19) ** GOTO lbl73
                    var14_10 = this.a;
                    var14_10 = g.e((g)var14_10);
                    var14_10.clear();
lbl73:
                    // 2 sources

                    var14_10 = var9_5.a;
                    var14_10 = g.e((g)var14_10);
                    var28_21 = var9_5.a;
                    var29_22 = g.f(var28_21);
                    var30_23 = var29_22.d();
                    var29_22 = var27_20;
                    var27_20 = new g$h(var28_21, var30_23, var1_1, var5_3, var3_2);
                    var14_10.add(var27_20);
                    var14_10 = var9_5.a;
                    g.g((g)var14_10);
                    var14_10 = new BDLocation();
                    var26_19 = 161;
                    var14_10.setLocType(var26_19);
                    var17_12 /* !! */  = (double)var10_6[var20_14];
                    var14_10.setLatitude(var17_12 /* !! */ );
                    var17_12 /* !! */  = (double)var10_6[var24_17];
                    var14_10.setLongitude(var17_12 /* !! */ );
                    var17_12 /* !! */  = var5_3;
                    var23_16 = (float)var5_3;
                    var14_10.setDirection(var23_16);
                    var31_24 = new Date();
                    var29_22 = var9_5.a;
                    var29_22 = var29_22.b;
                    var31_24 = var29_22.format((Date)var31_24);
                    var14_10.setTime((String)var31_24);
                    var31_24 = var9_5.a;
                    var31_24 = g.d((g)var31_24);
                    var14_10.setFloor((String)var31_24);
                    var31_24 = var9_5.a;
                    var31_24 = g.h((g)var31_24);
                    var14_10.setBuildingID((String)var31_24);
                    var31_24 = var9_5.a;
                    var31_24 = g.i((g)var31_24);
                    var14_10.setBuildingName((String)var31_24);
                    var31_24 = var9_5.a;
                    var20_14 = g.j((g)var31_24);
                    var14_10.setParkAvailable((int)var20_14);
                    var14_10.setIndoorLocMode((boolean)var24_17);
                    var31_24 = var9_5.a;
                    var20_14 = (double)g.k((g)var31_24);
                    if (var20_14 == false) break block80;
                    var20_14 = 0x41000000;
                    var23_16 = 8.0f;
                    var14_10.setRadius(var23_16);
                    break block81;
                }
                var20_14 = 1097859072;
                var23_16 = 15.0f;
                var14_10.setRadius(var23_16);
            }
            var31_24 = "res";
            var14_10.setFusionLocInfo((String)var31_24, (double[])var10_6);
            var20_14 = 5;
            var23_16 = 7.0E-45f;
            var21_15 /* !! */  = (double)var10_6[var20_14];
            var25_18 = (float)var21_15 /* !! */ ;
            var14_10.setRadius(var25_18);
            var24_17 = 6;
            var25_18 = 8.4E-45f;
            var21_15 /* !! */  = (double)var10_6[var24_17];
            var25_18 = (float)var21_15 /* !! */ ;
            var14_10.setDirection(var25_18);
            var24_17 = 8;
            var25_18 = 1.1E-44f;
            var21_15 /* !! */  = (double)var10_6[var24_17];
            var25_18 = (float)var21_15 /* !! */ ;
            var14_10.setSpeed(var25_18);
            var32_25 = "dr";
            var14_10.setNetworkLocationType((String)var32_25);
            var32_25 = new BDLocation((BDLocation)var14_10);
            var29_22 = "dr2";
            var32_25.setNetworkLocationType((String)var29_22);
            var29_22 = var9_5.a;
            var29_22 = g.l((g)var29_22);
            if (var29_22 == null) ** GOTO lbl205
            var29_22 = var9_5.a;
            var29_22 = g.l((g)var29_22);
            var26_19 = (int)var29_22.c();
            if (var26_19 == 0) ** GOTO lbl205
            var29_22 = var9_5.a;
            var29_22 = g.l((g)var29_22);
            var29_22.a((BDLocation)var32_25);
            ** GOTO lbl209
lbl205:
            // 2 sources

            var29_22 = var9_5.a;
            var33_26 = 21;
            g.a((g)var29_22, (BDLocation)var32_25, var33_26);
lbl209:
            // 2 sources

            var32_25 = var9_5.a;
            var32_25 = g.a((g)var32_25);
            var17_12 /* !! */  = (double)var10_6[var20_14];
            var10_6 = "dr";
            var11_8 = g$e.a((g$e)var32_25, (BDLocation)var14_10, var17_12 /* !! */ , (String)var10_6);
            if (var11_8) ** GOTO lbl222
            var10_6 = var9_5.a;
            var10_6.d();
lbl222:
            // 6 sources

            return;
            {
                catch (Exception v0) {
                    ** continue;
                }
            }
        }
    }
}

