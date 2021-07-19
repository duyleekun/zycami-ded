/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.mob.commons;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.MobProductCollector;
import com.mob.commons.a;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b$1;
import com.mob.commons.b$3;
import com.mob.commons.b$4;
import com.mob.commons.b$a;
import com.mob.commons.b.d;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.k;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class b {
    private static HashMap a;
    private static boolean b;
    private static volatile boolean c;
    private static int d;
    private static Object e;
    private static Object f;
    private static HashMap g;
    private static HashMap h;
    private static Object i;
    private static long j;

    static {
        Object object = new HashMap();
        a = object;
        b = false;
        c = false;
        d = 0;
        e = object = new Object();
        f = object = new Object();
        h = null;
        i = object = new Object();
        j = 0L;
    }

    public static long A() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("xmar", l10) * 1000L;
    }

    public static boolean B() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "bi";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static long C() {
        Long l10 = 30;
        return (Long)com.mob.commons.b.a("bigap", l10);
    }

    public static long D() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("pl", l10);
    }

    public static long E() {
        Long l10 = 86400L;
        return (Long)com.mob.commons.b.a("plgap", l10);
    }

    public static long F() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("le", l10);
    }

    public static long G() {
        Long l10 = 86400L;
        return (Long)com.mob.commons.b.a("legap", l10);
    }

    public static long H() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("sd", l10);
    }

    public static boolean I() {
        return com.mob.commons.b.a(480000L);
    }

    public static boolean J() {
        return com.mob.commons.b.a(480000L);
    }

    public static long K() {
        Integer n10 = 2;
        return (long)((Integer)com.mob.commons.b.a("deup", n10)).intValue() * 1000L;
    }

    public static long L() {
        Integer n10 = 2592000;
        return (long)((Integer)com.mob.commons.b.a("digap", n10)).intValue() * 1000L;
    }

    public static long M() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("pe", l10);
    }

    public static long N() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("ac", l10);
    }

    public static long O() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("sys", l10);
    }

    public static long P() {
        Long l10 = 2592000L;
        return (Long)com.mob.commons.b.a("sysgap", l10);
    }

    public static long Q() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("arpl", l10);
    }

    public static long R() {
        Long l10 = 604800L;
        return (Long)com.mob.commons.b.a("arplgap", l10);
    }

    public static boolean S() {
        long l10;
        Long l11 = 0L;
        String string2 = "gm";
        long l12 = l11 = (Long)com.mob.commons.b.a(string2, l11);
        long l13 = l12 - (l10 = 1L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            l11 = null;
        }
        return (boolean)object;
    }

    public static long T() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("aa", l10);
    }

    public static long U() {
        Long l10 = 86400L;
        return (Long)com.mob.commons.b.a("aagap", l10);
    }

    public static long V() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("rs", l10);
    }

    public static long W() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("at", l10);
    }

    public static boolean X() {
        boolean bl2 = false;
        Integer n10 = 0;
        String string2 = "lno";
        int n11 = n10 = (Integer)com.mob.commons.b.a(string2, n10);
        if (n11 > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static long Y() {
        Long l10 = 900L;
        return (Long)com.mob.commons.b.a("atgap", l10);
    }

    public static boolean Z() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "to";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static long a() {
        long l10;
        long l11 = 0L;
        Object object = g;
        String string2 = "serverTime";
        object = ((HashMap)object).get(string2);
        object = String.valueOf(object);
        object = Long.valueOf((String)object);
        try {
            l10 = (Long)object;
        }
        catch (Throwable throwable) {
            l10 = l11;
        }
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return System.currentTimeMillis();
        }
        l11 = com.mob.commons.b.av();
        return l10 + l11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object a(String object, Object object2) {
        int n10;
        Object object3;
        block19: {
            Object object4;
            int n11;
            float f10;
            float f11;
            int n12;
            Object object5 = f;
            synchronized (object5) {
                boolean bl2;
                object3 = g;
                n12 = 0;
                f11 = 0.0f;
                n10 = 1;
                f10 = Float.MIN_VALUE;
                if (object3 != null && (n11 = ((HashMap)object3).isEmpty()) == 0) {
                    n11 = 0;
                    object3 = null;
                } else {
                    n11 = n10;
                }
                n11 = com.mob.commons.b.c(n11 != 0);
                if (n11 == 0 && ((bl2 = ((String)(object4 = "to")).equals(object)) || (bl2 = ((String)(object4 = "conn")).equals(object)))) {
                    object2 = "to";
                    boolean bl3 = ((String)object2).equals(object);
                    if (!bl3) {
                        n12 = n10;
                        f11 = f10;
                    }
                    return n12;
                }
            }
            object4 = b.class;
            synchronized (object4) {
                block17: {
                    int n13;
                    block18: {
                        object5 = g;
                        if (object5 == null && n11 == 0) {
                            n13 = com.mob.commons.b.ax();
                            if (n13 == 0 && (n13 = b) == 0) {
                                b = n10;
                                object5 = new Object();
                                ((Thread)object5).start();
                            }
                            com.mob.commons.a.a(n10);
                        }
                        object5 = g;
                        n11 = 0;
                        object3 = null;
                        if (object5 == null) break block17;
                        object5 = "to";
                        n13 = ((String)object5).equals(object);
                        if (n13 == 0) break block18;
                        object5 = g;
                        object3 = ((HashMap)object5).get(object);
                        break block19;
                    }
                    object5 = g;
                    Object object6 = "to";
                    object5 = ((HashMap)object5).get(object6);
                    object6 = 0;
                    object5 = ResHelper.forceCast(object5, object6);
                    n13 = (Integer)(object5 = (Integer)object5);
                    if (n10 != n13) {
                        object5 = g;
                        object6 = "conn";
                        object5 = ((HashMap)object5).get(object6);
                        object6 = 0;
                        object5 = ResHelper.forceCast(object5, object6);
                        n13 = (Integer)(object5 = (Integer)object5);
                        if (n10 == n13) {
                            int n14;
                            object5 = g;
                            object6 = "cl";
                            object5 = ((HashMap)object5).get(object6);
                            if ((object5 = (ArrayList)object5) != null && (n14 = ((ArrayList)object5).size()) > 0) {
                                object5 = ((ArrayList)object5).iterator();
                                while ((n14 = (int)(object5.hasNext() ? 1 : 0)) != 0) {
                                    object6 = object5.next();
                                    n14 = (int)(((String)(object6 = (String)object6)).equals(object) ? 1 : 0);
                                    if (n14 == 0) continue;
                                    n12 = n10;
                                    f11 = f10;
                                }
                            }
                            if (n12 != 0) {
                                object5 = g;
                                object5 = ((HashMap)object5).get(object);
                                object3 = object5;
                            }
                            n10 = n12;
                            f10 = f11;
                        }
                    }
                    break block19;
                }
                com.mob.commons.a.a(0);
            }
        }
        if (n10 == 0) return com.mob.commons.b.b((String)object, object2);
        return ResHelper.forceCast(object3, object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(int n10) {
        int n11 = d;
        if (n11 >= n10) return;
        Object object = e;
        synchronized (object) {
            d = n10;
            return;
        }
    }

    public static void a(long l10, boolean bl2) {
        long l11;
        long l12;
        long l13;
        j = l10;
        if (!bl2 && (l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
            bl2 = deviceHelper.amIOnForeground();
        }
        if (bl2) {
            com.mob.commons.i.d(l10);
        }
    }

    public static void a(b$a b$a) {
        boolean bl2 = b;
        if (!bl2) {
            b = bl2 = true;
            b$1 b$1 = new b$1(b$a);
            b$1.start();
        }
    }

    private static void a(Object object) {
        Object object2 = new HashMap();
        String string2 = "list";
        ((HashMap)object2).put(string2, object);
        object = MobSDK.getContext();
        string2 = ".mcli";
        object = ResHelper.getDataCacheFile((Context)object, string2);
        string2 = "1234567890abcdfi";
        Hashon hashon = new Hashon();
        object2 = hashon.fromHashMap((HashMap)object2);
        object2 = Data.AES128Encode(string2, (String)object2);
        object = ((File)object).getPath();
        try {
            ResHelper.saveObjectToFile((String)object, object2);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
    }

    public static /* synthetic */ void a(String string2) {
        com.mob.commons.b.b(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(HashMap object) {
        Object object2 = i;
        synchronized (object2) {
            Object object3 = new HashMap();
            h = object3;
            if (object != null) {
                ((HashMap)object3).putAll(object);
            }
            object = MobLog.getInstance();
            object3 = "notify onlineLock";
            Object[] objectArray = null;
            objectArray = new Object[]{};
            ((NLog)object).d(object3, objectArray);
            object = i;
            object.notifyAll();
            return;
        }
    }

    public static void a(HashMap object, boolean bl2) {
        int n10 = c;
        if (n10 == 0 && object != null) {
            int n11;
            Object object2 = ((HashMap)object).get("to");
            Integer n12 = 0;
            n10 = (Integer)(object2 = (Integer)ResHelper.forceCast(object2, n12));
            if (n10 != (n11 = 1)) {
                object2 = ((HashMap)object).get("conn");
                Integer n13 = 0;
                n10 = (Integer)(object2 = (Integer)ResHelper.forceCast(object2, n13));
                if (n10 != 0) {
                    c = n11;
                    object2 = "fnc";
                    n10 = (int)(TextUtils.isEmpty((CharSequence)(object = (String)((HashMap)object).get(object2))) ? 1 : 0);
                    if (n10 != 0 && !bl2) {
                        c = false;
                        return;
                    }
                    bl2 = TextUtils.isEmpty((CharSequence)object);
                    if (bl2) {
                        return;
                    }
                    b$4 b$4 = new b$4((String)object);
                    b$4.start();
                }
            }
        }
    }

    private static boolean a(long l10) {
        return false;
    }

    public static /* synthetic */ boolean a(boolean bl2) {
        b = bl2;
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static String aA() {
        block268: {
            block250: {
                block260: {
                    block269: {
                        block270: {
                            block267: {
                                block261: {
                                    block265: {
                                        block266: {
                                            block264: {
                                                block262: {
                                                    block263: {
                                                        block259: {
                                                            block258: {
                                                                block257: {
                                                                    block256: {
                                                                        block255: {
                                                                            block254: {
                                                                                block253: {
                                                                                    block271: {
                                                                                        block252: {
                                                                                            block251: {
                                                                                                var0 = "timestamp";
                                                                                                var1_6 = "utf-8";
                                                                                                var2_7 = ":";
                                                                                                var3_8 = com.mob.commons.b.I();
                                                                                                if (var3_8 != 0) break block250;
                                                                                                var3_8 = com.mob.commons.b.aC();
                                                                                                if (var3_8 == 0) break block250;
                                                                                                var4_9 = MobSDK.getContext();
                                                                                                var4_9 = DeviceHelper.getInstance((Context)var4_9);
                                                                                                var5_10 = new NetworkHelper();
                                                                                                var6_11 = var4_9.getPackageName();
                                                                                                var7_12 = MobSDK.getAppkey();
                                                                                                var8_13 = TextUtils.isEmpty((CharSequence)var7_12);
                                                                                                var9_14 = 2;
                                                                                                var8_13 = var8_13 != 0 ? 1 : var9_14;
                                                                                                com.mob.commons.b.a(var8_13);
                                                                                                var10_15 = new ArrayList();
                                                                                                var12_17 = "appkey";
                                                                                                var11_16 = new KVPair((String)var12_17, var7_12);
                                                                                                var10_15.add(var11_16);
                                                                                                var12_17 = "plat";
                                                                                                var13_18 = var4_9.getPlatformCode();
                                                                                                var14_19 = String.valueOf(var13_18);
                                                                                                var11_16 = new KVPair((String)var12_17, var14_19);
                                                                                                var10_15.add(var11_16);
                                                                                                var12_17 = "apppkg";
                                                                                                var11_16 = new KVPair((String)var12_17, var6_11);
                                                                                                var10_15.add(var11_16);
                                                                                                var12_17 = "appver";
                                                                                                var14_19 = var4_9.getAppVersionName();
                                                                                                var11_16 = new KVPair((String)var12_17, var14_19);
                                                                                                var10_15.add(var11_16);
                                                                                                var12_17 = "networktype";
                                                                                                var14_19 = var4_9.getDetailNetworkTypeForStatic();
                                                                                                var11_16 = new KVPair((String)var12_17, var14_19);
                                                                                                var10_15.add(var11_16);
                                                                                                var11_16 = DeviceAuthorizer.authorizeForOnce();
                                                                                                var15_20 = TextUtils.isEmpty((CharSequence)var11_16);
                                                                                                if (var15_20) break block251;
                                                                                                var14_19 = "duid";
                                                                                                var12_17 = new KVPair((String)var14_19, var11_16);
                                                                                                var10_15.add(var12_17);
                                                                                            }
                                                                                            var12_17 = "ags";
                                                                                            var13_18 = 17;
                                                                                            var14_19 = k.a(var13_18);
                                                                                            var13_18 = (int)var4_9.isPackageInstalled((String)var14_19);
                                                                                            var13_18 = var13_18 != 0 ? 1 : -1;
                                                                                            var14_19 = String.valueOf(var13_18);
                                                                                            var11_16 = new KVPair((String)var12_17, var14_19);
                                                                                            var10_15.add(var11_16);
                                                                                            var16_21 = System.currentTimeMillis();
                                                                                            var18_22 = "ts";
                                                                                            var19_23 = String.valueOf(var16_21);
                                                                                            var14_19 = new KVPair((String)var18_22, var19_23);
                                                                                            var10_15.add(var14_19);
                                                                                            var20_24 = 18;
                                                                                            var14_19 = k.a(var20_24);
                                                                                            var14_19 = var4_9.getDefaultResolvePkg((String)var14_19);
                                                                                            var19_23 = k.a(var20_24);
                                                                                            var19_23 = var4_9.getResolvePkgs((String)var19_23);
                                                                                            var18_22 = new StringBuilder();
                                                                                            var18_22.append((String)var14_19);
                                                                                            var14_19 = "|";
                                                                                            var18_22.append((String)var14_19);
                                                                                            if (var19_23 == null) break block252;
                                                                                            var21_25 = var19_23.size();
                                                                                            if (var21_25 <= 0) break block252;
                                                                                            var22_26 = var19_23.size();
                                                                                            var14_19 = null;
                                                                                            for (var13_18 = 0; var13_18 < var22_26; ++var13_18) {
                                                                                                var23_27 /* !! */  = var19_23.get(var13_18);
                                                                                                var24_28 = var23_27 /* !! */ ;
                                                                                                var24_28 = (String)var23_27 /* !! */ ;
                                                                                                var18_22.append((String)var24_28);
                                                                                                var25_29 = var22_26 + -1;
                                                                                                if (var13_18 >= var25_29) continue;
                                                                                                var24_28 = ",";
                                                                                                var18_22.append((String)var24_28);
                                                                                            }
                                                                                            break block271;
                                                                                        }
                                                                                        var24_28 = "null";
                                                                                        var18_22.append((String)var24_28);
                                                                                    }
                                                                                    var24_28 = new StringBuilder();
                                                                                    var24_28.append((String)var7_12);
                                                                                    var24_28.append((String)var2_7);
                                                                                    var24_28.append((String)var6_11);
                                                                                    var24_28.append((String)var2_7);
                                                                                    var24_28.append(var16_21);
                                                                                    var24_28 = var24_28.toString();
                                                                                    var24_28 = Data.rawMD5((String)var24_28);
                                                                                    var19_23 = var18_22.toString();
                                                                                    var24_28 = Data.AES128Encode((byte[])var24_28, (String)var19_23);
                                                                                    var24_28 = Base64.encodeToString((byte[])var24_28, (int)var9_14);
                                                                                    var11_16 = "as";
                                                                                    var19_23 = new KVPair((String)var11_16, var24_28);
                                                                                    var10_15.add(var19_23);
                                                                                    var24_28 = com.mob.commons.a.e();
                                                                                    if (var24_28 == null) ** GOTO lbl189
                                                                                    var11_16 = "isAgreePp";
                                                                                    var24_28 = String.valueOf(var24_28);
                                                                                    var19_23 = new KVPair((String)var11_16, var24_28);
                                                                                    var10_15.add(var19_23);
lbl189:
                                                                                    // 2 sources

                                                                                    if ((var24_28 = com.mob.commons.a.f()) == null) ** GOTO lbl198
                                                                                    var11_16 = "isAgreePd";
                                                                                    var24_28 = String.valueOf(var24_28);
                                                                                    var19_23 = new KVPair((String)var11_16, var24_28);
                                                                                    var10_15.add(var19_23);
lbl198:
                                                                                    // 2 sources

                                                                                    var25_29 = com.mob.commons.a.g();
                                                                                    var11_16 = "ppVersion";
                                                                                    var24_28 = String.valueOf(var25_29);
                                                                                    var19_23 = new KVPair((String)var11_16, var24_28);
                                                                                    var10_15.add(var19_23);
                                                                                    var19_23 = "v6";
                                                                                    var26_30 = MobSDK.checkV6();
                                                                                    var22_26 = var26_30 != 0 ? 1 : -1;
                                                                                    var11_16 = String.valueOf(var22_26);
                                                                                    var24_28 = new KVPair((String)var19_23, var11_16);
                                                                                    var10_15.add(var24_28);
                                                                                    var19_23 = "uc";
                                                                                    var26_30 = var4_9.checkUA();
                                                                                    if (var26_30 != 0) {
                                                                                        var26_30 = 1;
                                                                                        break block253;
                                                                                    }
                                                                                    var26_30 = 0;
                                                                                    var11_16 = null;
                                                                                }
                                                                                var11_16 = String.valueOf(var26_30);
                                                                                var24_28 = new KVPair((String)var19_23, var11_16);
                                                                                var10_15.add(var24_28);
                                                                                var19_23 = "ud";
                                                                                var26_30 = (int)var4_9.usbEnable();
                                                                                if (var26_30 != 0) {
                                                                                    var26_30 = 1;
                                                                                    break block254;
                                                                                }
                                                                                var26_30 = 0;
                                                                                var11_16 = null;
                                                                            }
                                                                            var11_16 = String.valueOf(var26_30);
                                                                            var24_28 = new KVPair((String)var19_23, var11_16);
                                                                            var10_15.add(var24_28);
                                                                            var19_23 = "dv";
                                                                            var26_30 = (int)var4_9.devEnable();
                                                                            if (var26_30 != 0) {
                                                                                var26_30 = 1;
                                                                                break block255;
                                                                            }
                                                                            var26_30 = 0;
                                                                            var11_16 = null;
                                                                        }
                                                                        var11_16 = String.valueOf(var26_30);
                                                                        var24_28 = new KVPair((String)var19_23, var11_16);
                                                                        var10_15.add(var24_28);
                                                                        var19_23 = "vp";
                                                                        var26_30 = (int)var4_9.vpn();
                                                                        if (var26_30 != 0) {
                                                                            var26_30 = 1;
                                                                            break block256;
                                                                        }
                                                                        var26_30 = 0;
                                                                        var11_16 = null;
                                                                    }
                                                                    var11_16 = String.valueOf(var26_30);
                                                                    var24_28 = new KVPair((String)var19_23, var11_16);
                                                                    var10_15.add(var24_28);
                                                                    var19_23 = "wp";
                                                                    var26_30 = (int)var4_9.isWifiProxy();
                                                                    if (var26_30 != 0) {
                                                                        var26_30 = 1;
                                                                        break block257;
                                                                    }
                                                                    var26_30 = 0;
                                                                    var11_16 = null;
                                                                }
                                                                var11_16 = String.valueOf(var26_30);
                                                                var24_28 = new KVPair((String)var19_23, var11_16);
                                                                var10_15.add(var24_28);
                                                                var19_23 = "rt";
                                                                var26_30 = (int)var4_9.isRooted();
                                                                if (var26_30 != 0) {
                                                                    var26_30 = 1;
                                                                    break block258;
                                                                }
                                                                var26_30 = 0;
                                                                var11_16 = null;
                                                            }
                                                            var11_16 = String.valueOf(var26_30);
                                                            var24_28 = new KVPair((String)var19_23, var11_16);
                                                            var10_15.add(var24_28);
                                                            var19_23 = "xp";
                                                            var26_30 = (int)var4_9.cx();
                                                            if (var26_30 != 0) {
                                                                var26_30 = 1;
                                                                break block259;
                                                            }
                                                            var26_30 = 0;
                                                            var11_16 = null;
                                                        }
                                                        var11_16 = String.valueOf(var26_30);
                                                        var24_28 = new KVPair((String)var19_23, var11_16);
                                                        var10_15.add(var24_28);
                                                        var19_23 = "ad";
                                                        var3_8 = var4_9.debugable();
                                                        var27_31 = var3_8 != 0 ? 1 : 0;
                                                        var4_9 = String.valueOf(var27_31);
                                                        var24_28 = new KVPair((String)var19_23, var4_9);
                                                        var10_15.add(var24_28);
                                                        var24_28 = new NetworkHelper$NetworkTimeOut();
                                                        var3_8 = 30000;
                                                        var24_28.readTimout = var3_8;
                                                        var3_8 = 10000;
                                                        var24_28.connectionTimeout = var3_8;
                                                        var4_9 = new ArrayList();
                                                        var11_16 = "User-Identity";
                                                        var12_17 = MobProductCollector.getUserIdentity();
                                                        var19_23 = new KVPair((String)var11_16, var12_17);
                                                        var4_9.add(var19_23);
                                                        var26_30 = 68;
                                                        var11_16 = k.a(var26_30);
                                                        var12_17 = MobSDK.getContext();
                                                        var12_17 = com.mob.commons.b.d.d((Context)var12_17);
                                                        var19_23 = new KVPair((String)var11_16, var12_17);
                                                        var4_9.add(var19_23);
                                                        var19_23 = com.mob.commons.b.aD();
                                                        var24_28 = var5_10.httpGet((String)var19_23, (ArrayList)var10_15, (ArrayList)var4_9, (NetworkHelper$NetworkTimeOut)var24_28);
                                                        var4_9 = new Hashon();
                                                        var5_10 = var4_9.fromJson((String)var24_28);
                                                        if (var5_10 == null) {
                                                            return null;
                                                        }
                                                        var10_15 = "status";
                                                        var10_15 = var5_10.get(var10_15);
                                                        var10_15 = String.valueOf(var10_15);
                                                        var19_23 = "200";
                                                        var8_13 = (int)var19_23.equals(var10_15);
                                                        var19_23 = "response is illegal: ";
                                                        if (var8_13 == 0) break block260;
                                                        var10_15 = "sr";
                                                        var10_15 = var5_10.get(var10_15);
                                                        var10_15 = ResHelper.forceCast(var10_15);
                                                        var10_15 = (String)var10_15;
                                                        var11_16 = new StringBuilder();
                                                        var11_16.append((String)var7_12);
                                                        var11_16.append((String)var2_7);
                                                        var11_16.append((String)var6_11);
                                                        var11_16.append((String)var2_7);
                                                        var6_11 = var5_10.get(var0);
                                                        var11_16.append(var6_11);
                                                        var6_11 = var11_16.toString();
                                                        var6_11 = var6_11.getBytes((String)var1_6);
                                                        var6_11 = Data.rawMD5((byte[])var6_11);
                                                        if (var10_15 == null) break block261;
                                                        var10_15 = Base64.decode((String)var10_15, (int)var9_14);
                                                        var10_15 = Data.AES128Decode((byte[])var6_11, (byte[])var10_15);
                                                        var7_12 = new String((byte[])var10_15, (String)var1_6);
                                                        var7_12 = var4_9.fromJson((String)var7_12);
                                                        if (var7_12 == null) break block261;
                                                        var10_15 = "cdata";
                                                        var10_15 = var7_12.get(var10_15);
                                                        var10_15 = ResHelper.forceCast(var10_15);
                                                        var10_15 = (HashMap)var10_15;
                                                        var11_16 = "http://";
                                                        var12_17 = "path";
                                                        var14_19 = "httpport";
                                                        var28_32 = "host";
                                                        if (var10_15 == null) break block262;
                                                        var18_22 = var10_15.get(var28_32);
                                                        var18_22 = ResHelper.forceCast(var18_22);
                                                        var18_22 = (String)var18_22;
                                                        var29_33 = var10_15.get(var14_19);
                                                        var23_27 /* !! */  = var24_28;
                                                        var21_25 = 0;
                                                        var24_28 = 0;
                                                        var24_28 = ResHelper.forceCast(var29_33, var24_28);
                                                        var24_28 = (Integer)var24_28;
                                                        var25_29 = var24_28.intValue();
                                                        var10_15 = var10_15.get(var12_17);
                                                        var10_15 = ResHelper.forceCast(var10_15);
                                                        var10_15 = (String)var10_15;
                                                        if (var18_22 == null || var25_29 == 0 || var10_15 == null) break block263;
                                                        var29_33 = new StringBuilder();
                                                        var29_33.append((String)var11_16);
                                                        var29_33.append((String)var18_22);
                                                        var29_33.append((String)var2_7);
                                                        var29_33.append(var25_29);
                                                        var29_33.append((String)var10_15);
                                                        var24_28 = var29_33.toString();
                                                        com.mob.commons.i.e((String)var24_28);
                                                        break block264;
                                                    }
                                                    var25_29 = 0;
                                                    var24_28 = null;
                                                    com.mob.commons.i.e(null);
                                                    break block264;
                                                }
                                                var23_27 /* !! */  = var24_28;
                                                var25_29 = 0;
                                                var24_28 = null;
                                                com.mob.commons.i.e(null);
                                            }
                                            var24_28 = "cconf";
                                            var24_28 = var7_12.get(var24_28);
                                            var24_28 = ResHelper.forceCast(var24_28);
                                            var24_28 = (HashMap)var24_28;
                                            if (var24_28 == null) break block265;
                                            var7_12 = var24_28.get(var28_32);
                                            var7_12 = ResHelper.forceCast(var7_12);
                                            var7_12 = (String)var7_12;
                                            var10_15 = var24_28.get(var14_19);
                                            var9_14 = 0;
                                            var29_33 = null;
                                            var29_33 = 0;
                                            var10_15 = ResHelper.forceCast(var10_15, var29_33);
                                            var10_15 = (Integer)var10_15;
                                            var8_13 = var10_15.intValue();
                                            var24_28 = var24_28.get(var12_17);
                                            var24_28 = ResHelper.forceCast(var24_28);
                                            var24_28 = (String)var24_28;
                                            if (var7_12 == null || var8_13 == 0 || var24_28 == null) break block266;
                                            var29_33 = new StringBuilder();
                                            var29_33.append((String)var11_16);
                                            var29_33.append((String)var7_12);
                                            var29_33.append((String)var2_7);
                                            var29_33.append(var8_13);
                                            var29_33.append((String)var24_28);
                                            var2_7 = var29_33.toString();
                                            com.mob.commons.i.f((String)var2_7);
                                            break block267;
                                        }
                                        var2_7 = null;
                                        try {
                                            com.mob.commons.i.f(null);
                                            break block267;
                                        }
                                        catch (Throwable var0_1) {
                                            var1_6 = null;
                                            break block268;
                                        }
                                    }
                                    var2_7 = null;
                                    com.mob.commons.i.f(null);
                                    break block267;
                                    catch (Throwable var0_2) {
                                        var1_6 = null;
                                        break block268;
                                    }
                                }
                                var23_27 /* !! */  = var24_28;
                            }
                            var2_7 = "sc";
                            var2_7 = var5_10.get(var2_7);
                            var2_7 = ResHelper.forceCast(var2_7);
                            var2_7 = (String)var2_7;
                            if (var2_7 == null) break block269;
                            var30_34 = 2;
                            var2_7 = Base64.decode((String)var2_7, (int)var30_34);
                            var2_7 = Data.AES128Decode((byte[])var6_11, (byte[])var2_7);
                            var24_28 = new String((byte[])var2_7, (String)var1_6);
                            var1_6 = var4_9.fromJson((String)var24_28);
                            if (var1_6 == null) break block270;
                            var2_7 = "illegalMacs";
                            var2_7 = var1_6.get(var2_7);
                            com.mob.commons.b.a(var2_7);
                            var0 = var5_10.get(var0);
                            var31_35 = 0L;
                            var2_7 = var31_35;
                            var0 = ResHelper.forceCast(var0, var2_7);
                            var0 = (Long)var0;
                            var31_35 = var0.longValue();
                            var0 = "deviceTime";
                            var33_36 = SystemClock.elapsedRealtime();
                            var5_10 = var33_36;
                            var1_6.put(var0, var5_10);
                            var0 = "serverTime";
                            var2_7 = var31_35;
                            var1_6.put(var0, var2_7);
                            return var4_9.fromHashMap((HashMap)var1_6);
                        }
                        var1_6 = new StringBuilder();
                        var1_6.append((String)var19_23);
                        var2_7 = var23_27 /* !! */ ;
                        var1_6.append((String)var23_27 /* !! */ );
                        var1_6 = var1_6.toString();
                        var0 = new Throwable((String)var1_6);
                        throw var0;
                    }
                    var2_7 = var23_27 /* !! */ ;
                    var1_6 = new StringBuilder();
                    var1_6.append((String)var19_23);
                    var1_6.append((String)var23_27 /* !! */ );
                    var1_6 = var1_6.toString();
                    var0 = new Throwable((String)var1_6);
                    throw var0;
                }
                var2_7 = var24_28;
                var1_6 = new StringBuilder();
                var1_6.append((String)var19_23);
                var1_6.append((String)var24_28);
                var1_6 = var1_6.toString();
                try {
                    var0 = new Throwable((String)var1_6);
                    throw var0;
                }
                catch (Throwable var0_3) {
                    var1_6 = null;
                }
            }
            return null;
        }
        var2_7 = MobLog.getInstance();
        var2_7.w((Throwable)var0_4);
        try {
            com.mob.commons.i.e(null);
            com.mob.commons.i.f(null);
        }
        catch (Throwable var0_5) {
            var2_7 = MobLog.getInstance();
            var2_7.d(var0_5);
        }
        return null;
    }

    private static void aB() {
        HashMap hashMap;
        g = hashMap = new HashMap();
        Integer n10 = 0;
        hashMap.put("conn", n10);
        g.put("in", n10);
        g.put("all", n10);
        hashMap = g;
        Number number = 2592000L;
        hashMap.put("aspa", number);
        g.put("un", n10);
        g.put("rt", n10);
        hashMap = g;
        Number number2 = 180;
        hashMap.put("rtsr", number2);
        g.put("ext", n10);
        g.put("bs", n10);
        hashMap = g;
        number2 = 86400;
        hashMap.put("bsgap", number2);
        g.put("di", n10);
        g.put("l", n10);
        g.put("lgap", number2);
        g.put("wi", n10);
        hashMap = g;
        number2 = 3600L;
        hashMap.put("wigap", number2);
        g.put("wl", n10);
        hashMap = g;
        Number number3 = 300;
        hashMap.put("wlsr", number3);
        hashMap = g;
        number3 = 7200;
        hashMap.put("wlgap", number3);
        g.put("adle", n10);
        hashMap = g;
        number3 = 3600;
        hashMap.put("rtgap", number3);
        g.put("p", n10);
        g.put("ol", n10);
        g.put("olgapl", number2);
        hashMap = g;
        number3 = 60;
        hashMap.put("olgaph", number3);
        g.put("xmar", n10);
        g.put("bi", n10);
        hashMap = g;
        number3 = 30;
        hashMap.put("bigap", number3);
        g.put("pl", n10);
        hashMap = g;
        number3 = 86400L;
        hashMap.put("plgap", number3);
        hashMap = g;
        Long l10 = 0L;
        hashMap.put("le", l10);
        g.put("legap", number3);
        g.put("sd", l10);
        hashMap = g;
        Integer n11 = 2;
        hashMap.put("deup", n11);
        g.put("digap", number);
        g.put("illegalMacs", null);
        g.put("pe", l10);
        g.put("pegap", number3);
        g.put("ac", l10);
        g.put("acgap", number3);
        g.put("sys", l10);
        g.put("sysgap", number);
        g.put("arpl", l10);
        hashMap = g;
        number = 604800L;
        hashMap.put("arplgap", number);
        g.put("mph", l10);
        g.put("aw", null);
        g.put("to", n10);
        g.put("gm", n10);
        hashMap = g;
        number = 900;
        hashMap.put("gmgap", number);
        g.put("aa", l10);
        g.put("aagap", number3);
        g.put("rs", l10);
        g.put("rsgap", number3);
        g.put("cl", null);
        g.put("at", l10);
        hashMap = g;
        number = 900L;
        hashMap.put("atgap", number);
        g.put("bt", l10);
        g.put("bts", l10);
        hashMap = g;
        number = 7200L;
        hashMap.put("btsgap", number);
        g.put("ppl", l10);
        g.put("lno", n10);
        g.put("dv", l10);
        g.put("dvch", number2);
        g.put("dvuh", number2);
        hashMap = g;
        number = 1;
        hashMap.put("cerr", number);
        g.put("serr", n10);
        g.put("strategyId", l10);
        g.put("apm", n10);
        hashMap = g;
        number = 300L;
        hashMap.put("apmhuh", number);
        g.put("apmauh", number);
        g.put("oid", n10);
    }

    private static boolean aC() {
        boolean bl2;
        block10: {
            block9: {
                Object object;
                bl2 = false;
                try {
                    object = MobSDK.getContext();
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().d(throwable);
                    return false;
                }
                object = DeviceHelper.getInstance((Context)object);
                object = ((DeviceHelper)object).getDetailNetworkTypeForStatic();
                String string2 = "wifi";
                boolean bl3 = string2.equals(object);
                if (bl3) break block9;
                string2 = "5g";
                bl3 = string2.equals(object);
                if (bl3) break block9;
                string2 = "4g";
                bl3 = string2.equals(object);
                if (bl3) break block9;
                string2 = "3g";
                bl3 = string2.equals(object);
                if (bl3) break block9;
                string2 = "2g";
                boolean bl4 = string2.equals(object);
                if (!bl4) break block10;
            }
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    private static String aD() {
        block6: {
            var0 = com.mob.commons.i.h();
            var0 = com.mob.commons.j.b((String)var0);
            return var0;
            ** finally { 
lbl7:
            // 1 sources

            break block6;
            catch (Throwable var1_2) {
                var0 = null;
            }
            var2_4 = MobLog.getInstance();
            var2_4.w((Throwable)var1_3);
        }
        var3_5 = TextUtils.isEmpty((CharSequence)var0);
        if (var3_5) {
            var0 = new StringBuilder();
            var1_3 = com.mob.commons.j.a();
            var0.append(var1_3);
            var1_3 = "/v5/gcf";
            var0.append(var1_3);
            var0 = var0.toString();
        }
        return var0;
    }

    private static void aE() {
        Object[] objectArray = null;
        Object object = new HashMap();
        Object object2 = "apm";
        int n10 = com.mob.commons.b.ai();
        Object[] objectArray2 = n10;
        ((HashMap)object).put(object2, objectArray2);
        object2 = "apmhuh";
        long l10 = com.mob.commons.b.aj();
        objectArray2 = l10;
        ((HashMap)object).put(object2, objectArray2);
        object2 = "apmauh";
        l10 = com.mob.commons.b.ak();
        objectArray2 = l10;
        ((HashMap)object).put(object2, objectArray2);
        object2 = new Hashon();
        object = ((Hashon)object2).fromHashMap((HashMap)object);
        object2 = "com.mob.mobapm.MobAPM";
        object2 = ReflectHelper.importClass((String)object2);
        objectArray2 = "setJson";
        int n11 = 1;
        Object object3 = new Object[n11];
        object3[0] = object;
        ReflectHelper.invokeStaticMethod((String)object2, (String)objectArray2, object3);
        object2 = MobLog.getInstance();
        objectArray2 = new StringBuilder();
        object3 = ">>>>> Has APM <<<<< conf: ";
        objectArray2.append((String)object3);
        objectArray2.append((String)object);
        object = objectArray2.toString();
        objectArray2 = new Object[]{};
        try {
            ((NLog)object2).d(object, objectArray2);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            objectArray = new Object[]{};
            object2 = ">>>>> No APM <<<<<";
            ((NLog)object).d(object2, objectArray);
        }
    }

    public static boolean aa() {
        String string2;
        Serializable serializable = g;
        if (serializable != null) {
            string2 = "to";
            serializable = ((HashMap)serializable).get(string2);
        } else {
            boolean bl2 = false;
            serializable = null;
        }
        boolean bl2 = false;
        string2 = null;
        Integer n10 = 0;
        serializable = (Integer)ResHelper.forceCast(serializable, n10);
        boolean bl3 = ((Integer)serializable).intValue();
        boolean bl4 = true;
        if (bl4 == bl3) {
            bl2 = bl4;
        }
        return bl2;
    }

    public static boolean ab() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "ppl";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static boolean ac() {
        Long l10 = 0L;
        long l11 = 1L;
        String string2 = "dv";
        long l12 = l10 = (Long)com.mob.commons.b.a(string2, l10);
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            l10 = null;
        }
        return (boolean)object;
    }

    public static long ad() {
        Long l10 = 3600L;
        return (Long)com.mob.commons.b.a("dvch", l10);
    }

    public static long ae() {
        Long l10 = 3600L;
        return (Long)com.mob.commons.b.a("dvuh", l10);
    }

    public static boolean af() {
        int n10 = 1;
        Integer n11 = n10;
        String string2 = "cerr";
        int n12 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public static boolean ag() {
        int n10;
        int n11 = 0;
        Integer n12 = 0;
        String string2 = "serr";
        int n13 = n12 = (Integer)com.mob.commons.b.a(string2, n12);
        if (n13 == (n10 = 1)) {
            n11 = n10;
        }
        return n11 != 0;
    }

    public static long ah() {
        Long l10 = 0L;
        return (Long)com.mob.commons.b.a("strategyId", l10);
    }

    public static int ai() {
        Integer n10 = 0;
        return (Integer)com.mob.commons.b.a("apm", n10);
    }

    public static long aj() {
        Long l10 = 300L;
        return (Long)com.mob.commons.b.a("apmhuh", l10);
    }

    public static long ak() {
        Long l10 = 300L;
        return (Long)com.mob.commons.b.a("apmauh", l10);
    }

    public static boolean al() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "oid";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static void am() {
        com.mob.commons.b.b(null);
    }

    public static void an() {
        boolean bl2 = com.mob.commons.b.az();
        if (!bl2) {
            return;
        }
        b$3 b$3 = new b$3();
        b$3.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HashMap ao() {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object = DeviceHelper.getInstance(MobSDK.getContext());
        Object object2 = k.a(41);
        Object object3 = MobSDK.getAppkey();
        hashMap.put(object2, object3);
        object2 = k.a(42);
        object3 = MobSDK.SDK_VERSION_CODE;
        hashMap.put(object2, object3);
        object2 = k.a(64);
        int n10 = 1;
        Object object4 = n10;
        hashMap.put(object2, object4);
        object2 = k.a(43);
        float f10 = 0.0f;
        object4 = DeviceAuthorizer.authorize(null);
        hashMap.put(object2, object4);
        object2 = k.a(44);
        object4 = MobSDK.getContext().getPackageName();
        hashMap.put(object2, object4);
        object2 = k.a(45);
        object4 = ((DeviceHelper)object).getAppVersion();
        hashMap.put(object2, object4);
        object2 = k.a(46);
        object4 = ((DeviceHelper)object).getIMEI();
        hashMap.put(object2, object4);
        object2 = k.a(47);
        object4 = ((DeviceHelper)object).getSerialno();
        hashMap.put(object2, object4);
        object2 = k.a(48);
        object4 = ((DeviceHelper)object).getMacAddress();
        hashMap.put(object2, object4);
        object2 = k.a(49);
        object4 = ((DeviceHelper)object).getCarrier();
        hashMap.put(object2, object4);
        object2 = k.a(50);
        object4 = ((DeviceHelper)object).getModel();
        hashMap.put(object2, object4);
        object2 = k.a(51);
        object4 = ((DeviceHelper)object).getManufacturer();
        hashMap.put(object2, object4);
        object2 = k.a(52);
        object4 = ((DeviceHelper)object).getNetworkType();
        hashMap.put(object2, object4);
        object2 = k.a(53);
        object4 = ((DeviceHelper)object).getOSVersionName();
        hashMap.put(object2, object4);
        object2 = k.a(54);
        object4 = ((DeviceHelper)object).getMIUIVersion();
        hashMap.put(object2, object4);
        object2 = k.a(55);
        int n11 = ((DeviceHelper)object).getOSVersionInt();
        object4 = n11;
        hashMap.put(object2, object4);
        int n12 = com.mob.commons.b.x();
        if (n12 != 0) {
            n12 = 0;
            object2 = ((DeviceHelper)object).getLocation(0, 0, n10 != 0);
            if (object2 != null) {
                object3 = k.a(56);
                f10 = object2.getAccuracy();
                object4 = Float.valueOf(f10);
                hashMap.put(object3, object4);
                object3 = k.a(57);
                object4 = object2.getLatitude();
                hashMap.put(object3, object4);
                n10 = 58;
                object3 = k.a(n10);
                double d10 = object2.getLongitude();
                object2 = d10;
                hashMap.put(object3, object2);
            }
        }
        object2 = k.a(59);
        long l10 = System.currentTimeMillis();
        object3 = l10;
        hashMap.put(object2, object3);
        object2 = k.a(60);
        object3 = ((DeviceHelper)object).getSignMD5();
        hashMap.put(object2, object3);
        object2 = k.a(61);
        n10 = ((DeviceHelper)object).cscreen();
        object3 = n10;
        hashMap.put(object2, object3);
        n12 = 62;
        try {
            object2 = k.a(n12);
            object3 = MobSDK.getContext();
            n10 = ((DeviceHelper)object).ih((Context)object3);
            object3 = n10;
            hashMap.put(object2, object3);
        }
        catch (Throwable throwable) {}
        object2 = k.a(63);
        object3 = ((DeviceHelper)object).amIOnForeground();
        hashMap.put(object2, object3);
        object2 = k.a(65);
        object3 = ((DeviceHelper)object).getAndroidID();
        hashMap.put(object2, object3);
        object2 = k.a(66);
        object = ((DeviceHelper)object).getIMSI();
        hashMap.put(object2, object);
        object = k.a(67);
        object2 = Build.BRAND;
        hashMap.put(object, object2);
        return hashMap;
    }

    public static Object ap() {
        return a;
    }

    public static /* synthetic */ boolean aq() {
        return com.mob.commons.b.ax();
    }

    public static /* synthetic */ void ar() {
        com.mob.commons.b.ay();
    }

    public static /* synthetic */ boolean as() {
        return com.mob.commons.b.az();
    }

    public static /* synthetic */ boolean at() {
        return b;
    }

    public static /* synthetic */ HashMap au() {
        return a;
    }

    private static long av() {
        long l10;
        long l11 = 0L;
        Object object = g;
        String string2 = "deviceTime";
        object = ((HashMap)object).get(string2);
        object = String.valueOf(object);
        object = Long.valueOf((String)object);
        try {
            l10 = (Long)object;
        }
        catch (Throwable throwable) {
            l10 = l11;
        }
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return l11;
        }
        return SystemClock.elapsedRealtime() - l10;
    }

    /*
     * Loose catch block
     */
    private static boolean aw() {
        boolean bl2;
        block14: {
            HashMap hashMap;
            block13: {
                bl2 = false;
                hashMap = null;
                String string2 = com.mob.commons.i.f();
                boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                if (bl3) break block13;
                Object object = new Hashon();
                try {
                    hashMap = ((Hashon)object).fromJson(string2);
                }
                catch (Throwable throwable) {
                    object = MobLog.getInstance();
                    ((NLog)object).d(throwable);
                }
            }
            if (hashMap != null) {
                boolean bl4 = hashMap.isEmpty();
                if (bl4) break block14;
                com.mob.commons.b.b(hashMap);
                com.mob.commons.b.a(hashMap, false);
                bl2 = true;
            }
        }
        return bl2;
        {
            catch (Throwable throwable) {
                MobLog.getInstance().d(throwable);
                return false;
            }
        }
    }

    private static boolean ax() {
        boolean bl2;
        Object object;
        String string2 = com.mob.commons.b.aA();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            object = new Hashon();
            object = ((Hashon)object).fromJson(string2);
        } else {
            bl3 = false;
            object = null;
        }
        if (object != null && !(bl2 = ((HashMap)object).isEmpty())) {
            com.mob.commons.i.d(string2);
            com.mob.commons.b.a((HashMap)object);
            com.mob.commons.b.b((HashMap)object);
            com.mob.commons.b.aE();
            boolean bl4 = true;
            com.mob.commons.b.a((HashMap)object, bl4);
            return bl4;
        }
        com.mob.commons.i.d(null);
        com.mob.commons.b.b(null);
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void ay() {
        var0 = 2;
        var2_1 = 1L;
        var4_2 = var0;
        var6_3 = var2_1;
        while (true) {
            var8_4 = 1000L * var6_3;
            try {
                Thread.sleep(var8_4);
                ** GOTO lbl15
            }
            catch (Throwable var10_5) {
                block12: {
                    try {
                        var11_6 = MobLog.getInstance();
                        var11_6.d(var10_5);
lbl15:
                        // 2 sources

                        var12_7 = com.mob.commons.b.aC();
                        if (var12_7 == 0) break block12;
                        var13_8 = 0L;
                        cfr_temp_0 = var4_2 - var13_8;
                        var15_9 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                        if (var15_9 /* !! */  <= 0) {
                            com.mob.commons.b.aE();
                            return;
                        }
                        var4_2 -= var2_1;
                    }
                    catch (Throwable var16_10) {
                        try {
                            var17_12 = MobLog.getInstance();
                            var17_12.d(var16_10);
                            return;
                        }
                        finally {
                            com.mob.commons.b.a(null);
                        }
                    }
                }
                var13_8 = 8;
                if (var12_7 == 0 && (var12_7 = (cfr_temp_1 = (var6_3 *= var0) - var13_8) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) < 0) {
                    var6_3 = var13_8;
                }
                if ((var12_7 = (int)((cfr_temp_2 = var6_3 - (var8_4 = 300L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) > 0) {
                    var6_3 = var13_8;
                }
                var12_7 = (int)com.mob.commons.b.ax();
                if (var12_7 != 0) return;
                if ((var12_7 = (int)com.mob.commons.b.I()) == 0) continue;
                return;
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean az() {
        Object object = e;
        synchronized (object) {
            boolean bl2 = d;
            boolean bl3 = true;
            if (bl2 != bl3) return false;
            return bl3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object b(String object, Object object2) {
        Object object3 = i;
        synchronized (object3) {
            Object object4 = h;
            if (object4 == null) {
                try {
                    object4 = MobLog.getInstance();
                    String string2 = "wait onlineLock";
                    Object[] objectArray = null;
                    objectArray = new Object[]{};
                    ((NLog)object4).d(string2, objectArray);
                    object4 = i;
                    long l10 = 600000L;
                    object4.wait(l10);
                }
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    nLog.d(throwable);
                }
            }
            if ((object4 = h) == null) {
                return object2;
            }
            object = ((HashMap)object4).get(object);
            return ResHelper.forceCast(object, object2);
        }
    }

    /*
     * Exception decompiling
     */
    private static void b(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 70[TRYBLOCK] [96 : 777->780)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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
    private static void b(HashMap hashMap) {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            boolean bl2;
            if (hashMap != null && !(bl2 = hashMap.isEmpty())) {
                g = hashMap;
            } else {
                boolean bl3;
                hashMap = g;
                if (hashMap == null || (bl3 = hashMap.isEmpty())) {
                    com.mob.commons.b.aB();
                }
            }
            return;
        }
    }

    public static boolean b() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "conn";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static /* synthetic */ boolean b(boolean bl2) {
        c = bl2;
        return bl2;
    }

    public static boolean c() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "rt";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    private static boolean c(boolean bl2) {
        long l10 = com.mob.commons.b.av();
        long l11 = 86400000L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl3 = true;
        l12 = l12 >= 0 ? (long)bl3 : (long)0;
        if (!bl2 && l12 == false) {
            return bl3;
        }
        boolean bl4 = com.mob.commons.b.aw();
        if (bl4) {
            if (bl2 || l12 != false) {
                bl2 = false;
                com.mob.commons.b.a(null);
            }
            com.mob.commons.a.a((int)(bl3 ? 1 : 0));
            return bl3;
        }
        return false;
    }

    public static int d() {
        Integer n10 = 180;
        return (Integer)com.mob.commons.b.a("rtsr", n10);
    }

    public static boolean e() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "in";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static boolean f() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "all";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static boolean g() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "un";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static long h() {
        Long l10 = 2592000L;
        return (Long)com.mob.commons.b.a("aspa", l10);
    }

    public static boolean i() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "di";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static boolean j() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "ext";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static boolean k() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "bs";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static int l() {
        Integer n10 = 86400;
        return (Integer)com.mob.commons.b.a("bsgap", n10);
    }

    public static boolean m() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "l";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static int n() {
        Integer n10 = 86400;
        return (Integer)com.mob.commons.b.a("lgap", n10);
    }

    public static boolean o() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "wi";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static int p() {
        Integer n10 = 3600;
        return (Integer)com.mob.commons.b.a("wigap", n10);
    }

    public static boolean q() {
        boolean bl2 = false;
        Integer n10 = 0;
        String string2 = "wl";
        int n11 = n10 = (Integer)com.mob.commons.b.a(string2, n10);
        if (n11 > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static long r() {
        Integer n10 = 300;
        return ((Integer)com.mob.commons.b.a("wlsr", n10)).intValue();
    }

    public static int s() {
        Integer n10 = 7200;
        return (Integer)com.mob.commons.b.a("wlgap", n10);
    }

    public static ArrayList t() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("SSID");
        arrayList.add("BSSID");
        arrayList.add("level");
        arrayList.add("frequency");
        arrayList.add("___curConn");
        return (ArrayList)com.mob.commons.b.a("wisc", arrayList);
    }

    public static long u() {
        Integer n10 = 0;
        long l10 = (long)((Integer)com.mob.commons.b.a("adle", n10)).intValue() * 1000L;
        return com.mob.commons.b.a() + l10;
    }

    public static long v() {
        Integer n10 = 3600;
        return (long)((Integer)com.mob.commons.b.a("rtgap", n10)).intValue() * 1000L;
    }

    public static boolean w() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "p";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static boolean x() {
        int n10 = 0;
        Integer n11 = 0;
        int n12 = 1;
        String string2 = "ol";
        int n13 = n11 = (Integer)com.mob.commons.b.a(string2, n11);
        if (n12 == n13) {
            n10 = n12;
        }
        return n10 != 0;
    }

    public static long y() {
        Long l10 = 3600L;
        return (Long)com.mob.commons.b.a("olgapl", l10);
    }

    public static long z() {
        Long l10 = 60;
        return (Long)com.mob.commons.b.a("olgaph", l10);
    }
}

