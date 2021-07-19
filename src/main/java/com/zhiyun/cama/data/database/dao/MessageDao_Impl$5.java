/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;

public class MessageDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ MessageDao_Impl this$0;

    public MessageDao_Impl$5(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = messageDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM MessageLike";
    }
}

