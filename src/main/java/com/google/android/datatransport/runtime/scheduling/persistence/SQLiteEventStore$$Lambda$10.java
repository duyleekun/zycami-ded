/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;

public final class SQLiteEventStore$$Lambda$10
implements SQLiteEventStore$Function {
    private final long arg$1;
    private final TransportContext arg$2;

    private SQLiteEventStore$$Lambda$10(long l10, TransportContext transportContext) {
        this.arg$1 = l10;
        this.arg$2 = transportContext;
    }

    public static SQLiteEventStore$Function lambdaFactory$(long l10, TransportContext transportContext) {
        SQLiteEventStore$$Lambda$10 sQLiteEventStore$$Lambda$10 = new SQLiteEventStore$$Lambda$10(l10, transportContext);
        return sQLiteEventStore$$Lambda$10;
    }

    public Object apply(Object object) {
        long l10 = this.arg$1;
        TransportContext transportContext = this.arg$2;
        object = (SQLiteDatabase)object;
        return SQLiteEventStore.lambda$recordNextCallTime$6(l10, transportContext, (SQLiteDatabase)object);
    }
}

