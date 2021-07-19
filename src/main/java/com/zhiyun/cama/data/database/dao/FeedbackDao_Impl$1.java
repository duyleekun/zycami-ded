/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl;
import com.zhiyun.cama.data.database.model.Feedback;

public class FeedbackDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ FeedbackDao_Impl this$0;

    public FeedbackDao_Impl$1(FeedbackDao_Impl feedbackDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = feedbackDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Feedback feedback) {
        int n10 = feedback.errcode;
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = feedback.errmsg;
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            supportSQLiteStatement.bindString(n12, string2);
        }
        long l11 = feedback.getId();
        supportSQLiteStatement.bindLong(3, l11);
        n10 = 4;
        l11 = feedback.getUserId();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = feedback.getName();
        n12 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getName();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getContact();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getContact();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getTitle();
        n12 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getTitle();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getContent();
        n12 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getContent();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getType();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getType();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getPlatform();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getPlatform();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getMobileModel();
        n12 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getMobileModel();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getMobileOSVersion();
        n12 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getMobileOSVersion();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getAppVersion();
        n12 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getAppVersion();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getDeviceModel();
        n12 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getDeviceModel();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getImages();
        n12 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getImages();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getUser_lang();
        n12 = 16;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getUser_lang();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getFirmwareVersion();
        n12 = 17;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getFirmwareVersion();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 18;
        l11 = feedback.getFrequency();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = feedback.getAdvice_target();
        n12 = 19;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getAdvice_target();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 20;
        l11 = feedback.getDealStatus();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = feedback.getCreateAt();
        n12 = 21;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getCreateAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = feedback.getClosedAt();
        n12 = 22;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = feedback.getClosedAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = (long)feedback.isCanActive();
        supportSQLiteStatement.bindLong(23, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `Feedback` (`errcode`,`errmsg`,`id`,`userId`,`name`,`contact`,`title`,`content`,`type`,`platform`,`mobileModel`,`mobileOSVersion`,`appVersion`,`deviceModel`,`images`,`user_lang`,`firmwareVersion`,`frequency`,`advice_target`,`dealStatus`,`createAt`,`closedAt`,`canActive`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

