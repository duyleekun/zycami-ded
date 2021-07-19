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

public final class SQLiteEventStore$$Lambda$20
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$20 instance;

    static {
        SQLiteEventStore$$Lambda$20 sQLiteEventStore$$Lambda$20;
        instance = sQLiteEventStore$$Lambda$20 = new SQLiteEventStore$$Lambda$20();
    }

    private SQLiteEventStore$$Lambda$20() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$loadActiveContexts$8((Cursor)object);
    }
}

