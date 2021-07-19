/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.paging.DataSource$Factory;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl;
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl$3$1;

public class FeedbackDao_Impl$3
extends DataSource$Factory {
    public final /* synthetic */ FeedbackDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public FeedbackDao_Impl$3(FeedbackDao_Impl feedbackDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = feedbackDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public LimitOffsetDataSource create() {
        RoomDatabase roomDatabase = FeedbackDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        String[] stringArray = new String[]{"Feedback"};
        FeedbackDao_Impl$3$1 feedbackDao_Impl$3$1 = new FeedbackDao_Impl$3$1(this, roomDatabase, roomSQLiteQuery, false, true, stringArray);
        return feedbackDao_Impl$3$1;
    }
}

