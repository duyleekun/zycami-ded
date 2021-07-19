/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;

public final class SQLiteEventStore$$Lambda$4
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$4 instance;

    static {
        SQLiteEventStore$$Lambda$4 sQLiteEventStore$$Lambda$4;
        instance = sQLiteEventStore$$Lambda$4 = new SQLiteEventStore$$Lambda$4();
    }

    private SQLiteEventStore$$Lambda$4() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$getDb$0((Throwable)object);
    }
}

