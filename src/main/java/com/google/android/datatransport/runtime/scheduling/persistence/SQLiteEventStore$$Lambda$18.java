/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Producer;

public final class SQLiteEventStore$$Lambda$18
implements SQLiteEventStore$Producer {
    private final SQLiteDatabase arg$1;

    private SQLiteEventStore$$Lambda$18(SQLiteDatabase sQLiteDatabase) {
        this.arg$1 = sQLiteDatabase;
    }

    public static SQLiteEventStore$Producer lambdaFactory$(SQLiteDatabase sQLiteDatabase) {
        SQLiteEventStore$$Lambda$18 sQLiteEventStore$$Lambda$18 = new SQLiteEventStore$$Lambda$18(sQLiteDatabase);
        return sQLiteEventStore$$Lambda$18;
    }

    public Object produce() {
        return SQLiteEventStore.lambda$ensureBeginTransaction$15(this.arg$1);
    }
}

