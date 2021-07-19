/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.sqlite.SQLiteDatabase
 */
package d.o.a.a.b.c.f;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.quvideo.mobile.external.platform.uploader.db.OooO;
import d.o.a.a.b.c.f.a;

public abstract class b
implements a {
    public SQLiteDatabase OooO00o;

    public b() {
        SQLiteDatabase sQLiteDatabase;
        this.OooO00o = sQLiteDatabase = OooO.OooO00o().getWritableDatabase();
    }

    public void OooO00o() {
        this.OooO00o.beginTransaction();
    }

    public long OooO0O0(Object object) {
        SQLiteDatabase sQLiteDatabase = this.OooO00o;
        String string2 = this.OooO0OO();
        object = this.OooO00o(object);
        return sQLiteDatabase.replace(string2, null, (ContentValues)object);
    }

    public void OooO0O0() {
        this.OooO00o.endTransaction();
    }

    public abstract String OooO0OO();

    public void OooO0Oo() {
        this.OooO00o.setTransactionSuccessful();
    }
}

