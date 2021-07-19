/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.CEUpLoadCloudLogInfoDao_Impl;
import d.v.c.t0.h0;

public class CEUpLoadCloudLogInfoDao_Impl$2
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ CEUpLoadCloudLogInfoDao_Impl this$0;

    public CEUpLoadCloudLogInfoDao_Impl$2(CEUpLoadCloudLogInfoDao_Impl cEUpLoadCloudLogInfoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = cEUpLoadCloudLogInfoDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, h0 object) {
        String string2 = ((h0)object).g();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((h0)object).g();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "DELETE FROM `CEUpLoadCloudLogInfo` WHERE `url` = ?";
    }
}

