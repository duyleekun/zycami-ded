/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.ApplicationInfo
 *  android.net.ConnectivityManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 */
package com.tencent.liteav.basic.datareport;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.UUID;

public class TXCDRApi {
    private static final char[] DIGITS_LOWER;
    public static final int NETWORK_TYPE_2G = 4;
    public static final int NETWORK_TYPE_3G = 3;
    public static final int NETWORK_TYPE_4G = 2;
    public static final int NETWORK_TYPE_UNKNOWN = 255;
    public static final int NETWORK_TYPE_WIFI = 1;
    private static final String TAG = "TXCDRApi";
    private static String g_simulate_idfa = "";
    public static boolean initRpt = false;
    private static String mAppName = "";
    private static String mDevId = "";
    private static String mDevType = "";
    private static String mDevUUID = "";
    private static String mNetType = "";
    private static String mSysVersion = "";

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
        DIGITS_LOWER = cArray;
        initRpt = false;
        g.f();
        TXCDRApi.nativeInitDataReport();
    }

    public static void InitEvent(Context context, String string2, int n10, int n11, TXCDRExtInfo tXCDRExtInfo) {
        TXCDRApi.setCommonInfo(context);
        if (string2 == null) {
            return;
        }
        TXCDRApi.nativeInitEventInternal(string2, n10, n11, tXCDRExtInfo);
    }

    private static String byteArrayToHexString(byte[] object) {
        int n10;
        int n11 = ((byte[])object).length << 1;
        char[] cArray = new char[n11];
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = ((byte[])object).length); ++i10) {
            char c10;
            n10 = n12 + 1;
            char[] cArray2 = DIGITS_LOWER;
            int n13 = (object[i10] & 0xF0) >>> 4;
            cArray[n12] = n13 = cArray2[n13];
            n12 = n10 + 1;
            n13 = object[i10] & 0xF;
            cArray[n10] = c10 = cArray2[n13];
        }
        object = new String;
        object(cArray);
        return object;
    }

    public static String getApplicationNameByPackageName(Context object, String string2) {
        object = object.getPackageManager();
        int n10 = 128;
        string2 = object.getApplicationInfo(string2, n10);
        object = object.getApplicationLabel((ApplicationInfo)string2);
        try {
            object = object.toString();
        }
        catch (Exception exception) {
            object = "";
        }
        return object;
    }

    public static String getDevUUID(Context context, String string2) {
        return TXCDRApi.getSimulateIDFA(context);
    }

    public static int getNetworkType(Context context) {
        Object object;
        int n10;
        String string2;
        block11: {
            string2 = TAG;
            n10 = 255;
            if (context == null) {
                return n10;
            }
            object = (ConnectivityManager)context.getSystemService("connectivity");
            String string3 = "phone";
            context = (TelephonyManager)context.getSystemService(string3);
            try {
                object = object.getActiveNetworkInfo();
                if (object != null) break block11;
                return n10;
            }
            catch (Exception exception) {
                TXCLog.e(string2, "getActiveNetworkInfo exception:", exception);
                return n10;
            }
        }
        int n11 = object.getType();
        int n12 = 1;
        if (n11 == n12) {
            return n12;
        }
        int n13 = object.getType();
        if (n13 == 0) {
            int n14;
            n10 = 2;
            try {
                n14 = context.getNetworkType();
            }
            catch (Exception exception) {
                object = "TXCDRApi: get network type fail, exception occurred.";
                TXCLog.e(string2, (String)object, exception);
            }
            switch (n14) {
                default: {
                    return n10;
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
                    return 3;
                }
                case 1: 
                case 2: 
                case 4: 
                case 7: 
                case 11: 
            }
            return 4;
        }
        return n10;
    }

    public static String getOrigAndroidID(Context object) {
        object = object.getContentResolver();
        String string2 = "android_id";
        try {
            object = Settings.Secure.getString((ContentResolver)object, (String)string2);
        }
        catch (Throwable throwable) {
            object = "";
        }
        return TXCDRApi.string2Md5((String)object);
    }

    private static String getPackageName(Context object) {
        Object object2 = object.getPackageManager();
        object = object.getPackageName();
        String string2 = null;
        object = object2.getPackageInfo((String)object, 0);
        try {
            object = object.packageName;
        }
        catch (Exception exception) {
            object2 = TAG;
            string2 = "get package name failed.";
            TXCLog.e((String)object2, string2, exception);
            object = "";
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getSimulateIDFA(Context context) {
        String string2;
        Object object;
        Object object2;
        String string3;
        Object object3;
        String string4;
        SharedPreferences sharedPreferences;
        StringBuilder stringBuilder;
        String string5;
        File file;
        Object object4;
        int n10;
        int n11;
        Object object5;
        String string6;
        Object object6;
        block23: {
            block22: {
                block20: {
                    object6 = context;
                    string6 = "/txrtmp/spuid";
                    object5 = g_simulate_idfa;
                    if (object5 != null && (n11 = ((String)object5).length()) > 0) {
                        return g_simulate_idfa;
                    }
                    n10 = 0;
                    object4 = null;
                    file = object6.getExternalFilesDir(null);
                    string5 = TAG;
                    if (file == null) {
                        TXCLog.e(string5, "getSimulateIDFA sdcardDir is null");
                        return g_simulate_idfa;
                    }
                    object5 = "com.tencent.liteav.dev_uuid";
                    stringBuilder = null;
                    sharedPreferences = object6.getSharedPreferences((String)object5, 0);
                    string4 = "com.tencent.liteav.key_dev_uuid";
                    object3 = "";
                    string3 = sharedPreferences.getString(string4, (String)object3);
                    try {
                        object5 = new StringBuilder();
                        object2 = file.getAbsolutePath();
                        ((StringBuilder)object5).append((String)object2);
                        ((StringBuilder)object5).append(string6);
                        object5 = ((StringBuilder)object5).toString();
                        object2 = new File((String)object5);
                        n11 = (int)(((File)object2).exists() ? 1 : 0);
                        if (n11 == 0) break block20;
                        object5 = new FileInputStream((File)object2);
                        int n12 = ((FileInputStream)object5).available();
                        if (n12 > 0) {
                            object2 = new byte[n12];
                            ((FileInputStream)object5).read((byte[])object2);
                            object = "UTF-8";
                            string2 = new String((byte[])object2, (String)object);
                        } else {
                            string2 = null;
                        }
                    }
                    catch (Exception exception) {
                        string2 = null;
                        break block22;
                    }
                    try {
                        ((FileInputStream)object5).close();
                        break block23;
                    }
                    catch (Exception exception) {
                        break block22;
                    }
                }
                string2 = null;
                break block23;
            }
            object2 = new StringBuilder();
            object = "read UUID from file failed! reason: ";
            ((StringBuilder)object2).append((String)object);
            object5 = ((Throwable)object5).getMessage();
            ((StringBuilder)object2).append((String)object5);
            object5 = ((StringBuilder)object2).toString();
            TXCLog.e(string5, (String)object5);
        }
        if (string3 != null && (n11 = string3.length()) > 0) {
            object4 = string3;
        } else if (string2 != null && (n11 = string2.length()) > 0) {
            object4 = string2;
        }
        if (object4 == null || (n11 = ((String)object4).length()) == 0) {
            byte by2;
            long l10;
            long l11 = System.currentTimeMillis();
            long l12 = TXCTimeUtil.getTimeTick();
            object5 = g.c(context);
            int n13 = 5;
            while (true) {
                l10 = 255L;
                n10 = 1;
                object2 = "%02x";
                if (n13 < 0) break;
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)object3);
                object4 = new Object[n10];
                byte by3 = n13 * 8;
                long l13 = l11 >> by3;
                long l14 = l11;
                by3 = (byte)(l13 & l10);
                object3 = by3;
                by2 = 0;
                object = null;
                object4[0] = object3;
                object4 = String.format((String)object2, (Object[])object4);
                stringBuilder.append((String)object4);
                object3 = stringBuilder.toString();
                n13 += -1;
                l11 = l14;
                stringBuilder = null;
            }
            for (n13 = 3; n13 >= 0; n13 += -1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)object3);
                object3 = new Object[n10];
                by2 = n13 * 8;
                l11 = l12 >> by2 & l10;
                by2 = (byte)l11;
                object3[0] = object = Byte.valueOf(by2);
                object3 = String.format((String)object2, object3);
                stringBuilder.append((String)object3);
                object3 = stringBuilder.toString();
            }
            object6 = new StringBuilder();
            object6.append((String)object3);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object5);
            object5 = UUID.randomUUID().toString();
            ((StringBuilder)object4).append((String)object5);
            object5 = TXCDRApi.string2Md5(((StringBuilder)object4).toString());
            object6.append((String)object5);
            object4 = object6.toString();
        }
        g_simulate_idfa = object4;
        object5 = new StringBuilder();
        ((StringBuilder)object5).append("UUID:");
        object6 = g_simulate_idfa;
        ((StringBuilder)object5).append((String)object6);
        object5 = ((StringBuilder)object5).toString();
        TXCLog.i(string5, (String)object5);
        if (string2 == null || (n11 = (int)(string2.equals(object4) ? 1 : 0)) == 0) {
            try {
                object5 = new StringBuilder();
                object6 = file.getAbsolutePath();
                ((StringBuilder)object5).append((String)object6);
                object6 = "/txrtmp";
                ((StringBuilder)object5).append((String)object6);
                object5 = ((StringBuilder)object5).toString();
                object6 = new File((String)object5);
                n11 = (int)(object6.exists() ? 1 : 0);
                if (n11 == 0) {
                    object6.mkdir();
                }
                object5 = new StringBuilder();
                object6 = file.getAbsolutePath();
                ((StringBuilder)object5).append((String)object6);
                ((StringBuilder)object5).append(string6);
                object5 = ((StringBuilder)object5).toString();
                object6 = new File((String)object5);
                n11 = (int)(object6.exists() ? 1 : 0);
                if (n11 == 0) {
                    object6.createNewFile();
                }
                object5 = new FileOutputStream((File)object6);
                object6 = ((String)object4).getBytes();
                ((FileOutputStream)object5).write((byte[])object6);
                ((FileOutputStream)object5).close();
            }
            catch (Exception exception) {
                object6 = new StringBuilder();
                string6 = "write UUID to file failed! reason: ";
                object6.append(string6);
                object5 = exception.getMessage();
                object6.append((String)object5);
                object5 = object6.toString();
                TXCLog.e(string5, (String)object5);
            }
        }
        if (string3 == null || (n11 = (int)(string3.equals(object4) ? 1 : 0)) == 0) {
            object5 = sharedPreferences.edit();
            object5.putString(string4, (String)object4);
            object5.commit();
        }
        return g_simulate_idfa;
    }

    public static int getStatusReportInterval() {
        return TXCDRApi.nativeGetStatusReportInterval();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void initCrashReport(Context context) {
        Object object = TXCDRApi.class;
        try {
            synchronized (object) {
                boolean bl2 = initRpt;
                if (bl2) return;
                if (context == null) return;
            }
        }
        catch (Exception exception) {
            object = TAG;
            String string2 = "init crash report failed.";
            TXCLog.e((String)object, string2, exception);
            return;
        }
        {
            boolean bl3;
            String string3 = TXCCommonUtil.getSDKVersionStr();
            if (string3 == null) return;
            String string4 = "BuglySdkInfos";
            context = context.getSharedPreferences(string4, 0);
            context = context.edit();
            string4 = "8e50744bf0";
            context.putString(string4, string3);
            context.commit();
            initRpt = bl3 = true;
            return;
        }
    }

    public static native int nativeGetStatusReportInterval();

    private static native void nativeInitDataReport();

    private static native void nativeInitEventInternal(String var0, int var1, int var2, TXCDRExtInfo var3);

    public static native void nativeReportAVRoomEvent(int var0, long var1, String var3, int var4, int var5, String var6, String var7);

    private static native void nativeReportDAUInterval(int var0, int var1, String var2);

    public static native void nativeReportEvent(String var0, int var1);

    public static native void nativeReportEvent40003(String var0, int var1, int var2, String var3, String var4);

    public static native void nativeSetCommonValue(String var0, String var1);

    private static native void nativeSetEventValueInterval(String var0, int var1, String var2, String var3);

    private static native void nativeUninitDataReport();

    public static void reportAVRoomEvent(int n10, long l10, String string2, int n11, int n12, String string3, String string4) {
        TXCDRApi.nativeReportAVRoomEvent(n10, l10, string2, n11, n12, string3, string4);
    }

    public static void reportEvent40003(String string2, int n10, int n11, String string3, String string4) {
        TXCDRApi.nativeReportEvent40003(string2, n10, n11, string3, string4);
    }

    public static void setCommonInfo(Context object) {
        mDevType = Build.MODEL;
        mNetType = Integer.toString(TXCDRApi.getNetworkType((Context)object));
        String string2 = mDevId;
        boolean bl2 = string2.isEmpty();
        if (bl2) {
            mDevId = string2 = TXCDRApi.getSimulateIDFA((Context)object);
        }
        if (bl2 = (string2 = mDevUUID).isEmpty()) {
            string2 = mDevId;
            mDevUUID = string2 = TXCDRApi.getDevUUID((Context)object, string2);
        }
        string2 = TXCDRApi.getPackageName((Context)object);
        StringBuilder stringBuilder = new StringBuilder();
        object = TXCDRApi.getApplicationNameByPackageName((Context)object, string2);
        stringBuilder.append((String)object);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        mAppName = stringBuilder.toString();
        mSysVersion = String.valueOf(Build.VERSION.SDK_INT);
        object = new StringBuilder();
        ((StringBuilder)object).append("devType= ");
        string2 = mDevType;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", netType= ");
        string2 = mNetType;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", devId= ");
        string2 = mDevId;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", devUUID= ");
        string2 = mDevUUID;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", appName = ");
        string2 = mAppName;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", sysVersion= ");
        string2 = mSysVersion;
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TXCDRApi", (String)object);
        TXCDRApi.txSetCommonInfo();
    }

    public static String string2Md5(String object) {
        Object object2 = "";
        if (object == null) {
            return object2;
        }
        Object object3 = "MD5";
        object3 = MessageDigest.getInstance((String)object3);
        String string2 = "UTF-8";
        object = ((String)object).getBytes(string2);
        object = ((MessageDigest)object3).digest((byte[])object);
        try {
            object = TXCDRApi.byteArrayToHexString((byte[])object);
        }
        catch (Exception exception) {
            object3 = "TXCDRApi";
            string2 = "string2Md5 failed.";
            TXCLog.e((String)object3, string2, exception);
            object = object2;
        }
        if (object != null) {
            object2 = object;
        }
        return object2;
    }

    public static String txCreateToken() {
        return UUID.randomUUID().toString();
    }

    public static void txReportDAU(Context context, int n10) {
        if (context != null) {
            TXCDRApi.setCommonInfo(context);
        }
        TXCDRApi.nativeReportDAUInterval(n10, 0, "");
    }

    public static void txReportDAU(Context context, int n10, int n11, String string2) {
        if (context != null) {
            TXCDRApi.setCommonInfo(context);
        }
        TXCDRApi.nativeReportDAUInterval(n10, n11, string2);
    }

    public static void txSetAppVersion(String string2) {
        if (string2 != null) {
            String string3 = a.k;
            TXCDRApi.nativeSetCommonValue(string3, string2);
        }
    }

    public static void txSetCommonInfo() {
        String string2;
        String string3 = mDevType;
        if (string3 != null) {
            string3 = a.f;
            string2 = mDevType;
            TXCDRApi.nativeSetCommonValue(string3, string2);
        }
        if ((string3 = mNetType) != null) {
            string3 = a.g;
            string2 = mNetType;
            TXCDRApi.nativeSetCommonValue(string3, string2);
        }
        if ((string3 = mDevId) != null) {
            string3 = a.h;
            string2 = mDevId;
            TXCDRApi.nativeSetCommonValue(string3, string2);
        }
        if ((string3 = mDevUUID) != null) {
            string3 = a.i;
            string2 = mDevUUID;
            TXCDRApi.nativeSetCommonValue(string3, string2);
        }
        if ((string3 = mAppName) != null) {
            string3 = a.j;
            string2 = mAppName;
            TXCDRApi.nativeSetCommonValue(string3, string2);
        }
        if ((string3 = mSysVersion) != null) {
            string3 = a.l;
            string2 = mSysVersion;
            TXCDRApi.nativeSetCommonValue(string3, string2);
        }
    }

    public static void txSetEventIntValue(String string2, int n10, String string3, long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(l10);
        String string4 = stringBuilder.toString();
        TXCDRApi.nativeSetEventValueInterval(string2, n10, string3, string4);
    }

    public static void txSetEventValue(String string2, int n10, String string3, String string4) {
        TXCDRApi.nativeSetEventValueInterval(string2, n10, string3, string4);
    }
}

