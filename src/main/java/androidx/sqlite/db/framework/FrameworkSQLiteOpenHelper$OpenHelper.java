/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 */
package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$1;

public class FrameworkSQLiteOpenHelper$OpenHelper
extends SQLiteOpenHelper {
    public final SupportSQLiteOpenHelper$Callback mCallback;
    public final FrameworkSQLiteDatabase[] mDbRef;
    private boolean mMigrated;

    public FrameworkSQLiteOpenHelper$OpenHelper(Context context, String string2, FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray, SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        int n10 = supportSQLiteOpenHelper$Callback.version;
        FrameworkSQLiteOpenHelper$OpenHelper$1 frameworkSQLiteOpenHelper$OpenHelper$1 = new FrameworkSQLiteOpenHelper$OpenHelper$1(supportSQLiteOpenHelper$Callback, frameworkSQLiteDatabaseArray);
        super(context, string2, null, n10, (DatabaseErrorHandler)frameworkSQLiteOpenHelper$OpenHelper$1);
        this.mCallback = supportSQLiteOpenHelper$Callback;
        this.mDbRef = frameworkSQLiteDatabaseArray;
    }

    public static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray, SQLiteDatabase sQLiteDatabase) {
        boolean bl2;
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArray[0];
        if (frameworkSQLiteDatabase == null || !(bl2 = frameworkSQLiteDatabase.isDelegate(sQLiteDatabase))) {
            frameworkSQLiteDatabaseArray[0] = frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
        }
        return frameworkSQLiteDatabaseArray[0];
    }

    public void close() {
        synchronized (this) {
            super.close();
            FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray = this.mDbRef;
            frameworkSQLiteDatabaseArray[0] = null;
            return;
        }
    }

    public SupportSQLiteDatabase getReadableSupportDatabase() {
        synchronized (this) {
            Object object = null;
            this.mMigrated = false;
            object = super.getReadableDatabase();
            boolean bl2 = this.mMigrated;
            if (bl2) {
                this.close();
                object = this.getReadableSupportDatabase();
                return object;
            }
            object = this.getWrappedDb((SQLiteDatabase)object);
            return object;
        }
    }

    public FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
        return FrameworkSQLiteOpenHelper$OpenHelper.getWrappedDb(this.mDbRef, sQLiteDatabase);
    }

    public SupportSQLiteDatabase getWritableSupportDatabase() {
        synchronized (this) {
            Object object = null;
            this.mMigrated = false;
            object = super.getWritableDatabase();
            boolean bl2 = this.mMigrated;
            if (bl2) {
                this.close();
                object = this.getWritableSupportDatabase();
                return object;
            }
            object = this.getWrappedDb((SQLiteDatabase)object);
            return object;
        }
    }

    public void onConfigure(SQLiteDatabase object) {
        SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
        object = this.getWrappedDb((SQLiteDatabase)object);
        supportSQLiteOpenHelper$Callback.onConfigure((SupportSQLiteDatabase)object);
    }

    public void onCreate(SQLiteDatabase object) {
        SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
        object = this.getWrappedDb((SQLiteDatabase)object);
        supportSQLiteOpenHelper$Callback.onCreate((SupportSQLiteDatabase)object);
    }

    public void onDowngrade(SQLiteDatabase object, int n10, int n11) {
        this.mMigrated = true;
        SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
        object = this.getWrappedDb((SQLiteDatabase)object);
        supportSQLiteOpenHelper$Callback.onDowngrade((SupportSQLiteDatabase)object, n10, n11);
    }

    public void onOpen(SQLiteDatabase object) {
        boolean bl2 = this.mMigrated;
        if (!bl2) {
            SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
            object = this.getWrappedDb((SQLiteDatabase)object);
            supportSQLiteOpenHelper$Callback.onOpen((SupportSQLiteDatabase)object);
        }
    }

    public void onUpgrade(SQLiteDatabase object, int n10, int n11) {
        this.mMigrated = true;
        SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
        object = this.getWrappedDb((SQLiteDatabase)object);
        supportSQLiteOpenHelper$Callback.onUpgrade((SupportSQLiteDatabase)object, n10, n11);
    }
}

