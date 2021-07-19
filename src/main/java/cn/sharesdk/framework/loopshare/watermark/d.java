/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.media.MediaScannerConnection
 *  android.net.Uri
 *  android.os.Environment
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.loopshare.watermark;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class d {
    private static final String a;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        File file = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DCIM);
        stringBuilder.append(file);
        stringBuilder.append("/watermark");
        a = stringBuilder.toString();
    }

    public static ContentValues a(File comparable, long l10) {
        ContentValues contentValues = new ContentValues();
        Object object = comparable.getName();
        String string2 = "_display_name";
        contentValues.put(string2, (String)object);
        contentValues.put("description", "water mark video");
        object = comparable.getName();
        contentValues.put("title", (String)object);
        object = comparable.getName();
        contentValues.put(string2, (String)object);
        contentValues.put("mime_type", "video/*");
        object = l10;
        contentValues.put("datetaken", (Long)object);
        object = l10;
        contentValues.put("date_modified", (Long)object);
        Object object2 = l10;
        contentValues.put("date_added", (Long)object2);
        object2 = comparable.getAbsolutePath();
        contentValues.put("_data", (String)object2);
        comparable = comparable.length();
        contentValues.put("_size", (Long)comparable);
        return contentValues;
    }

    private static void a() {
        String string2 = a;
        File file = new File(string2);
        boolean bl2 = file.exists();
        if (!bl2) {
            try {
                file.mkdirs();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void a(Context object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        CharSequence charSequence = "ShareSDK";
        int n10 = 1;
        if (bl2) {
            object = SSDKLog.b();
            object2 = new Object[n10];
            object2[0] = " \u62f7\u8d1d\u6587\u4ef6\u7684\u76ee\u6807\u8def\u5f84\u4e3a\u7a7a ";
            ((NLog)object).e(charSequence, object2);
            return;
        }
        String[] stringArray = new File((String)object2);
        boolean bl3 = stringArray.exists();
        if (!bl3) {
            object = SSDKLog.b();
            object2 = new Object[n10];
            object2[0] = " \u62f7\u8d1d\u6587\u4ef6\u4e0d\u5b58\u5728 ";
            ((NLog)object).e(charSequence, object2);
            return;
        }
        d.a();
        charSequence = new StringBuilder();
        String string2 = a;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("/");
        string2 = stringArray.getName();
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        object2 = new File((String)charSequence);
        d.a((File)stringArray, (File)object2);
        stringArray = new String[n10];
        stringArray[0] = object2 = object2.getPath();
        MediaScannerConnection.scanFile((Context)object, (String[])stringArray, null, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(File object) {
        String string2 = "ShareSDK";
        Object object2 = MobSDK.getContext().getContentResolver();
        int n10 = 1;
        try {
            long l10 = System.currentTimeMillis();
            Object[] objectArray = d.a((File)object, l10);
            Object object3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            objectArray = object2.insert(object3, (ContentValues)objectArray);
            if (objectArray == null) {
                object2 = SSDKLog.b();
                objectArray = new Object[n10];
                object3 = "\u6b64\u6b3e\u673a\u578b\u62f7\u8d1d\u5230\u76f8\u518c\u5931\u8d25\uff0clocalUri is null, insert MediaStore failed\uff0c \u5c06\u4f1a\u518d\u6b21\u5c1d\u8bd5\u4e00\u4e0b\u522b\u7684\u8def\u5f84";
                objectArray[0] = object3;
                ((NLog)object2).e(string2, objectArray);
                object2 = MobSDK.getContext();
                objectArray = ((File)object).getAbsolutePath();
                d.a((Context)object2, (String)objectArray);
                object2 = SSDKLog.b();
                objectArray = new Object[n10];
                object3 = "\u522b\u7684\u8def\u5f84\u5c1d\u8bd5\u62f7\u8d1d\u5b8c\u6210";
                objectArray[0] = object3;
                ((NLog)object2).d(string2, objectArray);
                return;
            }
            int n11 = 1024;
            object3 = new byte[n11];
            Object object4 = "w";
            object2 = object2.openFileDescriptor((Uri)objectArray, (String)object4);
            object2 = object2.getFileDescriptor();
            object4 = new FileOutputStream((FileDescriptor)object2);
            object2 = new FileInputStream((File)object);
            while (true) {
                int n12;
                int n13;
                if ((n13 = ((InputStream)object2).read((byte[])object3)) == (n12 = -1)) {
                    ((InputStream)object2).close();
                    ((OutputStream)object4).flush();
                    object2 = new Intent();
                    object3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
                    object2.setAction((String)object3);
                    object2.setData((Uri)objectArray);
                    objectArray = MobSDK.getContext();
                    objectArray.sendBroadcast((Intent)object2);
                    object2 = SSDKLog.b();
                    objectArray = new Object[n10];
                    object3 = "\u89c6\u9891\u62f7\u8d1d\u5230\u76f8\u518c\u5b8c\u6210";
                    objectArray[0] = object3;
                    ((NLog)object2).d(string2, objectArray);
                    return;
                }
                ((FileOutputStream)object4).write((byte[])object3, 0, n13);
            }
        }
        catch (Throwable throwable) {
            Object[] objectArray;
            Object object5;
            try {
                object5 = MobSDK.getContext();
                object = ((File)object).getAbsolutePath();
                d.a((Context)object5, (String)object);
            }
            catch (Throwable throwable2) {
                object5 = SSDKLog.b();
                objectArray = new Object[n10];
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "\u5f02\u5e38\u5904\u7406\u4e0b\u518d\u6b21\u6267\u884c\u62f7\u8d1d\u4f9d\u7136\u5931\u8d25";
                stringBuilder.append(string3);
                stringBuilder.append(throwable2);
                objectArray[0] = object = stringBuilder.toString();
                ((NLog)object5).e(string2, objectArray);
            }
            object = SSDKLog.b();
            Object[] objectArray2 = new Object[n10];
            object5 = new StringBuilder();
            objectArray = "Failed to insert media file ";
            ((StringBuilder)object5).append((String)objectArray);
            ((StringBuilder)object5).append(throwable);
            String string4 = ((StringBuilder)object5).toString();
            objectArray2[0] = string4;
            ((NLog)object).e(string2, objectArray2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(File object, File object2) {
        String string2;
        String string3 = "ShareSDK";
        Object[] objectArray = ((File)object).getAbsolutePath();
        int n10 = (int)(objectArray.equals(string2 = ((File)object2).getAbsolutePath()) ? 1 : 0);
        if (n10 != 0) return;
        n10 = 1;
        string2 = null;
        try {
            Object object3 = new FileInputStream((File)object);
            Object[] objectArray2 = new FileOutputStream((File)object2);
            int n11 = 1024;
            Object object4 = new byte[n11];
            while (true) {
                int n12;
                if ((n12 = ((InputStream)object3).read((byte[])object4)) < 0) {
                    ((InputStream)object3).close();
                    objectArray2.close();
                    object3 = SSDKLog.b();
                    objectArray2 = new Object[n10];
                    object4 = new StringBuilder;
                    ((StringBuilder)object4)();
                    String string4 = "copyFile \u6267\u884c\u5b8c\u6bd5, src ";
                    ((StringBuilder)object4).append(string4);
                    long l10 = ((File)object).length();
                    ((StringBuilder)object4).append(l10);
                    object = " dest: ";
                    ((StringBuilder)object4).append((String)object);
                    long l11 = ((File)object2).length();
                    ((StringBuilder)object4).append(l11);
                    objectArray2[0] = object = ((StringBuilder)object4).toString();
                    ((NLog)object3).d(string3, objectArray2);
                    return;
                }
                objectArray2.write((byte[])object4, 0, n12);
            }
        }
        catch (IOException iOException) {
            object2 = SSDKLog.b();
            objectArray = new Object[n10];
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "\u62f7\u8d1d\u6587\u4ef6\u5230\u76f8\u518c\u5931\u8d25: ";
            stringBuilder.append(string5);
            stringBuilder.append(iOException);
            String string6 = stringBuilder.toString();
            objectArray[0] = string6;
            ((NLog)object2).e(string3, objectArray);
        }
    }
}

