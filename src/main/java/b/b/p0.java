/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class p0
implements Function {
    public final /* synthetic */ RoomDatabase a;

    public /* synthetic */ p0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public final Object apply(Object object) {
        RoomDatabase roomDatabase = this.a;
        object = (SupportSQLiteDatabase)object;
        return roomDatabase.b((SupportSQLiteDatabase)object);
    }
}

