/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomOpenHelper$ValidationResult;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class RoomOpenHelper$Delegate {
    public final int version;

    public RoomOpenHelper$Delegate(int n10) {
        this.version = n10;
    }

    public abstract void createAllTables(SupportSQLiteDatabase var1);

    public abstract void dropAllTables(SupportSQLiteDatabase var1);

    public abstract void onCreate(SupportSQLiteDatabase var1);

    public abstract void onOpen(SupportSQLiteDatabase var1);

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public RoomOpenHelper$ValidationResult onValidateSchema(SupportSQLiteDatabase object) {
        this.validateMigration((SupportSQLiteDatabase)object);
        object = new RoomOpenHelper$ValidationResult(true, null);
        return object;
    }

    public void validateMigration(SupportSQLiteDatabase object) {
        object = new UnsupportedOperationException("validateMigration is deprecated");
        throw object;
    }
}

