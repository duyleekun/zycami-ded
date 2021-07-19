/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class j
implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object[] c;

    public /* synthetic */ j(String string2, String string3, Object[] objectArray) {
        this.a = string2;
        this.b = string3;
        this.c = objectArray;
    }

    public final Object apply(Object object) {
        String string2 = this.a;
        String string3 = this.b;
        Object[] objectArray = this.c;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.a(string2, string3, objectArray, (SupportSQLiteDatabase)object);
    }
}

