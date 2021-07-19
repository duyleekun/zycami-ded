/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.database.MatrixCursor
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  android.text.TextUtils
 *  android.webkit.MimeTypeMap
 */
package com.huawei.updatesdk.fileprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.huawei.updatesdk.fileprovider.a;
import com.huawei.updatesdk.fileprovider.b;
import java.io.File;

public class UpdateSdkFileProvider
extends ContentProvider {
    public static final String AUTHORITIES_SUFFIX = ".updateSdk.fileProvider";
    private static final String[] COLUMNS = new String[]{"_display_name", "_size"};
    private static final String TAG = "UpdateSdkFileProvider";
    private static a mWStrategy;
    private String authority;

    private static File buildPath(File file, String ... stringArray) {
        for (String string2 : stringArray) {
            File file2;
            if (string2 == null) continue;
            file = file2 = new File(file, string2);
        }
        return file;
    }

    private static Object[] copyOf(Object[] objectArray, int n10) {
        Object[] objectArray2 = new Object[n10];
        System.arraycopy(objectArray, 0, objectArray2, 0, n10);
        return objectArray2;
    }

    private static String[] copyOf(String[] stringArray, int n10) {
        String[] stringArray2 = new String[n10];
        System.arraycopy(stringArray, 0, stringArray2, 0, n10);
        return stringArray2;
    }

    private static a createWiseDistPathStrategy(Context object, String object2) {
        Class<UpdateSdkFileProvider> clazz = UpdateSdkFileProvider.class;
        synchronized (clazz) {
            Object object3 = mWStrategy;
            if (object3 == null) {
                object3 = new b((String)object2);
                mWStrategy = object3;
                object2 = object.getFilesDir();
                if (object2 != null) {
                    object = object.getFilesDir();
                    object2 = "/";
                    object2 = new String[]{object2};
                    object = UpdateSdkFileProvider.buildPath((File)object, (String[])object2);
                    object2 = mWStrategy;
                    object3 = "updatesdkapk";
                    object2.a((String)object3, (File)object);
                }
            }
            object = mWStrategy;
            return object;
        }
    }

    public static Uri getUriForFile(Context context, String string2, File file) {
        UpdateSdkFileProvider.createWiseDistPathStrategy(context, string2);
        return mWStrategy.a(file);
    }

    public void attachInfo(Context object, ProviderInfo object2) {
        super.attachInfo(object, object2);
        boolean bl2 = object2.exported;
        if (!bl2) {
            bl2 = object2.grantUriPermissions;
            if (bl2) {
                object2 = object2.authority;
                this.authority = object2;
                UpdateSdkFileProvider.createWiseDistPathStrategy(object, (String)object2);
                return;
            }
            object = new SecurityException("WiseDist Provider must grant uri permissions");
            throw object;
        }
        object = new SecurityException("WiseDist Provider must not be exported");
        throw object;
    }

    public int delete(Uri object, String string2, String[] stringArray) {
        object = new UnsupportedOperationException("No external updates");
        throw object;
    }

    public String getType(Uri object) {
        boolean bl2;
        String string2;
        boolean bl3;
        if (object != null && !(bl3 = TextUtils.isEmpty((CharSequence)(string2 = object.toString()))) && (bl2 = ((String)(object = object.toString())).endsWith(string2 = "apk")) && (object = MimeTypeMap.getSingleton().getMimeTypeFromExtension(string2)) != null) {
            return object;
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri object, ContentValues contentValues) {
        object = new UnsupportedOperationException("No external inserts");
        throw object;
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri object, String string2) {
        String string3;
        boolean bl2;
        if (object == null) {
            return null;
        }
        String string4 = object.getAuthority();
        if (string4 != null && (bl2 = (string4 = object.getAuthority()).equals(string3 = this.authority))) {
            string4 = ((File)(object = mWStrategy.a((Uri)object))).getName();
            bl2 = string4.endsWith(string3 = "apk");
            if (!bl2) {
                com.huawei.updatesdk.a.a.c.a.a.a.b(TAG, "can not open this file.");
                return null;
            }
            return ParcelFileDescriptor.open((File)object, (int)0x10000000);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Cursor query(Uri stringArray, String[] objectArray, String object, String[] objectArray2, String string2) {
        object = mWStrategy;
        stringArray = object.a((Uri)stringArray);
        if (objectArray == null) {
            objectArray = COLUMNS;
        }
        int n10 = objectArray.length;
        object = new String[n10];
        int n11 = objectArray.length;
        objectArray2 = new Object[n11];
        int n12 = objectArray.length;
        int n13 = 0;
        int n14 = 0;
        while (true) {
            block8: {
                int n15;
                block7: {
                    Object object2;
                    Object object3;
                    block6: {
                        if (n13 >= n12) {
                            stringArray = UpdateSdkFileProvider.copyOf((String[])object, n14);
                            objectArray = UpdateSdkFileProvider.copyOf(objectArray2, n14);
                            object = new MatrixCursor(stringArray, 1);
                            object.addRow(objectArray);
                            return object;
                        }
                        object3 = "_display_name";
                        object2 = objectArray[n13];
                        boolean bl2 = ((String)object3).equals(object2);
                        if (!bl2) break block6;
                        object[n14] = object3;
                        n15 = n14 + 1;
                        objectArray2[n14] = object3 = stringArray.getName();
                        break block7;
                    }
                    object3 = "_size";
                    n15 = ((String)object3).equals(object2);
                    if (n15 == 0) break block8;
                    object[n14] = object3;
                    n15 = n14 + 1;
                    long l10 = stringArray.length();
                    objectArray2[n14] = object3 = Long.valueOf(l10);
                }
                n14 = n15;
            }
            ++n13;
        }
    }

    public int update(Uri object, ContentValues contentValues, String string2, String[] stringArray) {
        object = new UnsupportedOperationException("No external updates");
        throw object;
    }
}

