/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class r
implements Function {
    public static final /* synthetic */ r a;

    static {
        r r10;
        a = r10 = new r();
    }

    public final Object apply(Object object) {
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.E((SupportSQLiteDatabase)object);
    }
}

