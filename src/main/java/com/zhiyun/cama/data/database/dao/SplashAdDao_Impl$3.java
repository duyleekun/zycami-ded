/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl;

public class SplashAdDao_Impl$3
extends SharedSQLiteStatement {
    public final /* synthetic */ SplashAdDao_Impl this$0;

    public SplashAdDao_Impl$3(SplashAdDao_Impl splashAdDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = splashAdDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM SplashAd";
    }
}

