/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.DelegatingOpenHelper;
import androidx.room.QueryInterceptorDatabase;
import androidx.room.RoomDatabase$QueryCallback;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

public final class QueryInterceptorOpenHelper
implements SupportSQLiteOpenHelper,
DelegatingOpenHelper {
    private final SupportSQLiteOpenHelper mDelegate;
    private final RoomDatabase$QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public QueryInterceptorOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, RoomDatabase$QueryCallback roomDatabase$QueryCallback, Executor executor) {
        this.mDelegate = supportSQLiteOpenHelper;
        this.mQueryCallback = roomDatabase$QueryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    public void close() {
        this.mDelegate.close();
    }

    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegate.getReadableDatabase();
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        Executor executor = this.mQueryCallbackExecutor;
        QueryInterceptorDatabase queryInterceptorDatabase = new QueryInterceptorDatabase(supportSQLiteDatabase, roomDatabase$QueryCallback, executor);
        return queryInterceptorDatabase;
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegate.getWritableDatabase();
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        Executor executor = this.mQueryCallbackExecutor;
        QueryInterceptorDatabase queryInterceptorDatabase = new QueryInterceptorDatabase(supportSQLiteDatabase, roomDatabase$QueryCallback, executor);
        return queryInterceptorDatabase;
    }

    public void setWriteAheadLoggingEnabled(boolean bl2) {
        this.mDelegate.setWriteAheadLoggingEnabled(bl2);
    }
}

