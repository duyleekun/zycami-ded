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

public final class SchemaManager$$Lambda$4
implements SchemaManager$Migration {
    private static final SchemaManager$$Lambda$4 instance;

    static {
        SchemaManager$$Lambda$4 schemaManager$$Lambda$4;
        instance = schemaManager$$Lambda$4 = new SchemaManager$$Lambda$4();
    }

    private SchemaManager$$Lambda$4() {
    }

    public static SchemaManager$Migration lambdaFactory$() {
        return instance;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$3(sQLiteDatabase);
    }
}

