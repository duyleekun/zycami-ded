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

public final class SQLiteEventStore$$Lambda$7
implements SQLiteEventStore$Function {
    private final String arg$1;

    private SQLiteEventStore$$Lambda$7(String string2) {
        this.arg$1 = string2;
    }

    public static SQLiteEventStore$Function lambdaFactory$(String string2) {
        SQLiteEventStore$$Lambda$7 sQLiteEventStore$$Lambda$7 = new SQLiteEventStore$$Lambda$7(string2);
        return sQLiteEventStore$$Lambda$7;
    }

    public Object apply(Object object) {
        String string2 = this.arg$1;
        object = (SQLiteDatabase)object;
        return SQLiteEventStore.lambda$recordFailure$3(string2, (SQLiteDatabase)object);
    }
}

