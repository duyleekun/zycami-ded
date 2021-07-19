/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

public interface AutoMigrationCallback {
    default public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }
}

