/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;
import java.util.Map;

public final class SQLiteEventStore$$Lambda$17
implements SQLiteEventStore$Function {
    private final Map arg$1;

    private SQLiteEventStore$$Lambda$17(Map map) {
        this.arg$1 = map;
    }

    public static SQLiteEventStore$Function lambdaFactory$(Map map) {
        SQLiteEventStore$$Lambda$17 sQLiteEventStore$$Lambda$17 = new SQLiteEventStore$$Lambda$17(map);
        return sQLiteEventStore$$Lambda$17;
    }

    public Object apply(Object object) {
        Map map = this.arg$1;
        object = (Cursor)object;
        return SQLiteEventStore.lambda$loadMetadata$14(map, (Cursor)object);
    }
}

