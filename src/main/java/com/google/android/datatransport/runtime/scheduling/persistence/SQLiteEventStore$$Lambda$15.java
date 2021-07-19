/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;
import java.util.List;

public final class SQLiteEventStore$$Lambda$15
implements SQLiteEventStore$Function {
    private final SQLiteEventStore arg$1;
    private final List arg$2;
    private final TransportContext arg$3;

    private SQLiteEventStore$$Lambda$15(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.arg$1 = sQLiteEventStore;
        this.arg$2 = list;
        this.arg$3 = transportContext;
    }

    public static SQLiteEventStore$Function lambdaFactory$(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        SQLiteEventStore$$Lambda$15 sQLiteEventStore$$Lambda$15 = new SQLiteEventStore$$Lambda$15(sQLiteEventStore, list, transportContext);
        return sQLiteEventStore$$Lambda$15;
    }

    public Object apply(Object object) {
        SQLiteEventStore sQLiteEventStore = this.arg$1;
        List list = this.arg$2;
        TransportContext transportContext = this.arg$3;
        object = (Cursor)object;
        return SQLiteEventStore.lambda$loadEvents$12(sQLiteEventStore, list, transportContext, (Cursor)object);
    }
}

