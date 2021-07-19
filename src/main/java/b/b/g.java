/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class g
implements Function {
    public final /* synthetic */ boolean a;

    public /* synthetic */ g(boolean bl2) {
        this.a = bl2;
    }

    public final Object apply(Object object) {
        boolean bl2 = this.a;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.O(bl2, (SupportSQLiteDatabase)object);
    }
}

