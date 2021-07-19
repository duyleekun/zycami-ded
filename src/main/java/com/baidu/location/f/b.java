/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
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
 *  android.telephony.PhoneStateListener
 *  android.telephony.TelephonyManager
 *  android.telephony.TelephonyManager$CellInfoCallback
 *  android.telephony.cdma.CdmaCellLocation
 *  android.telephony.gsm.GsmCellLocation
 */
package com.baidu.location.f;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
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
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.f;
import com.baidu.location.f.a;
import com.baidu.location.f.b$a;
import com.baidu.location.f.b$b;
import com.baidu.location.h.l;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public class b {
    public static int a;
    public static int b;
    private static b c;
    private static Class k;
    private TelephonyManager d = null;
    private a e;
    private a f;
    private List g;
    private b$b h;
    private boolean i;
    private boolean j;
    private b$a l;
    private long m;
    private Handler n;

    private b() {
        Handler handler;
        a a10;
        this.e = a10 = new a();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.m = 0L;
        this.n = handler = new Handler();
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
    private a a(CellInfo var1_1) {
        block131: {
            block139: {
                block129: {
                    block138: {
                        block127: {
                            block136: {
                                block128: {
                                    block137: {
                                        block135: {
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
                                            var10_11 = new a();
                                            var11_12 = var1_1 instanceof CellInfoGsm;
                                            var12_13 = 2;
                                            var13_14 = 0;
                                            var14_15 = null;
                                            var15_16 = 3;
                                            var16_17 = 1;
                                            var17_18 = 103;
                                            var18_19 = 28;
                                            if (var11_12 == 0) break block135;
                                            var19_20 /* !! */  = var1_1;
                                            var19_20 /* !! */  = (CellInfoGsm)var1_1;
                                            var20_21 = var19_20 /* !! */ .getCellIdentity();
                                            var21_24 = var20_21.getMcc();
                                            var10_11.c = var21_24 = this.a(var21_24);
                                            var21_24 = var20_21.getMnc();
                                            var10_11.d = var21_24 = this.a(var21_24);
                                            var21_24 = var20_21.getLac();
                                            var10_11.a = var21_24 = this.a(var21_24);
                                            var22_25 = var20_21.getCid();
                                            var22_25 = this.a(var22_25);
                                            var10_11.b = var23_26 = (long)var22_25;
                                            var10_11.i = (char)var17_18;
                                            var19_20 /* !! */  = var19_20 /* !! */ .getCellSignalStrength();
                                            var10_11.h = var11_12 = var19_20 /* !! */ .getAsuLevel();
                                            var10_11.k = var12_13;
                                            if (var4_4 < var18_19) ** GOTO lbl40
lbl38:
                                            // 2 sources

                                            while (true) {
                                                var10_11.j = var11_12 = var1_1.getCellConnectionStatus();
lbl40:
                                                // 5 sources

                                                while (true) {
                                                    var11_12 = var16_17;
                                                    break block127;
                                                    break;
                                                }
                                                break;
                                            }
                                        }
                                        var11_12 = var1_1 instanceof CellInfoCdma;
                                        if (var11_12 == 0) break block136;
                                        var19_20 /* !! */  = var1_1;
                                        var19_20 /* !! */  = (CellInfoCdma)var1_1;
                                        var20_22 = var19_20 /* !! */ .getCellIdentity();
                                        var10_11.e = var21_24 = var20_22.getLatitude();
                                        var10_11.f = var21_24 = var20_22.getLongitude();
                                        var21_24 = var20_22.getSystemId();
                                        var10_11.d = var21_24 = this.a(var21_24);
                                        var21_24 = var20_22.getNetworkId();
                                        var10_11.a = var21_24 = this.a(var21_24);
                                        var22_25 = var20_22.getBasestationId();
                                        var10_11.b = var23_27 = (long)this.a(var22_25);
                                        var22_25 = 99;
                                        var10_11.i = (char)var22_25;
                                        var19_20 /* !! */  = var19_20 /* !! */ .getCellSignalStrength();
                                        var10_11.h = var11_12 = var19_20 /* !! */ .getCdmaDbm();
                                        var10_11.k = var16_17;
                                        if (var4_4 >= var18_19) {
                                            var10_11.j = var11_12 = var1_1.getCellConnectionStatus();
                                        }
                                        if ((var19_20 /* !! */  = var2_2.e) == null || (var11_12 = var19_20 /* !! */ .c) <= 0) break block137;
lbl65:
                                        // 2 sources

                                        while (true) {
                                            var10_11.c = var11_12;
                                            ** GOTO lbl40
                                            break;
                                        }
                                    }
                                    var11_12 = -1;
                                    var20_22 = var2_2.d;
                                    var20_22 = var20_22.getNetworkOperator();
                                    if (var20_22 == null) break block128;
                                    var21_24 = var20_22.length();
                                    if (var21_24 <= 0) break block128;
                                    var21_24 = var20_22.length();
                                    if (var21_24 < var15_16) break block128;
                                    var20_22 = var20_22.substring(0, var15_16);
                                    var20_22 = Integer.valueOf((String)var20_22);
                                    var22_25 = var20_22.intValue();
                                    if (var22_25 < 0) break block128;
                                    var11_12 = var22_25;
                                }
lbl90:
                                // 2 sources

                                while (true) {
                                    if (var11_12 <= 0) ** GOTO lbl40
                                    ** continue;
                                    break;
                                }
                            }
                            var11_12 = var1_1 instanceof CellInfoLte;
                            if (var11_12 != 0) {
                                var19_20 /* !! */  = var1_1;
                                var19_20 /* !! */  = (CellInfoLte)var1_1;
                                var20_23 = var19_20 /* !! */ .getCellIdentity();
                                var21_24 = var20_23.getMcc();
                                var10_11.c = var21_24 = this.a(var21_24);
                                var21_24 = var20_23.getMnc();
                                var10_11.d = var21_24 = this.a(var21_24);
                                var21_24 = var20_23.getTac();
                                var10_11.a = var21_24 = this.a(var21_24);
                                var22_25 = var20_23.getCi();
                                var22_25 = this.a(var22_25);
                                var10_11.b = var23_28 = (long)var22_25;
                                var10_11.i = (char)var17_18;
                                var19_20 /* !! */  = var19_20 /* !! */ .getCellSignalStrength();
                                var10_11.h = var11_12 = var19_20 /* !! */ .getAsuLevel();
                                var10_11.k = var15_16;
                                if (var4_4 >= var18_19) ** break;
                                ** continue;
                                ** continue;
                            }
                            var11_12 = 0;
                            var19_20 /* !! */  = null;
                        }
                        var22_25 = 18;
                        if (var6_7 < var22_25 || var11_12 != 0) ** GOTO lbl367
                        var6_7 = var3_3 instanceof CellInfoWcdma;
                        var11_12 = 4;
                        if (var6_7 == 0) break block138;
                        var5_5 = var3_3;
                        var5_5 = (CellInfoWcdma)var3_3;
                        var5_5 = var5_5.getCellIdentity();
                        var7_8 = var5_5.getMcc();
                        var7_8 = var2_2.a(var7_8);
                        var10_11.c = var7_8;
                        var7_8 = var5_5.getMnc();
                        var7_8 = var2_2.a(var7_8);
                        var10_11.d = var7_8;
                        var7_8 = var5_5.getLac();
                        var7_8 = var2_2.a(var7_8);
                        var10_11.a = var7_8;
                        var6_7 = var5_5.getCid();
                        var6_7 = var2_2.a(var6_7);
                        var25_29 = var6_7;
                        var10_11.b = var25_29;
                        var10_11.i = (char)var17_18;
                        var5_5 = var3_3;
                        var5_5 = (CellInfoWcdma)var3_3;
                        var5_5 = var5_5.getCellSignalStrength();
                        var6_7 = var5_5.getAsuLevel();
                        var10_11.h = var6_7;
                        var10_11.k = var11_12;
                        if (var4_4 < var18_19) ** GOTO lbl367
lbl164:
                        // 2 sources

                        while (true) {
                            var6_7 = var1_1.getCellConnectionStatus();
                            var10_11.j = var6_7;
                            ** GOTO lbl367
                            break;
                        }
                    }
                    var6_7 = 29;
                    if (var4_4 < var6_7) ** GOTO lbl367
                    var6_7 = var3_3 instanceof CellInfoTdscdma;
                    var22_25 = 5;
                    if (var6_7 == 0) break block139;
                    var5_5 = var3_3;
                    var5_5 = (CellInfoTdscdma)var3_3;
                    var5_5 = var5_5.getCellIdentity();
                    var8_9 = var5_5.getMccString();
                    if (var8_9 == null) break block129;
                    var8_9 = var5_5.getMccString();
                    var8_9 = Integer.valueOf((String)var8_9);
                    var7_8 = var8_9.intValue();
                    var10_11.c = var7_8;
                }
lbl193:
                // 2 sources

                while (true) {
                    block130: {
                        var8_9 = var5_5.getMncString();
                        if (var8_9 == null) break block130;
                        var8_9 = var5_5.getMncString();
                        var8_9 = Integer.valueOf((String)var8_9);
                        var7_8 = var8_9.intValue();
                        var10_11.d = var7_8;
                    }
lbl206:
                    // 2 sources

                    while (true) {
                        var7_8 = var5_5.getLac();
                        var7_8 = var2_2.a(var7_8);
                        var10_11.a = var7_8;
                        var6_7 = var5_5.getCid();
                        var6_7 = var2_2.a(var6_7);
                        var27_30 = var6_7;
                        var10_11.b = var27_30;
                        var10_11.i = (char)var17_18;
                        var5_5 = var3_3;
                        var5_5 = (CellInfoTdscdma)var3_3;
                        var5_5 = var5_5.getCellSignalStrength();
                        var6_7 = var5_5.getAsuLevel();
                        var10_11.h = var6_7;
                        var10_11.k = var22_25;
                        if (var4_4 >= var18_19) {
                            ** continue;
                        }
                        ** GOTO lbl367
                        break;
                    }
                    break;
                }
            }
            var6_7 = var3_3 instanceof CellInfoNr;
            if (var6_7 == 0) ** GOTO lbl367
            var5_5 = var3_3;
            var5_5 = (CellInfoNr)var3_3;
            var5_5 = var5_5.getCellIdentity();
            try {
                var8_9 = var5_5 = (CellIdentityNr)var5_5;
            }
            catch (Throwable var5_6) {
                var5_6.printStackTrace();
            }
            if (var8_9 == null) ** GOTO lbl367
            var5_5 = var8_9.getMccString();
            if (var5_5 == null) break block131;
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
lbl262:
        // 2 sources

        while (true) {
            block132: {
                var5_5 = var8_9.getMncString();
                if (var5_5 == null) break block132;
                var5_5 = var8_9.getMncString();
                var5_5 = Integer.valueOf((String)var5_5);
                var6_7 = var5_5.intValue();
                var10_11.d = var6_7;
            }
lbl275:
            // 2 sources

            while (true) {
                block134: {
                    block133: {
                        var6_7 = var8_9.getTac();
                        var6_7 = var2_2.a(var6_7);
                        var10_11.a = var6_7;
                        var29_31 = var8_9.getNci();
                        var31_32 = 0x7FFFFFFFFFFFFFFFL;
                        var6_7 = (int)(var29_31 == var31_32 ? 0 : (var29_31 < var31_32 ? -1 : 1));
                        if (var6_7 != 0) {
                            var29_31 = var8_9.getNci();
                            var10_11.b = var29_31;
                        }
                        var10_11.i = (char)var17_18;
                        var6_7 = 6;
                        var10_11.k = var6_7;
                        if (var4_4 < var18_19) break block133;
                        var4_4 = var1_1.getCellConnectionStatus();
                        var10_11.j = var4_4;
                    }
                    var33_33 /* !! */  = var3_3;
                    var33_33 /* !! */  = (CellInfoNr)var3_3;
                    var33_33 /* !! */  = var33_33 /* !! */ .getCellSignalStrength();
                    var33_33 /* !! */  = (CellSignalStrengthNr)var33_33 /* !! */ ;
                    var7_8 = var33_33 /* !! */ .getAsuLevel();
                    var10_11.h = var7_8;
                    var7_8 = (int)var10_11.b();
                    if (var7_8 == 0) break block134;
                    var8_9 = Locale.US;
                    var34_34 = "%d|%d|%d|%d|%d|%d|%d|%d";
                    var18_19 = 8;
                    var35_35 = new Object[var18_19];
                    var21_24 = var33_33 /* !! */ .getCsiRsrp();
                    var36_36 = var21_24;
                    var35_35[0] = var36_36;
                    var13_14 = var33_33 /* !! */ .getCsiRsrq();
                    var14_15 = var13_14;
                    var35_35[var16_17] = var14_15;
                    var13_14 = var33_33 /* !! */ .getCsiSinr();
                    var14_15 = var13_14;
                    var35_35[var12_13] = var14_15;
                    var12_13 = var33_33 /* !! */ .getDbm();
                    var37_37 = var12_13;
                    var35_35[var15_16] = var37_37;
                    var12_13 = var33_33 /* !! */ .getLevel();
                    var37_37 = var12_13;
                    var35_35[var11_12] = var37_37;
                    var11_12 = var33_33 /* !! */ .getSsRsrp();
                    var19_20 /* !! */  = Integer.valueOf(var11_12);
                    var35_35[var22_25] = var19_20 /* !! */ ;
                    var11_12 = var33_33 /* !! */ .getSsRsrq();
                    var19_20 /* !! */  = Integer.valueOf(var11_12);
                    var35_35[var6_7] = var19_20 /* !! */ ;
                    var6_7 = 7;
                    var4_4 = var33_33 /* !! */ .getSsSinr();
                    var33_33 /* !! */  = Integer.valueOf(var4_4);
                    var35_35[var6_7] = var33_33 /* !! */ ;
                    var5_5 = String.format((Locale)var8_9, var34_34, var35_35);
                    var10_11.m = var5_5;
                }
lbl368:
                // 2 sources

                while (true) {
                    var38_38 = SystemClock.elapsedRealtimeNanos();
                    var27_30 = var1_1.getTimeStamp();
                    var38_38 -= var27_30;
                    var27_30 = 1000000L;
                    var38_38 /= var27_30;
                    var27_30 = System.currentTimeMillis() - var38_38;
                    try {
                        var10_11.g = var27_30;
                    }
                    catch (Error v0) {
                        var10_11.g = var40_39 = System.currentTimeMillis();
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

    private a a(CellLocation cellLocation) {
        return this.a(cellLocation, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a a(CellLocation cellLocation, boolean n10) {
        int n11;
        Object object;
        long l10;
        int n12 = 0;
        Object object2 = null;
        if (cellLocation == null) return null;
        Object object3 = this.d;
        if (object3 == null) {
            return null;
        }
        object3 = new a();
        if (n10 != 0) {
            ((a)object3).f();
        }
        ((a)object3).g = l10 = System.currentTimeMillis();
        n10 = 3;
        try {
            int n13;
            object = this.d;
            object = object.getNetworkOperator();
            if (object != null && (n13 = ((String)object).length()) > 0) {
                a a10;
                Object object4;
                n13 = -1;
                int n14 = ((String)object).length();
                if (n14 >= n10) {
                    object4 = ((String)object).substring(0, n10);
                    n13 = (Integer)(object4 = Integer.valueOf((String)object4));
                    if (n13 < 0) {
                        a10 = this.e;
                        n14 = a10.c;
                    } else {
                        n14 = n13;
                    }
                    ((a)object3).c = n14;
                }
                if ((object = ((String)object).substring(n10)) != null) {
                    char c10;
                    object4 = ((String)object).toCharArray();
                    a10 = null;
                    for (n14 = 0; n14 < (c10 = ((Object)object4).length); ++n14) {
                        c10 = (char)object4[n14];
                        if ((c10 = (char)(Character.isDigit(c10) ? 1 : 0)) == '\u0000') break;
                    }
                    object = ((String)object).substring(0, n14);
                    object = Integer.valueOf((String)object);
                    n13 = (Integer)object;
                }
                if (n13 < 0) {
                    object = this.e;
                    n13 = ((a)object).d;
                }
                ((a)object3).d = n13;
            }
            object = this.d;
            a = n11 = object.getSimState();
        }
        catch (Exception exception) {
            b = n11 = 1;
        }
        n11 = cellLocation instanceof GsmCellLocation;
        if (n11 != 0) {
            long l11;
            cellLocation = (GsmCellLocation)cellLocation;
            ((a)object3).a = n10 = cellLocation.getLac();
            ((a)object3).b = l11 = (long)cellLocation.getCid();
            int n15 = 103;
            ((a)object3).i = (char)n15;
        } else {
            n11 = cellLocation instanceof CdmaCellLocation;
            if (n11 != 0) {
                n11 = 99;
                ((a)object3).i = (char)n11;
                object = k;
                if (object == null) {
                    object = "android.telephony.cdma.CdmaCellLocation";
                    try {
                        k = object = Class.forName((String)object);
                    }
                    catch (Exception exception) {
                        k = null;
                        return object3;
                    }
                }
                if ((object2 = k) != null && (n12 = ((Class)object2).isInstance(cellLocation)) != 0) {
                    object2 = cellLocation;
                    try {
                        int n16;
                        object2 = (CdmaCellLocation)cellLocation;
                        n12 = object2.getSystemId();
                        if (n12 < 0) {
                            object2 = this.e;
                            n12 = ((a)object2).d;
                        }
                        ((a)object3).d = n12;
                        object2 = cellLocation;
                        object2 = (CdmaCellLocation)cellLocation;
                        n12 = object2.getBaseStationId();
                        ((a)object3).b = l10 = (long)n12;
                        object2 = cellLocation;
                        object2 = (CdmaCellLocation)cellLocation;
                        ((a)object3).a = n12 = object2.getNetworkId();
                        object2 = cellLocation;
                        object2 = (CdmaCellLocation)cellLocation;
                        n12 = object2.getBaseStationLatitude();
                        if (n12 < (n11 = -1 >>> 1)) {
                            ((a)object3).e = n12;
                        }
                        if ((n16 = (cellLocation = (CdmaCellLocation)cellLocation).getBaseStationLongitude()) < n11) {
                            ((a)object3).f = n16;
                        }
                    }
                    catch (Exception exception) {
                        b = n10;
                        return object3;
                    }
                }
            }
        }
        this.c((a)object3);
        return object3;
    }

    public static b a() {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            b b10 = c;
            if (b10 == null) {
                c = b10 = new b();
            }
            b10 = c;
            return b10;
        }
    }

    public static /* synthetic */ void a(b b10) {
        b10.k();
    }

    public static /* synthetic */ Handler b(b b10) {
        return b10.n;
    }

    public static /* synthetic */ a c(b b10) {
        return b10.e;
    }

    private void c(a object) {
        block6: {
            block7: {
                Object object2;
                Object object3;
                block8: {
                    int n10;
                    object3 = ((a)object).b();
                    if (object3 == 0 || (object2 = this.e) != null && (object3 = ((a)object2).a((a)object)) != 0) break block6;
                    this.e = object;
                    boolean n102 = ((a)object).b();
                    if (!n102) break block7;
                    object = this.g;
                    int n11 = object.size();
                    if (n11 == 0) {
                        boolean bl2 = false;
                        object = null;
                    } else {
                        object2 = this.g;
                        int n12 = n11 + -1;
                        object = (a)object2.get(n12);
                    }
                    if (object == null) break block8;
                    long l10 = ((a)object).b;
                    a a10 = this.e;
                    long l11 = a10.b;
                    long l12 = l10 - l11;
                    object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object3 == 0 && (n10 = ((a)object).a) == (object3 = a10.a)) break block6;
                }
                object = this.g;
                object2 = this.e;
                object.add(object2);
                object = this.g;
                int n13 = object.size();
                object3 = 3;
                if (n13 > object3) {
                    object = this.g;
                    object.remove(0);
                }
                this.j();
                this.j = false;
                break block6;
            }
            object = this.g;
            if (object != null) {
                object.clear();
            }
        }
    }

    /*
     * Exception decompiling
     */
    private String d(a var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [18[TRYBLOCK]], but top level block is 41[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i() {
        b b10 = this;
        Object object = com.baidu.location.h.l.i();
        if (object == null) {
            return;
        }
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        ((StringBuilder)comparable).append((String)object);
        object = File.separator;
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append("lcvif2.dat");
        object = ((StringBuilder)comparable).toString();
        comparable = new Comparable<StringBuilder>((String)object);
        boolean bl2 = ((File)comparable).exists();
        if (!bl2) return;
        try {
            Object object2 = "rw";
            object = new RandomAccessFile((File)comparable, (String)object2);
            long l10 = 0L;
            ((RandomAccessFile)object).seek(l10);
            long l11 = ((RandomAccessFile)object).readLong();
            long l12 = System.currentTimeMillis() - l11;
            l11 = 60000L;
            long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
            if (l13 > 0) {
                ((RandomAccessFile)object).close();
                ((File)comparable).delete();
                return;
            }
            ((RandomAccessFile)object).readInt();
            int n10 = 0;
            while (true) {
                int n11;
                int n12;
                if (n10 >= (n12 = 3)) {
                    ((RandomAccessFile)object).close();
                    return;
                }
                l12 = ((RandomAccessFile)object).readLong();
                int n13 = ((RandomAccessFile)object).readInt();
                int n14 = ((RandomAccessFile)object).readInt();
                int n15 = ((RandomAccessFile)object).readInt();
                long l14 = ((RandomAccessFile)object).readLong();
                int n16 = ((RandomAccessFile)object).readInt();
                char c10 = n16 == (n11 = 1) ? (char)'g' : '\u0000';
                l13 = 2;
                if (n16 == l13) {
                    l13 = 99;
                    c10 = (char)l13;
                }
                if ((l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) != false) {
                    int n17 = -1;
                    int n18 = n11;
                    n11 = 0;
                    a a10 = new a(n15, l14, n13, n14, 0, c10, n17);
                    a10.g = l12;
                    boolean bl3 = a10.b();
                    if (bl3) {
                        b10.j = n18;
                        object2 = b10.g;
                        object2.add(a10);
                    }
                }
                ++n10;
                l10 = 0L;
            }
        }
        catch (Exception exception) {
            ((File)comparable).delete();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        int n10;
        int n11;
        int n12;
        long l10;
        RandomAccessFile randomAccessFile;
        Object object;
        Object object2;
        Object object3 = this.g;
        if (object3 == null && (object2 = this.f) == null) {
            return;
        }
        if (object3 == null && (object3 = this.f) != null) {
            object3 = new LinkedList();
            this.g = object3;
            object2 = this.f;
            object3.add(object2);
        }
        if ((object3 = com.baidu.location.h.l.i()) == null) {
            return;
        }
        object2 = this.g;
        if (object2 == null) return;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object3);
        object3 = File.separator;
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append("lcvif2.dat");
        object3 = ((StringBuilder)object2).toString();
        object2 = new File((String)object3);
        object3 = this.g;
        int n13 = object3.size();
        try {
            boolean bl2 = ((File)object2).exists();
            if (bl2) {
                ((File)object2).delete();
            }
            ((File)object2).createNewFile();
            object = "rw";
            randomAccessFile = new RandomAccessFile((File)object2, (String)object);
            l10 = 0L;
            randomAccessFile.seek(l10);
            object2 = this.g;
            n12 = n13 + -1;
            object2 = object2.get(n12);
            object2 = (a)object2;
            long l11 = ((a)object2).g;
            randomAccessFile.writeLong(l11);
            randomAccessFile.writeInt(n13);
            n11 = 0;
            object2 = null;
            n12 = 0;
        }
        catch (Exception exception) {
            return;
        }
        while (true) {
            int n14 = 3 - n13;
            n10 = 2;
            if (n12 >= n14) break;
            randomAccessFile.writeLong(l10);
            n14 = -1;
            randomAccessFile.writeInt(n14);
            randomAccessFile.writeInt(n14);
            randomAccessFile.writeInt(n14);
            long l12 = -1;
            randomAccessFile.writeLong(l12);
            randomAccessFile.writeInt(n10);
            ++n12;
            continue;
            break;
        }
        while (true) {
            if (n11 >= n13) {
                randomAccessFile.close();
                return;
            }
            object = this.g;
            object = object.get(n11);
            object = (a)object;
            l10 = ((a)object).g;
            randomAccessFile.writeLong(l10);
            object = this.g;
            object = object.get(n11);
            object = (a)object;
            int n15 = ((a)object).c;
            randomAccessFile.writeInt(n15);
            object = this.g;
            object = object.get(n11);
            object = (a)object;
            n15 = ((a)object).d;
            randomAccessFile.writeInt(n15);
            object = this.g;
            object = object.get(n11);
            object = (a)object;
            n15 = ((a)object).a;
            randomAccessFile.writeInt(n15);
            object = this.g;
            object = object.get(n11);
            object = (a)object;
            l10 = ((a)object).b;
            randomAccessFile.writeLong(l10);
            object = this.g;
            object = object.get(n11);
            object = (a)object;
            n15 = ((a)object).i;
            int n16 = 103;
            if (n15 == n16) {
                n15 = 1;
                randomAccessFile.writeInt(n15);
            } else {
                object = this.g;
                object = object.get(n11);
                object = (a)object;
                n15 = ((a)object).i;
                n16 = 99;
                if (n15 == n16) {
                    randomAccessFile.writeInt(n10);
                } else {
                    n15 = 3;
                    randomAccessFile.writeInt(n15);
                }
            }
            ++n11;
        }
    }

    private void k() {
        boolean bl2;
        int n10;
        int n11;
        a a10 = this.l();
        if (a10 != null) {
            this.c(a10);
        }
        if (!((n11 = Build.VERSION.SDK_INT) > (n10 = 28) || a10 != null && (bl2 = a10.b()))) {
            a10 = this.d;
            try {
                a10 = a10.getCellLocation();
            }
            catch (Throwable throwable) {
                bl2 = false;
                a10 = null;
            }
            if (a10 != null) {
                this.a((CellLocation)a10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a l() {
        Object object = Build.VERSION.SDK_INT;
        int n10 = (Integer)object;
        Object object2 = null;
        int n11 = 17;
        if (n10 < n11) {
            return null;
        }
        try {
            object = this.d;
            a = n10 = object.getSimState();
            object = this.d;
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
                boolean bl4 = ((a)object4).b();
                if (!bl4) {
                    bl2 = false;
                    object4 = null;
                } else if (bl3 && object3 != null) {
                    ((a)object3).l = object = ((a)object4).j();
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

    public String a(a object) {
        boolean bl2;
        int n10;
        int n11;
        Object object2;
        String string2;
        block9: {
            string2 = "&nc=";
            object2 = "";
            object = this.d((a)object);
            n11 = Build.VERSION.SDK_INT;
            Integer n12 = n11;
            n11 = n12;
            if (object == null) break block9;
            boolean bl3 = ((String)object).equals(object2);
            if (bl3) break block9;
            try {
                n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                if (n10 != 0) break block9;
                return object;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        if (n11 >= (n10 = 17)) {
            return object;
        }
        object2 = object;
        if (object2 != null && (bl2 = ((String)object2).equals(string2))) {
            return null;
        }
        return object2;
    }

    public String b(a object) {
        int n10;
        Object object2;
        int n11;
        StringBuffer stringBuffer;
        CharSequence charSequence;
        block33: {
            double d10;
            Object object3;
            charSequence = "|";
            stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            n11 = ((a)object).i;
            stringBuffer.append((char)n11);
            Object object4 = Locale.CHINA;
            object2 = new Object[5];
            object2[0] = object3 = Integer.valueOf(((a)object).c);
            object3 = ((a)object).d;
            int n12 = 1;
            object2[n12] = object3;
            object3 = ((a)object).a;
            int n13 = 2;
            object2[n13] = object3;
            long l10 = ((a)object).b;
            object2[3] = object3 = Long.valueOf(l10);
            int n14 = ((a)object).h;
            object3 = n14;
            int n15 = 4;
            object2[n15] = object3;
            object3 = "&cl=%d|%d|%d|%d&cl_s=%d";
            object4 = String.format((Locale)object4, (String)object3, object2);
            stringBuffer.append((String)object4);
            n11 = ((a)object).e;
            int n16 = -1 >>> 1;
            if (n11 < n16 && (n11 = ((a)object).f) < n16) {
                object3 = Locale.CHINA;
                Object[] objectArray = new Object[n13];
                d10 = n11;
                double d11 = 14400.0;
                objectArray[0] = object4 = Double.valueOf(d10 / d11);
                n11 = ((a)object).e;
                d10 = (double)n11 / d11;
                objectArray[n12] = object4 = Double.valueOf(d10);
                object4 = String.format((Locale)object3, "&cdmall=%.6f|%.6f", objectArray);
                stringBuffer.append((String)object4);
            }
            stringBuffer.append("&cl_t=");
            long l11 = ((a)object).g;
            stringBuffer.append(l11);
            stringBuffer.append("&clp=");
            n11 = ((a)object).k;
            stringBuffer.append(n11);
            object4 = ((a)object).m;
            if (object4 != null) {
                stringBuffer.append("&clnrs=");
                object4 = ((a)object).m;
                stringBuffer.append((String)object4);
            }
            if ((n11 = Build.VERSION.SDK_INT) >= (n14 = 28) && (n11 = ((a)object).j) != n16) {
                object4 = "&cl_cs=";
                stringBuffer.append((String)object4);
                n11 = ((a)object).j;
                stringBuffer.append(n11);
            }
            object4 = this.g;
            if (object4 == null) break block33;
            n11 = object4.size();
            if (n11 <= 0) break block33;
            object4 = this.g;
            n11 = object4.size();
            object2 = "&clt=";
            stringBuffer.append((String)object2);
            object2 = null;
            for (n16 = 0; n16 < n11; ++n16) {
                block36: {
                    block35: {
                        block34: {
                            try {
                                object3 = this.g;
                            }
                            catch (Exception exception) {}
                            object3 = object3.get(n16);
                            object3 = (a)object3;
                            if (object3 == null) continue;
                            n12 = ((a)object3).c;
                            n13 = ((a)object).c;
                            if (n12 == n13) break block34;
                            stringBuffer.append(n12);
                        }
                        stringBuffer.append((String)charSequence);
                        n12 = ((a)object3).d;
                        n13 = ((a)object).d;
                        if (n12 == n13) break block35;
                        stringBuffer.append(n12);
                    }
                    stringBuffer.append((String)charSequence);
                    n12 = ((a)object3).a;
                    n13 = ((a)object).a;
                    if (n12 == n13) break block36;
                    stringBuffer.append(n12);
                }
                stringBuffer.append((String)charSequence);
                l11 = ((a)object3).b;
                l10 = ((a)object).b;
                n15 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                if (n15 != 0) {
                    stringBuffer.append(l11);
                }
                stringBuffer.append((String)charSequence);
                l11 = System.currentTimeMillis();
                l10 = ((a)object3).g;
                l11 -= l10;
                l10 = 1000L;
                d10 = 4.94E-321;
                l11 /= l10;
                stringBuffer.append(l11);
                object3 = ";";
                stringBuffer.append((String)object3);
                continue;
                break;
            }
        }
        if ((n10 = a) > (n11 = 100)) {
            a = 0;
        }
        n10 = b << 8;
        n11 = a + n10;
        charSequence = new StringBuilder();
        object2 = "&cs=";
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuffer.append((String)charSequence);
        object = ((a)object).l;
        if (object != null) {
            stringBuffer.append((String)object);
        }
        return stringBuffer.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        synchronized (this) {
            boolean bl2;
            block8: {
                block9: {
                    boolean bl3 = this.i;
                    bl2 = true;
                    if (bl3 == bl2) {
                        return;
                    }
                    bl3 = com.baidu.location.f.isServing;
                    if (!bl3) {
                        return;
                    }
                    Object object = com.baidu.location.f.getServiceContext();
                    Object object2 = "phone";
                    object = object.getSystemService(object2);
                    object = (TelephonyManager)object;
                    this.d = object;
                    object = new LinkedList();
                    this.g = object;
                    object = new b$b(this);
                    this.h = object;
                    this.i();
                    object = this.d;
                    if (object == null || (object2 = this.h) == null) break block9;
                    int n10 = Build.VERSION.SDK_INT;
                    int n11 = 29;
                    if (n10 >= n11) break block8;
                    n10 = 1280;
                    try {
                        object.listen((PhoneStateListener)object2, n10);
                        break block8;
                    }
                    catch (Exception exception) {}
                }
                return;
            }
            this.i = bl2;
            return;
        }
    }

    public void c() {
        synchronized (this) {
            Object object;
            b$b b$b;
            boolean bl2;
            block12: {
                block11: {
                    bl2 = this.i;
                    if (bl2) break block11;
                    return;
                }
                b$b = this.h;
                if (b$b == null) break block12;
                object = this.d;
                if (object == null) break block12;
                object.listen((PhoneStateListener)b$b, 0);
            }
            bl2 = false;
            b$b = null;
            this.h = null;
            this.d = null;
            object = this.g;
            object.clear();
            this.g = null;
            this.j();
            this.i = false;
            return;
        }
    }

    public boolean d() {
        return this.j;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int e() {
        TelephonyManager telephonyManager = this.d;
        int n10 = 0;
        if (telephonyManager == null) {
            return 0;
        }
        try {
            return telephonyManager.getNetworkType();
        }
        catch (Exception exception) {
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public a f() {
        a a10;
        a a11;
        a a12;
        int n10;
        int n11;
        a a13;
        block7: {
            long l10;
            long l11;
            TelephonyManager telephonyManager;
            a a14;
            a a15 = this.e;
            a13 = null;
            if (a15 != null && (n11 = a15.a()) != 0 && (n11 = (int)((a14 = this.e).b() ? 1 : 0)) != 0 || (telephonyManager = this.d) == null) break block7;
            try {
                this.k();
                n11 = Build.VERSION.SDK_INT;
                n10 = 29;
                if (n11 < n10) break block7;
                l11 = System.currentTimeMillis();
                l10 = this.m;
            }
            catch (Exception exception) {}
            long l12 = (l11 -= l10) - (l10 = 30000L);
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 <= 0) break block7;
            this.m = l11 = System.currentTimeMillis();
            b$a b$a = this.l;
            if (b$a == null) {
                b$a b$a2;
                this.l = b$a2 = new b$a(this, null);
            }
            TelephonyManager telephonyManager2 = this.d;
            Context context = com.baidu.location.f.getServiceContext();
            Executor executor = context.getMainExecutor();
            b$a b$a3 = this.l;
            telephonyManager2.requestCellInfoUpdate(executor, (TelephonyManager.CellInfoCallback)b$a3);
        }
        if ((a12 = this.e) != null && (n11 = (int)(a12.e() ? 1 : 0)) != 0) {
            a a16;
            this.f = null;
            a13 = this.e;
            this.f = a16 = new a(a13);
        }
        if ((a11 = this.e) != null && (n11 = (int)(a11.d() ? 1 : 0)) != 0 && (a10 = this.f) != null) {
            a13 = this.e;
            n10 = a13.i;
            int n12 = 103;
            if (n10 == n12) {
                a13.d = n10 = a10.d;
                a13.c = n11 = a10.c;
            }
        }
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String g() {
        Object object;
        int n10 = -1;
        try {
            object = this.d;
            if (object != null) {
                n10 = object.getSimState();
            }
        }
        catch (Exception exception) {}
        object = new StringBuilder();
        ((StringBuilder)object).append("&sim=");
        ((StringBuilder)object).append(n10);
        return ((StringBuilder)object).toString();
    }

    public int h() {
        return 0;
    }
}

