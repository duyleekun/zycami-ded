/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.location.Location
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.NetworkInfo$State
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Process
 *  android.provider.Settings$Secure
 *  android.provider.Settings$System
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.baidu.location.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.c.d;
import com.baidu.location.f;
import com.baidu.location.f.a;
import com.baidu.location.f.h;
import com.baidu.location.h.b;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Locale;

public class l {
    public static int A = 0;
    public static float B = 1.1f;
    public static float C = 2.2f;
    public static float D = 2.3f;
    public static float E = 3.8f;
    public static int F = 3;
    public static int G = 10;
    public static int H = 2;
    public static int I = 7;
    public static int J = 20;
    public static int K = 70;
    public static int L = 120;
    public static float M = 2.0f;
    public static float N = 10.0f;
    public static float O = 50.0f;
    public static float P = 200.0f;
    public static int Q = 16;
    public static int R = 32;
    public static float S = 0.9f;
    public static int T = 10000;
    public static float U = 0.5f;
    public static float V = 0.0f;
    public static float W = 0.1f;
    public static int X = 30;
    public static int Y = 100;
    public static int Z = 0;
    public static boolean a = false;
    public static boolean aA = false;
    public static int aB = 16;
    public static float aC = 0.75f;
    public static double aD = (double)-0.1f;
    public static int aE = 0;
    public static int aF = 1;
    private static String aG = "http://loc.map.baidu.com/sdk.php";
    private static String aH = "http://loc.map.baidu.com/user_err.php";
    private static String aI = "http://loc.map.baidu.com/oqur.php";
    private static String aJ = "https://loc.map.baidu.com/tcu.php";
    private static String aK = "http://loc.map.baidu.com/rtbu.php";
    private static String aL = "http://loc.map.baidu.com/iofd.php";
    private static String aM = "http://loc.map.baidu.com/wloc";
    public static int aa = 0;
    public static int ab = 0;
    public static int ac = 420000;
    public static boolean ad = true;
    public static boolean ae = true;
    public static int af = 20;
    public static int ag = 300;
    public static int ah = 1000;
    public static int ai = Integer.MAX_VALUE;
    public static long aj = 900000L;
    public static long ak = 420000L;
    public static long al = 180000L;
    public static long am = 0L;
    public static long an = 15L;
    public static long ao = 300000L;
    public static int ap = 1000;
    public static int aq = 0;
    public static int ar = 30000;
    public static int as = 30000;
    public static float at = 10.0f;
    public static float au = 6.0f;
    public static float av = 10.0f;
    public static int aw = 60;
    public static int ax = 70;
    public static int ay = 6;
    public static String az;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    public static String e = "https://loc.map.baidu.com/sdk_ep.php";
    public static String f = "https://loc.map.baidu.com/sdk.php";
    public static String g = "no";
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static double n = 500.0;
    public static boolean o = false;
    public static String p = "gcj02";
    public static String q = "";
    public static boolean r = true;
    public static int s = 3;
    public static double t = 0.0;
    public static double u = 0.0;
    public static double v = 0.0;
    public static double w = 0.0;
    public static int x = 0;
    public static byte[] y;
    public static boolean z = false;

    public static int a(Context context, String string2) {
        int n10;
        int n11;
        block6: {
            block5: {
                int n12;
                n11 = 1;
                try {
                    n12 = Process.myPid();
                }
                catch (Exception exception) {}
                int n13 = Process.myUid();
                n10 = context.checkPermission(string2, n12, n13);
                if (n10 == 0) break block5;
                n10 = 0;
                context = null;
                break block6;
            }
            n10 = n11;
        }
        if (n10 == 0) {
            return 0;
        }
        return n11;
    }

