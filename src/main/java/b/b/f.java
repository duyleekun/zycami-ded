/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class f
implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ f(String string2, Object[] objectArray) {
        this.a = string2;
        this.b = objectArray;
    }

    public final Object apply(Object object) {
        String string2 = this.a;
        Object[] objectArray = this.b;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.q(string2, objectArray, (SupportSQLiteDatabase)object);
    }
}

