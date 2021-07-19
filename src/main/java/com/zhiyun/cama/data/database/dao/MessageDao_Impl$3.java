/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;

public class MessageDao_Impl$3
extends EntityInsertionAdapter {
    public final /* synthetic */ MessageDao_Impl this$0;

    public MessageDao_Impl$3(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = messageDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageUnReadCount messageUnReadCount) {
        long l10 = messageUnReadCount.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = messageUnReadCount.getMessage();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = messageUnReadCount.getComment();
        supportSQLiteStatement.bindLong(3, l10);
        l10 = messageUnReadCount.getFollow();
        supportSQLiteStatement.bindLong(4, l10);
        l10 = messageUnReadCount.getLike();
        supportSQLiteStatement.bindLong(5, l10);
        l10 = messageUnReadCount.getPersonal();
        supportSQLiteStatement.bindLong(6, l10);
        l10 = messageUnReadCount.getNotice();
        supportSQLiteStatement.bindLong(7, l10);
        long l11 = (long)messageUnReadCount.getPunished();
        supportSQLiteStatement.bindLong(8, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `MessageUnReadCount` (`id`,`message`,`comment`,`follow`,`like`,`personal`,`notice`,`punished`) VALUES (?,?,?,?,?,?,?,?)";
    }
}

