/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.tencent.liteav.basic.util;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;

public class TXCCommonUtil {
    private static final String TAG = "TXCCommonUtil";
    private static String mAppID = "";
    private static String mStrAppVersion = "";
    private static String mUserId = "";
    public static String pituLicencePath = "YTFaceSDK.licence";
    private static Context sApplicationContext;

    static {
        g.f();
    }

    public static boolean equals(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static Context getAppContext() {
        return sApplicationContext;
    }

    public static String getAppFilePath() {
        Object object = sApplicationContext;
        object = object != null ? object.getFilesDir().getAbsolutePath() : "/sdcard/liteav";
        File file = new File((String)object);
        boolean bl2 = file.exists();
        if (!bl2) {
            file.mkdirs();
        }
        return object;
    }

    public static String getAppID() {
        return mAppID;
    }

    public static String getAppNameByStreamUrl(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            String string3 = "?";
            n10 = string2.indexOf(string3);
            int n11 = 0;
            int n12 = -1;
            if (n10 != n12) {
                string2 = string2.substring(0, n10);
            }
            if (string2 != null && (n10 = string2.length()) != 0) {
                string3 = "/";
                int n13 = string2.lastIndexOf(string3);
                if (n13 != n12) {
                    string2 = string2.substring(0, n13);
                }
                if (string2 != null && (n11 = string2.length()) != 0) {
                    n10 = string2.lastIndexOf(string3);
                    if (n10 != n12) {
                        string2 = string2.substring(++n10);
                    }
                    if (string2 != null && (n10 = string2.length()) != 0) {
                        return string2;
                    }
                }
            }
        }
        return null;
    }

    public static String getAppPackageName() {
        return g.c(sApplicationContext);
    }

    public static String getAppVersion() {
        return mStrAppVersion;
    }

    public static String getConfigCenterKey() {
        return TXCCommonUtil.nativeGetConfigCenterKey();
    }

    public static final String getDeviceInfo() {
        String string2;
        StringBuilder stringBuilder;
        String string3 = "_";
        try {
            stringBuilder = new StringBuilder();
            string2 = Build.BRAND;
        }
        catch (Exception exception) {
            return "unknown_device";
        }
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        string2 = Build.MODEL;
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        string3 = Build.VERSION.RELEASE;
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String getFileExtension(String string2) {
        int n10;
        int n11;
        string2 = string2 != null && (n11 = string2.length()) > 0 && (n11 = string2.lastIndexOf(46)) > (n10 = -1) && n11 < (n10 = string2.length() + -1) ? string2.substring(++n11) : null;
        return string2;
    }

    public static int getGateway() {
        Object object = sApplicationContext;
        int n10 = 0;
        if (object == null) {
            return 0;
        }
        String string2 = "wifi";
        object = object.getSystemService(string2);
        object = (WifiManager)object;
        object = object.getDhcpInfo();
        try {
            n10 = object.gateway;
        }
        catch (Exception exception) {
            string2 = TAG;
            String string3 = "getGateway error ";
            TXCLog.e(string2, string3, exception);
        }
        return n10;
    }

    public static String getLogUploadPath() {
        Object object = sApplicationContext;
        CharSequence charSequence = "";
        if (object == null) {
            return charSequence;
        }
        if ((object = object.getExternalFilesDir(null)) == null) {
            return charSequence;
        }
        charSequence = new StringBuilder();
        object = ((File)object).getAbsolutePath();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("/log/tencent/liteav");
        return ((StringBuilder)charSequence).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getMD5(String string2) {
        Object object = "MD5";
        try {
            object = MessageDigest.getInstance((String)object);
            Object object2 = string2.getBytes();
            ((MessageDigest)object).update((byte[])object2);
            object = ((MessageDigest)object).digest();
            object2 = new StringBuffer;
            String string3 = "";
            ((StringBuffer)object2)(string3);
            int n10 = 0;
            string3 = null;
            while (true) {
                Object object3;
                Object object4;
                if (n10 >= (object4 = ((Object)object).length)) {
                    return ((StringBuffer)object2).toString();
                }
                object4 = object[n10];
                if (object4 < 0) {
                    object4 += 256;
                }
                if (object4 < (object3 = 16)) {
                    String string4 = "0";
                    ((StringBuffer)object2).append(string4);
                }
                String string5 = Integer.toHexString(object4);
                ((StringBuffer)object2).append(string5);
                ++n10;
            }
        }
        catch (Exception exception) {
            return string2;
        }
    }

    public static byte[] getMD5(byte[] byArray) {
        Object object = "MD5";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (Exception exception) {
            return null;
        }
        ((MessageDigest)object).update(byArray);
        return ((MessageDigest)object).digest();
    }

    public static int getSDKID() {
        return TXCCommonUtil.nativeGetSDKID();
    }

    public static int[] getSDKVersion() {
        int n10;
        String[] stringArray = TXCCommonUtil.nativeGetSDKVersion().split("\\.");
        int n11 = stringArray.length;
        int[] nArray = new int[n11];
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            String string2 = stringArray[i10];
            n10 = Integer.parseInt(string2);
            try {
                nArray[i10] = n10;
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                String string3 = TAG;
                String string4 = "parse version failed.";
                TXCLog.e(string3, string4, numberFormatException);
                nArray[i10] = 0;
            }
        }
        return nArray;
    }

    public static String getSDKVersionStr() {
        return TXCCommonUtil.nativeGetSDKVersion();
    }

    public static String getStreamIDByStreamUrl(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            int n11;
            String string3 = "?";
            n10 = string2.indexOf(string3);
            if (n10 != (n11 = -1)) {
                string2 = string2.substring(0, n10);
            }
            if (string2 != null && (n10 = string2.length()) != 0) {
                string3 = "/";
                n10 = string2.lastIndexOf(string3);
                if (n10 != n11) {
                    string2 = string2.substring(++n10);
                }
                if (string2 != null && (n10 = string2.length()) != 0) {
                    string3 = ".";
                    n10 = string2.indexOf(string3);
                    if (n10 != n11) {
                        string2 = string2.substring(0, n10);
                    }
                    if (string2 != null && (n10 = string2.length()) != 0) {
                        return string2;
                    }
                }
            }
        }
        return null;
    }

