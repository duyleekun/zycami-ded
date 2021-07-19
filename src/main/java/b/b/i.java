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

public final class i
implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ContentValues c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object[] e;

    public /* synthetic */ i(String string2, int n10, ContentValues contentValues, String string3, Object[] objectArray) {
        this.a = string2;
        this.b = n10;
        this.c = contentValues;
        this.d = string3;
        this.e = objectArray;
    }

    public final Object apply(Object object) {
        String string2 = this.a;
        int n10 = this.b;
        ContentValues contentValues = this.c;
        String string3 = this.d;
        Object[] objectArray = this.e;
        Object object2 = object;
        object2 = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.r0(string2, n10, contentValues, string3, objectArray, (SupportSQLiteDatabase)object2);
    }
}

