/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.StatFs
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.DisplayMetrics
 *  android.view.WindowManager
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.s.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import d.s.a.c$b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private static final String a = "MfpBuilder";
    public static final String b = "weibo_aid_value";

    public static void A(Context context) {
    }

    private static int B(byte[] byArray, int n10, int n11) {
        int n12 = byArray.length;
        if (n10 >= n12) {
            return -1;
        }
        return Math.min(byArray.length - n10, n11);
    }

    private static void a(String string2) {
    }

    private static void b(String string2) {
    }

    private static String c(byte[] byArray) {
        int n10;
        if (byArray != null && (n10 = byArray.length) != 0) {
            int n11;
            StringBuilder stringBuilder = new StringBuilder();
            int n12 = byArray.length;
            int n13 = 0;
            while (true) {
                Object object;
                n11 = 1;
                if (n13 >= n12) break;
                byte by2 = byArray[n13];
                Object object2 = new Object[n11];
                object2[0] = object = Byte.valueOf(by2);
                object = "%02X:";
                object2 = String.format((String)object, object2);
                stringBuilder.append((String)object2);
                ++n13;
            }
            int n14 = stringBuilder.length();
            if (n14 > 0) {
                n14 = stringBuilder.length() - n11;
                stringBuilder.deleteCharAt(n14);
            }
            return stringBuilder.toString();
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static String d(Context var0) {
        block49: {
            var1_1 = "batterycurrentcapacity";
            var2_2 = "";
            var3_3 = new JSONObject();
            var4_4 = c.s();
            {
                catch (JSONException v0) {
                    return var2_2;
                }
            }
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl15
            var6_7 = "os";
            var3_3.put(var6_7, (Object)var4_4);
lbl15:
            // 2 sources

            var4_4 = c.l(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl23
            var6_7 = "imei";
            var3_3.put(var6_7, (Object)var4_4);
lbl23:
            // 2 sources

            var4_4 = c.p(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl31
            var6_7 = "meid";
            var3_3.put(var6_7, (Object)var4_4);
lbl31:
            // 2 sources

            var4_4 = c.m(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl39
            var6_7 = "imsi";
            var3_3.put(var6_7, (Object)var4_4);
lbl39:
            // 2 sources

            var4_4 = c.n(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl47
            var6_7 = "mac";
            var3_3.put(var6_7, (Object)var4_4);
lbl47:
            // 2 sources

            var4_4 = c.k(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl55
            var6_7 = "iccid";
            var3_3.put(var6_7, (Object)var4_4);
lbl55:
            // 2 sources

            var4_4 = c.w();
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl63
            var6_7 = "serial";
            var3_3.put(var6_7, (Object)var4_4);
lbl63:
            // 2 sources

            var4_4 = c.f(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl71
            var6_7 = "androidid";
            var3_3.put(var6_7, (Object)var4_4);
lbl71:
            // 2 sources

            var4_4 = c.i();
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl79
            var6_7 = "cpu";
            var3_3.put(var6_7, (Object)var4_4);
lbl79:
            // 2 sources

            var4_4 = c.r();
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl87
            var6_7 = "model";
            var3_3.put(var6_7, (Object)var4_4);
lbl87:
            // 2 sources

            var4_4 = c.v();
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl95
            var6_7 = "sdcard";
            var3_3.put(var6_7, (Object)var4_4);
lbl95:
            // 2 sources

            var4_4 = c.u(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl103
            var6_7 = "resolution";
            var3_3.put(var6_7, (Object)var4_4);
lbl103:
            // 2 sources

            var4_4 = c.y(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl111
            var6_7 = "ssid";
            var3_3.put(var6_7, (Object)var4_4);
lbl111:
            // 2 sources

            var4_4 = c.z(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl119
            var6_7 = "bssid";
            var3_3.put(var6_7, (Object)var4_4);
lbl119:
            // 2 sources

            var4_4 = c.j();
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) ** GOTO lbl127
            var6_7 = "deviceName";
            var3_3.put(var6_7, (Object)var4_4);
lbl127:
            // 2 sources

            var4_4 = c.h(var0 /* !! */ );
            var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
            if (var5_6) break block49;
            var6_7 = "connecttype";
            var3_3.put(var6_7, (Object)var4_4);
        }
        try {
            var4_4 = c.e(var0 /* !! */ );
        }
        catch (Exception var4_5) {
            var4_5.printStackTrace();
            var4_4 = var2_2;
        }
        var5_6 = TextUtils.isEmpty((CharSequence)var4_4);
        if (var5_6) ** GOTO lbl150
        var6_7 = "ua";
        var3_3.put(var6_7, (Object)var4_4);
lbl150:
        // 2 sources

        var7_8 = c.g(var0 /* !! */ );
        var9_9 = "batterymaxcapacity";
        var10_10 = String.valueOf(var7_8);
        var3_3.put((String)var9_9, (Object)var10_10);
        var9_9 = String.valueOf(var7_8);
        var3_3.put(var1_1, var9_9);
        var11_11 = 0;
        var10_10 = null;
        var9_9 = new c$b(var0 /* !! */ , null);
        var0 /* !! */  = "batterycurrentvoltage";
        var11_11 = c$b.a((c$b)var9_9);
        var3_3.put((String)var0 /* !! */ , var11_11);
        var0 /* !! */  = "batterycurrenttemperature";
        var11_11 = c$b.b((c$b)var9_9);
        var3_3.put((String)var0 /* !! */ , var11_11);
        var12_12 = c$b.c((c$b)var9_9);
        var13_13 = var12_12;
        var7_8 *= var13_13;
        var12_12 = c$b.d((c$b)var9_9);
        var15_14 = var12_12;
        var7_8 /= var15_14;
        var3_3.put(var1_1, var7_8);
        return var3_3.toString();
    }

    private static String e(Context object) {
        String string2;
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object = object.getPackageName()));
        object = !bl3 && (bl2 = ((String)object).contains(string2 = "com.sina.weibo")) ? "weibo" : "ssosdk";
        string2 = Build.MANUFACTURER;
        stringBuilder.append(string2);
        stringBuilder.append("-");
        string2 = Build.MODEL;
        stringBuilder.append(string2);
        string2 = "__";
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        object = "1.0";
        string2 = "\\s+";
        String string3 = "_";
        object = ((String)object).replaceAll(string2, string3);
        try {
            stringBuilder.append((String)object);
        }
        catch (Exception exception) {
            object = "unknown";
            stringBuilder.append((String)object);
        }
        stringBuilder.append("__android__android");
        object = Build.VERSION.RELEASE;
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    private static String f(Context context) {
        String string2;
        try {
            context = context.getContentResolver();
            string2 = "android_id";
        }
        catch (Exception exception) {
            return "";
        }
        return Settings.Secure.getString((ContentResolver)context, (String)string2);
    }

    private static double g(Context object) {
        Object object2 = "com.android.internal.os.PowerProfile";
        int n10 = 1;
        Object object3 = Class.forName((String)object2);
        Object[] objectArray = new Class[n10];
        Class clazz = Context.class;
        objectArray[0] = clazz;
        object3 = ((Class)object3).getConstructor((Class<?>[])objectArray);
        objectArray = new Object[n10];
        objectArray[0] = object;
        try {
            object = ((Constructor)object3).newInstance(objectArray);
        }
        catch (Exception exception) {
            object = null;
        }
        try {
            object2 = Class.forName((String)object2);
            object3 = "getAveragePower";
        }
        catch (Exception exception) {
            return 0.0;
        }
        objectArray = new Class[n10];
        clazz = String.class;
        objectArray[0] = clazz;
        object2 = ((Class)object2).getMethod((String)object3, (Class<?>[])objectArray);
        Object[] objectArray2 = new Object[n10];
        object3 = "battery.capacity";
        objectArray2[0] = object3;
        object = ((Method)object2).invoke(object, objectArray2);
        object = (Double)object;
        return (Double)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String h(Context object) {
        int n10;
        NetworkInfo networkInfo;
        String string2;
        block13: {
            Object object2;
            string2 = "none";
            String string3 = "connectivity";
            try {
                object2 = object.getSystemService(string3);
            }
            catch (Exception exception) {
                return string2;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager)object2;
            networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) return string2;
            n10 = networkInfo.getType();
            if (n10 != 0) break block13;
            int n11 = networkInfo.getSubtype();
            switch (n11) {
                default: {
                    return string2;
                }
                case 13: {
                    return "4G";
                }
                case 3: 
                case 5: 
                case 6: 
                case 8: 
                case 9: 
                case 10: 
                case 12: 
                case 14: 
                case 15: {
                    return "3G";
                }
                case 1: 
                case 2: 
                case 4: 
                case 7: 
                case 11: {
                    return "2G";
                }
            }
        }
        int n12 = networkInfo.getType();
        n10 = 1;
        if (n12 != n10) return string2;
        return "wifi";
    }

    private static String i() {
        try {
            return Build.CPU_ABI;
        }
        catch (Exception exception) {
            return "";
        }
    }

    private static String j() {
        try {
            return Build.BRAND;
        }
        catch (Exception exception) {
            return "";
        }
    }

    private static String k(Context object) {
        String string2 = "phone";
        try {
            object = object.getSystemService(string2);
        }
        catch (Exception exception) {
            return "";
        }
        object = (TelephonyManager)object;
        return object.getSimSerialNumber();
    }

    private static String l(Context object) {
        String string2 = "phone";
        try {
            object = object.getSystemService(string2);
        }
        catch (Exception exception) {
            return "";
        }
        object = (TelephonyManager)object;
        return object.getDeviceId();
    }

    private static String m(Context object) {
        String string2 = "phone";
        try {
            object = object.getSystemService(string2);
        }
        catch (Exception exception) {
            return "";
        }
        object = (TelephonyManager)object;
        return object.getSubscriberId();
    }

    private static String n(Context object) {
        String string2;
        block7: {
            block6: {
                string2 = "";
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 23;
                if (n10 >= n11) {
                    return c.o();
                }
                String string3 = "wifi";
                try {
                    object = object.getSystemService(string3);
                }
                catch (Exception exception) {}
                object = (WifiManager)object;
                if (object != null) break block6;
                return string2;
            }
            object = object.getConnectionInfo();
            if (object == null) break block7;
            return object.getMacAddress();
        }
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String o() {
        int n10;
        int n11;
        int n12;
        String string2;
        Object object;
        Object object2;
        String string3;
        block24: {
            string3 = "";
            object2 = NetworkInterface.getNetworkInterfaces();
            object2 = Collections.list(object2);
            object2 = object2.iterator();
            while (true) {
                boolean bl2 = object2.hasNext();
                if (!bl2) return string3;
                object = object2.next();
                object = (NetworkInterface)object;
                String string4 = ((NetworkInterface)object).getName();
                string2 = "wlan0";
                if ((n12 = string4.equalsIgnoreCase(string2)) == 0) continue;
                break;
            }
            object2 = ((NetworkInterface)object).getHardwareAddress();
            if (object2 != null) break block24;
            return string3;
        }
        object = new StringBuilder();
        n12 = ((Object)object2).length;
        string2 = null;
        int n13 = 0;
        while (true) {
            n11 = 1;
            if (n13 >= n12) break;
            Object object3 = object2[n13];
            String string5 = "%02X:";
            Object[] objectArray = new Object[n11];
            Byte by2 = (byte)object3;
            objectArray[0] = by2;
            String string6 = String.format(string5, objectArray);
            ((StringBuilder)object).append(string6);
            ++n13;
            continue;
            break;
        }
        try {
            n10 = ((StringBuilder)object).length();
            if (n10 <= 0) return ((StringBuilder)object).toString();
        }
        catch (Exception exception) {
            return string3;
        }
        n10 = ((StringBuilder)object).length() - n11;
        ((StringBuilder)object).deleteCharAt(n10);
        return ((StringBuilder)object).toString();
    }

    private static String p(Context object) {
        String string2 = "phone";
        try {
            object = object.getSystemService(string2);
        }
        catch (Exception exception) {
            return "";
        }
        object = (TelephonyManager)object;
        return object.getDeviceId();
    }

    public static String q(Context object) {
        String string2;
        object = c.d(object);
        object = object.getBytes();
        String string3 = "UTF-8";
        try {
            string2 = new String((byte[])object, string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string2 = "";
        }
        return string2;
    }

    private static String r() {
        try {
            return Build.MODEL;
        }
        catch (Exception exception) {
            return "";
        }
    }

    private static String s() {
        StringBuilder stringBuilder;
        String string2 = "Android ";
        try {
            stringBuilder = new StringBuilder(string2);
            string2 = Build.VERSION.RELEASE;
        }
        catch (Exception exception) {
            return "";
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static PublicKey t(String object) {
        object = Base64.decode((byte[])((String)object).getBytes(), (int)2);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec((byte[])object);
        return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    }

    private static String u(Context object) {
        String string2;
        Object object2;
        try {
            object2 = new DisplayMetrics();
            string2 = "window";
        }
        catch (Exception exception) {
            return "";
        }
        object = object.getSystemService(string2);
        object = (WindowManager)object;
        object = object.getDefaultDisplay();
        object.getMetrics(object2);
        object = new StringBuilder();
        int n10 = object2.widthPixels;
        string2 = String.valueOf(n10);
        ((StringBuilder)object).append(string2);
        string2 = "*";
        ((StringBuilder)object).append(string2);
        int n11 = object2.heightPixels;
        object2 = String.valueOf(n11);
        ((StringBuilder)object).append((String)object2);
        return ((StringBuilder)object).toString();
    }

    private static String v() {
        Object object;
        try {
            object = Environment.getExternalStorageDirectory();
        }
        catch (Exception exception) {
            return "";
        }
        object = ((File)object).getPath();
        StatFs statFs = new StatFs((String)object);
        int n10 = statFs.getBlockSize();
        long l10 = n10;
        n10 = statFs.getBlockCount();
        long l11 = (long)n10 * l10;
        return Long.toString(l11);
    }

    private static String w() {
        Object object = String.class;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return c.x();
        }
        Object object2 = "android.os.SystemProperties";
        object2 = Class.forName((String)object2);
        Object[] objectArray = "get";
        int n12 = 2;
        Class[] classArray = new Class[n12];
        classArray[0] = object;
        int n13 = 1;
        classArray[n13] = object;
        object = ((Class)object2).getMethod((String)objectArray, classArray);
        objectArray = new Object[n12];
        String string2 = "ro.serialno";
        objectArray[0] = string2;
        string2 = "unknown";
        objectArray[n13] = string2;
        object = ((Method)object).invoke(object2, objectArray);
        try {
            object = (String)object;
        }
        catch (Exception exception) {
            object = "";
        }
        return object;
    }

    private static String x() {
        String string2;
        try {
            string2 = Build.getSerial();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            string2 = "";
        }
        return string2;
    }

    private static String y(Context context) {
        block3: {
            context = context.getApplicationContext();
            String string2 = "wifi";
            context = (WifiManager)context.getSystemService(string2);
            try {
                context = context.getConnectionInfo();
                if (context == null) break block3;
            }
            catch (Exception exception) {}
            return context.getSSID();
        }
        return "";
    }

    public static String z(Context context) {
        block3: {
            context = context.getApplicationContext();
            String string2 = "wifi";
            context = (WifiManager)context.getSystemService(string2);
            try {
                context = context.getConnectionInfo();
                if (context == null) break block3;
            }
            catch (SecurityException securityException) {}
            return context.getBSSID();
        }
        return "";
    }
}

