/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssNavigationMessage
 *  android.location.Location
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.b.ab;
import com.baidu.location.b.ac;
import com.baidu.location.b.ad;
import com.baidu.location.b.b;
import com.baidu.location.b.g;
import com.baidu.location.b.k;
import com.baidu.location.b.y;
import com.baidu.location.c.d;
import com.baidu.location.e.h;
import com.baidu.location.f.a;
import com.baidu.location.f.i;
import com.baidu.location.h.l;

public class ae
extends Handler {
    public final /* synthetic */ ad a;

    public ae(ad ad2, Looper looper) {
        this.a = ad2;
        super(looper);
    }

    /*
     * Unable to fully structure code
     */
    public void handleMessage(Message var1_1) {
        block37: {
            var2_4 = var1_1.what;
            switch (var2_4) {
                default: {
                    break block37;
                }
                case 11: {
                    var1_1 = var1_1.getData();
                    var3_5 = "gnss_navigation_message";
                    var3_5 = var1_1.getParcelable(var3_5);
                    var3_5 = (GnssNavigationMessage)var3_5;
                    var4_8 = "gps_time";
                    var5_12 = var1_1.getLong(var4_8);
                    var1_1 = ab.a();
                    var1_1.a((GnssNavigationMessage)var3_5, var5_12);
                    break block37;
                }
                case 8: 
                case 9: {
                    var1_1.getData();
                    break block37;
                }
                case 7: {
                    ac.a().c();
                    var1_1 = com.baidu.location.c.h.a();
                    var1_1.c();
                    break block37;
                }
                case 5: {
                    var1_1 = com.baidu.location.c.h.a();
                    var1_1.b();
                    break block37;
                }
                case 4: {
                    var1_1 = i.a();
                    var7_14 = var1_1.j();
                    var2_4 = (int)l.b();
                    var8_15 = 0;
                    var4_9 = null;
                    if (var2_4 != 0) {
                        var7_14 = 0;
                        var1_1 = null;
                    }
                    var2_4 = 1;
                    if (var7_14 != 0) {
                        var1_1 = k.a();
                        var7_14 = var1_1.d();
                        if (var7_14 != var2_4) {
                            var8_15 = var2_4;
                        }
                    } else {
                        var8_15 = var7_14;
                    }
                    if (var8_15 != 0) {
                        var1_1 = d.a();
                        var7_14 = (int)var1_1.e();
                        if (var7_14 != 0) {
                            h.a().m();
                            var1_1 = h.a();
                            var1_1.i();
                        }
                        com.baidu.location.c.h.a().c();
                        var1_1 = d.a();
                        var7_14 = (int)var1_1.e();
                        if (var7_14 != 0) {
                            var1_1 = ac.a();
                            var1_1.c();
                        }
                    }
                    var1_1 = this.a;
                    var1_1 = ad.a((ad)var1_1);
                    if (var1_1 == null) ** GOTO lbl82
                    var1_1 = this.a;
                    var1_1 = ad.a((ad)var1_1);
                    var2_4 = 4;
                    var8_15 = l.T;
                    var5_13 = var8_15;
                    try {
                        var1_1.sendEmptyMessageDelayed(var2_4, var5_13);
                    }
                    catch (Exception var1_2) {
                        var1_2.printStackTrace();
                    }
lbl82:
                    // 3 sources

                    var1_1 = ab.a();
                    var1_1.b();
                    break block37;
                }
                case 3: {
                    var1_1 = y.c();
                    var2_4 = 0;
                    var3_6 = null;
                    var4_10 = y.d();
                    var9_16 = b.a().d();
                    ** GOTO lbl97
                }
                case 2: {
                    var1_1 = y.c();
                    var3_6 = i.a().o();
                    var4_10 = y.d();
                    var9_16 = y.a();
lbl97:
                    // 2 sources

                    ac.a((a)var1_1, var3_6, var4_10, var9_16);
                    break block37;
                }
                case 1: 
            }
            var1_1 = var1_1.getData();
            var3_7 = "loc";
            var3_7 = var1_1.getParcelable(var3_7);
            var3_7 = (Location)var3_7;
            var4_11 = "satnum";
            var1_1.getInt(var4_11);
            if (var3_7 == null) break block37;
            var1_1 = g.a();
            try {
                var1_1.a((Location)var3_7);
            }
            catch (Exception var1_3) {
                var1_3.printStackTrace();
            }
        }
lbl119:
        // 2 sources

        return;
        catch (Exception v0) {
            ** continue;
        }
    }
}

