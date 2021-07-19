/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.AutoCloser;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.room.DelegatingOpenHelper;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;

public final class AutoClosingRoomOpenHelper
implements SupportSQLiteOpenHelper,
DelegatingOpenHelper {
    private final AutoCloser mAutoCloser;
    private final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase mAutoClosingDb;
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper closeable, AutoCloser autoCloser) {
        this.mDelegateOpenHelper = closeable;
        this.mAutoCloser = autoCloser;
        autoCloser.init((SupportSQLiteOpenHelper)closeable);
        super(autoCloser);
        this.mAutoClosingDb = closeable;
    }

    public void close() {
        AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase autoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase = this.mAutoClosingDb;
        try {
            autoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.close();
        }
        catch (IOException iOException) {
            SneakyThrow.reThrow(iOException);
        }
    }

    public AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    public SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    public void setWriteAheadLoggingEnabled(boolean bl2) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(bl2);
    }
}

