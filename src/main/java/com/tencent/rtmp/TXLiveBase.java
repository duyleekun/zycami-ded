/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.tencent.rtmp;

import android.content.Context;
import android.util.Log;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.license.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.s;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase$a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TXLiveBase {
    private static final String FILE_MD5_FFMPEG_ARM = "___md5_libtxffmpeg_arm_md5______";
    private static final String FILE_MD5_FFMPEG_V64 = "___md5_libtxffmpeg_v64_md5______";
    private static final String FILE_MD5_FFMPEG_V7A = "___md5_libtxffmpeg_v7a_md5______";
    private static final String FILE_MD5_LITEAV_ARM = "___md5_libliteavsdk_arm_md5_____";
    private static final String FILE_MD5_LITEAV_V64 = "___md5_libliteavsdk_v64_md5_____";
    private static final String FILE_MD5_LITEAV_V7A = "___md5_libliteavsdk_v7a_md5_____";
    private static final String FILE_MD5_SATURN_ARM = "___md5_libsaturn_arm_md5________";
    private static final String FILE_MD5_SATURN_V64 = "___md5_libsaturn_v64_md5________";
    private static final String FILE_MD5_SATURN_V7A = "___md5_libsaturn_v7a_md5________";
    private static final String FILE_MD5_TRAE_ARM = "___md5_libtraeimp_arm_md5_______";
    private static final String FILE_MD5_TRAE_V64 = "___md5_libtraeimp_v64_md5_______";
    private static final String FILE_MD5_TRAE_V7A = "___md5_libtraeimp_v7a_md5_______";
    private static final String TAG = "TXLiveBase";
    private static TXLiveBase instance;
    private static ITXLiveBaseListener listener;

    static {
        TXLiveBase tXLiveBase;
        instance = tXLiveBase = new TXLiveBase();
    }

    private TXLiveBase() {
    }

    public static /* synthetic */ ITXLiveBaseListener access$100() {
        return listener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String getFileMD5(String object, String object2) {
        File file = new File((String)object, (String)object2);
        int n10 = file.exists();
        object2 = null;
        if (n10 == 0) return null;
        n10 = file.isFile();
        if (n10 == 0) {
            return null;
        }
        n10 = 1024;
        byte[] byArray = new byte[n10];
        Object object3 = "MD5";
        try {
            object2 = MessageDigest.getInstance((String)object3);
            object3 = new FileInputStream(file);
            while (true) {
                int n11;
                file = null;
                int n12 = ((FileInputStream)object3).read(byArray, 0, n10);
                if (n12 == (n11 = -1)) break;
                ((MessageDigest)object2).update(byArray, 0, n12);
            }
            ((FileInputStream)object3).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        object2 = ((MessageDigest)object2).digest();
        object = new BigInteger(1, (byte[])object2);
        return ((BigInteger)object).toString(16);
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public static String getPituSDKVersion() {
        return s.a();
    }

    public static String getSDKVersionStr() {
        return TXCCommonUtil.getSDKVersionStr();
    }

    public static boolean isLibraryPathValid(String string2) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        String string3 = TXLiveBase.getFileMD5(string2, "libliteavsdk.so");
        String string4 = TXLiveBase.getFileMD5(string2, "libsaturn.so");
        String string5 = TXLiveBase.getFileMD5(string2, "libtxffmpeg.so");
        string2 = TXLiveBase.getFileMD5(string2, "libtraeimp-rtmp.so");
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("MD5-CHECK-V64 libliteavsdk = ");
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(" FILE_MD5_LITEAV_V64 = ");
        CharSequence charSequence2 = FILE_MD5_LITEAV_V64;
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        String string6 = TAG;
        Log.e((String)string6, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("MD5-CHECK-V64 libsaturn    = ");
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(" FILE_MD5_SATURN_V64 = ");
        String string7 = FILE_MD5_SATURN_V64;
        ((StringBuilder)charSequence).append(string7);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.e((String)string6, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("MD5-CHECK-V64 libtxffmpeg  = ");
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append(" FILE_MD5_FFMPEG_V64 = ");
        String string8 = FILE_MD5_FFMPEG_V64;
        ((StringBuilder)charSequence).append(string8);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.e((String)string6, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("MD5-CHECK-V64 libtraeimpl  = ");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(" FILE_MD5_TRAE_V64   = ");
        String string9 = FILE_MD5_TRAE_V64;
        ((StringBuilder)charSequence).append(string9);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.e((String)string6, (String)charSequence);
        boolean bl5 = true;
        if (string3 != null && (bl4 = string3.equalsIgnoreCase((String)charSequence2)) && string4 != null && (bl4 = string4.equalsIgnoreCase(string7)) && string5 != null && (bl4 = string5.equalsIgnoreCase(string8)) && string2 != null && (bl4 = string2.equalsIgnoreCase(string9))) {
            return bl5;
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-V7A libliteavsdk = ");
        ((StringBuilder)charSequence2).append(string3);
        ((StringBuilder)charSequence2).append(" FILE_MD5_LITEAV_V7A = ");
        string7 = FILE_MD5_LITEAV_V7A;
        ((StringBuilder)charSequence2).append(string7);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-V7A libsaturn    = ");
        ((StringBuilder)charSequence2).append(string4);
        ((StringBuilder)charSequence2).append(" FILE_MD5_SATURN_V7A = ");
        string8 = FILE_MD5_SATURN_V7A;
        ((StringBuilder)charSequence2).append(string8);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-V7A libtxffmpeg  = ");
        ((StringBuilder)charSequence2).append(string5);
        ((StringBuilder)charSequence2).append(" FILE_MD5_FFMPEG_V7A = ");
        string9 = FILE_MD5_FFMPEG_V7A;
        ((StringBuilder)charSequence2).append(string9);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-V7A libtraeimpl  = ");
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append(" FILE_MD5_TRAE_V7A   = ");
        String string10 = FILE_MD5_TRAE_V7A;
        ((StringBuilder)charSequence2).append(string10);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        if (string3 != null && (bl4 = string3.equalsIgnoreCase(string7)) && string4 != null && (bl4 = string4.equalsIgnoreCase(string8)) && string5 != null && (bl4 = string5.equalsIgnoreCase(string9)) && string2 != null && (bl4 = string2.equalsIgnoreCase(string10))) {
            return bl5;
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-ARM libliteavsdk = ");
        ((StringBuilder)charSequence2).append(string3);
        ((StringBuilder)charSequence2).append(" FILE_MD5_LITEAV_ARM = ");
        string7 = FILE_MD5_LITEAV_ARM;
        ((StringBuilder)charSequence2).append(string7);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-ARM libsaturn    = ");
        ((StringBuilder)charSequence2).append(string4);
        ((StringBuilder)charSequence2).append(" FILE_MD5_SATURN_ARM = ");
        string8 = FILE_MD5_SATURN_ARM;
        ((StringBuilder)charSequence2).append(string8);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-ARM libtxffmpeg  = ");
        ((StringBuilder)charSequence2).append(string5);
        ((StringBuilder)charSequence2).append(" FILE_MD5_FFMPEG_ARM = ");
        string9 = FILE_MD5_FFMPEG_ARM;
        ((StringBuilder)charSequence2).append(string9);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("MD5-CHECK-ARM libtraeimpl  = ");
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append(" FILE_MD5_TRAE_ARM   = ");
        string10 = FILE_MD5_TRAE_ARM;
        ((StringBuilder)charSequence2).append(string10);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Log.e((String)string6, (String)charSequence2);
        if (string3 != null && (bl3 = string3.equalsIgnoreCase(string7)) && string4 != null && (bl3 = string4.equalsIgnoreCase(string8)) && string5 != null && (bl3 = string5.equalsIgnoreCase(string9)) && string2 != null && (bl2 = string2.equalsIgnoreCase(string10))) {
            return bl5;
        }
        return false;
    }

    public static void setAppID(String string2) {
        TXCCommonUtil.setAppID(string2);
    }

    public static void setAppVersion(String string2) {
        TXCDRApi.txSetAppVersion(string2);
        TXCCommonUtil.setAppVersion(string2);
    }

    public static void setConsoleEnabled(boolean bl2) {
        TXCLog.setConsoleEnabled(bl2);
    }

    public static void setLibraryPath(String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setLibraryPath ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        Log.i((String)TAG, (String)charSequence);
        g.b(string2);
    }

    public static void setListener(ITXLiveBaseListener iTXLiveBaseListener) {
        TXLiveBase$a tXLiveBase$a = new TXLiveBase$a(null);
        TXCLog.setListener(tXLiveBase$a);
        listener = iTXLiveBaseListener;
    }

    public static void setLogLevel(int n10) {
        TXCLog.setLevel(n10);
    }

    public static void setPituLicencePath(String string2) {
        TXCCommonUtil.setPituLicencePath(string2);
    }

    public static void setUserId(String string2) {
        TXCCommonUtil.setUserId(string2);
    }

    public String getLicenceInfo(Context context) {
        f f10 = new f();
        LicenceCheck.a().a(f10, context);
        return f10.a;
    }

    public void setLicence(Context context, String string2, String string3) {
        LicenceCheck.a().a(context, string2, string3);
    }
}

