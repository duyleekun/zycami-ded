/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.paging.DataSource$Factory;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl$10$1;

public class WorksDao_Impl$10
extends DataSource$Factory {
    public final /* synthetic */ WorksDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public WorksDao_Impl$10(WorksDao_Impl worksDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = worksDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public LimitOffsetDataSource create() {
        RoomDatabase roomDatabase = WorksDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        String[] stringArray = new String[]{"Works"};
        WorksDao_Impl$10$1 worksDao_Impl$10$1 = new WorksDao_Impl$10$1(this, roomDatabase, roomSQLiteQuery, false, true, stringArray);
        return worksDao_Impl$10$1;
    }
}

