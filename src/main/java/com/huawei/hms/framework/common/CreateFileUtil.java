/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.huawei.libcore.io.ExternalStorageFile
 *  com.huawei.libcore.io.ExternalStorageFileInputStream
 *  com.huawei.libcore.io.ExternalStorageFileOutputStream
 *  com.huawei.libcore.io.ExternalStorageRandomAccessFile
 */
package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextCompat;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public static void deleteSecure(File object) {
        boolean bl2;
        boolean bl3;
        if (object != null && (bl3 = ((File)object).exists()) && !(bl2 = ((File)object).delete())) {
            object = TAG;
            String string2 = "deleteSecure exception";
            Logger.w((String)object, string2);
        }
    }

    public static void deleteSecure(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = CreateFileUtil.newFile((String)object);
            CreateFileUtil.deleteSecure((File)object);
        }
    }

    public static String getCacheDirPath(Context context) {
        if (context == null) {
            return "";
        }
        return ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String string2) {
        String string3 = TAG;
        File file = CreateFileUtil.newFile(string2);
        try {
            string2 = file.getCanonicalPath();
        }
        catch (Exception exception) {
            String string4 = "the canonicalPath has other Exception";
            Logger.w(string3, string4, exception);
        }
        catch (SecurityException securityException) {
            String string5 = "the canonicalPath has securityException";
            Logger.w(string3, string5, securityException);
        }
        catch (IOException iOException) {
            String string6 = "the canonicalPath has IOException";
            Logger.w(string3, string6, iOException);
        }
        return string2;
    }

    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static File newFile(String string2) {
        Object object;
        if (string2 == null) {
            return null;
        }
        boolean bl2 = EmuiUtil.isUpPVersion();
        if (bl2 && (bl2 = ReflectionUtils.checkCompatible((String)(object = EXTERNAL_FILE_NAME)))) {
            object = new ExternalStorageFile(string2);
            return object;
        }
        object = new File(string2);
        return object;
    }

    public static FileInputStream newFileInputStream(String object) {
        if (object != null) {
            Object object2;
            boolean bl2 = EmuiUtil.isUpPVersion();
            if (bl2 && (bl2 = ReflectionUtils.checkCompatible((String)(object2 = EXTERNAL_INPUTSTREAM_NAME)))) {
                object2 = new ExternalStorageFileInputStream((String)object);
                return object2;
            }
            object2 = new FileInputStream((String)object);
            return object2;
        }
        Logger.w(TAG, "newFileInputStream  file is null");
        object = new FileNotFoundException("file is null");
        throw object;
    }

    public static FileOutputStream newFileOutputStream(File serializable) {
        if (serializable != null) {
            Object object;
            boolean bl2 = EmuiUtil.isUpPVersion();
            if (bl2 && (bl2 = ReflectionUtils.checkCompatible((String)(object = EXTERNAL_OUTPUTSTREAM_NAME)))) {
                object = new ExternalStorageFileOutputStream(serializable);
                return object;
            }
            object = new FileOutputStream((File)serializable);
            return object;
        }
        Logger.e(TAG, "newFileOutputStream  file is null");
        serializable = new FileNotFoundException("file is null");
        throw serializable;
    }

    public static RandomAccessFile newRandomAccessFile(String object, String string2) {
        if (object != null) {
            Object object2;
            boolean bl2 = EmuiUtil.isUpPVersion();
            if (bl2 && (bl2 = ReflectionUtils.checkCompatible((String)(object2 = RANDOM_ACCESS_FILE_NAME)))) {
                object2 = new ExternalStorageRandomAccessFile((String)object, string2);
                return object2;
            }
            object2 = new RandomAccessFile((String)object, string2);
            return object2;
        }
        Logger.w(TAG, "newFileOutputStream  file is null");
        object = new FileNotFoundException("file is null");
        throw object;
    }
}

