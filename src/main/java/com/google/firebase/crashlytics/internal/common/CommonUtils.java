/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.hardware.SensorManager
 *  android.net.ConnectivityManager
 *  android.os.Build
 *  android.os.Debug
 *  android.os.StatFs
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 */
package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils$Architecture;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommonUtils {
    public static final int BYTES_IN_A_GIGABYTE = 0x40000000;
    public static final int BYTES_IN_A_KILOBYTE = 1024;
    public static final int BYTES_IN_A_MEGABYTE = 0x100000;
    public static final int DEVICE_STATE_BETAOS = 8;
    public static final int DEVICE_STATE_COMPROMISEDLIBRARIES = 32;
    public static final int DEVICE_STATE_DEBUGGERATTACHED = 4;
    public static final int DEVICE_STATE_ISSIMULATOR = 1;
    public static final int DEVICE_STATE_JAILBROKEN = 2;
    public static final int DEVICE_STATE_VENDORINTERNAL = 16;
    private static final String GOOGLE_SDK = "google_sdk";
    private static final char[] HEX_VALUES;
    public static final String LEGACY_MAPPING_FILE_ID_RESOURCE_NAME = "com.crashlytics.android.build_id";
    public static final String LEGACY_SHARED_PREFS_NAME = "com.crashlytics.prefs";
    public static final String MAPPING_FILE_ID_RESOURCE_NAME = "com.google.firebase.crashlytics.mapping_file_id";
    private static final String SDK = "sdk";
    private static final String SHA1_INSTANCE = "SHA-1";
    public static final String SHARED_PREFS_NAME = "com.google.firebase.crashlytics";
    private static final long UNCALCULATED_TOTAL_RAM = 255L;
    private static final String UNITY_EDITOR_VERSION = "com.google.firebase.crashlytics.unity_version";
    private static long totalRamInBytes;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[16];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 97;
        cArray3[11] = 98;
        cArray2[12] = 99;
        cArray3[13] = 100;
        cArray2[14] = 101;
        cArray3[15] = 102;
        HEX_VALUES = cArray;
        totalRamInBytes = -1;
    }

    public static long calculateFreeRamInBytes(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long calculateUsedDiskSpaceInBytes(String string2) {
        StatFs statFs = new StatFs(string2);
        long l10 = statFs.getBlockSize();
        long l11 = (long)statFs.getBlockCount() * l10;
        long l12 = statFs.getAvailableBlocks();
        return l11 - (l10 *= l12);
    }

    public static boolean canTryConnection(Context context) {
        boolean bl2;
        String string2 = "android.permission.ACCESS_NETWORK_STATE";
        boolean bl3 = CommonUtils.checkPermission(context, string2);
        boolean bl4 = true;
        if (bl3 && ((context = ((ConnectivityManager)context.getSystemService(string2 = "connectivity")).getActiveNetworkInfo()) == null || !(bl2 = context.isConnectedOrConnecting()))) {
            bl4 = false;
        }
        return bl4;
    }

    public static boolean checkPermission(Context context, String string2) {
        int n10 = context.checkCallingOrSelfPermission(string2);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    public static void closeOrLog(Closeable closeable, String string2) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (IOException iOException) {
                Logger logger = Logger.getLogger();
                logger.e(string2, iOException);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (RuntimeException runtimeException) {
                throw runtimeException;
            }
            catch (Exception exception) {}
        }
    }

    public static long convertMemInfoToBytes(String string2, String string3, int n10) {
        long l10 = Long.parseLong(string2.split(string3)[0].trim());
        long l11 = n10;
        return l10 * l11;
    }

    public static String createInstanceIdFrom(String ... object) {
        int n10;
        String string2 = null;
        if (object != null && (n10 = ((String[])object).length) != 0) {
            int n11;
            Object object2 = new ArrayList();
            for (String string3 : object) {
                if (string3 == null) continue;
                String string4 = "";
                string3 = string3.replace("-", string4);
                Locale locale = Locale.US;
                string3 = string3.toLowerCase(locale);
                object2.add(string3);
            }
            Collections.sort(object2);
            object = new StringBuilder();
            object2 = object2.iterator();
            while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                String string5 = (String)object2.next();
                ((StringBuilder)object).append(string5);
            }
            n10 = ((String)(object = ((StringBuilder)object).toString())).length();
            if (n10 > 0) {
                string2 = CommonUtils.sha1((String)object);
            }
        }
        return string2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String extractFieldFromSystemFile(File object, String string2) {
        void var0_3;
        Object object2;
        String string3;
        block10: {
            BufferedReader bufferedReader;
            block8: {
                String[] stringArray;
                block9: {
                    string3 = "Failed to close system file reader.";
                    boolean bl2 = ((File)object).exists();
                    object2 = null;
                    if (!bl2) return object2;
                    stringArray = new FileReader((File)object);
                    int n10 = 1024;
                    bufferedReader = new BufferedReader((Reader)stringArray, n10);
                    try {
                        while ((stringArray = bufferedReader.readLine()) != null) {
                            Object object3 = "\\s*:\\s*";
                            object3 = Pattern.compile((String)object3);
                            int n11 = 2;
                            n10 = (stringArray = ((Pattern)object3).split((CharSequence)stringArray, n11)).length;
                            if (n10 <= (n11 = 1)) continue;
                            n10 = 0;
                            object3 = null;
                            object3 = stringArray[0];
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) continue;
                            object2 = object = stringArray[n11];
                            break block8;
                        }
                        break block8;
                    }
                    catch (Exception exception) {
                        break block9;
                    }
                    catch (Throwable throwable) {
                        break block10;
                    }
                    catch (Exception exception) {
                        bl2 = false;
                        bufferedReader = null;
                    }
                }
                try {
                    void var1_7;
                    stringArray = Logger.getLogger();
                    StringBuilder stringBuilder = new StringBuilder();
                    String string4 = "Error parsing ";
                    stringBuilder.append(string4);
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    stringArray.e((String)object, (Throwable)var1_7);
                }
                catch (Throwable throwable) {
                    object2 = bufferedReader;
                }
            }
            CommonUtils.closeOrLog(bufferedReader, string3);
            return object2;
        }
        CommonUtils.closeOrLog(object2, string3);
        throw var0_3;
    }

    public static ActivityManager.RunningAppProcessInfo getAppProcessInfo(String string2, Context object) {
        boolean bl2;
        String string3 = "activity";
        if ((object = ((ActivityManager)object.getSystemService(string3)).getRunningAppProcesses()) != null) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                string3 = (ActivityManager.RunningAppProcessInfo)object.next();
                String string4 = ((ActivityManager.RunningAppProcessInfo)string3).processName;
                boolean bl3 = string4.equals(string2);
                if (!bl3) continue;
                break;
            }
        } else {
            bl2 = false;
            string3 = null;
        }
        return string3;
    }

    public static boolean getBooleanResourceValue(Context context, String string2, boolean bl2) {
        Object object;
        if (context != null && (object = context.getResources()) != null) {
            String string3 = "bool";
            int n10 = CommonUtils.getResourcesIdentifier(context, string2, string3);
            if (n10 > 0) {
                return object.getBoolean(n10);
            }
            object = "string";
            int n11 = CommonUtils.getResourcesIdentifier(context, string2, (String)object);
            if (n11 > 0) {
                return Boolean.parseBoolean(context.getString(n11));
            }
        }
        return bl2;
    }

    public static int getCpuArchitectureInt() {
        return CommonUtils$Architecture.getValue().ordinal();
    }

    public static int getDeviceState(Context context) {
        int n10 = (int)(CommonUtils.isEmulator(context) ? 1 : 0);
        n10 = n10 != 0 ? 1 : 0;
        boolean bl2 = CommonUtils.isRooted(context);
        if (bl2) {
            n10 |= 2;
        }
        if (bl2 = CommonUtils.isDebuggerAttached()) {
            n10 |= 4;
        }
        return n10;
    }

    public static SharedPreferences getLegacySharedPrefs(Context context) {
        return context.getSharedPreferences(LEGACY_SHARED_PREFS_NAME, 0);
    }

    public static String getMappingFileId(Context object) {
        String string2 = MAPPING_FILE_ID_RESOURCE_NAME;
        String string3 = "string";
        int n10 = CommonUtils.getResourcesIdentifier(object, string2, string3);
        if (n10 == 0) {
            string2 = LEGACY_MAPPING_FILE_ID_RESOURCE_NAME;
            n10 = CommonUtils.getResourcesIdentifier(object, string2, string3);
        }
        object = n10 != 0 ? object.getResources().getString(n10) : null;
        return object;
    }

    public static boolean getProximitySensorEnabled(Context context) {
        int n10 = CommonUtils.isEmulator(context);
        boolean bl2 = false;
        if (n10 != 0) {
            return false;
        }
        String string2 = "sensor";
        context = (SensorManager)context.getSystemService(string2);
        n10 = 8;
        if ((context = context.getDefaultSensor(n10)) != null) {
            bl2 = true;
        }
        return bl2;
    }

    public static String getResourcePackageName(Context context) {
        Object object;
        block7: {
            object = context.getApplicationContext().getApplicationInfo();
            int n10 = object.icon;
            if (n10 > 0) {
                Object object2 = context.getResources();
                object = object2.getResourcePackageName(n10);
                object2 = "android";
                boolean bl2 = ((String)object2).equals(object);
                if (!bl2) break block7;
                try {
                    object = context.getPackageName();
                }
                catch (Resources.NotFoundException notFoundException) {
                    object = context.getPackageName();
                }
            } else {
                object = context.getPackageName();
            }
        }
        return object;
    }

    public static int getResourcesIdentifier(Context object, String string2, String string3) {
        Resources resources = object.getResources();
        object = CommonUtils.getResourcePackageName(object);
        return resources.getIdentifier(string2, string3, (String)object);
    }

    public static SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_NAME, 0);
    }

    public static String getStringsFileValue(Context context, String string2) {
        String string3 = "string";
        int n10 = CommonUtils.getResourcesIdentifier(context, string2, string3);
        if (n10 > 0) {
            return context.getString(n10);
        }
        return "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long getTotalRamInBytes() {
        Class<CommonUtils> clazz = CommonUtils.class;
        synchronized (clazz) {
            long l10;
            block9: {
                l10 = totalRamInBytes;
                long l11 = -1;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 != false) return totalRamInBytes;
                l10 = 0L;
                Object object = "/proc/meminfo";
                Object object2 = new File((String)object);
                object = "MemTotal";
                boolean bl2 = TextUtils.isEmpty((CharSequence)(object2 = CommonUtils.extractFieldFromSystemFile((File)object2, (String)object)));
                if (!bl2) {
                    object = Locale.US;
                    object2 = ((String)object2).toUpperCase((Locale)object);
                    object = "KB";
                    try {
                        bl2 = ((String)object2).endsWith((String)object);
                        if (bl2) {
                            object = "KB";
                            int n10 = 1024;
                            l10 = CommonUtils.convertMemInfoToBytes((String)object2, (String)object, n10);
                            break block9;
                        }
                        object = "MB";
                        bl2 = ((String)object2).endsWith((String)object);
                        if (bl2) {
                            object = "MB";
                            int n11 = 0x100000;
                            l10 = CommonUtils.convertMemInfoToBytes((String)object2, (String)object, n11);
                            break block9;
                        }
                        object = "GB";
                        bl2 = ((String)object2).endsWith((String)object);
                        if (bl2) {
                            object = "GB";
                            int n12 = 0x40000000;
                            l10 = CommonUtils.convertMemInfoToBytes((String)object2, (String)object, n12);
                        } else {
                            object = Logger.getLogger();
                            CharSequence charSequence = new StringBuilder();
                            String string2 = "Unexpected meminfo format while computing RAM: ";
                            charSequence.append(string2);
                            charSequence.append((String)object2);
                            charSequence = charSequence.toString();
                            ((Logger)object).w((String)charSequence);
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        Logger logger = Logger.getLogger();
                        StringBuilder stringBuilder = new StringBuilder();
                        String string3 = "Unexpected meminfo format while computing RAM: ";
                        stringBuilder.append(string3);
                        stringBuilder.append((String)object2);
                        object2 = stringBuilder.toString();
                        logger.e((String)object2, numberFormatException);
                    }
                }
            }
            totalRamInBytes = l10;
            return totalRamInBytes;
        }
    }

    private static String hash(String string2, String string3) {
        return CommonUtils.hash(string2.getBytes(), string3);
    }

    private static String hash(byte[] byArray, String object) {
        try {
            object = MessageDigest.getInstance((String)object);
            ((MessageDigest)object).update(byArray);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            Logger logger = Logger.getLogger();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create hashing algorithm: ");
            stringBuilder.append((String)object);
            stringBuilder.append(", returning empty string.");
            object = stringBuilder.toString();
            logger.e((String)object, noSuchAlgorithmException);
            return "";
        }
        return CommonUtils.hexify(((MessageDigest)object).digest());
    }

    public static String hexify(byte[] object) {
        int n10;
        int n11 = ((byte[])object).length * 2;
        char[] cArray = new char[n11];
        for (int i10 = 0; i10 < (n10 = ((byte[])object).length); ++i10) {
            n10 = object[i10] & 0xFF;
            int n12 = i10 * 2;
            char[] cArray2 = HEX_VALUES;
            int n13 = n10 >>> 4;
            cArray[n12] = n13 = cArray2[n13];
            n10 &= 0xF;
            cArray[++n12] = n10 = cArray2[n10];
        }
        object = new String;
        object(cArray);
        return object;
    }

    public static boolean isAppDebuggable(Context context) {
        context = context.getApplicationInfo();
        int n10 = context.flags & 2;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    public static boolean isDebuggerAttached() {
        boolean bl2 = Debug.isDebuggerConnected();
        bl2 = bl2 || (bl2 = Debug.waitingForDebugger());
        return bl2;
    }

    public static boolean isEmulator(Context object) {
        boolean bl2;
        boolean bl3;
        object = Settings.Secure.getString((ContentResolver)object.getContentResolver(), (String)"android_id");
        String string2 = SDK;
        String string3 = Build.PRODUCT;
        boolean bl4 = string2.equals(string3);
        if (!bl4 && !(bl3 = (string2 = GOOGLE_SDK).equals(string3)) && object != null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isLoggingEnabled(Context context) {
        return false;
    }

    public static boolean isRooted(Context context) {
        String string2;
        boolean bl2;
        boolean bl3 = CommonUtils.isEmulator(context);
        Object object = Build.TAGS;
        boolean bl4 = true;
        if (!bl3 && object != null && (bl2 = ((String)object).contains(string2 = "test-keys"))) {
            return bl4;
        }
        string2 = "/system/app/Superuser.apk";
        object = new File(string2);
        bl2 = ((File)object).exists();
        if (bl2) {
            return bl4;
        }
        string2 = "/system/xbin/su";
        object = new File(string2);
        if (!bl3 && (bl3 = ((File)object).exists())) {
            return bl4;
        }
        return false;
    }

    public static String padWithZerosToMaxIntWidth(int n10) {
        if (n10 >= 0) {
            Locale locale = Locale.US;
            Object[] objectArray = new Object[1];
            Integer n11 = n10;
            objectArray[0] = n11;
            return String.format(locale, "%1$10s", objectArray).replace(' ', '0');
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("value must be zero or greater");
        throw illegalArgumentException;
    }

    public static String resolveUnityEditorVersion(Context object) {
        Object object2 = UNITY_EDITOR_VERSION;
        CharSequence charSequence = "string";
        int n10 = CommonUtils.getResourcesIdentifier(object, (String)object2, (String)charSequence);
        if (n10 != 0) {
            object = object.getResources().getString(n10);
            object2 = Logger.getLogger();
            charSequence = new StringBuilder();
            String string2 = "Unity Editor version is: ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            ((Logger)object2).v((String)charSequence);
        } else {
            object = null;
        }
        return object;
    }

    public static String sha1(String string2) {
        return CommonUtils.hash(string2, SHA1_INSTANCE);
    }

    public static String streamToString(InputStream object) {
        Scanner scanner = new Scanner((InputStream)object);
        boolean bl2 = ((Scanner)(object = scanner.useDelimiter("\\A"))).hasNext();
        object = bl2 ? ((Scanner)object).next() : "";
        return object;
    }
}

