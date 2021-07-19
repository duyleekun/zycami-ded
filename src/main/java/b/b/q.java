/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class q
implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ q(int n10) {
        this.a = n10;
    }

    public final Object apply(Object object) {
        int n10 = this.a;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.n0(n10, (SupportSQLiteDatabase)object);
    }
}

