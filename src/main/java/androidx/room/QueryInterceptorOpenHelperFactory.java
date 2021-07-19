/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.QueryInterceptorOpenHelper;
import androidx.room.RoomDatabase$QueryCallback;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import java.util.concurrent.Executor;

public final class QueryInterceptorOpenHelperFactory
implements SupportSQLiteOpenHelper$Factory {
    private final SupportSQLiteOpenHelper$Factory mDelegate;
    private final RoomDatabase$QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory, RoomDatabase$QueryCallback roomDatabase$QueryCallback, Executor executor) {
        this.mDelegate = supportSQLiteOpenHelper$Factory;
        this.mQueryCallback = roomDatabase$QueryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper$Configuration object) {
        object = this.mDelegate.create((SupportSQLiteOpenHelper$Configuration)object);
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        Executor executor = this.mQueryCallbackExecutor;
        QueryInterceptorOpenHelper queryInterceptorOpenHelper = new QueryInterceptorOpenHelper((SupportSQLiteOpenHelper)object, roomDatabase$QueryCallback, executor);
        return queryInterceptorOpenHelper;
    }
}

