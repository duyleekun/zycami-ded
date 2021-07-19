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

public final class SQLiteEventStore$$Lambda$9
implements SQLiteEventStore$Function {
    private final SQLiteEventStore arg$1;
    private final TransportContext arg$2;

    private SQLiteEventStore$$Lambda$9(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.arg$1 = sQLiteEventStore;
        this.arg$2 = transportContext;
    }

    public static SQLiteEventStore$Function lambdaFactory$(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        SQLiteEventStore$$Lambda$9 sQLiteEventStore$$Lambda$9 = new SQLiteEventStore$$Lambda$9(sQLiteEventStore, transportContext);
        return sQLiteEventStore$$Lambda$9;
    }

    public Object apply(Object object) {
        SQLiteEventStore sQLiteEventStore = this.arg$1;
        TransportContext transportContext = this.arg$2;
        object = (SQLiteDatabase)object;
        return SQLiteEventStore.lambda$hasPendingEventsFor$5(sQLiteEventStore, transportContext, (SQLiteDatabase)object);
    }
}

