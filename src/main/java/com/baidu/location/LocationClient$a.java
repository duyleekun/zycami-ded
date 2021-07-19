/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.baidu.location;

import android.app.Notification;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import java.lang.ref.WeakReference;

public class LocationClient$a
extends Handler {
    private final WeakReference a;

    public LocationClient$a(Looper object, LocationClient locationClient) {
        super(object);
        super(locationClient);
        this.a = object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message var1_1) {
        block31: {
            block29: {
                block30: {
                    block34: {
                        block32: {
                            block33: {
                                var2_2 = (LocationClient)this.a.get();
                                if (var2_2 == null) {
                                    return;
                                }
                                var3_3 = var1_1 /* !! */ .what;
                                var4_4 = 21;
                                var5_5 = 1;
                                if (var3_3 == var4_4) break block29;
                                var4_4 = 303;
                                var6_6 = "UTF-8";
                                if (var3_3 == var4_4) ** GOTO lbl129
                                var4_4 = 406;
                                if (var3_3 == var4_4) break block30;
                                var4_4 = 701;
                                if (var3_3 == var4_4) {
                                    var1_1 /* !! */  = (BDLocation)var1_1 /* !! */ .obj;
                                    LocationClient.a((LocationClient)var2_2, (BDLocation)var1_1 /* !! */ );
                                    return;
                                }
                                var4_4 = 1300;
                                if (var3_3 == var4_4) {
                                    LocationClient.e((LocationClient)var2_2, var1_1 /* !! */ );
                                    return;
                                }
                                var4_4 = 1400;
                                if (var3_3 == var4_4) {
                                    LocationClient.f((LocationClient)var2_2, var1_1 /* !! */ );
                                    return;
                                }
                                var4_4 = 26;
                                if (var3_3 == var4_4) break block31;
                                var4_4 = 27;
                                if (var3_3 == var4_4) {
                                    LocationClient.i((LocationClient)var2_2, var1_1 /* !! */ );
                                    return;
                                }
                                var4_4 = 54;
                                if (var3_3 == var4_4) break block32;
                                var4_4 = 55;
                                var5_5 = 0;
                                var7_8 = null;
                                if (var3_3 == var4_4) break block33;
                                var4_4 = 703;
                                if (var3_3 == var4_4) ** GOTO lbl87
                                var4_4 = 704;
                                if (var3_3 != var4_4) {
                                    switch (var3_3) {
                                        default: {
                                            super.handleMessage(var1_1 /* !! */ );
                                            return;
                                        }
                                        case 12: {
                                            LocationClient.t(var2_2);
                                            return;
                                        }
                                        case 11: {
                                            LocationClient.r(var2_2);
                                            return;
                                        }
                                        case 10: {
                                            LocationClient.h(var2_2, var1_1 /* !! */ );
                                            return;
                                        }
                                        case 9: {
                                            LocationClient.g(var2_2, var1_1 /* !! */ );
                                            return;
                                        }
                                        case 8: {
                                            LocationClient.b(var2_2, var1_1 /* !! */ );
                                            return;
                                        }
                                        case 6: {
                                            LocationClient.d(var2_2, var1_1 /* !! */ );
                                            return;
                                        }
                                        case 5: {
                                            LocationClient.c(var2_2, var1_1 /* !! */ );
                                            return;
                                        }
                                        case 4: {
                                            LocationClient.s(var2_2);
                                            return;
                                        }
                                        case 3: {
                                            LocationClient.a(var2_2, var1_1 /* !! */ );
                                            return;
                                        }
                                        case 2: {
                                            LocationClient.q(var2_2);
                                            return;
                                        }
                                        case 1: {
                                            LocationClient.p(var2_2);
                                            return;
                                        }
                                        case 7: 
                                    }
                                    return;
                                }
                                var1_1 /* !! */  = var1_1 /* !! */ .getData();
                                var8_10 = "removenotify";
                                var9_15 = var1_1 /* !! */ .getBoolean(var8_10);
                                LocationClient.e(var2_2, var9_15);
                                return;
lbl87:
                                // 1 sources

                                var3_3 = (var1_1 /* !! */  = var1_1 /* !! */ .getData()).getInt(var8_11 = "id", 0);
                                if (var3_3 <= 0) return;
                                var10_19 = "notification";
                                var1_1 /* !! */  = var1_1 /* !! */ .getParcelable(var10_19);
                                var1_1 /* !! */  = (Notification)var1_1 /* !! */ ;
                                LocationClient.a(var2_2, var3_3, (Notification)var1_1 /* !! */ );
                                return;
                            }
                            var1_1 /* !! */  = LocationClient.f(var2_2);
                            var9_16 = var1_1 /* !! */ .location_change_notify;
                            if (var9_16 == false) return;
                            break block34;
                        }
                        var1_1 /* !! */  = LocationClient.f((LocationClient)var2_2);
                        var9_17 = var1_1 /* !! */ .location_change_notify;
                        if (var9_17 == false) return;
                    }
                    LocationClient.c(var2_2, (boolean)var5_5);
                    return;
                }
                try {
                    var1_1 /* !! */  = var1_1 /* !! */ .getData();
                    var8_12 = "mac";
                    var8_12 = var1_1 /* !! */ .getByteArray((String)var8_12);
                    var4_4 = 0;
                    var10_20 = null;
                    if (var8_12 != null) {
                        var10_20 = new String((byte[])var8_12, var6_6);
                    }
                    var8_12 = "hotspot";
                    var5_5 = -1;
                    var9_18 = var1_1 /* !! */ .getInt((String)var8_12, var5_5);
                    var8_12 = LocationClient.m((LocationClient)var2_2);
                    if (var8_12 == null) return;
                    var2_2 = LocationClient.m((LocationClient)var2_2);
                    var2_2 = var2_2.iterator();
                    while ((var3_3 = (int)var2_2.hasNext()) != 0) {
                        var8_12 = var2_2.next();
                        var8_12 = (BDAbstractLocationListener)var8_12;
                        var8_12.onConnectHotSpotMessage(var10_20, var9_18);
                    }
                    return;
lbl129:
                    // 1 sources

                    var1_1 /* !! */  = var1_1 /* !! */ .getData();
                    var8_13 = "loctype";
                    var3_3 = var1_1 /* !! */ .getInt(var8_13);
                    var10_21 = "diagtype";
                    var4_4 = var1_1 /* !! */ .getInt(var10_21);
                    var7_9 = "diagmessage";
                    var1_1 /* !! */  = (Message)var1_1 /* !! */ .getByteArray((String)var7_9);
                    if (var3_3 <= 0) return;
                    if (var4_4 <= 0) return;
                    if (var1_1 /* !! */  == null) return;
                    var7_9 = LocationClient.m((LocationClient)var2_2);
                    if (var7_9 == null) return;
                    var2_2 = LocationClient.m((LocationClient)var2_2);
                    var2_2 = var2_2.iterator();
                    while ((var5_5 = (int)var2_2.hasNext()) != 0) {
                        var7_9 = var2_2.next();
                        var7_9 = (BDAbstractLocationListener)var7_9;
                        var11_22 = new String((byte[])var1_1 /* !! */ , var6_6);
                        var7_9.onLocDiagnosticMessage(var3_3, var4_4, var11_22);
                    }
                    return;
                }
                catch (Exception v0) {}
            }
            var8_14 = var1_1 /* !! */ .getData();
            var6_7 = BDLocation.class.getClassLoader();
            var8_14.setClassLoader((ClassLoader)var6_7);
            var6_7 = "locStr";
            var8_14 = (BDLocation)var8_14.getParcelable((String)var6_7);
            var12_23 = LocationClient.u((LocationClient)var2_2);
            if (var12_23 == 0 && (var12_23 = LocationClient.v((LocationClient)var2_2)) == var5_5 && (var3_3 = var8_14.getLocType()) == (var12_23 = 66)) {
                return;
            }
            var3_3 = (int)LocationClient.u((LocationClient)var2_2);
            if (var3_3 == 0 && (var3_3 = (int)LocationClient.v((LocationClient)var2_2)) == var5_5) {
                LocationClient.d((LocationClient)var2_2, (boolean)var5_5);
                return;
            }
            var3_3 = (int)LocationClient.u((LocationClient)var2_2);
            if (var3_3 == 0) {
                LocationClient.d((LocationClient)var2_2, (boolean)var5_5);
            }
        }
        LocationClient.a((LocationClient)var2_2, var1_1 /* !! */ , var4_4);
        return;
    }
}

