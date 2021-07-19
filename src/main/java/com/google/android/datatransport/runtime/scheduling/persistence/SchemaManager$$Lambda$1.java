/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$Migration;

public final class SchemaManager$$Lambda$1
implements SchemaManager$Migration {
    private static final SchemaManager$$Lambda$1 instance;

    static {
        SchemaManager$$Lambda$1 schemaManager$$Lambda$1;
        instance = schemaManager$$Lambda$1 = new SchemaManager$$Lambda$1();
    }

    private SchemaManager$$Lambda$1() {
    }

    public static SchemaManager$Migration lambdaFactory$() {
        return instance;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$0(sQLiteDatabase);
    }
}