    public static int a(String string2, String string3, String string4) {
        String string5;
        int n10;
        int n11 = -1 << -1;
        if (string2 != null && (n10 = string2.equals(string5 = "")) == 0) {
            int n12;
            n10 = string2.indexOf(string3);
            if (n10 == (n12 = -1)) {
                return n11;
            }
            int n13 = string3.length();
            if ((n13 = string2.indexOf(string4, n10 += n13)) == n12) {
                return n11;
            }
            if ((string2 = string2.substring(n10, n13)) != null && (n13 = (int)(string2.equals(string5) ? 1 : 0)) == 0) {
                try {
                    return Integer.parseInt(string2);
                }
                catch (NumberFormatException numberFormatException) {}
            }
        }
        return n11;
    }

    public static String a() {
        Comparable<Calendar> comparable = Calendar.getInstance();
        int n10 = 5;
        int n11 = comparable.get(n10);
        int n12 = 1;
        int n13 = comparable.get(n12);
        int n14 = 2;
        int n15 = comparable.get(n14) + n12;
        int n16 = comparable.get(11);
        int n17 = comparable.get(12);
        int n18 = comparable.get(13);
        Locale locale = Locale.CHINA;
        Object[] objectArray = new Object[6];
        Integer n19 = n13;
        objectArray[0] = n19;
        n19 = n15;
        objectArray[n12] = n19;
        Integer n20 = n11;
        objectArray[n14] = n20;
        n20 = n16;
        objectArray[3] = n20;
        n20 = n17;
        objectArray[4] = n20;
        comparable = n18;
        objectArray[n10] = comparable;
        return String.format(locale, "%d-%02d-%02d %02d:%02d:%02d", objectArray);
    }

    public static String a(a a10, h h10, Location location, String string2, int n10) {
        return com.baidu.location.h.l.a(a10, h10, location, string2, n10, false);
    }

    /*
     * Unable to fully structure code
     */
    public static String a(a var0, h var1_1, Location var2_2, String var3_3, int var4_4, boolean var5_5) {
        block22: {
            block23: {
                var7_7 = 2048;
                var6_6 = new StringBuffer(var7_7);
                if (var0 != null && (var8_8 = com.baidu.location.f.b.a().b((a)var0)) != null) {
                    var6_6.append(var8_8);
                }
                if (var1_1 != null) {
                    var9_9 = var4_4 == 0 ? (var5_5 != 0 ? var1_1.b() : var1_1.c()) : var1_1.d();
                    if (var9_9 != null) {
                        var6_6.append(var9_9);
                    }
                }
                if (var2_2 != null && (var9_9 = (var5_5 = com.baidu.location.h.l.d) != 0 && var4_4 != 0 ? com.baidu.location.f.f.c(var2_2) : com.baidu.location.f.f.b(var2_2)) != null) {
                    var6_6.append(var9_9);
                }
                var5_5 = 0;
                var9_9 = null;
                var7_7 = 1;
                if (var4_4 == 0) {
                    var5_5 = var7_7;
                }
                if ((var10_10 = com.baidu.location.h.b.a().a((boolean)var5_5)) != null) {
                    var6_6.append(var10_10);
                }
                if (var3_3 != null) {
                    var6_6.append((String)var3_3);
                }
                if ((var4_4 = (int)TextUtils.isEmpty((CharSequence)(var3_3 = com.baidu.location.c.d.a().d()))) == 0) {
                    var10_10 = "&bc=";
                    var6_6.append(var10_10);
                    var6_6.append((String)var3_3);
                }
                var3_3 = com.baidu.location.f.f.a().m();
                var6_6.append((String)var3_3);
                var3_3 = com.baidu.location.f.b.a();
                var0 = var3_3.a((a)var0);
                if (var0 != null) {
                    var11_11 = var0.length();
                    var4_4 = var6_6.length();
                    if ((var11_11 += var4_4) < (var4_4 = 2000)) {
                        var6_6.append((String)var0);
                    }
                }
                var0 = var6_6.toString();
                var11_11 = 3;
                if (var2_2 == null || var1_1 == null) ** GOTO lbl78
                var12_12 = var2_2.getSpeed();
                var4_4 = com.baidu.location.h.l.d;
                var5_5 = var1_1.i();
                var13_13 = var1_1.a();
                var14_14 = var1_1.j();
                var15_15 = com.baidu.location.h.l.au;
                var16_16 = var12_12 == var15_15 ? 0 : (var12_12 < var15_15 ? -1 : 1);
                if (var16_16 >= 0 || var4_4 != var7_7 && var4_4 != 0) ** GOTO lbl65
                var16_16 = com.baidu.location.h.l.aw;
                if (var5_5 >= var16_16 && var14_14 != var7_7) ** GOTO lbl65
                com.baidu.location.h.l.s = var7_7;
                break block22;
lbl65:
                // 2 sources

                if ((var14_14 = (cfr_temp_0 = var12_12 - (var17_17 = com.baidu.location.h.l.av)) == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1)) >= 0 || var4_4 != var7_7 && var4_4 != 0 && var4_4 != var11_11) ** GOTO lbl78
                var14_14 = com.baidu.location.h.l.ax;
                if (var5_5 < var14_14) break block23;
                var14_14 = com.baidu.location.h.l.ay;
                if (var13_13 <= var14_14) ** GOTO lbl78
            }
            var14_14 = 2;
            var17_17 = 2.8E-45f;
            try {
                com.baidu.location.h.l.s = var14_14;
                break block22;
lbl78:
                // 3 sources

                com.baidu.location.h.l.s = var11_11;
            }
            catch (Exception v0) {
                com.baidu.location.h.l.s = var11_11;
            }
        }
        return var0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(File comparable, String object) {
        int n10 = ((File)comparable).isFile();
        if (n10 == 0) {
            return null;
        }
        n10 = 1024;
        byte[] byArray = new byte[n10];
        try {
            object = MessageDigest.getInstance((String)object);
            FileInputStream fileInputStream = new FileInputStream((File)comparable);
            while (true) {
                int n11;
                comparable = null;
                int n12 = fileInputStream.read(byArray, 0, n10);
                if (n12 == (n11 = -1)) break;
                ((MessageDigest)object).update(byArray, 0, n12);
            }
            fileInputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        object = ((MessageDigest)object).digest();
        comparable = new Comparable<File>(1, (byte[])object);
        return ((BigInteger)comparable).toString(16);
    }

    public static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = q;
        stringBuilder.append(string3);
        stringBuilder.append(";");
        stringBuilder.append(string2);
        return Jni.en1(stringBuilder.toString());
    }

