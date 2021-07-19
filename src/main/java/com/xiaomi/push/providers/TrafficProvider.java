/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.UriMatcher
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.net.Uri
 */
package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.xiaomi.push.gx;
import com.xiaomi.push.providers.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class TrafficProvider
extends ContentProvider {
    private static final UriMatcher a;
    public static final Uri a;
    private SQLiteOpenHelper a;

    static {
        UriMatcher uriMatcher;
        a = Uri.parse((String)"content://com.xiaomi.push.providers.TrafficProvider/traffic");
        a = uriMatcher = new UriMatcher(-1);
        String string2 = "com.xiaomi.push.providers.TrafficProvider";
        uriMatcher.addURI(string2, "traffic", 1);
        uriMatcher.addURI(string2, "update_imsi", 2);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArray) {
        return 0;
    }

    public int delete(Uri uri, String string2, String[] stringArray) {
        return 0;
    }

    public String getType(Uri object) {
        int n10;
        Object object2 = a;
        int n11 = object2.match(object);
        if (n11 == (n10 = 1)) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown URI ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Context context = this.getContext();
        a a10 = new a(context);
        this.a = a10;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Cursor query(Uri object, String[] stringArray, String charSequence, String[] stringArray2, String string2) {
        Object object2 = com.xiaomi.push.providers.a.a;
        synchronized (object2) {
            UriMatcher uriMatcher = a;
            int n10 = uriMatcher.match(object);
            int n11 = 1;
            if (n10 == n11) {
                object = this.a;
                uriMatcher = object.getReadableDatabase();
                String string3 = "traffic";
                return uriMatcher.query(string3, stringArray, (String)charSequence, stringArray2, null, null, string2);
            }
            charSequence = new StringBuilder();
            stringArray2 = "Unknown URI ";
            ((StringBuilder)charSequence).append((String)stringArray2);
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            stringArray = new IllegalArgumentException((String)object);
            throw stringArray;
        }
    }

    public int update(Uri object, ContentValues contentValues, String string2, String[] stringArray) {
        int n10;
        string2 = a;
        int n11 = string2.match(object);
        if (n11 == (n10 = 2) && contentValues != null && (n10 = (int)(contentValues.containsKey((String)(object = "imsi")) ? 1 : 0)) != 0) {
            object = contentValues.getAsString((String)object);
            gx.a((String)object);
        }
        return 0;
    }
}

