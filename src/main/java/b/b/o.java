/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 */
package b.b;

import android.content.ContentValues;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class o
implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ContentValues c;

    public /* synthetic */ o(String string2, int n10, ContentValues contentValues) {
        this.a = string2;
        this.b = n10;
        this.c = contentValues;
    }

    public final Object apply(Object object) {
        String string2 = this.a;
        int n10 = this.b;
        ContentValues contentValues = this.c;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.B(string2, n10, contentValues, (SupportSQLiteDatabase)object);
    }
}

