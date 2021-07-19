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

public final class SQLiteEventStore$$Lambda$13
implements SQLiteEventStore$Function {
    private final long arg$1;

    private SQLiteEventStore$$Lambda$13(long l10) {
        this.arg$1 = l10;
    }

    public static SQLiteEventStore$Function lambdaFactory$(long l10) {
        SQLiteEventStore$$Lambda$13 sQLiteEventStore$$Lambda$13 = new SQLiteEventStore$$Lambda$13(l10);
        return sQLiteEventStore$$Lambda$13;
    }

    public Object apply(Object object) {
        long l10 = this.arg$1;
        object = (SQLiteDatabase)object;
        return SQLiteEventStore.lambda$cleanUp$10(l10, (SQLiteDatabase)object);
    }
}

