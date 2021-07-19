/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class l
implements Function {
    public final /* synthetic */ String a;

    public /* synthetic */ l(String string2) {
        this.a = string2;
    }

    public final Object apply(Object object) {
        String string2 = this.a;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.h(string2, (SupportSQLiteDatabase)object);
    }
}

