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
package com.huawei.hms.update.provider;

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
import com.huawei.hms.availableupdate.l;
import java.io.File;

public class UpdateProvider
extends ContentProvider {
    public static final String AUTHORITIES_SUFFIX = ".hms.update.provider";
    public static final String[] a;
    public static l b;

    static {
        l l10;
        a = new String[]{"_display_name", "_size"};
        b = l10 = new l();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(String string2) {
        Object object = "r";
        boolean bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x10000000;
        }
        object = "w";
        bl2 = ((String)object).equals(string2);
        if (bl2) return 0x2C000000;
        object = "wt";
        bl2 = ((String)object).equals(string2);
        if (bl2) return 0x2C000000;
        object = "wa";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x2A000000;
        }
        object = "rw";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x38000000;
        }
        object = "rwt";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x3C000000;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid mode: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static Object[] a(Object[] objectArray, int n10) {
        Object[] objectArray2 = new Object[n10];
        System.arraycopy(objectArray, 0, objectArray2, 0, n10);
        return objectArray2;
    }

    public static String[] a(String[] stringArray, int n10) {
        String[] stringArray2 = new String[n10];
        System.arraycopy(stringArray, 0, stringArray2, 0, n10);
        return stringArray2;
    }

    public static File getLocalFile(Context context, String string2) {
        l l10 = b;
        context = context.getApplicationContext();
        l10.a(context);
        return b.a(string2);
    }

    public static Uri getUriForFile(Context context, String string2, File file) {
        l l10 = b;
        context = context.getApplicationContext();
        l10.a(context);
        return b.a(file, string2);
    }

    public void attachInfo(Context object, ProviderInfo providerInfo) {
        super.attachInfo(object, providerInfo);
        boolean bl2 = providerInfo.exported;
        if (!bl2) {
            bl2 = providerInfo.grantUriPermissions;
            if (bl2) {
                return;
            }
            object = new SecurityException("Provider must grant uri permissions");
            throw object;
        }
        object = new SecurityException("Provider must not be exported");
        throw object;
    }

    public int delete(Uri uri, String object, String[] context) {
        object = b;
        context = this.getContext().getApplicationContext();
        ((l)object).a(context);
        return (int)(b.a(uri).delete() ? 1 : 0);
    }

    public String getType(Uri object) {
        Object object2 = this.getContext();
        String string2 = "application/octet-stream";
        if (object2 == null) {
            return string2;
        }
        object2 = b;
        Context context = this.getContext().getApplicationContext();
        ((l)object2).a(context);
        object2 = b;
        object = ((l)object2).a((Uri)object).getName();
        int n10 = ((String)object).lastIndexOf(46);
        if (n10 >= 0) {
            object = ((String)object).substring(++n10);
            object2 = MimeTypeMap.getSingleton();
            object = object2.getMimeTypeFromExtension((String)object);
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 == 0) {
                return object;
            }
        }
        return string2;
    }

    public Uri insert(Uri object, ContentValues contentValues) {
        object = new UnsupportedOperationException("No external inserts");
        throw object;
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri object, String string2) {
        l l10 = b;
        Context context = this.getContext().getApplicationContext();
        l10.a(context);
        object = b.a((Uri)object);
        int n10 = UpdateProvider.a(string2);
        return ParcelFileDescriptor.open((File)object, (int)n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Cursor query(Uri stringArray, String[] objectArray, String object, String[] objectArray2, String string2) {
        object = b;
        objectArray2 = this.getContext().getApplicationContext();
        ((l)object).a((Context)objectArray2);
        object = b;
        stringArray = ((l)object).a((Uri)stringArray);
        if (objectArray == null) {
            objectArray = a;
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
                            stringArray = UpdateProvider.a((String[])object, n14);
                            objectArray = UpdateProvider.a(objectArray2, n14);
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

