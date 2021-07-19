/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.net.Uri
 *  android.util.Log
 */
package com.huawei.agconnect.core.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import d.j.a.b;

public class AGConnectInitializeProvider
extends ContentProvider {
    public int delete(Uri uri, String string2, String[] stringArray) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Log.i((String)"AGConnectProvider", (String)"AGConnectInitializeProvider#onCreate");
        b.d(this.getContext());
        return false;
    }

    public Cursor query(Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string2, String[] stringArray) {
        return 0;
    }
}

