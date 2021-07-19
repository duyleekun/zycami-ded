/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Producer;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

public final class SQLiteEventStore$$Lambda$1
implements SQLiteEventStore$Producer {
    private final SchemaManager arg$1;

    private SQLiteEventStore$$Lambda$1(SchemaManager schemaManager) {
        this.arg$1 = schemaManager;
    }

    public static SQLiteEventStore$Producer lambdaFactory$(SchemaManager schemaManager) {
        SQLiteEventStore$$Lambda$1 sQLiteEventStore$$Lambda$1 = new SQLiteEventStore$$Lambda$1(schemaManager);
        return sQLiteEventStore$$Lambda$1;
    }

    public Object produce() {
        return this.arg$1.getWritableDatabase();
    }
}

