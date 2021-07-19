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

public final class SQLiteEventStore$$Lambda$16
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$16 instance;

    static {
        SQLiteEventStore$$Lambda$16 sQLiteEventStore$$Lambda$16;
        instance = sQLiteEventStore$$Lambda$16 = new SQLiteEventStore$$Lambda$16();
    }

    private SQLiteEventStore$$Lambda$16() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$readPayload$13((Cursor)object);
    }
}