    public static String getUserId() {
        return mUserId;
    }

    public static String loadString(String string2) {
        Object object = sApplicationContext;
        String string3 = "";
        if (object == null) {
            return string3;
        }
        String string4 = "TXCCommonConfig";
        object = object.getSharedPreferences(string4, 0);
        try {
            string3 = object.getString(string2, string3);
        }
        catch (Exception exception) {
            object = TAG;
            string4 = "load string failed.";
            TXCLog.e((String)object, string4, exception);
        }
        return string3;
    }

    public static long loadUInt64(String string2) {
        Object object = sApplicationContext;
        long l10 = 0L;
        if (object == null) {
            return l10;
        }
        String string3 = "TXCCommonConfig";
        object = object.getSharedPreferences(string3, 0);
        try {
            l10 = object.getLong(string2, l10);
        }
        catch (Exception exception) {
            object = TAG;
            string3 = "load uint64 failed.";
            TXCLog.e((String)object, string3, exception);
        }
        return l10;
    }

    private static native String nativeGetConfigCenterKey();

    private static native int nativeGetSDKID();

    private static native String nativeGetSDKVersion();

    public static void saveString(String string2, String string3) {
        Object object = sApplicationContext;
        if (object == null) {
            return;
        }
        String string4 = "TXCCommonConfig";
        object = object.getSharedPreferences(string4, 0);
        object = object.edit();
        try {
            object.putString(string2, string3);
            object.commit();
        }
        catch (Exception exception) {
            string3 = "TXCCommonUtil";
            object = "save string failed";
            TXCLog.e(string3, (String)object, exception);
        }
    }

    public static void saveUInt64(String string2, long l10) {
        Context context = sApplicationContext;
        if (context == null) {
            return;
        }
        String string3 = "TXCCommonConfig";
        context = context.getSharedPreferences(string3, 0);
        context = context.edit();
        try {
            context.putLong(string2, l10);
            context.commit();
        }
        catch (Exception exception) {
            String string4 = "TXCCommonUtil";
            String string5 = "save uint64 failed.";
            TXCLog.e(string4, string5, exception);
        }
    }

    public static void setAppContext(Context context) {
        if (context == null) {
            return;
        }
        sApplicationContext = context.getApplicationContext();
    }

    public static void setAppID(String string2) {
        mAppID = string2;
    }

    public static void setAppVersion(String string2) {
        mStrAppVersion = string2;
    }

    public static void setPituLicencePath(String string2) {
        pituLicencePath = string2;
    }

    public static void setUserId(String string2) {
        mUserId = string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void sleep(int n10) {
        long l10 = n10;
        try {
            Thread.sleep(l10);
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public static void zip(ArrayList var0, String var1_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 28[TRYBLOCK] [54 : 299->303)] java.lang.Throwable
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
}

