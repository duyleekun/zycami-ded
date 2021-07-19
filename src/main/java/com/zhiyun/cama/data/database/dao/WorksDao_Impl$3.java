/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;
import com.zhiyun.cama.data.database.model.Likes;

public class WorksDao_Impl$3
extends EntityInsertionAdapter {
    public final /* synthetic */ WorksDao_Impl this$0;

    public WorksDao_Impl$3(WorksDao_Impl worksDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = worksDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Likes object) {
        long l10 = ((Likes)object).getLikeId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = ((Likes)object).getUser();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = ((Likes)object).getId();
        int n10 = 3;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = ((Likes)object).getSourceUrls();
        int n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getSourceUrls();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getDes();
        n11 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getDes();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getCommentCnt();
        n11 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getCommentCnt();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getLikeCnt();
        n11 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getLikeCnt();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getShareCnt();
        n11 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getShareCnt();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getPublishAt();
        n11 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getPublishAt();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getPv();
        n11 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getPv();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getDuration();
        n11 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getDuration();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getThumbwh();
        n11 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((Likes)object).getThumbwh();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((Likes)object).getUserId();
        n11 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = ((Likes)object).getUserId();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `Likes` (`likeId`,`user`,`id`,`sourceUrls`,`des`,`commentCnt`,`likeCnt`,`shareCnt`,`publishAt`,`pv`,`duration`,`thumbwh`,`userId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

