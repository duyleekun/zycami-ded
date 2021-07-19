/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 */
package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper;

public class FrameworkSQLiteOpenHelper$OpenHelper$1
implements DatabaseErrorHandler {
    public final /* synthetic */ SupportSQLiteOpenHelper$Callback val$callback;
    public final /* synthetic */ FrameworkSQLiteDatabase[] val$dbRef;

    public FrameworkSQLiteOpenHelper$OpenHelper$1(SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback, FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray) {
        this.val$callback = supportSQLiteOpenHelper$Callback;
        this.val$dbRef = frameworkSQLiteDatabaseArray;
    }

    public void onCorruption(SQLiteDatabase object) {
        SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.val$callback;
        object = FrameworkSQLiteOpenHelper$OpenHelper.getWrappedDb(this.val$dbRef, object);
        supportSQLiteOpenHelper$Callback.onCorruption((SupportSQLiteDatabase)object);
    }
}

