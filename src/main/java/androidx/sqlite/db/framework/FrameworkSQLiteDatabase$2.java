/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteCursor
 *  android.database.sqlite.SQLiteCursorDriver
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteQuery
 */
package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;

public class FrameworkSQLiteDatabase$2
implements SQLiteDatabase.CursorFactory {
    public final /* synthetic */ FrameworkSQLiteDatabase this$0;
    public final /* synthetic */ SupportSQLiteQuery val$supportQuery;

    public FrameworkSQLiteDatabase$2(FrameworkSQLiteDatabase frameworkSQLiteDatabase, SupportSQLiteQuery supportSQLiteQuery) {
        this.this$0 = frameworkSQLiteDatabase;
        this.val$supportQuery = supportSQLiteQuery;
    }

    public Cursor newCursor(SQLiteDatabase object, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
        object = this.val$supportQuery;
        FrameworkSQLiteProgram frameworkSQLiteProgram = new FrameworkSQLiteProgram((SQLiteProgram)sQLiteQuery);
        object.bindTo(frameworkSQLiteProgram);
        object = new SQLiteCursor(sQLiteCursorDriver, string2, sQLiteQuery);
        return object;
    }
}

