/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.PublishLogDao_Impl;
import com.zhiyun.cama.data.database.model.PublishLog;

public class PublishLogDao_Impl$2
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ PublishLogDao_Impl this$0;

    public PublishLogDao_Impl$2(PublishLogDao_Impl publishLogDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = publishLogDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, PublishLog publishLog) {
        long l10 = publishLog.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `PublishLog` WHERE `id` = ?";
    }
}

