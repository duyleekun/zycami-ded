/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;

public final class SQLiteEventStore$$Lambda$21
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$21 instance;

    static {
        SQLiteEventStore$$Lambda$21 sQLiteEventStore$$Lambda$21;
        instance = sQLiteEventStore$$Lambda$21 = new SQLiteEventStore$$Lambda$21();
    }

    private SQLiteEventStore$$Lambda$21() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return ((Cursor)object).moveToNext();
    }
}

