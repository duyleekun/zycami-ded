/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl;
import com.zhiyun.cama.data.database.model.SplashAdWatch;

public class SplashAdDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ SplashAdDao_Impl this$0;

    public SplashAdDao_Impl$2(SplashAdDao_Impl splashAdDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = splashAdDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, SplashAdWatch splashAdWatch) {
        long l10 = splashAdWatch.getWatchId();
        supportSQLiteStatement.bindLong(1, l10);
        long l11 = (long)splashAdWatch.isWatched();
        supportSQLiteStatement.bindLong(2, l11);
        long l12 = splashAdWatch.getWatchTime();
        supportSQLiteStatement.bindLong(3, l12);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `SplashAdWatch` (`watchId`,`isWatched`,`watchTime`) VALUES (?,?,?)";
    }
}

