/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;

public final class SQLiteEventStore$$Lambda$19
implements SQLiteEventStore$Function {
    private static final SQLiteEventStore$$Lambda$19 instance;

    static {
        SQLiteEventStore$$Lambda$19 sQLiteEventStore$$Lambda$19;
        instance = sQLiteEventStore$$Lambda$19 = new SQLiteEventStore$$Lambda$19();
    }

    private SQLiteEventStore$$Lambda$19() {
    }

    public static SQLiteEventStore$Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return SQLiteEventStore.lambda$ensureBeginTransaction$16((Throwable)object);
    }
}

