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

public final class SQLiteEventStore$$Lambda$12
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$12 instance;

    static {
        SQLiteEventStore$$Lambda$12 sQLiteEventStore$$Lambda$12;
        instance = sQLiteEventStore$$Lambda$12 = new SQLiteEventStore$$Lambda$12();
    }

    private SQLiteEventStore$$Lambda$12() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$loadActiveContexts$9((SQLiteDatabase)object);
    }
}

