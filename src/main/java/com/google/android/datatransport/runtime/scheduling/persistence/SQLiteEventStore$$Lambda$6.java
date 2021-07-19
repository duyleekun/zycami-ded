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

public final class SQLiteEventStore$$Lambda$6
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$6 instance;

    static {
        SQLiteEventStore$$Lambda$6 sQLiteEventStore$$Lambda$6;
        instance = sQLiteEventStore$$Lambda$6 = new SQLiteEventStore$$Lambda$6();
    }

    private SQLiteEventStore$$Lambda$6() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$getTransportContextId$2((Cursor)object);
    }
}

