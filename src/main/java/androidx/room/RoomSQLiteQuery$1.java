/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteProgram;

public class RoomSQLiteQuery$1
implements SupportSQLiteProgram {
    public final /* synthetic */ RoomSQLiteQuery val$query;

    public RoomSQLiteQuery$1(RoomSQLiteQuery roomSQLiteQuery) {
        this.val$query = roomSQLiteQuery;
    }

    public void bindBlob(int n10, byte[] byArray) {
        this.val$query.bindBlob(n10, byArray);
    }

    public void bindDouble(int n10, double d10) {
        this.val$query.bindDouble(n10, d10);
    }

    public void bindLong(int n10, long l10) {
        this.val$query.bindLong(n10, l10);
    }

    public void bindNull(int n10) {
        this.val$query.bindNull(n10);
    }

    public void bindString(int n10, String string2) {
        this.val$query.bindString(n10, string2);
    }

    public void clearBindings() {
        this.val$query.clearBindings();
    }

    public void close() {
    }
}

