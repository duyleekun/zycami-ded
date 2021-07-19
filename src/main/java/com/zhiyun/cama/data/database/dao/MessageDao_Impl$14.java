/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.paging.DataSource$Factory;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$14$1;

public class MessageDao_Impl$14
extends DataSource$Factory {
    public final /* synthetic */ MessageDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public MessageDao_Impl$14(MessageDao_Impl messageDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = messageDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public LimitOffsetDataSource create() {
        RoomDatabase roomDatabase = MessageDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        String[] stringArray = new String[]{"MessageViolation"};
        MessageDao_Impl$14$1 messageDao_Impl$14$1 = new MessageDao_Impl$14$1(this, roomDatabase, roomSQLiteQuery, false, true, stringArray);
        return messageDao_Impl$14$1;
    }
}

