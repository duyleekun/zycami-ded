/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;

public class WorksDao_Impl$8
extends SharedSQLiteStatement {
    public final /* synthetic */ WorksDao_Impl this$0;

    public WorksDao_Impl$8(WorksDao_Impl worksDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = worksDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM PublishWorks";
    }
}

