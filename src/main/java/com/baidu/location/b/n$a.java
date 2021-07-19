/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.b.n;
import com.baidu.location.b.n$b;
import com.baidu.location.b.n$f;
import java.util.ArrayList;
import org.json.JSONObject;

public class n$a
extends Handler {
    public final /* synthetic */ n a;

    public n$a(n n10, Looper looper) {
        this.a = n10;
        super(looper);
    }

    /*
     * Unable to fully structure code
     */
    private String a(BDLocation var1_1) {
        var2_2 = new JSONObject();
        var3_3 = "latitude";
        var4_4 = var1_1.getLatitude();
        var2_2.put(var3_3, var4_4);
        var3_3 = "longitude";
        var4_4 = var1_1.getLongitude();
        var2_2.put(var3_3, var4_4);
        var3_3 = "radius";
        var6_5 = var1_1.getRadius();
        var4_4 = var6_5;
        var2_2.put(var3_3, var4_4);
        var3_3 = "errorcode";
        var7_6 = 1;
        var6_5 = 1.4E-45f;
        var2_2.put(var3_3, var7_6);
        var8_7 = var1_1.hasAltitude();
        if (var8_7 == 0) ** GOTO lbl36
        var3_3 = "altitude";
        var4_4 = var1_1.getAltitude();
        var2_2.put(var3_3, var4_4);
lbl36:
        // 2 sources

        if ((var8_7 = var1_1.hasSpeed()) == 0) ** GOTO lbl45
        var3_3 = "speed";
        var6_5 = var1_1.getSpeed();
        var9_8 = 3.6f;
        var4_4 = var6_5 /= var9_8;
        var2_2.put(var3_3, var4_4);
lbl45:
        // 2 sources

        var8_7 = var1_1.getLocType();
        var7_6 = 61;
        var6_5 = 8.5E-44f;
        if (var8_7 != var7_6) ** GOTO lbl56
        var3_3 = "direction";
        var6_5 = var1_1.getDirection();
        var4_4 = var6_5;
        var2_2.put(var3_3, var4_4);
lbl56:
        // 2 sources

        if ((var3_3 = var1_1.getBuildingName()) == null) ** GOTO lbl63
        var3_3 = "buildingname";
        var10_9 = var1_1.getBuildingName();
        var2_2.put(var3_3, (Object)var10_9);
lbl63:
        // 2 sources

        if ((var3_3 = var1_1.getBuildingID()) == null) ** GOTO lbl70
        var3_3 = "buildingid";
        var10_9 = var1_1.getBuildingID();
        var2_2.put(var3_3, (Object)var10_9);
lbl70:
        // 2 sources

        if ((var3_3 = var1_1.getFloor()) == null) ** GOTO lbl77
        var3_3 = "floor";
        var1_1 = var1_1.getFloor();
        try {
            var2_2.put(var3_3, var1_1);
lbl77:
            // 2 sources

            var1_1 = var2_2.toString();
        }
        catch (Exception v0) {
            var1_1 = null;
        }
        return var1_1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2) {
        boolean bl2;
        Object object;
        Object object2 = this.a;
        int n10 = n.c((n)object2);
        if (n10 != 0) {
            object2 = n.b(this.a);
            object = n.d(this.a);
            object2.removeCallbacks((Runnable)object);
            object2 = this.a;
            bl2 = false;
            object = null;
            n.a((n)object2, false);
        }
        if ((object2 = n.e(this.a)) == null || (n10 = (object2 = n.e(this.a)).size()) <= 0) return;
        object2 = n.e(this.a).iterator();
        try {
            while (bl2 = object2.hasNext()) {
                object = object2.next();
                Object object3 = ((n$b)(object = (n$b)object)).b();
                if (object3 != null) {
                    object3 = new StringBuilder();
                    String string3 = "javascript:";
                    ((StringBuilder)object3).append(string3);
                    object = ((n$b)object).b();
                    ((StringBuilder)object3).append((String)object);
                    object = "('";
                    ((StringBuilder)object3).append((String)object);
                    ((StringBuilder)object3).append(string2);
                    object = "')";
                    ((StringBuilder)object3).append((String)object);
                    object = ((StringBuilder)object3).toString();
                    object3 = this.a;
                    object3 = n.f((n)object3);
                    object3.loadUrl((String)object);
                }
                object2.remove();
            }
            return;
        }
        catch (Exception exception) {}
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message var1_1) {
        block23: {
            block22: {
                block21: {
                    var2_2 = var1_1 /* !! */ .what;
                    var3_3 = 2;
                    var4_4 = "errorcode";
                    var5_5 = null;
                    switch (var2_2) {
                        default: {
                            return;
                        }
                        case 6: {
                            var1_1 /* !! */  = new JSONObject();
                            var1_1 /* !! */ .put(var4_4, var3_3);
                            var5_5 = var1_1 /* !! */ .toString();
                            break block21;
                        }
                        case 5: {
                            var1_1 /* !! */  = new JSONObject();
                            var1_1 /* !! */ .put(var4_4, 0);
                            var5_5 = var1_1 /* !! */ .toString();
                            break block22;
                        }
                        case 4: {
                            var1_1 /* !! */  = n.e(this.a);
                            if (var1_1 /* !! */  != null) {
                                n.e(this.a).clear();
                                var1_1 /* !! */  = this.a;
                                n.a((n)var1_1 /* !! */ , null);
                            }
                            var1_1 /* !! */  = n.g(this.a);
                            var6_6 = this.a.a;
                            var1_1 /* !! */ .unRegisterLocationListener((BDAbstractLocationListener)var6_6);
                            var1_1 /* !! */  = this.a;
                            var7_9 = 0L;
                            n.a((n)var1_1 /* !! */ , var7_9);
                            n.a(this.a, null);
                            var1_1 /* !! */  = n.d(this.a);
                            if (var1_1 /* !! */  != null && (var9_10 = n.c((n)(var1_1 /* !! */  = this.a)))) {
                                var1_1 /* !! */  = n.b(this.a);
                                var6_6 = n.d(this.a);
                                var1_1 /* !! */ .removeCallbacks((Runnable)var6_6);
                            }
                            n.a(this.a, false);
                            var1_1 /* !! */  = n.f(this.a);
                            var6_6 = "BaiduLocAssistant";
                            var1_1 /* !! */ .removeJavascriptInterface((String)var6_6);
                            return;
                        }
                        case 3: {
                            var1_1 /* !! */  = n.e(this.a);
                            if (var1_1 /* !! */  == null) {
                                var1_1 /* !! */  = this.a;
                                var6_7 = new ArrayList();
                                n.a((n)var1_1 /* !! */ , var6_7);
                            } else {
                                var1_1 /* !! */  = n.e(this.a);
                                var1_1 /* !! */ .clear();
                            }
                            var1_1 /* !! */  = n.g(this.a);
                            var6_7 = this.a.a;
                            var1_1 /* !! */ .registerLocationListener((BDAbstractLocationListener)var6_7);
                            return;
                        }
                        case 2: {
                            var1_1 /* !! */  = (BDLocation)var1_1 /* !! */ .obj;
                            var1_1 /* !! */  = this.a((BDLocation)var1_1 /* !! */ );
                            this.a((String)var1_1 /* !! */ );
                            return;
                        }
                        case 1: {
                            var1_1 /* !! */  = (n$b)var1_1 /* !! */ .obj;
                            var6_8 = n.e(this.a);
                            if (var6_8 != null) {
                                var6_8 = n.e(this.a);
                                var6_8.add(var1_1 /* !! */ );
                            }
                            if ((var1_1 /* !! */  = n.g(this.a)) == null) return;
                            var1_1 /* !! */  = n.g(this.a);
                            var9_11 = var1_1 /* !! */ .requestLocation();
                            var2_2 = true;
                            if (var9_11 == 0) ** GOTO lbl-1000
                            var10_12 = System.currentTimeMillis();
                            var12_13 = n.h(this.a);
                            var10_12 -= var12_13;
                            var1_1 /* !! */  = n.i(this.a);
                            if (var1_1 /* !! */  != null && (var9_11 = (int)((cfr_temp_0 = var10_12 - (var12_13 = 10000L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) <= 0) {
                                var1_1 /* !! */  = n.b(this.a).obtainMessage(var3_3);
                                var1_1 /* !! */ .obj = var14_14 = n.i(this.a);
                                var1_1 /* !! */ .sendToTarget();
                                var9_11 = 0;
                                var1_1 /* !! */  = null;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var9_11 = var2_2;
                            }
                            if (var9_11 == 0) return;
                            var1_1 /* !! */  = this.a;
                            var9_11 = (int)n.c((n)var1_1 /* !! */ );
                            if (var9_11 != 0) {
                                var1_1 /* !! */  = n.b(this.a);
                                var14_14 = n.d(this.a);
                                var1_1 /* !! */ .removeCallbacks((Runnable)var14_14);
                                var1_1 /* !! */  = this.a;
                                n.a((n)var1_1 /* !! */ , false);
                            }
                            if ((var1_1 /* !! */  = n.d(this.a)) == null) {
                                var1_1 /* !! */  = this.a;
                                var14_14 = new n$f((n)var1_1 /* !! */ , null);
                                n.a((n)var1_1 /* !! */ , (n$f)var14_14);
                            }
                            var1_1 /* !! */  = n.b(this.a);
                            var14_14 = n.d(this.a);
                            var15_15 = n.c();
                            var1_1 /* !! */ .postDelayed((Runnable)var14_14, var15_15);
                            var1_1 /* !! */  = this.a;
                            n.a((n)var1_1 /* !! */ , var2_2);
                            return;
                        }
                    }
                    catch (Exception v0) {}
                }
                if (var5_5 == null) return;
                break block23;
                catch (Exception v1) {}
            }
            if (var5_5 == null) return;
        }
        this.a(var5_5);
    }
}

