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

public final class SchemaManager$$Lambda$2
implements SchemaManager$Migration {
    private static final SchemaManager$$Lambda$2 instance;

    static {
        SchemaManager$$Lambda$2 schemaManager$$Lambda$2;
        instance = schemaManager$$Lambda$2 = new SchemaManager$$Lambda$2();
    }

    private SchemaManager$$Lambda$2() {
    }

    public static SchemaManager$Migration lambdaFactory$() {
        return instance;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$1(sQLiteDatabase);
    }
}

