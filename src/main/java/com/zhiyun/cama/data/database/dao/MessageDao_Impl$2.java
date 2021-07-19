/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;
import com.zhiyun.cama.data.database.model.MessageSystem;

public class MessageDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ MessageDao_Impl this$0;

    public MessageDao_Impl$2(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = messageDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageSystem object) {
        int n10 = ((MessageSystem)object).getId();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = ((MessageSystem)object).getCreateAt();
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getCreateAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 3;
        long l11 = ((MessageSystem)object).getIsRead();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((MessageSystem)object).getVerb();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getVerb();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 5;
        l11 = ((MessageSystem)object).getObjectId();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((MessageSystem)object).getObjectType();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getObjectType();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageSystem)object).getTitle();
        n12 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getTitle();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageSystem)object).getContent();
        n12 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getContent();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageSystem)object).getNickname();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getNickname();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageSystem)object).getSourceUrls();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getSourceUrls();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageSystem)object).getEndAt();
        n12 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getEndAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((MessageSystem)object).getImage();
        n12 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((MessageSystem)object).getImage();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 13;
        l11 = ((MessageSystem)object).getUserId();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((MessageSystem)object).getAvatar();
        n12 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = ((MessageSystem)object).getAvatar();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `MessageSystem` (`id`,`createAt`,`isRead`,`verb`,`objectId`,`objectType`,`title`,`content`,`nickname`,`sourceUrls`,`endAt`,`image`,`userId`,`avatar`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

