/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;
import com.zhiyun.cama.data.database.model.MessageLike;

public class MessageDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ MessageDao_Impl this$0;

    public MessageDao_Impl$1(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = messageDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageLike object) {
        long l10 = ((MessageLike)object).getId();
        supportSQLiteStatement.bindLong(1, l10);
        int n10 = ((MessageLike)object).getUserId();
        l10 = n10;
        int n11 = 2;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = ((MessageLike)object).getNickname();
        int n12 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageLike)object).getNickname();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageLike)object).getAvatar();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageLike)object).getAvatar();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 5;
        long l11 = ((MessageLike)object).getVerified();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((MessageLike)object).getWorkType();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageLike)object).getWorkType();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = ((MessageLike)object).getCircleArticleId();
        supportSQLiteStatement.bindLong(7, l11);
        n10 = 8;
        l11 = ((MessageLike)object).getPostId();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((MessageLike)object).getSourceUrls();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageLike)object).getSourceUrls();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageLike)object).getCreateAt();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageLike)object).getCreateAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 11;
        l11 = ((MessageLike)object).getIsRead();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((MessageLike)object).getTargetText();
        n12 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = ((MessageLike)object).getTargetText();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `MessageLike` (`id`,`userId`,`nickname`,`avatar`,`verified`,`workType`,`circleArticleId`,`postId`,`sourceUrls`,`createAt`,`isRead`,`targetText`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

