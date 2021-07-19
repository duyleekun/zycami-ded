/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;

public final class SQLiteEventStore$$Lambda$8
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$8 instance;

    static {
        SQLiteEventStore$$Lambda$8 sQLiteEventStore$$Lambda$8;
        instance = sQLiteEventStore$$Lambda$8 = new SQLiteEventStore$$Lambda$8();
    }

    private SQLiteEventStore$$Lambda$8() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$getNextCallTime$4((Cursor)object);
    }
}

