/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class m
implements Function {
    public final /* synthetic */ long a;

    public /* synthetic */ m(long l10) {
        this.a = l10;
    }

    public final Object apply(Object object) {
        long l10 = this.a;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.o0(l10, (SupportSQLiteDatabase)object);
    }
}

