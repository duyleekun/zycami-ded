/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  android.text.TextUtils
 */
package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class PushProvider
extends ContentProvider {
    public int delete(Uri uri, String string2, String[] stringArray) {
        return 0;
    }

    public String getType(Uri object) {
        String string2;
        boolean bl2 = ((String)(object = object.toString())).endsWith(string2 = ".xml");
        if (bl2) {
            return "xml";
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public ParcelFileDescriptor openFile(Uri object, String object2) {
        object2 = "PushProvider";
        HMSLog.i((String)object2, "use sdk PushProvider openFile");
        Object object3 = this.getType((Uri)object);
        String string2 = "xml";
        int n10 = string2.equals(object3);
        if (n10 != 0) {
            int n11 = Build.VERSION.SDK_INT;
            n10 = 24;
            int n12 = 0x10000000;
            String string3 = "/shared_prefs/push_notify_flag.xml";
            if (n11 >= n10) {
                object3 = new StringBuilder();
                Object object4 = this.getContext();
                Objects.requireNonNull(object4);
                object4 = object4.createDeviceProtectedStorageContext().getDataDir();
                ((StringBuilder)object3).append(object4);
                ((StringBuilder)object3).append(string3);
                object3 = ((StringBuilder)object3).toString();
                object2 = new File((String)object3);
                n10 = (int)(((File)object2).exists() ? 1 : 0);
                if (n10 != 0) {
                    return ParcelFileDescriptor.open((File)object2, (int)n12);
                }
                object3 = new StringBuilder();
                object4 = this.getContext().getDataDir();
                ((StringBuilder)object3).append(object4);
                ((StringBuilder)object3).append(string3);
                object3 = ((StringBuilder)object3).toString();
                object2 = new File((String)object3);
                n10 = (int)(((File)object2).exists() ? 1 : 0);
                if (n10 != 0) {
                    return ParcelFileDescriptor.open((File)object2, (int)n12);
                }
            } else {
                object2 = new StringBuilder();
                object3 = this.getContext().getFilesDir();
                ((StringBuilder)object2).append(object3);
                object3 = "";
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (n10 == 0) {
                    object3 = new StringBuilder();
                    int n13 = ((String)object2).length() + -6;
                    object2 = ((String)object2).substring(0, n13);
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append(string3);
                    object2 = ((StringBuilder)object3).toString();
                    object3 = new File((String)object2);
                    n11 = (int)(((File)object3).exists() ? 1 : 0);
                    if (n11 != 0) {
                        return ParcelFileDescriptor.open((File)object3, (int)n12);
                    }
                }
            }
            object = object.getPath();
            object2 = new FileNotFoundException((String)object);
            throw object2;
        }
        HMSLog.w((String)object2, "Incorrect file uri");
        object = object.getPath();
        object2 = new FileNotFoundException((String)object);
        throw object2;
    }

    public Cursor query(Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string2, String[] stringArray) {
        return 0;
    }
}

