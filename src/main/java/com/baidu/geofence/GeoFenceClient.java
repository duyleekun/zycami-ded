/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.PendingIntent$CanceledException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.baidu.geofence;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.geofence.GeoFence;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.a.b$a;
import com.baidu.geofence.a.f;
import com.baidu.geofence.a.f$a;
import com.baidu.geofence.a.j;
import com.baidu.geofence.a.j$a;
import com.baidu.geofence.b;
import com.baidu.geofence.c;
import com.baidu.geofence.d;
import com.baidu.geofence.model.DPoint;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption$LocationMode;
import com.baidu.location.h.l;
import com.baidu.location.indoor.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeoFenceClient
extends BDAbstractLocationListener
implements j$a {
    public static final String BD09LL = "bd09ll";
    public static final String BD09MC = "bd09mc";
    public static final String GCJ02 = "gcj02";
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_IN_OUT = 4;
    public static final int GEOFENCE_IN_OUT_STAYED = 7;
    public static final int GEOFENCE_IN_STAYED = 5;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_OUT_STAYED = 6;
    public static final int GEOFENCE_STAYED = 3;
    public static final String WGS84 = "wgs84";
    private static Handler w;
    private String a;
    private GeoFenceListener b;
    private ArrayList c;
    private LocationClient d;
    private Intent e;
    private PendingIntent f;
    private Context g;
    private int h;
    private int i;
    private boolean j;
    private LocationClientOption k;
    private boolean l;
    private boolean m;
    private long n;
    private StringBuilder o;
    private StringBuilder p;
    private StringBuilder q;
    private StringBuilder r;
    private StringBuilder s;
    private int t;
    private int u;
    private int v;

    public GeoFenceClient(Context object) {
        long l10;
        boolean bl2 = true;
        this.h = bl2;
        this.i = bl2;
        this.j = bl2;
        Looper looper = null;
        this.l = false;
        this.m = false;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.g = object;
        this.c = object;
        super();
        this.o = object;
        super();
        this.p = object;
        super();
        this.q = object;
        super();
        this.r = object;
        super();
        this.s = object;
        object = Looper.myLooper();
        if (object == null) {
            looper = Looper.getMainLooper();
            super(looper);
        } else {
            looper = Looper.myLooper();
            super(looper);
        }
        w = object;
        looper = this.g;
        super((Context)looper);
        this.d = object;
        super();
        this.k = object;
        ((LocationClientOption)object).setScanSpan(5000);
        this.k.setIsNeedAddress(bl2);
        object = this.d;
        LocationClientOption locationClientOption = this.k;
        ((LocationClient)object).setLocOption(locationClientOption);
        this.d.registerLocationListener(this);
        this.n = l10 = System.currentTimeMillis();
    }

    private int a(long l10, long l11) {
        return Integer.parseInt(String.valueOf((l11 - l10) / 1000L));
    }

    public static /* synthetic */ GeoFenceListener a(GeoFenceClient geoFenceClient) {
        return geoFenceClient.b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private BDLocation a(DPoint object, String object2) {
        Object object3 = new BDLocation();
        double d10 = ((DPoint)object).getLatitude();
        ((BDLocation)object3).setLatitude(d10);
        d10 = ((DPoint)object).getLongitude();
        ((BDLocation)object3).setLongitude(d10);
        String string2 = BD09MC;
        boolean bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)object2);
        if (bl2) {
            object = "bd092gcj";
            return LocationClient.getBDLocationInCoorType((BDLocation)object3, (String)object);
        }
        string2 = BD09LL;
        bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)object2);
        if (bl2) {
            object = "bd09ll2gcj";
            return LocationClient.getBDLocationInCoorType((BDLocation)object3, (String)object);
        }
        string2 = WGS84;
        bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)object2);
        if (bl2) {
            object = "gps2gcj";
            return LocationClient.getBDLocationInCoorType((BDLocation)object3, (String)object);
        }
        object3 = GCJ02;
        boolean bl3 = TextUtils.equals((CharSequence)object3, (CharSequence)object2);
        if (!bl3) return null;
        object2 = new BDLocation();
        double d11 = ((DPoint)object).getLatitude();
        ((BDLocation)object2).setLatitude(d11);
        d11 = ((DPoint)object).getLongitude();
        ((BDLocation)object2).setLongitude(d11);
        return object2;
    }

    private void a() {
        boolean bl2;
        this.j = bl2 = true;
        LocationClient locationClient = this.d;
        if (locationClient != null && !(bl2 = locationClient.isStarted())) {
            locationClient = this.d;
            locationClient.start();
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a(int var1_1, BDLocation var2_2, GeoFence var3_3) {
        block10: {
            block16: {
                block13: {
                    block14: {
                        block15: {
                            block11: {
                                block12: {
                                    var4_4 = this;
                                    var5_5 = var1_1;
                                    var6_6 = var2_2;
                                    var7_7 = var3_3;
                                    var8_8 = var3_3.getActivatesAction();
                                    var9_9 = "1";
                                    var10_10 = var8_8.contains(var9_9);
                                    var11_11 = 2;
                                    var12_12 = 1;
                                    if (var10_10 == 0) break block11;
                                    if (var1_1 != var12_12) break block12;
                                    var13_13 = var2_2.getLatitude();
                                    var15_16 = var2_2.getLongitude();
                                    var17_19 = var3_3.getCenter().getLatitude();
                                    var8_8 = var3_3.getCenter();
                                    var19_21 = var8_8.getLongitude();
                                    var13_13 = com.baidu.location.indoor.m.a(var13_13, var15_16, var17_19, var19_21);
                                    var21_23 = var3_3.getRadius();
                                    var15_16 = var21_23;
                                    var13_13 -= var15_16;
                                    var22_24 = 4647503709213818880L;
                                    var15_16 = 500.0;
                                    cfr_temp_0 = var13_13 - var15_16;
                                    var10_10 = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 < 0.0 ? -1 : 1));
                                    if (var10_10 < 0) lbl-1000:
                                    // 5 sources

                                    {
                                        while (true) {
                                            var4_4.b(var7_7);
                                            ** GOTO lbl67
                                            break;
                                        }
                                    }
                                    break block13;
                                }
                                if (var1_1 != var11_11 || (var10_10 = com.baidu.geofence.model.c.a(var2_2, (ArrayList)(var8_8 = var3_3.getPoints()))) == 0) break block13;
                                ** GOTO lbl-1000
                            }
                            var8_8 = var3_3.getActivatesAction();
                            var10_10 = var8_8.contains((CharSequence)(var24_27 = "2"));
                            if (var10_10 == 0) break block14;
                            if (var1_1 != var12_12) break block15;
                            var13_14 = var2_2.getLatitude();
                            var15_17 = var2_2.getLongitude();
                            var17_20 = var3_3.getCenter().getLatitude();
                            cfr_temp_1 = (var13_14 = com.baidu.location.indoor.m.a(var13_14, var15_17, var17_20, var19_22 = (var8_8 = var3_3.getCenter()).getLongitude())) - (var15_17 = (double)(var21_23 = var3_3.getRadius()));
                            var10_10 = (int)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 < 0.0 ? -1 : 1));
                            if (var10_10 >= 0) break block13;
                            var21_23 = var3_3.getRadius();
                            var13_14 = var21_23;
                            var15_17 = var2_2.getLatitude();
                            var17_20 = var2_2.getLongitude();
                            var19_22 = var3_3.getCenter().getLatitude();
                            var8_8 = var3_3.getCenter();
                            var25_28 = var8_8.getLongitude();
                            var15_17 = com.baidu.location.indoor.m.a(var15_17, var17_20, var19_22, var25_28);
                            var13_14 -= var15_17;
                            var22_25 = 4636737291354636288L;
                            var15_17 = 100.0;
                            cfr_temp_2 = var13_14 - var15_17;
                            var10_10 = (int)(cfr_temp_2 == 0.0 ? 0 : (cfr_temp_2 < 0.0 ? -1 : 1));
                            if (var10_10 >= 0) break block13;
                            ** GOTO lbl-1000
                        }
                        if (var1_1 != var11_11 || (var10_10 = (int)com.baidu.geofence.model.c.a((DPoint)(var8_8 = new DPoint(var13_15 = var2_2.getLatitude(), var15_18 = var2_2.getLongitude())), (List)(var24_27 = var3_3.getPoints()))) == 0) break block13;
                        ** GOTO lbl-1000
                    }
                    var8_8 = var3_3.getActivatesAction();
                    var10_10 = (int)var8_8.contains((CharSequence)(var24_27 = "3"));
                    if (var10_10 == 0 || (var10_10 = (int)var3_3.isIn()) == 0 || (var10_10 = (int)var3_3.isOut()) != 0 || (var10_10 = this.a(var27_29 = var3_3.getStartTimeMillis(), var22_26 = System.currentTimeMillis())) < (var29_30 = 550) || (var10_10 = this.a(var27_29 = var3_3.getStartTimeMillis(), var22_26 = System.currentTimeMillis())) > (var29_30 = 600)) ** break;
                    ** while (true)
                }
                if (var5_5 == var12_12) {
                    var30_31 = var2_2.getLatitude();
                    var39_36 = com.baidu.location.indoor.m.a(var30_31, var32_32 = var2_2.getLongitude(), var34_33 = var3_3.getCenter().getLatitude(), var37_35 = (var36_34 = var3_3.getCenter()).getLongitude());
                    cfr_temp_3 = var39_36 - (var42_39 = (double)(var41_38 = var3_3.getRadius()));
                    var5_5 = (int)(cfr_temp_3 == 0.0 ? 0 : (cfr_temp_3 < 0.0 ? -1 : 1));
                    if (var5_5 <= 0) lbl-1000:
                    // 3 sources

                    {
                        while (true) {
                            var4_4.a(var7_7, var6_6);
                            break block10;
                            break;
                        }
                    }
lbl77:
                    // 4 sources

                    while (true) {
                        var4_4.b(var7_7, var6_6);
                        break block10;
                        break;
                    }
                }
                if (var5_5 != var11_11) break block16;
                var39_37 = var2_2.getLatitude();
                var36_34 = new DPoint(var39_37, var42_40 = var2_2.getLongitude());
                var5_5 = (int)com.baidu.geofence.model.c.a((DPoint)var36_34, (List)(var8_8 = var3_3.getPoints()));
                if (var5_5 == 0) ** GOTO lbl77
                ** GOTO lbl-1000
            }
            var10_10 = 3;
            var21_23 = 4.2E-45f;
            if (var5_5 == var10_10) {
                var36_34 = var2_2.getAddrStr();
                var5_5 = (int)TextUtils.isEmpty((CharSequence)var36_34);
                if (var5_5 == 0) {
                    var36_34 = var2_2.getAddrStr();
                    var5_5 = (int)var36_34.contains((CharSequence)(var8_8 = var3_3.getRegion()));
                    if (var5_5 != 0) ** break;
                    ** continue;
                    ** continue;
                }
                var5_5 = (int)var3_3.isSend();
                if (var5_5 != 0 && (var5_5 = (int)TextUtils.isEmpty((CharSequence)(var36_34 = var3_3.getActivatesAction()))) != 0) {
                    return;
                }
                var5_5 = 18;
                var41_38 = 2.5E-44f;
                var44_41 = var2_2.getLocType();
                var4_4.a(var5_5, var7_7, var44_41);
            }
        }
        var36_34 = var3_3.getActivatesAction();
        var5_5 = (int)TextUtils.isEmpty((CharSequence)var36_34);
        if (var5_5 != 0 && (var5_5 = (int)var3_3.isOneSecond()) != 0) {
            var5_5 = 0;
            var41_38 = 0.0f;
            var36_34 = null;
            var7_7.setOneSecond(false);
        }
    }

    private void a(GeoFence geoFence) {
        int n10;
        String string2 = geoFence.getActivatesAction();
        if (geoFence != null && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0) {
            int n11;
            String string3 = "1";
            n10 = string2.contains(string3);
            int n12 = 1;
            if (n10 != 0) {
                n10 = this.t;
                if (n10 < n12) {
                    geoFence.setInTriggerCount(n12);
                } else {
                    geoFence.setInTriggerCount(n10);
                }
            }
            if ((n10 = (int)(string2.contains(string3 = "2") ? 1 : 0)) != 0) {
                n10 = this.u;
                if (n10 < n12) {
                    geoFence.setOutTriggerCount(n12);
                } else {
                    geoFence.setOutTriggerCount(n10);
                }
            }
            if ((n11 = string2.contains(string3 = "3")) != 0) {
                n11 = this.v;
                if (n11 < n12) {
                    geoFence.setStayTriggerCount(n12);
                } else {
                    geoFence.setStayTriggerCount(n11);
                }
            }
        }
    }

    private void a(GeoFence geoFence, BDLocation object) {
        long l10;
        long l11;
        int n10;
        String string2 = geoFence.getActivatesAction();
        String string3 = "3";
        int n11 = string2.contains(string3);
        int n12 = 1;
        if (n11 != 0 && (n11 = geoFence.isIn()) == 0) {
            long l12 = System.currentTimeMillis();
            geoFence.setStartTimeMillis(l12);
            geoFence.setIn(n12 != 0);
        }
        if ((n11 = geoFence.isSend()) == 0) {
            n11 = ((BDLocation)object).getLocType();
            n10 = 24;
            this.a(n10, geoFence, n11);
            geoFence.setStatus(n10);
            geoFence.setSend(n12 != 0);
        }
        string2 = geoFence.getActivatesAction();
        String string4 = "1";
        n11 = (int)(string2.contains(string4) ? 1 : 0);
        String string5 = "";
        if (n11 != 0) {
            geoFence.setCurrentLoc((BDLocation)object);
            n11 = 15;
            geoFence.setStatus(n11);
            int n13 = ((BDLocation)object).getLocType();
            n11 = (int)(this.a(n11, geoFence, n13) ? 1 : 0);
            if (n11 != 0) {
                n11 = geoFence.getInTriggerCount() - n12;
                geoFence.setInTriggerCount(n11);
            }
            if ((n11 = geoFence.getInTriggerCount()) == 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(string2 = geoFence.getActivatesAction())) ? 1 : 0)) == 0) {
                string2 = geoFence.getActivatesAction().replace(string4, string5);
                geoFence.setActivatesAction(string2);
            }
        }
        if ((n11 = (int)((string2 = geoFence.getActivatesAction()).contains(string3) ? 1 : 0)) != 0 && (n11 = (int)(geoFence.isIn() ? 1 : 0)) != 0 && (n11 = (int)(geoFence.isOut() ? 1 : 0)) == 0 && (n11 = this.a(l11 = geoFence.getStartTimeMillis(), l10 = System.currentTimeMillis())) > (n10 = 600)) {
            geoFence.setCurrentLoc((BDLocation)object);
            n11 = 17;
            geoFence.setStatus(n11);
            int n14 = ((BDLocation)object).getLocType();
            n14 = (int)(this.a(n11, geoFence, n14) ? 1 : 0);
            if (n14 != 0) {
                n14 = geoFence.getStayTriggerCount() - n12;
                geoFence.setStayTriggerCount(n14);
            }
            if ((n14 = geoFence.getStayTriggerCount()) == 0 && (n14 = (int)(TextUtils.isEmpty((CharSequence)(object = geoFence.getActivatesAction())) ? 1 : 0)) == 0) {
                object = geoFence.getActivatesAction().replace(string3, string5);
                geoFence.setActivatesAction((String)object);
            }
        }
    }

    public static /* synthetic */ void a(GeoFenceClient geoFenceClient, GeoFence geoFence) {
        geoFenceClient.a(geoFence);
    }

    private void a(String string2, int n10) {
        SharedPreferences.Editor editor = this.g.getApplicationContext().getSharedPreferences("geofence", 0).edit();
        editor.putInt(string2, n10);
        editor.apply();
    }

    private boolean a(int n10, GeoFence object, int n11) {
        Bundle bundle = new Bundle();
        bundle.putInt("3", n10);
        String string2 = ((GeoFence)object).getCustomId();
        String string3 = "2";
        bundle.putString(string3, string2);
        bundle.putParcelable("5", (Parcelable)object);
        bundle.putInt("4", n11);
        string2 = ((GeoFence)object).getFenceId();
        bundle.putString("1", string2);
        string2 = this.e;
        object = GeoFence.class.getClassLoader();
        string2.setExtrasClassLoader((ClassLoader)object);
        this.e.putExtras(bundle);
        string2 = this.g;
        int n12 = this.h;
        this.h = n11 = n12 + 1;
        Intent intent = this.e;
        int n13 = 0x8000000;
        string2 = PendingIntent.getBroadcast((Context)string2, (int)n12, (Intent)intent, (int)n13);
        this.f = string2;
        try {
            string2.send();
            return true;
        }
        catch (PendingIntent.CanceledException canceledException) {
            return false;
        }
    }

    public static /* synthetic */ boolean a(GeoFenceClient geoFenceClient, boolean bl2) {
        geoFenceClient.m = bl2;
        return bl2;
    }

    private boolean a(String string2) {
        boolean bl2;
        String string3 = GCJ02;
        boolean bl3 = string3.equalsIgnoreCase(string2);
        return bl3 || (bl3 = (string3 = BD09LL).equalsIgnoreCase(string2)) || (bl3 = (string3 = BD09MC).equalsIgnoreCase(string2)) || (bl2 = (string3 = WGS84).equalsIgnoreCase(string2));
        {
        }
    }

    private int b(String string2) {
        return this.g.getApplicationContext().getSharedPreferences("geofence", 0).getInt(string2, 0);
    }

    public static /* synthetic */ ArrayList b(GeoFenceClient geoFenceClient) {
        return geoFenceClient.c;
    }

    private void b(GeoFence geoFence) {
        int n10;
        Object object = this.k;
        int n11 = ((LocationClientOption)object).getScanSpan();
        if (n11 != (n10 = 1000)) {
            Object object2;
            object = this.k;
            ((LocationClientOption)object).setScanSpan(n10);
            n11 = (int)(this.l ? 1 : 0);
            if (n11 && (object = this.k.getLocationMode()) != (object2 = LocationClientOption$LocationMode.Hight_Accuracy)) {
                object = this.k;
                ((LocationClientOption)object).setLocationMode((LocationClientOption$LocationMode)((Object)object2));
            }
            object = this.d;
            object2 = this.k;
            ((LocationClient)object).setLocOption((LocationClientOption)object2);
            n11 = 1;
            geoFence.setOneSecond(n11 != 0);
        }
    }

    private void b(GeoFence geoFence, BDLocation object) {
        int n10;
        int n11 = geoFence.isIn();
        int n12 = 1;
        if (n11 != 0 && (n11 = geoFence.isOut()) == 0) {
            long l10 = System.currentTimeMillis();
            geoFence.setEndTimeMillis(l10);
            geoFence.setOut(n12 != 0);
        }
        if ((n11 = geoFence.isSend()) == 0) {
            n11 = ((BDLocation)object).getLocType();
            int n13 = 25;
            this.a(n13, geoFence, n11);
            geoFence.setStatus(n13);
            geoFence.setSend(n12 != 0);
        }
        String string2 = geoFence.getActivatesAction();
        String string3 = "2";
        n11 = (int)(string2.contains(string3) ? 1 : 0);
        String string4 = "";
        if (n11 != 0) {
            geoFence.setCurrentLoc((BDLocation)object);
            n11 = 16;
            geoFence.setStatus(n11);
            n10 = ((BDLocation)object).getLocType();
            n11 = (int)(this.a(n11, geoFence, n10) ? 1 : 0);
            if (n11 != 0) {
                n11 = geoFence.getOutTriggerCount() - n12;
                geoFence.setOutTriggerCount(n11);
            }
            if ((n11 = geoFence.getOutTriggerCount()) == 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(string2 = geoFence.getActivatesAction())) ? 1 : 0)) == 0) {
                string2 = geoFence.getActivatesAction().replace(string3, string4);
                geoFence.setActivatesAction(string2);
            }
        }
        if ((n11 = (int)((string2 = geoFence.getActivatesAction()).contains(string3 = "3") ? 1 : 0)) != 0) {
            long l11;
            long l12;
            n11 = (int)(geoFence.isIn() ? 1 : 0);
            if (n11 != 0 && (n11 = this.a(l12 = geoFence.getStartTimeMillis(), l11 = geoFence.getEndTimeMillis())) > (n10 = 600)) {
                geoFence.setCurrentLoc((BDLocation)object);
                n11 = 17;
                geoFence.setStatus(n11);
                int n14 = ((BDLocation)object).getLocType();
                n14 = (int)(this.a(n11, geoFence, n14) ? 1 : 0);
                if (n14 != 0) {
                    n14 = geoFence.getStayTriggerCount() - n12;
                    geoFence.setStayTriggerCount(n14);
                }
                if ((n14 = geoFence.getStayTriggerCount()) == 0 && (n14 = (int)(TextUtils.isEmpty((CharSequence)(object = geoFence.getActivatesAction())) ? 1 : 0)) == 0) {
                    object = geoFence.getActivatesAction().replace(string3, string4);
                    geoFence.setActivatesAction((String)object);
                }
            } else {
                boolean bl2 = false;
                object = null;
                geoFence.setIn(false);
                geoFence.setOut(false);
                long l13 = 0L;
                geoFence.setStartTimeMillis(l13);
                geoFence.setEndTimeMillis(l13);
            }
        }
    }

    private boolean b() {
        boolean bl2;
        Object object = this.c;
        boolean bl3 = true;
        if (object != null && !(bl2 = ((ArrayList)object).isEmpty())) {
            boolean bl4;
            object = this.c.iterator();
            while (bl4 = object.hasNext()) {
                String string2 = ((GeoFence)object.next()).getActivatesAction();
                bl4 = TextUtils.isEmpty((CharSequence)string2);
                if (bl4) continue;
                return false;
            }
        }
        return bl3;
    }

    public static /* synthetic */ String c(GeoFenceClient geoFenceClient) {
        return geoFenceClient.a;
    }

    private void c() {
        SharedPreferences.Editor editor = this.g.getApplicationContext().getSharedPreferences("geofence", 0).edit();
        editor.putInt("1", 0);
        editor.putInt("2", 0);
        editor.putInt("3", 0);
        editor.putInt("4", 0);
        editor.putInt("5", 0);
        editor.apply();
    }

    public static /* synthetic */ int d(GeoFenceClient geoFenceClient) {
        int n10;
        int n11 = geoFenceClient.i;
        geoFenceClient.i = n10 = n11 + 1;
        return n11;
    }

    private void d() {
        int n10;
        String string2 = "1";
        int n11 = this.b(string2);
        String string3 = "5";
        CharSequence charSequence = "4";
        CharSequence charSequence2 = "3";
        CharSequence charSequence3 = "2";
        if (n11 == 0 && (n11 = this.b((String)charSequence3)) == 0 && (n11 = this.b((String)charSequence2)) == 0 && (n11 = this.b((String)charSequence)) == 0 && (n11 = this.b(string3)) == 0) {
            return;
        }
        long l10 = this.n;
        long l11 = System.currentTimeMillis();
        n11 = this.a(l10, l11);
        if (n11 > (n10 = 60)) {
            long l12;
            String[] stringArray = new ArrayList();
            Object object = this.o;
            stringArray.add(object);
            object = this.p;
            stringArray.add(object);
            object = this.q;
            stringArray.add(object);
            object = this.r;
            stringArray.add(object);
            object = this.s;
            stringArray.add(object);
            object = new j();
            ((j)object).a((ArrayList)stringArray);
            ((j)object).a(this);
            n11 = 5;
            stringArray = new String[n11];
            CharSequence charSequence4 = new StringBuilder();
            String string4 = "circleFence:";
            charSequence4.append(string4);
            int n12 = this.b(string2);
            charSequence4.append(n12);
            stringArray[0] = string2 = charSequence4.toString();
            CharSequence charSequence5 = new StringBuilder();
            charSequence4 = "polygonFence:";
            charSequence5.append((String)charSequence4);
            int n13 = this.b((String)charSequence3);
            charSequence5.append(n13);
            charSequence3 = charSequence5.toString();
            stringArray[1] = charSequence3;
            charSequence3 = new StringBuilder();
            charSequence5 = "poiCircleFence:";
            ((StringBuilder)charSequence3).append((String)charSequence5);
            int n14 = this.b((String)charSequence2);
            ((StringBuilder)charSequence3).append(n14);
            charSequence2 = ((StringBuilder)charSequence3).toString();
            stringArray[2] = charSequence2;
            charSequence2 = new StringBuilder();
            charSequence3 = "poiRegionFence:";
            ((StringBuilder)charSequence2).append((String)charSequence3);
            int n15 = this.b((String)charSequence);
            ((StringBuilder)charSequence2).append(n15);
            charSequence = ((StringBuilder)charSequence2).toString();
            stringArray[3] = charSequence;
            n12 = 4;
            charSequence = new StringBuilder();
            charSequence2 = "regionFence:";
            ((StringBuilder)charSequence).append((String)charSequence2);
            int n16 = this.b(string3);
            ((StringBuilder)charSequence).append(n16);
            stringArray[n12] = string3 = ((StringBuilder)charSequence).toString();
            ((j)object).a(stringArray);
            this.n = l12 = System.currentTimeMillis();
        }
    }

    public static /* synthetic */ void e(GeoFenceClient geoFenceClient) {
        geoFenceClient.a();
    }

    public static /* synthetic */ LocationClientOption f(GeoFenceClient geoFenceClient) {
        return geoFenceClient.k;
    }

    public static /* synthetic */ LocationClient g(GeoFenceClient geoFenceClient) {
        return geoFenceClient.d;
    }

    public static Handler getHandlerInstance() {
        Handler handler = w;
        if (handler == null) {
            handler = Looper.myLooper();
            if (handler == null) {
                Looper looper = Looper.getMainLooper();
                handler = new Handler(looper);
            } else {
                Looper looper = Looper.myLooper();
                handler = new Handler(looper);
            }
            w = handler;
        }
        return w;
    }

    public void addGeoFence(DPoint object, String arrayList, float f10, String string2) {
        if (object == null) {
            return;
        }
        Object object2 = this.o;
        ((StringBuilder)object2).append("[");
        double d10 = ((DPoint)object).getLatitude();
        ((StringBuilder)object2).append(d10);
        Object object3 = ",";
        ((StringBuilder)object2).append((String)object3);
        double d11 = ((DPoint)object).getLongitude();
        ((StringBuilder)object2).append(d11);
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append((String)((Object)arrayList));
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(f10);
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(string2);
        object3 = "]";
        ((StringBuilder)object2).append((String)object3);
        object2 = "1";
        int n10 = this.b((String)object2) + 1;
        this.a((String)object2, n10);
        Object object4 = TextUtils.isEmpty((CharSequence)((Object)arrayList));
        n10 = 8;
        int n11 = 0;
        if (object4 == 0 && (object4 = this.a((String)((Object)arrayList))) != 0) {
            float f11 = 0.0f;
            object2 = null;
            float f12 = f10 - 0.0f;
            object4 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object4 > 0 && (object4 = (Object)TextUtils.isEmpty((CharSequence)string2)) == 0) {
                double d12;
                double d13;
                double d14 = Math.abs(((BDLocation)(object = this.a((DPoint)object, (String)((Object)arrayList)))).getLatitude());
                double d15 = d14 - (d13 = 90.0);
                Object object5 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
                if (object5 <= 0 && (object5 = (d12 = (d14 = Math.abs(((BDLocation)object).getLongitude())) - (d13 = 180.0)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) <= 0) {
                    block8: {
                        float f13;
                        double d16;
                        double d17;
                        double d18 = ((BDLocation)object).getLatitude();
                        d11 = ((BDLocation)object).getLongitude();
                        arrayList = new DPoint(d18, d11);
                        object = this.c.iterator();
                        do {
                            object4 = object.hasNext();
                            n10 = 20;
                            if (object4 == 0) break block8;
                        } while ((n11 = ((GeoFence)(object2 = (GeoFence)object.next())).getType()) != n10 || (n10 = (int)((d17 = (d10 = ((DPoint)(object3 = ((GeoFence)object2).getCenter())).getLatitude()) - (d14 = ((DPoint)((Object)arrayList)).getLatitude())) == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1))) != 0 || (n10 = (int)((d16 = (d10 = ((DPoint)(object3 = ((GeoFence)object2).getCenter())).getLongitude()) - (d14 = ((DPoint)((Object)arrayList)).getLongitude())) == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1))) != 0 || (object4 = (Object)((f13 = (f11 = ((GeoFence)object2).getRadius()) - f10) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) != 0);
                        object = this.b;
                        arrayList = this.c;
                        object.onGeoFenceCreateFinished(arrayList, 14, string2);
                        return;
                    }
                    object = new GeoFence();
                    ((GeoFence)object).setFenceType(n10);
                    object2 = this.a;
                    ((GeoFence)object).setActivatesAction((String)object2);
                    ((GeoFence)object).setCustomId(string2);
                    object4 = this.i;
                    this.i = n10 = object4 + 1;
                    object2 = String.valueOf(object4);
                    ((GeoFence)object).setFenceId((String)object2);
                    ((GeoFence)object).setCenter((DPoint)((Object)arrayList));
                    ((GeoFence)object).setRadius(f10);
                    this.a((GeoFence)object);
                    this.c.add(object);
                    arrayList = new ArrayList();
                    arrayList.add(object);
                    object = this.b;
                    if (object != null) {
                        int n12 = 7;
                        f10 = 9.8E-45f;
                        object.onGeoFenceCreateFinished(arrayList, n12, string2);
                    }
                    this.m = false;
                    this.a();
                    return;
                }
                object = this.b;
                if (object != null) {
                    object.onGeoFenceCreateFinished(null, n10, string2);
                }
                return;
            }
        }
        if ((object = this.b) != null) {
            object.onGeoFenceCreateFinished(null, n10, string2);
        }
    }

    public void addGeoFence(String object, String string2) {
        Object object2 = this.s;
        ((StringBuilder)object2).append("[");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(",");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append("]");
        object2 = "5";
        int n10 = this.b((String)object2) + 1;
        this.a((String)object2, n10);
        int n11 = TextUtils.isEmpty((CharSequence)object);
        n10 = 0;
        Object object3 = null;
        if (n11 == 0 && (n11 = TextUtils.isEmpty((CharSequence)string2)) == 0) {
            boolean bl2;
            object2 = this.c.iterator();
            while (bl2 = object2.hasNext()) {
                int n12;
                Object object4 = (GeoFence)object2.next();
                int n13 = ((GeoFence)object4).getType();
                if (n13 != (n12 = 23) || !(bl2 = TextUtils.equals((CharSequence)(object4 = ((GeoFence)object4).getRegion()), (CharSequence)object))) continue;
                object = this.b;
                if (object != null) {
                    n11 = 14;
                    object.onGeoFenceCreateFinished(null, n11, string2);
                }
                return;
            }
            object3 = this.g;
            object2 = new com.baidu.geofence.a.b((String)object, (Context)object3);
            object3 = this.b;
            ((com.baidu.geofence.a.b)object2).a((GeoFenceListener)object3);
            object3 = new d(this, string2, (String)object);
            ((com.baidu.geofence.a.b)object2).a((b$a)object3);
            return;
        }
        object = this.b;
        if (object != null) {
            n11 = 8;
            object.onGeoFenceCreateFinished(null, n11, string2);
        }
    }

    public void addGeoFence(String object, String object2, DPoint object3, String object4, float f10, int n10, String string2) {
        float f11;
        float f12;
        float f13;
        if (object3 == null) {
            return;
        }
        CharSequence charSequence = this.q;
        charSequence.append("[");
        charSequence.append((String)object);
        Object object5 = ",";
        charSequence.append((String)object5);
        charSequence.append((String)object2);
        charSequence.append((String)object5);
        charSequence.append("(");
        double d10 = ((DPoint)object3).getLatitude();
        charSequence.append(d10);
        charSequence.append((String)object5);
        d10 = ((DPoint)object3).getLongitude();
        charSequence.append(d10);
        String string3 = ")";
        charSequence.append(string3);
        charSequence.append((String)object5);
        charSequence.append((String)object4);
        charSequence.append((String)object5);
        charSequence.append(f10);
        charSequence.append((String)object5);
        charSequence.append(n10);
        charSequence.append((String)object5);
        charSequence.append(string2);
        object5 = "]";
        charSequence.append((String)object5);
        charSequence = "3";
        int n11 = this.b((String)charSequence);
        int n12 = 1;
        this.a((String)charSequence, n11 += n12);
        int n13 = TextUtils.isEmpty((CharSequence)object);
        n11 = 8;
        ArrayList arrayList = null;
        if (n13 == 0 && (n13 = TextUtils.isEmpty((CharSequence)object2)) == 0 && (n13 = TextUtils.isEmpty((CharSequence)object4)) == 0 && (n13 = (f13 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) >= 0 && (n13 = (int)((f11 = f10 - (f12 = 5000.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) <= 0 && n10 > 0) {
            n13 = 25;
            f12 = 3.5E-44f;
            if (n10 <= n13 && (n13 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) == 0 && (n13 = (int)(this.a((String)object4) ? 1 : 0)) != 0) {
                double d11;
                double d12;
                double d13 = Math.abs(((BDLocation)(object3 = this.a((DPoint)object3, (String)object4))).getLatitude());
                double d14 = d13 - (d12 = 90.0);
                Object object6 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
                if (object6 <= 0 && (object6 = (d11 = (d13 = Math.abs(((BDLocation)object3).getLongitude())) - (d12 = 180.0)) == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1)) <= 0) {
                    object4 = this.g;
                    object6 = com.baidu.location.h.l.a((Context)object4);
                    if (object6 == false) {
                        object = this.b;
                        if (object != null) {
                            int n14 = 9;
                            object.onGeoFenceCreateFinished(null, n14, string2);
                        }
                        return;
                    }
                    double d15 = ((BDLocation)object3).getLatitude();
                    double d16 = ((BDLocation)object3).getLongitude();
                    object4 = new DPoint(d15, d16);
                    charSequence = this.g;
                    object5 = this.b;
                    arrayList = this.c;
                    object3 = new f((Context)charSequence, n12 != 0, (GeoFenceListener)object5, arrayList);
                    ((f)object3).a(n10);
                    ((f)object3).b((String)object);
                    ((f)object3).c((String)object2);
                    ((f)object3).a((DPoint)object4);
                    ((f)object3).a(f10);
                    ((f)object3).a(string2);
                    object2 = new b(this, string2, (String)object);
                    ((f)object3).a((f$a)object2);
                    return;
                }
                object = this.b;
                if (object != null) {
                    object.onGeoFenceCreateFinished(null, n11, string2);
                }
                return;
            }
        }
        if ((object = this.b) != null) {
            object.onGeoFenceCreateFinished(null, n11, string2);
        }
    }

    public void addGeoFence(String object, String object2, String string2, int n10, String string3) {
        Object object3 = this.r;
        ((StringBuilder)object3).append("[");
        ((StringBuilder)object3).append((String)object);
        String string4 = ",";
        ((StringBuilder)object3).append(string4);
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(string4);
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(string4);
        ((StringBuilder)object3).append(n10);
        ((StringBuilder)object3).append(string4);
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append("]");
        object3 = "4";
        int n11 = this.b((String)object3) + 1;
        this.a((String)object3, n11);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        n11 = 0;
        string4 = null;
        if (!(bl2 || (bl2 = TextUtils.isEmpty((CharSequence)object2)) || (bl2 = TextUtils.isEmpty((CharSequence)string2)) || n10 == 0 || (bl2 = TextUtils.isEmpty((CharSequence)string3)))) {
            object3 = this.g;
            bl2 = com.baidu.location.h.l.a((Context)object3);
            if (!bl2) {
                object = this.b;
                if (object != null) {
                    int n12 = 9;
                    object.onGeoFenceCreateFinished(null, n12, string3);
                }
                return;
            }
            string4 = this.g;
            GeoFenceListener geoFenceListener = this.b;
            ArrayList arrayList = this.c;
            object3 = new f((Context)string4, false, geoFenceListener, arrayList);
            ((f)object3).b((String)object);
            ((f)object3).d(string2);
            ((f)object3).c((String)object2);
            ((f)object3).a(n10);
            ((f)object3).a(string3);
            object2 = new c(this, string3, (String)object);
            ((f)object3).a((f$a)object2);
            return;
        }
        object = this.b;
        if (object != null) {
            int n13 = 8;
            object.onGeoFenceCreateFinished(null, n13, string3);
        }
    }

    public void addGeoFence(ArrayList object, String object2, String string2) {
        int n10;
        double d10;
        Object object3;
        Object object4;
        ArrayList<Object> arrayList;
        int n11;
        int n12;
        Object object5 = this.p;
        ((StringBuilder)object5).append("[");
        ((StringBuilder)object5).append((String)object2);
        String string3 = ",";
        ((StringBuilder)object5).append(string3);
        ((StringBuilder)object5).append(string2);
        if (object != null && (n12 = ((ArrayList)object).isEmpty()) == 0) {
            object5 = ((ArrayList)object).iterator();
            while ((n11 = object5.hasNext()) != 0) {
                arrayList = (DPoint)object5.next();
                object4 = this.p;
                ((StringBuilder)object4).append(string3);
                object3 = "(";
                ((StringBuilder)object4).append((String)object3);
                d10 = ((DPoint)((Object)arrayList)).getLatitude();
                ((StringBuilder)object4).append(d10);
                ((StringBuilder)object4).append(string3);
                d10 = ((DPoint)((Object)arrayList)).getLongitude();
                ((StringBuilder)object4).append(d10);
                arrayList = ")";
                ((StringBuilder)object4).append((String)((Object)arrayList));
            }
        }
        this.p.append("]");
        object5 = "2";
        int n13 = this.b((String)object5) + 1;
        this.a((String)object5, n13);
        n12 = 8;
        n13 = 0;
        string3 = null;
        if (object != null && (n11 = ((ArrayList)object).size()) >= (n10 = 3) && (n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0)) == 0 && (n11 = (int)(this.a((String)object2) ? 1 : 0)) != 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) == 0) {
            int n14;
            block11: {
                Object object6;
                double d11;
                arrayList = new ArrayList<Object>();
                object = ((ArrayList)object).iterator();
                while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    double d12;
                    object4 = (DPoint)object.next();
                    d10 = Math.abs(((BDLocation)(object4 = this.a((DPoint)object4, (String)object2))).getLatitude());
                    double d13 = d10 - (d11 = 90.0);
                    object6 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
                    if (object6 <= 0 && (object6 = (d12 = (d10 = Math.abs(((BDLocation)object4).getLongitude())) - (d11 = 180.0)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) <= 0) {
                        double d14 = ((BDLocation)object4).getLatitude();
                        double d15 = ((BDLocation)object4).getLongitude();
                        object3 = new DPoint(d14, d15);
                        arrayList.add(object3);
                        continue;
                    }
                    object = this.b;
                    if (object != null) {
                        object.onGeoFenceCreateFinished(null, n12, string2);
                    }
                    return;
                }
                object = this.c.iterator();
                while (true) {
                    double d16;
                    DPoint dPoint;
                    double d17;
                    n14 = object.hasNext();
                    n12 = 21;
                    object4 = null;
                    if (n14 == 0) break block11;
                    object2 = (GeoFence)object.next();
                    object6 = ((GeoFence)object2).getType();
                    if (object6 != n12 || (n12 = ((ArrayList)(object5 = ((GeoFence)object2).getPoints())).size()) != (object6 = (Object)arrayList.size())) continue;
                    n12 = 0;
                    object5 = null;
                    for (n10 = 0; n10 < (object6 = (Object)arrayList.size()) && (object6 = (d17 = (d10 = ((DPoint)(object3 = (DPoint)arrayList.get(n10))).getLatitude()) - (d11 = (dPoint = (DPoint)((GeoFence)object2).getPoints().get(n10)).getLatitude())) == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1)) == false && (object6 = (d16 = (d10 = ((DPoint)(object3 = (DPoint)arrayList.get(n10))).getLongitude()) - (d11 = (dPoint = (DPoint)((GeoFence)object2).getPoints().get(n10)).getLongitude())) == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1)) == false; ++n10) {
                        ++n12;
                    }
                    n14 = arrayList.size();
                    if (n12 == n14) break;
                }
                object = this.b;
                if (object != null) {
                    n14 = 14;
                    object.onGeoFenceCreateFinished(null, n14, string2);
                }
                return;
            }
            object = new GeoFence();
            ((GeoFence)object).setPoints(arrayList);
            ((GeoFence)object).setFenceType(n12);
            object2 = this.a;
            ((GeoFence)object).setActivatesAction((String)object2);
            ((GeoFence)object).setCustomId(string2);
            n14 = this.i;
            this.i = n12 = n14 + 1;
            object2 = String.valueOf(n14);
            ((GeoFence)object).setFenceId((String)object2);
            this.a((GeoFence)object);
            this.c.add(object);
            object2 = new Object();
            object2.add(object);
            object = this.b;
            if (object != null) {
                n12 = 7;
                object.onGeoFenceCreateFinished((List)object2, n12, string2);
            }
            this.m = false;
            this.a();
            return;
        }
        object = this.b;
        if (object != null) {
            object.onGeoFenceCreateFinished(null, n12, string2);
        }
    }

    public void clear() {
        this.c();
    }

    public void createPendingIntent(String string2) {
        Intent intent;
        this.e = intent = new Intent(string2);
    }

    public List getAllGeoFence() {
        return this.c;
    }

    public void isHighAccuracyLoc(boolean bl2) {
        this.l = bl2;
    }

    public boolean isPause() {
        LocationClient locationClient;
        boolean bl2 = this.j;
        if (!bl2 && !(bl2 = (locationClient = this.d).isStarted())) {
            bl2 = true;
        } else {
            bl2 = false;
            locationClient = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void onReceiveLocation(BDLocation object) {
        block23: {
            void var6_15;
            block24: {
                int n10;
                block22: {
                    LocationClientOption$LocationMode locationClientOption$LocationMode;
                    boolean bl2;
                    boolean bl3;
                    int n11;
                    String string2;
                    int n12;
                    GeoFence geoFence;
                    int n13;
                    this.d();
                    n10 = this.j;
                    int n14 = 23;
                    int n15 = 1;
                    if (n10) {
                        n10 = ((BDLocation)object).getLocType();
                        if (n10 != (n13 = 161) && (n10 = ((BDLocation)object).getLocType()) != (n13 = 66) && (n10 = ((BDLocation)object).getLocType()) != (n13 = 61)) {
                            Iterator iterator2 = this.c.iterator();
                            while (n13 = (int)(iterator2.hasNext() ? 1 : 0)) {
                                geoFence = (GeoFence)iterator2.next();
                                n12 = (int)(geoFence.isSend() ? 1 : 0);
                                if (n12 != 0 && (n12 = (int)(TextUtils.isEmpty((CharSequence)(string2 = geoFence.getActivatesAction())) ? 1 : 0)) != 0) continue;
                                n12 = 18;
                                n11 = ((BDLocation)object).getLocType();
                                this.a(n12, geoFence, n11);
                            }
                        } else {
                            Iterator iterator3 = this.c.iterator();
                            while (n13 = (int)(iterator3.hasNext() ? 1 : 0)) {
                                geoFence = (GeoFence)iterator3.next();
                                n12 = geoFence.isAble();
                                if (n12 == 0 || (n12 = TextUtils.isEmpty((CharSequence)(string2 = geoFence.getActivatesAction()))) != 0) continue;
                                n12 = geoFence.getType();
                                if (n12 == (n11 = 20) || (n12 = geoFence.getType()) == (n11 = 22)) {
                                    this.a(n15, (BDLocation)object, geoFence);
                                    continue;
                                }
                                n12 = geoFence.getType();
                                if (n12 == (n11 = 21)) {
                                    n12 = 2;
                                } else {
                                    n12 = geoFence.getType();
                                    if (n12 != n14) continue;
                                    n12 = 3;
                                }
                                this.a(n12, (BDLocation)object, geoFence);
                            }
                        }
                    }
                    if (bl3 = this.m) {
                        return;
                    }
                    object = this.c.iterator();
                    n10 = 0;
                    Object var6_9 = null;
                    n12 = 0;
                    string2 = null;
                    n11 = 0;
                    n13 = n15;
                    while (bl2 = object.hasNext()) {
                        GeoFence geoFence2 = (GeoFence)object.next();
                        String string3 = geoFence2.getActivatesAction();
                        int n16 = TextUtils.isEmpty((CharSequence)string3);
                        if (n16 == 0) {
                            n13 = 0;
                            geoFence = null;
                        }
                        if ((n16 = geoFence2.getType()) == n14 && (n16 = (int)(TextUtils.isEmpty((CharSequence)(string3 = geoFence2.getActivatesAction())) ? 1 : 0)) == 0) {
                            n12 = n15;
                        }
                        if (!(bl2 = geoFence2.isOneSecond())) continue;
                        n11 = n15;
                    }
                    if (n13) {
                        this.pauseGeoFence();
                        return;
                    }
                    this.j = n15;
                    this.m = false;
                    object = this.k;
                    if (n12 != 0) {
                        String string4;
                        bl3 = TextUtils.equals((CharSequence)(object = ((LocationClientOption)object).getAddrType()), (CharSequence)(string4 = "all"));
                        if (!bl3) {
                            object = this.k;
                            ((LocationClientOption)object).setIsNeedAddress(n15 != 0);
                        }
                    } else {
                        ((LocationClientOption)object).setIsNeedAddress(false);
                    }
                    object = this.k;
                    if (n11 == 0) break block22;
                    n10 = 1000;
                    ((LocationClientOption)object).setScanSpan(n10);
                    bl3 = this.l;
                    if (!bl3 || (object = this.k.getLocationMode()) == (locationClientOption$LocationMode = LocationClientOption$LocationMode.Hight_Accuracy)) break block23;
                    object = this.k;
                    break block24;
                }
                n10 = 5000;
                ((LocationClientOption)object).setScanSpan(n10);
                object = this.k.getLocationMode();
                LocationClientOption$LocationMode locationClientOption$LocationMode = LocationClientOption$LocationMode.Hight_Accuracy;
                if (object != locationClientOption$LocationMode) break block23;
                object = this.k;
                LocationClientOption$LocationMode locationClientOption$LocationMode2 = LocationClientOption$LocationMode.Battery_Saving;
            }
            ((LocationClientOption)object).setLocationMode((LocationClientOption$LocationMode)var6_15);
        }
        object = this.d;
        LocationClientOption locationClientOption = this.k;
        ((LocationClient)object).setLocOption(locationClientOption);
        this.a();
    }

    public void pauseGeoFence() {
        this.m = true;
        this.j = false;
        LocationClient locationClient = this.d;
        boolean bl2 = locationClient.isStarted();
        if (bl2) {
            locationClient = this.d;
            locationClient.stop();
        }
    }

    public void removeGeoFence() {
        boolean bl2;
        Object object = this.c;
        if (object != null && !(bl2 = ((ArrayList)object).isEmpty())) {
            this.c.clear();
            this.j = false;
            this.i = 1;
            object = this.d;
            bl2 = ((LocationClient)object).isStarted();
            if (bl2) {
                object = this.d;
                ((LocationClient)object).stop();
            }
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        boolean bl2;
        Object object;
        if (geoFence != null && (object = this.c) != null && !(bl2 = ((ArrayList)object).isEmpty())) {
            boolean bl3;
            object = this.c.iterator();
            while (bl3 = object.hasNext()) {
                String string2;
                String string3 = ((GeoFence)object.next()).getFenceId();
                bl3 = TextUtils.equals((CharSequence)string3, (CharSequence)(string2 = geoFence.getFenceId()));
                if (!bl3) continue;
                this.c.remove(geoFence);
                return true;
            }
        }
        return false;
    }

    public void resumeGeoFence() {
        int n10;
        ArrayList arrayList = this.c;
        if (arrayList != null && (n10 = arrayList.size()) != 0 && (n10 = (int)(this.b() ? 1 : 0)) == 0 && (n10 = (int)(this.isPause() ? 1 : 0)) != 0) {
            this.j = true;
            n10 = 0;
            arrayList = null;
            this.m = false;
            this.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setActivateAction(int n10) {
        block9: {
            String string2;
            block3: {
                int n11;
                block8: {
                    block7: {
                        block6: {
                            block5: {
                                block4: {
                                    block2: {
                                        n11 = 1;
                                        if (n10 != n11) break block2;
                                        string2 = "1";
                                        break block3;
                                    }
                                    n11 = 2;
                                    if (n10 != n11) break block4;
                                    string2 = "2";
                                    break block3;
                                }
                                n11 = 3;
                                if (n10 != n11) break block5;
                                string2 = "3";
                                break block3;
                            }
                            n11 = 4;
                            if (n10 != n11) break block6;
                            string2 = "12";
                            break block3;
                        }
                        n11 = 5;
                        if (n10 != n11) break block7;
                        string2 = "13";
                        break block3;
                    }
                    n11 = 6;
                    if (n10 != n11) break block8;
                    string2 = "23";
                    break block3;
                }
                n11 = 7;
                if (n10 != n11) break block9;
                string2 = "123";
            }
            this.a = string2;
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)this.a) ? 1 : 0);
    }

    public void setGeoFenceAble(String string2, boolean bl2) {
        Object object;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && (object = this.c) != null && (n10 = ((ArrayList)object).size()) != 0) {
            boolean bl3;
            object = this.c.iterator();
            while (bl3 = object.hasNext()) {
                GeoFence geoFence = (GeoFence)object.next();
                String string3 = geoFence.getFenceId();
                boolean bl4 = TextUtils.equals((CharSequence)string3, (CharSequence)string2);
                if (!bl4) continue;
                geoFence.setAble(bl2);
            }
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        this.b = geoFenceListener;
    }

    public void setTriggerCount(int n10, int n11, int n12) {
        String string2;
        String string3;
        String string4 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            return;
        }
        string4 = this.a;
        String string5 = "1";
        bl2 = string4.contains(string5);
        int n13 = 1;
        if (bl2) {
            this.t = n10 < n13 ? n13 : n10;
        }
        if ((n10 = (int)((string3 = this.a).contains(string4 = "2") ? 1 : 0)) != 0) {
            this.u = n11 < n13 ? n13 : n11;
        }
        if ((n10 = (int)((string3 = this.a).contains(string2 = "3") ? 1 : 0)) != 0) {
            this.v = n12 < n13 ? n13 : n12;
        }
    }
}