    public static String a(byte[] byArray, String string2, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12;
            int n13 = byArray[i10] & 0xFF;
            String string3 = Integer.toHexString(n13);
            if (bl2) {
                string3 = string3.toUpperCase();
            }
            if ((n12 = string3.length()) == (n11 = 1)) {
                String string4 = "0";
                stringBuilder.append(string4);
            }
            stringBuilder.append(string3);
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static String a(byte[] byArray, boolean bl2) {
        Object object = "MD5";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            RuntimeException runtimeException = new RuntimeException(noSuchAlgorithmException);
            throw runtimeException;
        }
        ((MessageDigest)object).reset();
        ((MessageDigest)object).update(byArray);
        byArray = ((MessageDigest)object).digest();
        object = "";
        return com.baidu.location.h.l.a(byArray, (String)object, bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(Context context) {
        if ((context = (ConnectivityManager)context.getSystemService("connectivity")) != null) {
            NetworkInfo[] networkInfoArray = null;
            try {
                networkInfoArray = context.getAllNetworkInfo();
            }
            catch (Exception exception) {}
            if (networkInfoArray != null) {
                int n10;
                context = null;
                for (int i10 = 0; i10 < (n10 = networkInfoArray.length); ++i10) {
                    NetworkInfo.State state;
                    NetworkInfo.State state2 = networkInfoArray[i10].getState();
                    if (state2 != (state = NetworkInfo.State.CONNECTED)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(BDLocation bDLocation) {
        int n10;
        int n11 = bDLocation.getLocType();
        return n11 > (n10 = 100) && n11 < (n10 = 200) || n11 == (n10 = 62);
    }

    public static int b(Context context) {
        int n10;
        context = context.getContentResolver();
        String string2 = "airplane_mode_on";
        try {
            n10 = Settings.System.getInt((ContentResolver)context, (String)string2, (int)0);
        }
        catch (Exception exception) {
            n10 = 2;
        }
        return n10;
    }

    public static boolean b() {
        return false;
    }

    public static boolean b(Context object, String string2) {
        object = object.getPackageManager();
        int n10 = 128;
        object = object.getInstalledApplications(n10).iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            String string3 = ((ApplicationInfo)object.next()).packageName;
            n10 = (int)(TextUtils.equals((CharSequence)string3, (CharSequence)string2) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public static boolean b(String object, String string2, String object2) {
        Object object3 = "RSA";
        try {
            object3 = KeyFactory.getInstance((String)object3);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        object2 = ((String)object2).getBytes();
        object2 = Base64.decode((byte[])object2, (int)0);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec((byte[])object2);
        object2 = ((KeyFactory)object3).generatePublic(x509EncodedKeySpec);
        object3 = "SHA1WithRSA";
        object3 = Signature.getInstance((String)object3);
        ((Signature)object3).initVerify((PublicKey)object2);
        object = ((String)object).getBytes();
        ((Signature)object3).update((byte[])object);
        object = string2.getBytes();
        object = Base64.decode((byte[])object, (int)0);
        return ((Signature)object3).verify((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int c(Context context) {
        String string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = -1;
        int n12 = 19;
        if (n10 < n12) return -2;
        try {
            context = context.getContentResolver();
            string2 = "location_mode";
        }
        catch (Exception exception) {
            return n11;
        }
        return Settings.Secure.getInt((ContentResolver)context, (String)string2, (int)n11);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String c() {
        block26: {
            var0 = NetworkInterface.getNetworkInterfaces();
            block23: while (true) {
                var1_1 = var0.hasMoreElements();
                if (!var1_1) break block26;
                var2_2 = var0.nextElement();
                ** try [egrp 3[TRYBLOCK] [3 : 22->26)] { 
lbl11:
                // 2 sources

                var2_2 = var2_2.getInetAddresses();
                do {
                    var3_3 = var2_2.hasMoreElements();
                    if (var3_3 == 0) continue block23;
                    var4_4 = var2_2.nextElement();
                    var4_4 = (InetAddress)var4_4;
                    ** try [egrp 8[TRYBLOCK] [8 : 58->63)] { 
lbl21:
                    // 1 sources

                } while ((var5_5 = var4_4.isLoopbackAddress()) != 0 || (var5_5 = var4_4 instanceof Inet4Address) == 0);
                break;
            }
            try {
                var0 = ((InetAddress)var4_4).getAddress();
                var2_2 = "";
                var3_3 = 0;
                var4_4 = null;
            }
lbl62:
            // 20 sources

            catch (Exception v0) {}
            while (true) {
                block27: {
                    var5_5 = ((Object)var0).length;
                    if (var3_3 >= var5_5) break;
                    var5_5 = var0[var3_3] & 255;
                    var6_6 = Integer.toHexString(var5_5);
                    var7_7 = var6_6.length();
                    var8_8 = '\u0001';
                    if (var7_7 != var8_8) break block27;
                    var9_9 = new StringBuilder();
                    var8_8 = '0';
                    var9_9.append(var8_8);
                    var9_9.append(var6_6);
                    var6_6 = var9_9.toString();
                }
                var9_9 = new StringBuilder();
                var9_9.append((String)var2_2);
                var9_9.append(var6_6);
                var2_2 = var9_9.toString();
                ++var3_3;
                continue;
                break;
            }
            return var2_2;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    public static String d() {
        block17: {
            var0 = "";
            var1_1 = NetworkInterface.getNetworkInterfaces();
            block14: while (true) {
                var2_2 = var1_1.hasMoreElements();
                if (!var2_2) break block17;
                var3_3 = var1_1.nextElement();
                ** try [egrp 3[TRYBLOCK] [7, 6 : 25->29)] { 
lbl12:
                // 2 sources

                var3_3 = var3_3.getInetAddresses();
                while (true) {
                    var4_4 = var3_3.hasMoreElements();
                    if (!var4_4) continue block14;
                    var5_5 = var3_3.nextElement();
                    var5_5 = (InetAddress)var5_5;
                    ** try [egrp 8[TRYBLOCK] [17, 16 : 63->68)] { 
lbl22:
                    // 1 sources

                    var6_6 = var5_5.isLoopbackAddress();
                    if (var6_6 || !(var6_6 = var5_5 instanceof Inet6Address)) continue;
                    var7_7 = ((InetAddress)var5_5).getHostAddress();
                    if (var7_7 == null) continue;
                    var7_7 = ((InetAddress)var5_5).getHostAddress();
                    var8_8 = "fe80:";
                    var6_6 = var7_7.startsWith(var8_8);
                    if (!var6_6) break block14;
                    continue;
                    break;
                }
                break;
            }
            try {
                var0 = ((InetAddress)var5_5).getHostAddress();
            }
lbl39:
            // 26 sources

            catch (Throwable | SocketException v0) {
                ** continue;
            }
        }
lbl37:
        // 2 sources

        return var0;
    }

    public static boolean d(Context context) {
        int n10;
        block10: {
            n10 = 1;
            float f10 = Float.MIN_VALUE;
            if (context != null) {
                float f11;
                int n11;
                block9: {
                    int n12;
                    int n13;
                    String string2 = "android.permission.ACCESS_COARSE_LOCATION";
                    try {
                        n11 = context.checkCallingOrSelfPermission(string2);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        n11 = 0;
                        string2 = null;
                        f11 = 0.0f;
                    }
                    if (n11 != 0) {
                        n11 = 0;
                        string2 = null;
                        f11 = 0.0f;
                    } else {
                        n11 = n10;
                        f11 = f10;
                    }
                    if (n11 != 0 && (n13 = Build.VERSION.SDK_INT) >= (n12 = 23)) {
                        String string3;
                        try {
                            context = context.getContentResolver();
                            string3 = "location_mode";
                        }
                        catch (Exception exception) {}
                        int n14 = Settings.Secure.getInt((ContentResolver)context, (String)string3, (int)n10);
                        if (n14 != 0) break block9;
                        n10 = 0;
                        f10 = 0.0f;
                        break block10;
                    }
                }
                n10 = n11;
                f10 = f11;
            }
        }
        return n10 != 0;
    }

    public static String e() {
        return aG;
    }

    public static String e(Context context) {
        int n10 = com.baidu.location.h.l.a(context, "android.permission.ACCESS_COARSE_LOCATION");
        int n11 = com.baidu.location.h.l.a(context, "android.permission.ACCESS_FINE_LOCATION");
        int n12 = com.baidu.location.h.l.a(context, "android.permission.READ_PHONE_STATE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&per=");
        stringBuilder.append(n10);
        String string2 = "|";
        stringBuilder.append(string2);
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append(n12);
        return stringBuilder.toString();
    }

    public static String f() {
        return aJ;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String f(Context object) {
        int n10 = -1;
        if (object != null) {
            String string2 = "connectivity";
            try {
                boolean bl2;
                object = object.getSystemService(string2);
                object = (ConnectivityManager)object;
                object = object.getActiveNetworkInfo();
                if (object != null && (bl2 = object.isAvailable())) {
                    n10 = object.getType();
                }
            }
            catch (Throwable throwable) {}
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("&netc=");
        ((StringBuilder)object).append(n10);
        return ((StringBuilder)object).toString();
    }

    public static String g() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String h() {
        Object object;
        Object object2;
        Object object3;
        String string2;
        int n10;
        int n11;
        block21: {
            boolean bl2;
            block20: {
                n11 = Build.VERSION.SDK_INT;
                n10 = 28;
                string2 = null;
                if (n11 <= n10) {
                    object3 = Environment.getExternalStorageState();
                    String string3 = "mounted";
                    bl2 = ((String)object3).equals(string3);
                    if (!bl2) break block20;
                    object3 = Environment.getExternalStorageDirectory();
                    try {
                        object3 = ((File)object3).getPath();
                        break block21;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            bl2 = false;
            object3 = null;
        }
        if (object3 == null && n11 > n10 && (object2 = com.baidu.location.f.getServiceContext()) != null) {
            try {
                object2 = com.baidu.location.f.getServiceContext();
            }
            catch (Exception exception) {
                return null;
            }
            object = Environment.DIRECTORY_MOVIES;
            object2 = object2.getExternalFilesDir((String)object);
            object3 = ((File)object2).getAbsolutePath();
        }
        if (object3 == null) return object3;
        try {
            object2 = new StringBuilder();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string2;
        }
        ((StringBuilder)object2).append((String)object3);
        object = "/baidu/tempdata";
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        object = new File((String)object2);
        n11 = (int)(((File)object).exists() ? 1 : 0);
        if (n11 != 0) return object3;
        ((File)object).mkdirs();
        return object3;
    }

    public static String i() {
        String string2 = com.baidu.location.h.l.h();
        if (string2 == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("/baidu/tempdata");
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String j() {
        Context context;
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            context = com.baidu.location.f.getServiceContext();
        }
        catch (Exception exception) {
            return null;
        }
        File file = context.getFilesDir();
        stringBuilder.append(file);
        String string2 = File.separator;
        stringBuilder.append(string2);
        String string3 = "lldt";
        stringBuilder.append(string3);
        String string4 = stringBuilder.toString();
        File file2 = new File(string4);
        boolean bl2 = file2.exists();
        if (bl2) return file2.getAbsolutePath();
        file2.mkdirs();
        return file2.getAbsolutePath();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String k() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Context context = com.baidu.location.f.getServiceContext();
            File file = context.getFilesDir();
            stringBuilder.append(file);
            String string2 = File.separator;
            stringBuilder.append(string2);
            String string3 = "/baidu/tempdata";
            stringBuilder.append(string3);
            String string4 = stringBuilder.toString();
            File file2 = new File(string4);
            boolean bl2 = file2.exists();
            if (!bl2) {
                file2.mkdirs();
            }
            file2 = com.baidu.location.f.getServiceContext();
            file2 = file2.getFilesDir();
            return file2.getPath();
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String l() {
        Comparable<File> comparable;
        Object object;
        Object object2;
        String string2;
        block16: {
            string2 = "/baidu/tempdata";
            try {
                object2 = new StringBuilder();
                object = com.baidu.location.f.getServiceContext();
            }
            catch (Exception exception) {
                return null;
            }
            object = object.getFilesDir();
            ((StringBuilder)object2).append(object);
            object = File.separator;
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            comparable = new Comparable<File>((String)object2);
            boolean bl2 = ((File)comparable).exists();
            if (bl2) break block16;
            ((File)comparable).mkdirs();
        }
        comparable = new Comparable<File>();
        object2 = com.baidu.location.f.getServiceContext();
        object2 = object2.getFilesDir();
        object2 = ((File)object2).getPath();
        ((StringBuilder)comparable).append((String)object2);
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append(string2);
        return ((StringBuilder)comparable).toString();
    }

    public static boolean m() {
        int n10;
        String string2 = "/sbin/";
        Object object = "/vendor/bin/";
        CharSequence charSequence = "/su/bin/";
        String[] stringArray = new String[]{"/system/bin/", "/system/xbin/", "/system/sbin/", string2, object, charSequence};
        for (int i10 = 0; i10 < (n10 = 6); ++i10) {
            string2 = stringArray[i10];
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            string2 = "su";
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            object = new File(string2);
            n10 = (int)(((File)object).exists() ? 1 : 0);
            if (n10 == 0) continue;
            try {
                n10 = (int)(((File)object).canExecute() ? 1 : 0);
                if (n10 == 0) continue;
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                break;
            }
        }
        return false;
    }
}

