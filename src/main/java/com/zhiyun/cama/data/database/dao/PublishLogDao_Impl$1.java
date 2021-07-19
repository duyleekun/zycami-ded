/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.PublishLogDao_Impl;
import com.zhiyun.cama.data.database.model.PublishLog;

public class PublishLogDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ PublishLogDao_Impl this$0;

    public PublishLogDao_Impl$1(PublishLogDao_Impl publishLogDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = publishLogDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, PublishLog object) {
        int n10 = ((PublishLog)object).getId();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = ((PublishLog)object).getUserId();
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getUserId();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getPostId();
        n12 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getPostId();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getPhoneid();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getPhoneid();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getReason();
        n12 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getReason();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getReasonCode();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getReasonCode();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getSourceUrl1();
        n12 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getSourceUrl1();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getSourceUrl2();
        n12 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getSourceUrl2();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getFailAt();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((PublishLog)object).getFailAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((PublishLog)object).getVersion();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = ((PublishLog)object).getVersion();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `PublishLog` (`id`,`userId`,`postId`,`phoneid`,`reason`,`reasonCode`,`sourceUrl1`,`sourceUrl2`,`failAt`,`version`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
    }
}

