/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class p
implements Function {
    public static final /* synthetic */ p a;

    static {
        p p10;
        a = p10 = new p();
    }

    public final Object apply(Object object) {
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.C((SupportSQLiteDatabase)object);
    }
}

