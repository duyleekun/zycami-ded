/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int n10, int n11) {
        this.startVersion = n10;
        this.endVersion = n11;
    }

    public abstract void migrate(SupportSQLiteDatabase var1);
}

