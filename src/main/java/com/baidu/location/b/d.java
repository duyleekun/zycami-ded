/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  android.net.wifi.WifiConfiguration
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.telephony.CellIdentityNr
 *  android.telephony.CellInfo
 *  android.telephony.CellInfoCdma
 *  android.telephony.CellInfoGsm
 *  android.telephony.CellInfoLte
 *  android.telephony.CellInfoNr
 *  android.telephony.CellInfoTdscdma
 *  android.telephony.CellInfoWcdma
 *  android.telephony.CellLocation
 *  android.telephony.CellSignalStrengthNr
 *  android.telephony.TelephonyManager
 *  android.telephony.cdma.CdmaCellLocation
 *  android.telephony.gsm.GsmCellLocation
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.a;
import com.baidu.location.b.d$a;
import com.baidu.location.b.d$b;
import com.baidu.location.b.d$c;
import com.baidu.location.b.d$d;
import com.baidu.location.b.e;
import com.baidu.location.h.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class d {
    private static Class i;
    private static char[] r;
    public String a;
    public String b;
    public d$b c;
    private Context d;
    private TelephonyManager e;
    private com.baidu.location.f.a f;
    private WifiManager g;
    private d$d h;
    private String j;
    private String k;
    private LocationClientOption l;
    private d$a m;
    private String n;
    private String o;
    private String p;
    private boolean q;
    private int s;
    private boolean t;
    private long u;
    private boolean v;

    static {
        r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public d(Context object, LocationClientOption object2, d$a object3) {
        int n10;
        long l10;
        int n11;
        int n12 = 0;
        CharSequence charSequence = null;
        this.d = null;
        this.e = null;
        Object object4 = new com.baidu.location.f.a();
        this.f = object4;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.a = null;
        this.b = null;
        object4 = null;
        this.q = false;
        Object object5 = new d$b(this);
        this.c = object5;
        this.s = n11 = 16;
        this.t = false;
        this.u = l10 = 0L;
        this.v = false;
        object = object.getApplicationContext();
        this.d = object;
        try {
            com.baidu.location.h.l.az = object = object.getPackageName();
        }
        catch (Exception exception) {}
        this.q = n10 = 1;
        this.l = object4 = new LocationClientOption((LocationClientOption)object2);
        this.m = object3;
        this.a = object3 = this.d.getPackageName();
        this.b = null;
        try {
            object3 = this.d;
            object4 = "phone";
            object3 = object3.getSystemService((String)object4);
            object3 = (TelephonyManager)object3;
            this.e = object3;
            object3 = this.d;
            object3 = object3.getApplicationContext();
            object4 = "wifi";
            object3 = object3.getSystemService((String)object4);
            object3 = (WifiManager)object3;
            this.g = object3;
        }
        catch (Exception exception) {}
        object3 = new StringBuilder();
        object4 = "&";
        ((StringBuilder)object3).append((String)object4);
        object5 = this.a;
        ((StringBuilder)object3).append((String)object5);
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append((String)null);
        this.k = object3 = ((StringBuilder)object3).toString();
        try {
            object3 = this.d;
            object3 = LBSAuthManager.getInstance((Context)object3);
            this.b = object3 = ((LBSAuthManager)object3).getCUID();
        }
        catch (Throwable throwable) {
            this.b = null;
            this.e = null;
            this.g = null;
        }
        object3 = this.b;
        object4 = "&coor=";
        object5 = ":";
        String string2 = "&prod=";
        if (object3 != null) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("");
            charSequence = this.b;
            ((StringBuilder)object3).append((String)charSequence);
            com.baidu.location.h.l.q = ((StringBuilder)object3).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string2);
            charSequence = this.l.prodName;
            ((StringBuilder)object3).append((String)charSequence);
            ((StringBuilder)object3).append((String)object5);
            charSequence = this.a;
            ((StringBuilder)object3).append((String)charSequence);
            ((StringBuilder)object3).append("|&cu=");
            charSequence = this.b;
        } else {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string2);
            string2 = this.l.prodName;
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append((String)object5);
            object5 = this.a;
            ((StringBuilder)object3).append((String)object5);
            object5 = "|&im=";
            ((StringBuilder)object3).append((String)object5);
        }
        ((StringBuilder)object3).append((String)charSequence);
        ((StringBuilder)object3).append((String)object4);
        charSequence = ((LocationClientOption)object2).getCoorType();
        ((StringBuilder)object3).append((String)charSequence);
        this.j = object3 = ((StringBuilder)object3).toString();
        n12 = 256;
        object3 = new StringBuffer(n12);
        ((StringBuffer)object3).append("&fw=");
        charSequence = "8.4";
        ((StringBuffer)object3).append((String)charSequence);
        object4 = "&sdk=";
        ((StringBuffer)object3).append((String)object4);
        ((StringBuffer)object3).append((String)charSequence);
        ((StringBuffer)object3).append("&lt=1");
        ((StringBuffer)object3).append("&mb=");
        charSequence = Build.MODEL;
        ((StringBuffer)object3).append((String)charSequence);
        ((StringBuffer)object3).append("&resid=");
        ((StringBuffer)object3).append("12");
        ((LocationClientOption)object2).getAddrType();
        charSequence = ((LocationClientOption)object2).getAddrType();
        if (charSequence != null && (n12 = (int)(((String)(charSequence = ((LocationClientOption)object2).getAddrType())).equals(object4 = "all") ? 1 : 0)) != 0) {
            object4 = this.j;
            ((StringBuilder)charSequence).append((String)object4);
            object4 = "&addr=allj2";
            ((StringBuilder)charSequence).append((String)object4);
            charSequence = ((StringBuilder)charSequence).toString();
            this.j = charSequence;
            n12 = (int)(((LocationClientOption)object2).isNeedNewVersionRgc ? 1 : 0);
            if (n12 != 0) {
                charSequence = "&adtp=n2";
                ((StringBuffer)object3).append((String)charSequence);
            }
        }
        if ((n12 = (int)(((LocationClientOption)object2).isNeedAptag ? 1 : 0)) == n10 || (n12 = (int)(((LocationClientOption)object2).isNeedAptagd ? 1 : 0)) == n10) {
            int n13;
            super();
            object4 = this.j;
            ((StringBuilder)charSequence).append((String)object4);
            object4 = "&sema=";
            ((StringBuilder)charSequence).append((String)object4);
            charSequence = ((StringBuilder)charSequence).toString();
            this.j = charSequence;
            n12 = (int)(((LocationClientOption)object2).isNeedAptag ? 1 : 0);
            if (n12 == n10) {
                super();
                object4 = this.j;
                ((StringBuilder)charSequence).append((String)object4);
                object4 = "aptag|";
                ((StringBuilder)charSequence).append((String)object4);
                charSequence = ((StringBuilder)charSequence).toString();
                this.j = charSequence;
            }
            if ((n13 = ((LocationClientOption)object2).isNeedAptagd) == n10) {
                object = new StringBuilder();
                object2 = this.j;
                ((StringBuilder)object).append((String)object2);
                object2 = "aptagd2|";
                ((StringBuilder)object).append((String)object2);
                this.j = object = ((StringBuilder)object).toString();
            }
            this.o = object = com.baidu.location.a.a.b(this.d);
            this.p = object = com.baidu.location.a.a.c(this.d);
        }
        ((StringBuffer)object3).append("&first=1");
        ((StringBuffer)object3).append("&os=A");
        object = Build.VERSION.SDK;
        ((StringBuffer)object3).append((String)object);
        object = new StringBuilder();
        object2 = this.j;
        ((StringBuilder)object).append((String)object2);
        object2 = ((StringBuffer)object3).toString();
        ((StringBuilder)object).append((String)object2);
        this.j = object = ((StringBuilder)object).toString();
    }

    private int a(int n10) {
        int n11 = -1 >>> 1;
        if (n10 == n11) {
            n10 = -1;
        }
        return n10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private com.baidu.location.f.a a(CellInfo var1_1) {
        block127: {
            block133: {
                block125: {
                    block132: {
                        block123: {
                            block130: {
                                block124: {
                                    block131: {
                                        var2_2 = this;
                                        var3_3 = var1_1;
                                        var4_4 = Build.VERSION.SDK_INT;
                                        var5_5 = var4_4;
                                        var6_7 = var5_5.intValue();
                                        var7_8 = 0;
                                        var8_9 = null;
                                        var9_10 = 17;
                                        if (var6_7 < var9_10) {
                                            return null;
                                        }
                                        var10_11 = new com.baidu.location.f.a();
                                        var11_12 = var1_1 instanceof CellInfoGsm;
                                        var12_13 = 2;
                                        var13_14 = 0;
                                        var14_15 = null;
                                        var15_16 = 3;
                                        var16_17 = 1;
                                        var17_18 = 103;
                                        if (var11_12 != 0) {
                                            var18_19 /* !! */  = var1_1;
                                            var18_19 /* !! */  = (CellInfoGsm)var1_1;
                                            var19_20 = var18_19 /* !! */ .getCellIdentity();
                                            var20_21 = var19_20.getMcc();
                                            var10_11.c = var20_21 = this.a(var20_21);
                                            var20_21 = var19_20.getMnc();
                                            var10_11.d = var20_21 = this.a(var20_21);
                                            var20_21 = var19_20.getLac();
                                            var10_11.a = var20_21 = this.a(var20_21);
                                            var21_22 = var19_20.getCid();
                                            var21_22 = this.a(var21_22);
                                            var10_11.b = var22_23 = (long)var21_22;
                                            var10_11.i = (char)var17_18;
                                            var18_19 /* !! */  = var18_19 /* !! */ .getCellSignalStrength();
                                            var10_11.h = var11_12 = var18_19 /* !! */ .getAsuLevel();
                                            var10_11.k = var12_13;
lbl36:
                                            // 4 sources

                                            while (true) {
                                                var11_12 = var16_17;
                                                break block123;
                                                break;
                                            }
                                        }
                                        var11_12 = var1_1 instanceof CellInfoCdma;
                                        if (var11_12 == 0) break block130;
                                        var18_19 /* !! */  = var1_1;
                                        var18_19 /* !! */  = (CellInfoCdma)var1_1;
                                        var19_20 = var18_19 /* !! */ .getCellIdentity();
                                        var10_11.e = var20_21 = var19_20.getLatitude();
                                        var10_11.f = var20_21 = var19_20.getLongitude();
                                        var20_21 = var19_20.getSystemId();
                                        var10_11.d = var20_21 = this.a(var20_21);
                                        var20_21 = var19_20.getNetworkId();
                                        var10_11.a = var20_21 = this.a(var20_21);
                                        var21_22 = var19_20.getBasestationId();
                                        var10_11.b = var22_24 = (long)this.a(var21_22);
                                        var21_22 = 99;
                                        var10_11.i = (char)var21_22;
                                        var10_11.h = var11_12 = var18_19 /* !! */ .getCellSignalStrength().getCdmaDbm();
                                        var10_11.k = var16_17;
                                        var18_19 /* !! */  = this.f;
                                        if (var18_19 /* !! */  == null || (var11_12 = var18_19 /* !! */ .c) <= 0) break block131;
lbl58:
                                        // 2 sources

                                        while (true) {
                                            var10_11.c = var11_12;
                                            ** GOTO lbl36
                                            break;
                                        }
                                    }
                                    var11_12 = -1;
                                    var19_20 = var2_2.e;
                                    var19_20 = var19_20.getNetworkOperator();
                                    if (var19_20 == null) break block124;
                                    var20_21 = var19_20.length();
                                    if (var20_21 <= 0) break block124;
                                    var20_21 = var19_20.length();
                                    if (var20_21 < var15_16) break block124;
                                    var19_20 = var19_20.substring(0, var15_16);
                                    var19_20 = Integer.valueOf((String)var19_20);
                                    var21_22 = var19_20.intValue();
                                    if (var21_22 < 0) break block124;
                                    var11_12 = var21_22;
                                }
lbl83:
                                // 2 sources

                                while (true) {
                                    if (var11_12 <= 0) ** GOTO lbl36
                                    ** continue;
                                    break;
                                }
                            }
                            var11_12 = var1_1 instanceof CellInfoLte;
                            if (var11_12 != 0) {
                                var18_19 /* !! */  = var1_1;
                                var18_19 /* !! */  = (CellInfoLte)var1_1;
                                var19_20 = var18_19 /* !! */ .getCellIdentity();
                                var20_21 = var19_20.getMcc();
                                var10_11.c = var20_21 = this.a(var20_21);
                                var20_21 = var19_20.getMnc();
                                var10_11.d = var20_21 = this.a(var20_21);
                                var20_21 = var19_20.getTac();
                                var10_11.a = var20_21 = this.a(var20_21);
                                var21_22 = var19_20.getCi();
                                var21_22 = this.a(var21_22);
                                var10_11.b = var22_25 = (long)var21_22;
                                var10_11.i = (char)var17_18;
                                var18_19 /* !! */  = var18_19 /* !! */ .getCellSignalStrength();
                                var10_11.h = var11_12 = var18_19 /* !! */ .getAsuLevel();
                                var10_11.k = var15_16;
                                ** continue;
                            }
                            var11_12 = 0;
                            var18_19 /* !! */  = null;
                        }
                        var21_22 = 18;
                        if (var6_7 < var21_22 || var11_12 != 0) ** GOTO lbl353
                        var6_7 = var3_3 instanceof CellInfoWcdma;
                        var11_12 = 4;
                        if (var6_7 == 0) break block132;
                        var5_5 = var3_3;
                        var5_5 = (CellInfoWcdma)var3_3;
                        var5_5 = var5_5.getCellIdentity();
                        var4_4 = var5_5.getMcc();
                        var4_4 = var2_2.a(var4_4);
                        var10_11.c = var4_4;
                        var4_4 = var5_5.getMnc();
                        var4_4 = var2_2.a(var4_4);
                        var10_11.d = var4_4;
                        var4_4 = var5_5.getLac();
                        var4_4 = var2_2.a(var4_4);
                        var10_11.a = var4_4;
                        var6_7 = var5_5.getCid();
                        var6_7 = var2_2.a(var6_7);
                        var24_26 = var6_7;
                        var10_11.b = var24_26;
                        var10_11.i = (char)var17_18;
                        var5_5 = var3_3;
                        var5_5 = (CellInfoWcdma)var3_3;
                        var5_5 = var5_5.getCellSignalStrength();
                        var6_7 = var5_5.getAsuLevel();
                        var10_11.h = var6_7;
                        var10_11.k = var11_12;
                        ** GOTO lbl353
                    }
                    var6_7 = 29;
                    if (var4_4 < var6_7) ** GOTO lbl353
                    var6_7 = var3_3 instanceof CellInfoTdscdma;
                    var21_22 = 28;
                    var20_21 = 5;
                    if (var6_7 == 0) break block133;
                    var5_5 = var3_3;
                    var5_5 = (CellInfoTdscdma)var3_3;
                    var5_5 = var5_5.getCellIdentity();
                    var8_9 = var5_5.getMccString();
                    if (var8_9 == null) break block125;
                    var8_9 = var5_5.getMccString();
                    var8_9 = Integer.valueOf((String)var8_9);
                    var7_8 = var8_9.intValue();
                    var10_11.c = var7_8;
                }
lbl179:
                // 2 sources

                while (true) {
                    block126: {
                        var8_9 = var5_5.getMncString();
                        if (var8_9 == null) break block126;
                        var8_9 = var5_5.getMncString();
                        var8_9 = Integer.valueOf((String)var8_9);
                        var7_8 = var8_9.intValue();
                        var10_11.d = var7_8;
                    }
lbl192:
                    // 2 sources

                    while (true) {
                        var7_8 = var5_5.getLac();
                        var7_8 = var2_2.a(var7_8);
                        var10_11.a = var7_8;
                        var6_7 = var5_5.getCid();
                        var6_7 = var2_2.a(var6_7);
                        var26_27 = var6_7;
                        var10_11.b = var26_27;
                        var10_11.i = (char)var17_18;
                        var5_5 = var3_3;
                        var5_5 = (CellInfoTdscdma)var3_3;
                        var5_5 = var5_5.getCellSignalStrength();
                        var6_7 = var5_5.getAsuLevel();
                        var10_11.h = var6_7;
                        var10_11.k = var20_21;
                        if (var4_4 < var21_22) ** GOTO lbl353
                        var6_7 = var1_1.getCellConnectionStatus();
                        var10_11.j = var6_7;
                        ** GOTO lbl353
                        break;
                    }
                    break;
                }
            }
            var6_7 = var3_3 instanceof CellInfoNr;
            if (var6_7 == 0) ** GOTO lbl353
            var5_5 = var3_3;
            var5_5 = (CellInfoNr)var3_3;
            var5_5 = var5_5.getCellIdentity();
            try {
                var8_9 = var5_5 = (CellIdentityNr)var5_5;
            }
            catch (Throwable var5_6) {
                var5_6.printStackTrace();
            }
            if (var8_9 == null) ** GOTO lbl353
            var5_5 = var8_9.getMccString();
            if (var5_5 == null) break block127;
            var5_5 = var8_9.getMccString();
            var5_5 = Integer.valueOf((String)var5_5);
            var6_7 = var5_5.intValue();
            try {
                var10_11.c = var6_7;
            }
            catch (Throwable v4) {
                ** continue;
            }
        }
lbl251:
        // 2 sources

        while (true) {
            block128: {
                var5_5 = var8_9.getMncString();
                if (var5_5 == null) break block128;
                var5_5 = var8_9.getMncString();
                var5_5 = Integer.valueOf((String)var5_5);
                var6_7 = var5_5.intValue();
                var10_11.d = var6_7;
            }
lbl264:
            // 2 sources

            while (true) {
                block129: {
                    var6_7 = var8_9.getTac();
                    var6_7 = var2_2.a(var6_7);
                    var10_11.a = var6_7;
                    var28_28 = var8_9.getNci();
                    var30_29 = 0x7FFFFFFFFFFFFFFFL;
                    var6_7 = (int)(var28_28 == var30_29 ? 0 : (var28_28 < var30_29 ? -1 : 1));
                    if (var6_7 != 0) {
                        var28_28 = var8_9.getNci();
                        var10_11.b = var28_28;
                    }
                    var10_11.i = (char)var17_18;
                    var6_7 = 6;
                    var10_11.k = var6_7;
                    if (var4_4 < var21_22) break block129;
                    var4_4 = var1_1.getCellConnectionStatus();
                    var10_11.j = var4_4;
                }
                var32_30 /* !! */  = var3_3;
                var32_30 /* !! */  = (CellInfoNr)var3_3;
                var32_30 /* !! */  = var32_30 /* !! */ .getCellSignalStrength();
                var32_30 /* !! */  = (CellSignalStrengthNr)var32_30 /* !! */ ;
                var7_8 = var32_30 /* !! */ .getAsuLevel();
                var10_11.h = var7_8;
                var8_9 = Locale.US;
                var33_31 = "%d|%d|%d|%d|%d|%d|%d|%d";
                var21_22 = 8;
                var19_20 = new Object[var21_22];
                var34_32 = var32_30 /* !! */ .getCsiRsrp();
                var35_33 = var34_32;
                var19_20[0] = var35_33;
                var13_14 = var32_30 /* !! */ .getCsiRsrq();
                var14_15 = var13_14;
                var19_20[var16_17] = var14_15;
                var13_14 = var32_30 /* !! */ .getCsiSinr();
                var14_15 = var13_14;
                var19_20[var12_13] = var14_15;
                var12_13 = var32_30 /* !! */ .getDbm();
                var36_34 = var12_13;
                var19_20[var15_16] = var36_34;
                var12_13 = var32_30 /* !! */ .getLevel();
                var36_34 = var12_13;
                var19_20[var11_12] = var36_34;
                var11_12 = var32_30 /* !! */ .getSsRsrp();
                var18_19 /* !! */  = Integer.valueOf(var11_12);
                var19_20[var20_21] = var18_19 /* !! */ ;
                var11_12 = var32_30 /* !! */ .getSsRsrq();
                var18_19 /* !! */  = Integer.valueOf(var11_12);
                var19_20[var6_7] = var18_19 /* !! */ ;
                var6_7 = 7;
                var4_4 = var32_30 /* !! */ .getSsSinr();
                var32_30 /* !! */  = Integer.valueOf(var4_4);
                var19_20[var6_7] = var32_30 /* !! */ ;
                var5_5 = String.format((Locale)var8_9, var33_31, (Object[])var19_20);
                var10_11.m = var5_5;
lbl353:
                // 9 sources

                while (true) {
                    var24_26 = SystemClock.elapsedRealtimeNanos();
                    var26_27 = var1_1.getTimeStamp();
                    var24_26 -= var26_27;
                    var26_27 = 1000000L;
                    var24_26 /= var26_27;
                    var26_27 = System.currentTimeMillis() - var24_26;
                    try {
                        var10_11.g = var26_27;
                    }
                    catch (Error v0) {
                        var10_11.g = var37_35 = System.currentTimeMillis();
                    }
                    return var10_11;
                }
                break;
            }
            break;
        }
        catch (Exception v1) {
            ** continue;
        }
        catch (Throwable v2) {
            ** continue;
        }
        catch (Throwable v3) {
            ** continue;
        }
        catch (Throwable v5) {
            ** continue;
        }
        {
            catch (Exception v6) {
                ** continue;
            }
        }
    }

    private Object a(Object object, String string2) {
        return object.getClass().getField(string2).get(object);
    }

    public static /* synthetic */ String a(d d10) {
        return d10.o;
    }

    private String a(List object) {
        boolean bl2;
        int n10;
        String string2;
        Object object2;
        int n11;
        ArrayList<Object> arrayList;
        int n12;
        int n13 = 0;
        Object object3 = null;
        int n14 = 0;
        Iterator iterator2 = null;
        if (object != null && (n12 = object.size()) > 0) {
            arrayList = new ArrayList<Object>();
            object = object.iterator();
            while ((n11 = object.hasNext()) != 0) {
                object2 = (WifiConfiguration)object.next();
                string2 = ((WifiConfiguration)object2).SSID;
                Object object4 = "numAssociation";
                object2 = this.a(object2, (String)object4);
                object2 = (Integer)object2;
                try {
                    n11 = (Integer)object2;
                }
                catch (Throwable throwable) {
                    n11 = 0;
                    object2 = null;
                }
                if (n11 <= 0 || (n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) != 0) continue;
                object4 = new d$c(this, string2, n11);
                arrayList.add(object4);
            }
        } else {
            n12 = 0;
            arrayList = null;
        }
        if (arrayList != null && !(bl2 = arrayList.isEmpty())) {
            object = new e(this);
            Collections.sort(arrayList, object);
            n14 = 200;
            object = new StringBuffer(n14);
            iterator2 = arrayList.iterator();
            do {
                n11 = iterator2.hasNext();
                string2 = ",";
                n10 = 4;
                if (n11 == 0) break;
                object2 = (d$c)iterator2.next();
                String string3 = ((d$c)object2).a;
                ((StringBuffer)object).append(string3);
                ((StringBuffer)object).append(string2);
                n11 = ((d$c)object2).b;
                ((StringBuffer)object).append(n11);
                object2 = "|";
                ((StringBuffer)object).append((String)object2);
            } while (++n13 != n10);
            if ((n13 = arrayList.size()) >= (n14 = 5)) {
                object3 = ((d$c)arrayList.get((int)n10)).a;
                ((StringBuffer)object).append((String)object3);
                ((StringBuffer)object).append(string2);
                object3 = (d$c)arrayList.get(n10);
                n13 = ((d$c)object3).b;
                ((StringBuffer)object).append(n13);
            }
            return ((StringBuffer)object).toString();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(CellLocation cellLocation) {
        int n10;
        int n11;
        Object object;
        int n12;
        int n13;
        if (cellLocation == null) return;
        Object object2 = this.e;
        if (object2 == null) {
            return;
        }
        object2 = new com.baidu.location.f.a();
        Object object3 = this.e.getNetworkOperator();
        if (object3 != null && (n13 = ((String)object3).length()) > 0) {
            try {
                n13 = ((String)object3).length();
                n12 = 0;
                int n14 = 3;
                if (n13 >= n14) {
                    object = ((String)object3).substring(0, n14);
                    n13 = (Integer)(object = Integer.valueOf((String)object));
                    if (n13 < 0) {
                        object = this.f;
                        n13 = ((com.baidu.location.f.a)object).c;
                    }
                    ((com.baidu.location.f.a)object2).c = n13;
                }
                if ((object3 = ((String)object3).substring(n14)) != null) {
                    char c10;
                    object = ((String)object3).toCharArray();
                    for (n14 = 0; n14 < (c10 = ((Object)object).length); ++n14) {
                        c10 = (char)object[n14];
                        if ((c10 = (char)(Character.isDigit(c10) ? 1 : 0)) == '\u0000') break;
                    }
                    object3 = ((String)object3).substring(0, n14);
                    n11 = (Integer)(object3 = Integer.valueOf((String)object3));
                    if (n11 < 0) {
                        object3 = this.f;
                        n11 = ((com.baidu.location.f.a)object3).d;
                    }
                    ((com.baidu.location.f.a)object2).d = n11;
                }
            }
            catch (Exception exception) {}
        }
        n11 = cellLocation instanceof GsmCellLocation;
        n13 = 0;
        object = null;
        if (n11 != 0) {
            long l10;
            cellLocation = (GsmCellLocation)cellLocation;
            ((com.baidu.location.f.a)object2).a = n11 = cellLocation.getLac();
            ((com.baidu.location.f.a)object2).b = l10 = (long)cellLocation.getCid();
            n10 = 103;
            ((com.baidu.location.f.a)object2).i = (char)n10;
        } else {
            n11 = cellLocation instanceof CdmaCellLocation;
            if (n11 != 0) {
                n11 = 99;
                ((com.baidu.location.f.a)object2).i = (char)n11;
                object3 = i;
                if (object3 == null) {
                    object3 = "android.telephony.cdma.CdmaCellLocation";
                    try {
                        object3 = Class.forName((String)object3);
                        i = object3;
                    }
                    catch (Exception exception) {
                        i = null;
                        return;
                    }
                }
                if ((object3 = i) != null && (n11 = (int)(((Class)object3).isInstance(cellLocation) ? 1 : 0)) != 0) {
                    object3 = cellLocation;
                    try {
                        long l11;
                        object3 = (CdmaCellLocation)cellLocation;
                        n11 = object3.getSystemId();
                        if (n11 < 0) {
                            n11 = -1;
                        }
                        ((com.baidu.location.f.a)object2).d = n11;
                        object3 = cellLocation;
                        object3 = (CdmaCellLocation)cellLocation;
                        n11 = object3.getBaseStationId();
                        ((com.baidu.location.f.a)object2).b = l11 = (long)n11;
                        object3 = cellLocation;
                        object3 = (CdmaCellLocation)cellLocation;
                        ((com.baidu.location.f.a)object2).a = n11 = object3.getNetworkId();
                        object3 = cellLocation;
                        object3 = (CdmaCellLocation)cellLocation;
                        n11 = object3.getBaseStationLatitude();
                        if (n11 < (n12 = -1 >>> 1)) {
                            ((com.baidu.location.f.a)object2).e = n11;
                        }
                        if ((n10 = (cellLocation = (CdmaCellLocation)cellLocation).getBaseStationLongitude()) < n12) {
                            ((com.baidu.location.f.a)object2).f = n10;
                        }
                    }
                    catch (Exception exception) {}
                }
            }
        }
        if ((n10 = ((com.baidu.location.f.a)object2).b()) != 0) {
            this.f = object2;
            return;
        }
        this.f = null;
    }

    public static /* synthetic */ void a(d d10, int n10) {
        d10.c(n10);
    }

    public static /* synthetic */ void a(d d10, String string2) {
        d10.a(string2);
    }

    private void a(String context) {
        block20: {
            int n11;
            Object object;
            String string2;
            block19: {
                string2 = "ideocfre";
                object = new JSONObject((String)context);
                context = "content";
                context = object.getJSONObject((String)context);
                n11 = 0;
                object = null;
                boolean n10 = context.has(string2);
                if (!n10) break block19;
                object = context.getString(string2);
            }
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block20;
            context = "|";
            bl2 = ((String)object).contains((CharSequence)context);
            if (!bl2) break block20;
            context = "\\|";
            context = ((String)object).split((String)context);
            if (context == null) break block20;
            int n10 = ((String[])context).length;
            n11 = 2;
            if (n10 < n11) break block20;
            n10 = 0;
            string2 = null;
            object = context[0];
            n11 = Integer.parseInt((String)object);
            int n12 = 1;
            context = context[n12];
            long l10 = Long.parseLong((String)context);
            context = this.d;
            String string3 = "cuidRelate";
            context = context.getSharedPreferences(string3, 0);
            context = context.edit();
            string2 = "cuidoc";
            context.putInt(string2, n11);
            string2 = "cuidfreq";
            try {
                context.putLong(string2, l10);
                context.apply();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static /* synthetic */ boolean a(d d10, boolean bl2) {
        d10.v = bl2;
        return bl2;
    }

    public static /* synthetic */ int b(d d10, int n10) {
        d10.s = n10;
        return n10;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String b(int n10) {
        CharSequence charSequence;
        Object object;
        Object object2;
        String string2;
        block23: {
            block22: {
                int n11;
                block21: {
                    block20: {
                        int n12;
                        string2 = null;
                        object2 = this.d();
                        if (object2 != null && (n11 = ((com.baidu.location.f.a)object2).b()) != 0) {
                            this.f = object2;
                        } else {
                            n12 = Build.VERSION.SDK_INT;
                            n11 = 28;
                            if (n12 <= n11) {
                                object2 = this.e;
                                object2 = object2.getCellLocation();
                                this.a((CellLocation)object2);
                            }
                        }
                        object2 = this.f;
                        if (object2 != null && (n12 = (int)(((com.baidu.location.f.a)object2).b() ? 1 : 0)) != 0) {
                            object2 = this.f;
                            object2 = ((com.baidu.location.f.a)object2).i();
                            break block20;
                        }
                        n12 = 0;
                        object2 = null;
                    }
                    try {
                        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                        if (n11 == 0 && (object = this.f) != null && (object = ((com.baidu.location.f.a)object).l) != null) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append((String)object2);
                            com.baidu.location.f.a a10 = this.f;
                            String string3 = a10.l;
                            ((StringBuilder)object).append(string3);
                            object2 = ((StringBuilder)object).toString();
                        }
                        break block21;
                    }
                    catch (Throwable throwable) {}
                    catch (Throwable throwable) {
                        boolean bl2 = false;
                        object2 = null;
                    }
                }
                try {
                    this.h = null;
                    n11 = (int)(this.e() ? 1 : 0);
                    if (n11 == 0) break block22;
                    WifiManager wifiManager = this.g;
                    List list = wifiManager.getScanResults();
                    this.h = object = new d$d(this, list);
                    String string4 = this.f();
                    charSequence = ((d$d)object).a(n10, string4);
                }
                catch (Exception exception) {}
                try {
                    object = this.l;
                    if (object != null && (n11 = (int)(((LocationClientOption)object).isOnceLocation() ? 1 : 0)) != 0) {
                        object = this.g;
                        object.startScan();
                    }
                    break block23;
                }
                catch (Exception exception) {}
            }
            n10 = 0;
            charSequence = null;
        }
        if (object2 == null && charSequence == null) {
            this.n = null;
            return null;
        }
        if (charSequence != null) {
            if (object2 == null) {
                object2 = charSequence;
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)charSequence);
                object2 = ((StringBuilder)object).toString();
            }
        }
        if (object2 == null) {
            return null;
        }
        this.n = object2;
        charSequence = this.j;
        if (charSequence != null) {
            charSequence = new StringBuilder();
            string2 = this.n;
            ((StringBuilder)charSequence).append(string2);
            string2 = this.j;
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            this.n = charSequence;
        }
        this.h();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object2);
        string2 = this.j;
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public static /* synthetic */ String b(d d10) {
        return d10.p;
    }

    public static /* synthetic */ LocationClientOption c(d d10) {
        return d10.l;
    }

    private void c(int n10) {
        Object object = this.l;
        boolean bl2 = ((LocationClientOption)object).isOnceLocation();
        if (bl2) {
            object = new BDLocation();
            ((BDLocation)object).setLocType(n10);
            d$a d$a = this.m;
            if (d$a != null) {
                d$a.onReceiveLocation((BDLocation)object);
            }
        }
    }

    public static /* synthetic */ d$a d(d d10) {
        return d10.m;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private com.baidu.location.f.a d() {
        Object object = Build.VERSION.SDK_INT;
        int n10 = (Integer)object;
        Object object2 = null;
        int n11 = 17;
        if (n10 < n11) {
            return null;
        }
        try {
            object = this.e;
            object = object.getAllCellInfo();
            if (object == null) return object2;
            n11 = object.size();
            if (n11 <= 0) return object2;
            object = object.iterator();
            n11 = 0;
            Object object3 = null;
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    return object3;
                }
                Object object4 = object.next();
                boolean bl3 = (object4 = (CellInfo)object4).isRegistered();
                if (!bl3) continue;
                bl3 = false;
                if (object3 != null) {
                    bl3 = true;
                }
                if ((object4 = this.a((CellInfo)object4)) == null) continue;
                boolean bl4 = ((com.baidu.location.f.a)object4).b();
                if (!bl4) {
                    bl2 = false;
                    object4 = null;
                } else if (bl3 && object3 != null) {
                    ((com.baidu.location.f.a)object3).l = object = ((com.baidu.location.f.a)object4).j();
                    return object3;
                }
                if (object3 != null) continue;
                object3 = object4;
            }
        }
        catch (Throwable throwable) {
            return object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean e() {
        boolean bl3 = false;
        try {
            WifiManager wifiManager = this.g;
            int n10 = wifiManager.isWifiEnabled();
            boolean bl2 = true;
            if (n10 != 0) return bl2;
            n10 = Build.VERSION.SDK_INT;
            int n11 = 17;
            if (n10 <= n11) return bl3;
            wifiManager = this.g;
            n10 = (int)(wifiManager.isScanAlwaysAvailable() ? 1 : 0);
            if (n10 == 0) return bl3;
            return bl2;
        }
        catch (Throwable throwable) {}
        return bl3;
    }

    public static /* synthetic */ boolean e(d d10) {
        return d10.t;
    }

    public static /* synthetic */ Context f(d d10) {
        return d10.d;
    }

    private String f() {
        String string2;
        Object object;
        block12: {
            block11: {
                block10: {
                    block9: {
                        object = this.g;
                        if (object == null) {
                            return null;
                        }
                        try {
                            object = object.getConnectionInfo();
                            if (object != null) break block9;
                            return null;
                        }
                        catch (Exception exception) {
                            return null;
                        }
                    }
                    object = object.getBSSID();
                    if (object == null) break block10;
                    string2 = ":";
                    String string3 = "";
                    object = ((String)object).replace(string2, string3);
                    break block11;
                }
                object = null;
            }
            if (object != null) {
                int n10 = ((String)object).length();
                int n11 = 12;
                if (n10 == n11) break block12;
                return null;
            }
        }
        string2 = new String((String)object);
        return string2;
    }

    public static /* synthetic */ int g(d d10) {
        return d10.s;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean g() {
        int n10;
        Object object = com.baidu.location.b.a.a();
        int n11 = ((a)object).d;
        if (n11 == 0) {
            return false;
        }
        object = this.d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        String string2 = "isInstalled";
        int n12 = object.contains(string2);
        boolean bl2 = true;
        if (n12 == 0) {
            SharedPreferences.Editor editor = object.edit();
            Context context = this.d;
            String string3 = "com.baidu.map.location";
            boolean bl3 = com.baidu.location.h.l.b(context, string3);
            if (!bl3) {
                editor.putInt(string2, 0);
                return false;
            }
            editor.putInt(string2, (int)(bl2 ? 1 : 0));
            editor.apply();
        } else {
            n12 = -1;
            n10 = object.getInt(string2, n12);
            if (n10 == 0) {
                return false;
            }
        }
        string2 = "cuidoc";
        n10 = object.getInt(string2, (int)(bl2 ? 1 : 0));
        if (n10 == 0) {
            return false;
        }
        long l10 = System.currentTimeMillis();
        long l11 = object.getLong("reqtime", 0L);
        String string4 = "cuidfreq";
        long l12 = (l10 = (l10 - l11) / 1000L) - (l11 = object.getLong(string4, (long)60));
        n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n11 < 0) {
            return false;
        }
        object = this.d;
        n11 = com.baidu.location.h.l.c((Context)object);
        if (n11 < (n10 = 2)) {
            return false;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 == 0) return false;
        object = this.h;
        n11 = ((d$d)object).a();
        if (n11 > (n10 = 3)) return bl2;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private void h() {
        block9: {
            block6: {
                block8: {
                    block7: {
                        var1_1 = this.g();
                        var2_2 = false;
                        var3_3 = null;
                        if (!var1_1) break block6;
                        this.t = var1_1 = true;
                        var4_4 = this.h;
                        var5_5 = var4_4.a();
                        var6_6 = 10;
                        var7_7 = null;
                        if (var5_5 < var6_6) break block7;
                        var4_4 = this.h;
                        var8_8 = this.f();
                        var6_6 = (int)TextUtils.isEmpty((CharSequence)(var4_4 = var4_4.a(9, var8_8)));
                        if (var6_6 != 0) ** GOTO lbl-1000
                        var4_4 = com.baidu.location.h.l.a(var4_4.getBytes(), false);
                        break block8;
                    }
                    var4_4 = this.h;
                    var6_6 = var4_4.a();
                    var8_9 = this.f();
                    if ((var6_6 = (int)TextUtils.isEmpty((CharSequence)(var4_4 = var4_4.a(var6_6, var8_9)))) == 0) {
                        var4_4 = com.baidu.location.h.l.a(var4_4.getBytes(), false);
                    } else lbl-1000:
                    // 2 sources

                    {
                        var5_5 = 0;
                        var4_4 = null;
                    }
                }
                var9_10 = this.i();
                var9_10 = this.a((List)var9_10);
                var10_11 = TextUtils.isEmpty((CharSequence)var9_10);
                if (!var10_11) {
                    var9_10 = var9_10.getBytes();
                    var7_7 = com.baidu.location.h.l.a((byte[])var9_10, false);
                }
                if ((var6_6 = (int)TextUtils.isEmpty((CharSequence)var4_4)) == 0) {
                    var3_3 = new StringBuilder();
                    var9_10 = this.n;
                    var3_3.append((String)var9_10);
                    var9_10 = "&swf5=";
                    var3_3.append((String)var9_10);
                    var3_3.append((String)var4_4);
                    var3_3 = var3_3.toString();
                    this.n = var3_3;
                    this.t = var1_1;
                } else {
                    this.t = false;
                }
                var2_2 = TextUtils.isEmpty((CharSequence)var7_7);
                if (!var2_2) {
                    var3_3 = new StringBuilder();
                    var4_4 = this.n;
                    var3_3.append((String)var4_4);
                    var4_4 = "&hwf5=";
                    var3_3.append((String)var4_4);
                    var3_3.append(var7_7);
                    var3_3 = var3_3.toString();
                    this.n = var3_3;
                    this.t = var1_1;
                }
                break block9;
            }
            this.t = false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private List i() {
        WifiManager wifiManager;
        List list = null;
        try {
            wifiManager = this.g;
            if (wifiManager == null) return list;
        }
        catch (Exception exception) {
            return list;
        }
        return wifiManager.getConfiguredNetworks();
    }

    public void a() {
        this.b();
    }

    public String b() {
        int n10 = 15;
        try {
            return this.b(n10);
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void c() {
        block55: {
            block54: {
                block53: {
                    block52: {
                        block51: {
                            block50: {
                                var1_1 = this.n;
                                if (var1_1 == null) {
                                    this.c(62);
                                    return;
                                }
                                var2_2 = this.q;
                                if (!var2_2) {
                                    return;
                                }
                                var1_1 = this.g;
                                var3_3 = null;
                                if (var1_1 == null) break block55;
                                var1_1 = this.l;
                                var4_4 = var1_1.scanSpan;
                                var5_5 = 1000;
                                if (var4_4 < var5_5 || (var2_2 = (var1_1 = var1_1.getAddrType()).equals(var6_6 = "all"))) break block55;
                                var1_1 = this.l;
                                var4_4 = (int)var1_1.isNeedAptag;
                                if (var4_4 != 0 || (var4_4 = (int)var1_1.isNeedAptagd) != 0 || (var2_2 = var1_1.isOnceLocation())) break block55;
                                try {
                                    var1_1 = this.f;
                                    if (var1_1 == null) break block50;
                                }
                                catch (Exception v0) {
                                    ** continue;
                                }
                                var1_1 = var1_1.g();
                                break block51;
                            }
                            var2_2 = false;
                            var1_1 = null;
                        }
                        var6_6 = this.g;
                        var5_5 = 0;
                        var7_7 = 66;
                        var8_8 = 0.10000000149011612;
                        if (var6_6 == null) break block52;
                        var6_6 = com.baidu.location.e.a.a();
                        var10_9 /* !! */  = this.g;
                        var10_9 /* !! */  = var10_9 /* !! */ .getScanResults();
                        var1_1 = var6_6.a((String)var1_1, (List)var10_9 /* !! */ , false);
                        if (var1_1 == null) break block53;
                        var4_4 = var1_1.getLocType();
                        if (var4_4 != var7_7) break block53;
                        var11_10 /* !! */  = var1_1.getLatitude();
                        var11_10 /* !! */  = Math.abs(var11_10 /* !! */ );
                        var4_4 = (int)(var11_10 /* !! */  == var8_8 ? 0 : (var11_10 /* !! */  < var8_8 ? -1 : 1));
                        if (var4_4 >= 0) break block53;
                        var11_10 /* !! */  = var1_1.getLongitude();
                        var11_10 /* !! */  = Math.abs(var11_10 /* !! */ );
                        var4_4 = (int)(var11_10 /* !! */  == var8_8 ? 0 : (var11_10 /* !! */  < var8_8 ? -1 : 1));
                        if (var4_4 >= 0) break block53;
                        var4_4 = 67;
                        var1_1.setLocType(var4_4);
                        break block53;
                    }
                    var2_2 = false;
                    var1_1 = null;
                }
                if (var1_1 != null) {
                    var1_1.getLocType();
                }
                if (var1_1 == null) ** GOTO lbl76
                var1_1.getLocType();
lbl76:
                // 2 sources

                var6_6 = this.l;
                var6_6 = var6_6.coorType;
                var10_9 /* !! */  = "gcj02";
                var4_4 = (int)var6_6.equals(var10_9 /* !! */ );
                if (var4_4 != 0 || var1_1 == null) break block54;
                var4_4 = var1_1.getLocType();
                if (var4_4 != var7_7) break block54;
                var11_10 /* !! */  = var1_1.getLongitude();
                var13_11 = var1_1.getLatitude();
                var15_12 = Math.abs(var11_10 /* !! */ );
                var4_4 = (int)(var15_12 == var8_8 ? 0 : (var15_12 > var8_8 ? 1 : -1));
                if (var4_4 > 0) {
                    var15_12 = Math.abs(var13_11);
                    var4_4 = (int)(var15_12 == var8_8 ? 0 : (var15_12 > var8_8 ? 1 : -1));
                    if (var4_4 > 0) {
                        var6_6 = this.l;
                        var6_6 = var6_6.coorType;
                        var6_6 = Jni.coorEncrypt(var11_10 /* !! */ , var13_11, (String)var6_6);
                        var11_10 /* !! */  = (double)var6_6[0];
                        var1_1.setLongitude(var11_10 /* !! */ );
                        var5_5 = 1;
                        var11_10 /* !! */  = (double)var6_6[var5_5];
                        var1_1.setLatitude(var11_10 /* !! */ );
                        var6_6 = this.l;
                        var6_6 = var6_6.coorType;
                        var1_1.setCoorType((String)var6_6);
                    }
                }
            }
            if (var1_1 != null) {
                var4_4 = var1_1.getLocType();
                if (var4_4 != var7_7) break block55;
                var17_13 = var1_1.getLatitude();
                var17_13 = Math.abs(var17_13);
                var4_4 = (int)(var17_13 == var8_8 ? 0 : (var17_13 > var8_8 ? 1 : -1));
                if (var4_4 > 0) {
                    var17_13 = var1_1.getLongitude();
                    var17_13 = Math.abs(var17_13);
                    var4_4 = (int)(var17_13 == var8_8 ? 0 : (var17_13 > var8_8 ? 1 : -1));
                    if (var4_4 > 0) {
                        block56: {
                            var4_4 = (int)this.v;
                            if (var4_4 != 0) break block56;
                            var6_6 = this.m;
                            var6_6.onReceiveLocation((BDLocation)var1_1);
                        }
                        var3_3 = var1_1;
                    }
                }
            }
        }
lbl145:
        // 2 sources

        while (true) {
            if (var3_3 == null) {
                var1_1 = this.c;
                var3_3 = this.n;
                var1_1.a((String)var3_3);
            }
            return;
        }
    }
}

