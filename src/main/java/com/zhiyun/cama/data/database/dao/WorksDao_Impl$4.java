/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;
import com.zhiyun.cama.data.database.model.PublishWorks;

public class WorksDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ WorksDao_Impl this$0;

    public WorksDao_Impl$4(WorksDao_Impl worksDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = worksDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, PublishWorks object) {
        String string2 = ((PublishWorks)object).getFilePath();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((PublishWorks)object).getFilePath();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "DELETE FROM `PublishWorks` WHERE `filePath` = ?";
    }
}

