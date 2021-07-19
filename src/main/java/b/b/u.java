/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class u
implements Function {
    public final /* synthetic */ AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement a;
    public final /* synthetic */ Function b;

    public /* synthetic */ u(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement autoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement, Function function) {
        this.a = autoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;
        this.b = function;
    }

    public final Object apply(Object object) {
        AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement autoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement = this.a;
        Function function = this.b;
        object = (SupportSQLiteDatabase)object;
        return autoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement.q(function, (SupportSQLiteDatabase)object);
    }
}

