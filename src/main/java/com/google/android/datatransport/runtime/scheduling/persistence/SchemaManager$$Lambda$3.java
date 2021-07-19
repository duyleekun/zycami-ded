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

public final class SchemaManager$$Lambda$3
implements SchemaManager$Migration {
    private static final SchemaManager$$Lambda$3 instance;

    static {
        SchemaManager$$Lambda$3 schemaManager$$Lambda$3;
        instance = schemaManager$$Lambda$3 = new SchemaManager$$Lambda$3();
    }

    private SchemaManager$$Lambda$3() {
    }

    public static SchemaManager$Migration lambdaFactory$() {
        return instance;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$2(sQLiteDatabase);
    }
}

