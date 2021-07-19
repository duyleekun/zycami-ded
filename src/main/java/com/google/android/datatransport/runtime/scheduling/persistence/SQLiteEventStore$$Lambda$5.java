/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;

public final class SQLiteEventStore$$Lambda$5
implements SQLiteEventStore$Function {
    private final SQLiteEventStore arg$1;
    private final TransportContext arg$2;
    private final EventInternal arg$3;

    private SQLiteEventStore$$Lambda$5(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        this.arg$1 = sQLiteEventStore;
        this.arg$2 = transportContext;
        this.arg$3 = eventInternal;
    }

    public static SQLiteEventStore$Function lambdaFactory$(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        SQLiteEventStore$$Lambda$5 sQLiteEventStore$$Lambda$5 = new SQLiteEventStore$$Lambda$5(sQLiteEventStore, transportContext, eventInternal);
        return sQLiteEventStore$$Lambda$5;
    }

    public Object apply(Object object) {
        SQLiteEventStore sQLiteEventStore = this.arg$1;
        TransportContext transportContext = this.arg$2;
        EventInternal eventInternal = this.arg$3;
        object = (SQLiteDatabase)object;
        return SQLiteEventStore.lambda$persist$1(sQLiteEventStore, transportContext, eventInternal, (SQLiteDatabase)object);
    }
}

