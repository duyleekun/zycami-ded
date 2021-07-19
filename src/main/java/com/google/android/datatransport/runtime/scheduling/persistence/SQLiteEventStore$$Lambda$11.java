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

public final class SQLiteEventStore$$Lambda$11
implements SQLiteEventStore$Function {
    private final SQLiteEventStore arg$1;
    private final TransportContext arg$2;

    private SQLiteEventStore$$Lambda$11(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.arg$1 = sQLiteEventStore;
        this.arg$2 = transportContext;
    }

    public static SQLiteEventStore$Function lambdaFactory$(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        SQLiteEventStore$$Lambda$11 sQLiteEventStore$$Lambda$11 = new SQLiteEventStore$$Lambda$11(sQLiteEventStore, transportContext);
        return sQLiteEventStore$$Lambda$11;
    }

    public Object apply(Object object) {
        SQLiteEventStore sQLiteEventStore = this.arg$1;
        TransportContext transportContext = this.arg$2;
        object = (SQLiteDatabase)object;
        return SQLiteEventStore.lambda$loadBatch$7(sQLiteEventStore, transportContext, (SQLiteDatabase)object);
    }
}

