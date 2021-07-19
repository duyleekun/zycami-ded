/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.bluetooth.BluetoothAdapter
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.StatFs
 *  android.provider.Settings$Global
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 */
package com.zhiyun.common.util;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.zhiyun.common.util.Windows;
import d.v.e.l.d1;
import d.v.e.l.s1;
import d.v.e.l.u1;
import d.v.e.l.x1;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m.a.a;

public class Devices {
    private static final String a = "^([Hh][Uu][Aa][Ww][Ee][Ii]\\s|HW-|LC\\s|LGM-|LG-|LG\\s|LM-|LG|HTC(?:[\\s_])*|QK|360[\\s]?|ASUS[\\s_]*|[Ll][Ee](?:2|tv[_\\s-]*|\\s)?|ONEPLUS[\\s]*)?(.+)$";
    private static String b;
    private static String c;
    private static String d;

    public static String A() {
        int n10;
        String string2 = Build.MODEL;
        String string3 = "";
        string2 = string2.replace("SAMSUNG-", string3).replace("ZTE ", string3).replace("Lenovo ", string3).replace(" (AOSP)", string3);
        Matcher matcher = Pattern.compile(a).matcher(string2);
        int n11 = matcher.matches();
        if (n11 != 0 && (n11 = matcher.groupCount()) >= (n10 = 2)) {
            string2 = matcher.group(n10);
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ArrayList B() {
        int n10;
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        Object object = Environment.getRootDirectory().getAbsoluteFile();
        ((StringBuilder)((Object)arrayList)).append(object);
        object = File.separator;
        ((StringBuilder)((Object)arrayList)).append((String)object);
        Object object2 = "etc";
        ((StringBuilder)((Object)arrayList)).append((String)object2);
        ((StringBuilder)((Object)arrayList)).append((String)object);
        object = "vold.fstab";
        ((StringBuilder)((Object)arrayList)).append((String)object);
        arrayList = ((StringBuilder)((Object)arrayList)).toString();
        Object object3 = new File((String)((Object)arrayList));
        arrayList = new ArrayList<String[]>();
        boolean bl2 = ((File)object3).exists();
        if (!bl2) {
            return arrayList;
        }
        object = new ArrayList();
        try {
            object.clear();
            Object object4 = new FileReader((File)object3);
            object2 = new BufferedReader((Reader)object4);
            while ((object3 = ((BufferedReader)object2).readLine()) != null) {
                object4 = "dev_mount";
                n10 = ((String)object3).startsWith((String)object4);
                if (n10 == 0) continue;
                object.add(object3);
            }
            ((BufferedReader)object2).close();
            object.trimToSize();
        }
        catch (IOException iOException) {}
        object3 = object.iterator();
        while (bl2 = object3.hasNext()) {
            int n11;
            object = (String)object3.next();
            if (object == null || (object = object.split((String)(object2 = " "))) == null || (n11 = ((String[])object).length) < (n10 = 4) || (object = object[n11 = 2]) == null || (n11 = (int)(((File)(object2 = new File((String)object))).exists() ? 1 : 0)) == 0) continue;
            arrayList.add((String[])object);
        }
        return arrayList;
    }

    public static String C() {
        String string2;
        boolean bl2;
        String string3 = Environment.getExternalStorageDirectory().getPath();
        if (string3 != null && !(bl2 = string3.endsWith(string2 = "/"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string3 = stringBuilder.toString();
        }
        return string3;
    }

    public static String D() {
        String string2;
        boolean bl2;
        String string3 = Environment.getExternalStorageDirectory().getPath();
        boolean bl3 = Devices.Q();
        if (!bl3) {
            return null;
        }
        if (string3 != null && !(bl2 = string3.endsWith(string2 = "/"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string3 = stringBuilder.toString();
        }
        return string3;
    }

    public static int E() {
        return Build.VERSION.SDK_INT;
    }

    public static String F() {
        return Build.SERIAL;
    }

    public static String G() {
        int n10;
        int n11;
        String string2 = d;
        if (string2 != null) {
            return string2;
        }
        string2 = Devices.C();
        Object object = Devices.B();
        CharSequence charSequence = "/mnt/external1";
        ((ArrayList)object).add(charSequence);
        long l10 = 0L;
        int n12 = n11 = -1;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)object).size()); ++i10) {
            long l11;
            long l12;
            long l13;
            String string3 = (String)((ArrayList)object).get(i10);
            boolean bl2 = s1.Z(string3, string2);
            if (bl2 || !(bl2 = s1.q(string3)) || (l13 = (l12 = (l11 = Devices.d(string3)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) continue;
            n12 = i10;
            l10 = l11;
        }
        if (n12 == n11) {
            string2 = null;
        } else {
            string2 = (String)((ArrayList)object).get(n12);
            boolean bl3 = string2.endsWith((String)(object = "/"));
            if (!bl3) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object);
                string2 = ((StringBuilder)charSequence).toString();
            }
        }
        d = string2;
        return string2;
    }

    public static String H() {
        return Build.VERSION.RELEASE;
    }

    public static long I() {
        String string2 = Devices.G();
        if (string2 == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(string2);
        long l10 = statFs.getBlockSize();
        return (long)statFs.getBlockCount() * l10;
    }

    public static long J() {
        String string2 = Environment.getExternalStorageDirectory().getPath();
        StatFs statFs = new StatFs(string2);
        long l10 = statFs.getBlockSize();
        return (long)statFs.getBlockCount() * l10;
    }

    public static long K() {
        Object object = Environment.getDataDirectory();
        object = ((File)object).getPath();
        StatFs statFs = new StatFs((String)object);
        long l10 = statFs.getBlockSize();
        return (long)statFs.getBlockCount() * l10;
    }

    public static long L(Context context) {
        context = (ActivityManager)context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (context != null) {
            context.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    public static long M(Context context) {
        return Devices.L(context);
    }

    public static boolean N() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 11;
        if (n10 >= n11) {
            return Environment.isExternalStorageEmulated();
        }
        return false;
    }

    public static boolean O() {
        String string2;
        boolean bl2;
        String string3 = Devices.x();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3 && (bl2 = (string3 = string3.toLowerCase()).contains(string2 = "huawei"))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    public static boolean P() {
        new Build();
        String string2 = Build.BRAND.toLowerCase();
        String string3 = "meizu";
        boolean bl2 = string2.contains(string3);
        return bl2;
    }

    public static boolean Q() {
        String string2 = Environment.getExternalStorageState();
        return "mounted".equalsIgnoreCase(string2);
    }

    public static boolean R() {
        new Build();
        String string2 = Build.BRAND.toLowerCase();
        String string3 = "samsung";
        boolean bl2 = string2.contains(string3);
        return bl2;
    }

    public static boolean S(Context context) {
        String string2 = "activity";
        context = ((ActivityManager)context.getSystemService(string2)).getDeviceConfigurationInfo();
        int n10 = context.reqGlEsVersion;
        int n11 = 131072;
        if (n10 >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    public static String a(Context context) {
        return Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
    }

    public static long b() {
        String string2 = Environment.getExternalStorageDirectory().getPath();
        StatFs statFs = new StatFs(string2);
        long l10 = statFs.getBlockSize();
        return (long)statFs.getAvailableBlocks() * l10;
    }

    public static long c() {
        Object object = Environment.getDataDirectory();
        object = ((File)object).getPath();
        StatFs statFs = new StatFs((String)object);
        long l10 = statFs.getBlockSize();
        return (long)statFs.getAvailableBlocks() * l10;
    }

    public static long d(String string2) {
        StatFs statFs = new StatFs(string2);
        long l10 = statFs.getBlockSize();
        return (long)statFs.getAvailableBlocks() * l10;
    }

    public static String e() {
        return Build.BRAND;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String f() {
        CharSequence charSequence;
        String string2 = "\\s+";
        String[] stringArray = b;
        if (stringArray != null) {
            return stringArray;
        }
        stringArray = "";
        b = stringArray;
        Object object = "/proc/cpuinfo";
        stringArray = new String[]{stringArray, stringArray};
        Object object2 = new FileReader((String)object);
        int n10 = 8192;
        object = new BufferedReader((Reader)object2, n10);
        object2 = ((BufferedReader)object).readLine();
        object2 = ((String)object2).split(string2);
        int n11 = n10 = 2;
        while (true) {
            int n12 = ((String[])object2).length;
            if (n11 >= n12) break;
            charSequence = new StringBuilder();
            Object object3 = stringArray[0];
            ((StringBuilder)charSequence).append((String)object3);
            object3 = object2[n11];
            ((StringBuilder)charSequence).append((String)object3);
            object3 = " ";
            ((StringBuilder)charSequence).append((String)object3);
            charSequence = ((StringBuilder)charSequence).toString();
            stringArray[0] = charSequence;
            ++n11;
            continue;
            break;
        }
        try {
            object2 = ((BufferedReader)object).readLine();
        }
        catch (IOException iOException) {
            return b;
        }
        String[] stringArray2 = ((String)object2).split(string2);
        object2 = new StringBuilder();
        n11 = 1;
        charSequence = stringArray[n11];
        ((StringBuilder)object2).append((String)charSequence);
        String string3 = stringArray2[n10];
        ((StringBuilder)object2).append(string3);
        String string4 = ((StringBuilder)object2).toString();
        stringArray[n11] = string4;
        ((BufferedReader)object).close();
        String string5 = stringArray[0];
        b = string5;
        return b;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String g() {
        void var0_3;
        Object object;
        block11: {
            BufferedReader bufferedReader;
            StringBuilder stringBuilder;
            block9: {
                stringBuilder = new StringBuilder();
                String string2 = "/proc/cpuinfo";
                object = new File(string2);
                boolean bl2 = ((File)object).exists();
                if (!bl2) return stringBuilder.toString();
                bl2 = false;
                object = null;
                File file = new File(string2);
                Object[] objectArray = new FileReader(file);
                bufferedReader = new BufferedReader((Reader)objectArray);
                try {
                    block10: {
                        try {
                            while ((object = bufferedReader.readLine()) != null) {
                                int n10;
                                string2 = "Hardware";
                                int n11 = ((String)object).contains(string2);
                                if (n11 == 0) continue;
                                string2 = ":";
                                n11 = ((String)object).indexOf(string2);
                                if (n11 >= 0 && n11 < (n10 = ((String)object).length() + -1)) {
                                    object = ((String)object).substring(++n11);
                                    object = ((String)object).trim();
                                    stringBuilder.append((String)object);
                                }
                                break block9;
                            }
                            break block9;
                        }
                        catch (IOException iOException) {
                            break block10;
                        }
                        catch (Throwable throwable) {
                            break block11;
                        }
                        catch (IOException iOException) {
                            bufferedReader = null;
                            object = iOException;
                        }
                    }
                    string2 = "getCPUInfo";
                    boolean bl3 = false;
                    objectArray = null;
                    objectArray = new Object[]{};
                    m.a.a.g((Throwable)object, string2, objectArray);
                }
                catch (Throwable throwable) {
                    object = bufferedReader;
                }
            }
            u1.a(bufferedReader);
            return stringBuilder.toString();
        }
        u1.a((Closeable)object);
        throw var0_3;
    }

    public static String getSerialId(Context object) {
        boolean bl2;
        Object object2 = "android.os.SystemProperties";
        object2 = Class.forName((String)object2);
        Object object3 = "get";
        int n10 = 1;
        Object object4 = new Class[n10];
        Class<String> clazz = String.class;
        object4[0] = clazz;
        object3 = ((Class)object2).getMethod((String)object3, (Class<?>)object4);
        Object[] objectArray = new Object[n10];
        object4 = "ro.serialno";
        objectArray[0] = object4;
        object2 = ((Method)object3).invoke(object2, objectArray);
        try {
            object2 = (String)object2;
        }
        catch (Exception exception) {
            object2 = null;
        }
        if (object2 != null && !(bl2 = ((String)object2).equals(object3 = ""))) {
            return object2;
        }
        object2 = "phone";
        if ((object = ((TelephonyManager)object.getSystemService((String)object2)).getDeviceId()) == null) {
            object = "unknown";
        }
        return object;
    }

    public static int h() {
        String string2 = "/sys/devices/system/cpu/cpu1";
        File file = new File(string2);
        int n10 = file.exists();
        n10 = n10 != 0 ? 2 : 1;
        return n10;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String i() {
        Object object;
        Object object2;
        Object object3;
        block24: {
            String string2;
            block22: {
                block25: {
                    block23: {
                        block21: {
                            byte[] byArray;
                            int n10 = 0;
                            object3 = null;
                            object2 = Runtime.getRuntime();
                            object = "getprop ro.board.platform";
                            object2 = ((Runtime)object2).exec((String)object);
                            object = ((Process)object2).getInputStream();
                            int n11 = 128;
                            try {
                                byArray = new byte[n11];
                                ((InputStream)object).read(byArray);
                                string2 = new String(byArray);
                                object3 = "\n";
                            }
                            catch (IOException iOException) {
                                string2 = null;
                                object3 = iOException;
                                break block23;
                            }
                            try {
                                n10 = string2.indexOf((String)object3);
                                n11 = -1;
                                if (n10 != n11) {
                                    n11 = 0;
                                    byArray = null;
                                    string2 = string2.substring(0, n10);
                                }
                                if (object == null) break block21;
                            }
                            catch (IOException iOException) {
                                break block23;
                            }
                            try {
                                ((InputStream)object).close();
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                        }
                        if (object2 == null) return string2;
                        break block22;
                        catch (Throwable throwable) {
                            object = null;
                            object3 = throwable;
                            break block24;
                        }
                        catch (IOException iOException) {
                            string2 = null;
                            object3 = iOException;
                            object = null;
                            break block23;
                        }
                        catch (Throwable throwable) {
                            object = null;
                            object3 = throwable;
                            object2 = null;
                            break block24;
                        }
                        catch (IOException iOException) {
                            object = null;
                            string2 = null;
                            object3 = iOException;
                            object2 = null;
                        }
                    }
                    ((Throwable)object3).printStackTrace();
                    if (object == null) break block25;
                    try {
                        ((InputStream)object).close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                if (object2 == null) return string2;
            }
            ((Process)object2).destroy();
            return string2;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object != null) {
            try {
                ((InputStream)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (object2 == null) throw object3;
        ((Process)object2).destroy();
        throw object3;
    }

    /*
     * Loose catch block
     */
    public static String j() {
        Object object;
        Object object2;
        block23: {
            block25: {
                block24: {
                    block22: {
                        block21: {
                            object2 = null;
                            object = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
                            FileReader fileReader = new FileReader((String)object);
                            object = new BufferedReader(fileReader);
                            object2 = ((BufferedReader)object).readLine();
                            object2 = ((String)object2).trim();
                            try {
                                ((BufferedReader)object).close();
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            break block25;
                            catch (IOException iOException) {
                                break block21;
                            }
                            catch (FileNotFoundException fileNotFoundException) {
                                break block22;
                            }
                            catch (Throwable throwable) {
                                object = null;
                                object2 = throwable;
                                break block23;
                            }
                            catch (IOException iOException) {
                                object = null;
                                object2 = iOException;
                            }
                        }
                        ((Throwable)object2).printStackTrace();
                        if (object == null) break block24;
                        ((BufferedReader)object).close();
                        catch (FileNotFoundException fileNotFoundException) {
                            object = null;
                            object2 = fileNotFoundException;
                        }
                    }
                    ((Throwable)object2).printStackTrace();
                    if (object == null) break block24;
                    try {
                        ((BufferedReader)object).close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                object2 = "N/A";
            }
            return object2;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object != null) {
            try {
                ((BufferedReader)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        throw object2;
    }

    public static String k(Context object) {
        object = object.getApplicationContext();
        SharedPreferences sharedPreferences = object.getSharedPreferences("com.avos.avoscloud.analysis1", 0);
        String string2 = "com.avos.avoscloud.deviceId1";
        String string3 = null;
        String string4 = sharedPreferences.getString(string2, null);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            string4 = object.getPackageName();
            String string5 = Devices.a(object);
            String string6 = Build.ID;
            String string7 = Devices.u(object);
            object = Devices.s(object);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string7);
            if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)object))) {
                string3 = UUID.randomUUID().toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append(string5);
            stringBuilder.append(string6);
            stringBuilder.append(string7);
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            object = x1.b(stringBuilder.toString()).toLowerCase();
            sharedPreferences.edit().putString(string2, (String)object).apply();
            return object;
        }
        return string4;
    }

    public static Map l(Context object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object2 = d1.e(object);
        hashMap.put("package_name", object2);
        object2 = d1.h(object);
        hashMap.put("app_version", object2);
        object2 = d1.f(object);
        hashMap.put("version_code", object2);
        object2 = Windows.l(object).toString();
        hashMap.put("resolution", object2);
        object2 = Build.MODEL;
        hashMap.put("device_model", object2);
        object2 = Build.MANUFACTURER;
        hashMap.put("device_manufacturer", object2);
        object2 = Build.VERSION.RELEASE;
        hashMap.put("os_version", object2);
        object2 = Build.DEVICE;
        hashMap.put("device_name", object2);
        object2 = Build.BRAND;
        hashMap.put("device_brand", object2);
        object2 = Build.BOARD;
        hashMap.put("device_board", object2);
        object2 = Build.FINGERPRINT;
        hashMap.put("device_manuid", object2);
        object2 = Devices.g();
        hashMap.put("cpu", object2);
        hashMap.put("os", "Android");
        object = Devices.k(object);
        hashMap.put("device_id", object);
        object = Locale.getDefault().getCountry();
        hashMap.put("region", object);
        return hashMap;
    }

    public static String m(Context object) {
        object = object.getContentResolver();
        String string2 = "device_name";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = Settings.Global.getString((ContentResolver)object, (String)string2)));
        if (bl2) {
            object = BluetoothAdapter.getDefaultAdapter().getName();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = new StringBuilder();
            string2 = Build.MANUFACTURER;
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" ");
            string2 = Build.MODEL;
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        return object;
    }

    public static String n(Context object) {
        object = object.getContentResolver();
        String string2 = "device_name";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = Settings.Global.getString((ContentResolver)object, (String)string2)));
        if (bl2) {
            object = new StringBuilder();
            string2 = Build.MANUFACTURER;
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" ");
            string2 = Build.MODEL;
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        return object;
    }

    public static long o() {
        String string2 = Devices.D();
        if (string2 == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(string2);
        long l10 = statFs.getBlockSize();
        long l11 = statFs.getAvailableBlocks();
        return ((long)statFs.getBlockCount() - l11) * l10;
    }

    public static long p() {
        String string2 = Environment.getExternalStorageDirectory().getPath();
        StatFs statFs = new StatFs(string2);
        long l10 = statFs.getBlockSize();
        return (long)statFs.getFreeBlocks() * l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String q(List object, String string2) {
        if (object == null) return null;
        try {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                int n10;
                byte[] byArray;
                boolean bl2;
                Object e10 = object.next();
                NetworkInterface networkInterface = (NetworkInterface)e10;
                String string3 = networkInterface.getName();
                int n11 = TextUtils.isEmpty((CharSequence)string3);
                if (n11 != 0 || !(bl2 = string3.equalsIgnoreCase(string2)) || (byArray = networkInterface.getHardwareAddress()) == null) continue;
                object = new StringBuilder();
                int n12 = byArray.length;
                bl2 = false;
                string3 = null;
                n11 = 0;
                while (true) {
                    n10 = 1;
                    if (n11 >= n12) break;
                    byte by2 = byArray[n11];
                    String string4 = "%02X:";
                    Object[] objectArray = new Object[n10];
                    Byte by3 = by2;
                    objectArray[0] = by3;
                    String string5 = String.format(string4, objectArray);
                    ((StringBuilder)object).append(string5);
                    ++n11;
                }
                n12 = ((StringBuilder)object).length();
                if (n12 <= 0) return ((StringBuilder)object).toString();
                n12 = ((StringBuilder)object).length() - n10;
                ((StringBuilder)object).deleteCharAt(n12);
                return ((StringBuilder)object).toString();
            }
            return null;
        }
        catch (Exception exception) {}
        return null;
    }

    public static long r(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static String s(Context object) {
        String string2 = "phone";
        try {
            object = object.getSystemService(string2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
        object = (TelephonyManager)object;
        return object.getDeviceId();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String t() {
        int n10;
        Object object;
        Object object2;
        String string2 = c;
        if (string2 != null) {
            return string2;
        }
        c = string2 = "";
        int n11 = 0;
        Object object3 = null;
        try {
            object2 = Runtime.getRuntime();
            object = "cat /proc/version";
            object3 = ((Runtime)object2).exec((String)object);
        }
        catch (IOException iOException) {}
        object3 = ((Process)object3).getInputStream();
        object = Charset.defaultCharset();
        object2 = new InputStreamReader((InputStream)object3, (Charset)object);
        int n12 = 8192;
        object3 = new BufferedReader((Reader)object2, n12);
        object2 = string2;
        try {
            while ((object = ((BufferedReader)object3).readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                stringBuilder.append((String)object);
                object2 = stringBuilder.toString();
            }
        }
        catch (IOException iOException) {}
        if ((n10 = TextUtils.equals((CharSequence)object2, (CharSequence)string2)) == 0) {
            n10 = ((String)object2).indexOf("version ") + 8;
            string2 = ((String)object2).substring(n10);
            object3 = " ";
            n11 = string2.indexOf((String)object3);
            object2 = null;
            c = string2 = string2.substring(0, n11);
        }
        return c;
    }

    public static String u(Context object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = Devices.w(object)));
        if (bl2) {
            object = Devices.v();
        }
        return object;
    }

    private static String v() {
        String string2;
        block6: {
            Object object;
            try {
                object = NetworkInterface.getNetworkInterfaces();
            }
            catch (SocketException socketException) {
                return null;
            }
            object = Collections.list(object);
            string2 = "wlan0";
            string2 = Devices.q((List)object, string2);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) break block6;
            string2 = "eth1";
            return Devices.q((List)object, string2);
        }
        return string2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String w(Context object) {
        void var4_7;
        Object object2;
        block5: {
            int n10 = Build.VERSION.SDK_INT;
            object2 = null;
            int n11 = 23;
            if (n10 >= n11) {
                return null;
            }
            String string2 = "wifi";
            try {
                object = object.getSystemService(string2);
                object = (WifiManager)object;
                object = object.getConnectionInfo();
                object = object.getMacAddress();
                string2 = "02:00:00:00:00:00";
            }
            catch (Exception exception) {
                // empty catch block
                break block5;
            }
            try {
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) return object;
                return null;
            }
            catch (Exception exception) {
                object2 = object;
            }
        }
        object = new Object[]{};
        String string3 = "failed to get wifi mac address";
        m.a.a.z((Throwable)var4_7, string3, (Object[])object);
        return object2;
    }

    public static String x() {
        return Build.MANUFACTURER;
    }

    /*
     * Loose catch block
     */
    public static long y() {
        Object object;
        Object object2;
        block20: {
            long l10;
            block22: {
                block21: {
                    block19: {
                        object2 = null;
                        object = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
                        FileReader fileReader = new FileReader((String)object);
                        object = new BufferedReader(fileReader);
                        object2 = ((BufferedReader)object).readLine();
                        object2 = ((String)object2).trim();
                        object2 = Long.valueOf((String)object2);
                        l10 = (Long)object2;
                        try {
                            ((BufferedReader)object).close();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                        break block22;
                        catch (IOException iOException) {
                            break block19;
                        }
                        catch (Throwable throwable) {
                            object = null;
                            object2 = throwable;
                            break block20;
                        }
                        catch (IOException iOException) {
                            object = null;
                            object2 = iOException;
                        }
                    }
                    ((Throwable)object2).printStackTrace();
                    if (object == null) break block21;
                    try {
                        ((BufferedReader)object).close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                l10 = -1;
            }
            return l10;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object != null) {
            try {
                ((BufferedReader)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        throw object2;
    }

    public static String z(Context object) {
        String string2 = "phone";
        if ((object = ((TelephonyManager)object.getSystemService(string2)).getLine1Number()) == null) {
            object = "";
        }
        return object;
    }
}

