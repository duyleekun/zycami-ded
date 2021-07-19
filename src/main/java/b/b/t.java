/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

public final class t
implements Function {
    public static final /* synthetic */ t a;

    static {
        t t10;
        a = t10 = new t();
    }

    public final Object apply(Object object) {
        return AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement.a((SupportSQLiteStatement)object);
    }
}

