/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;

public final class SQLiteEventStore$$Lambda$14
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$14 instance;

    static {
        SQLiteEventStore$$Lambda$14 sQLiteEventStore$$Lambda$14;
        instance = sQLiteEventStore$$Lambda$14 = new SQLiteEventStore$$Lambda$14();
    }

    private SQLiteEventStore$$Lambda$14() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$clearDb$11((SQLiteDatabase)object);
    }
}

