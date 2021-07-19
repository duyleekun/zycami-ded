/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;
import com.zhiyun.cama.data.database.model.MessageViolation;

public class MessageDao_Impl$4
extends EntityInsertionAdapter {
    public final /* synthetic */ MessageDao_Impl this$0;

    public MessageDao_Impl$4(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = messageDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageViolation messageViolation) {
        int n10 = messageViolation.getId();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = messageViolation.getVerb();
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getVerb();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 3;
        long l11 = messageViolation.getRefId();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = messageViolation.getRefType();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getRefType();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getContent();
        n12 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getContent();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getCreateAt();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getCreateAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 7;
        l11 = messageViolation.getIsRead();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = messageViolation.getBuild_time();
        n12 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getBuild_time();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getDegree();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getDegree();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getRefuse_reason();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getRefuse_reason();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getAppeal_id();
        n12 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getAppeal_id();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getAppeal_status();
        n12 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getAppeal_status();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getHas_punish();
        n12 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getHas_punish();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getClassify();
        n12 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getClassify();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getPunish();
        n12 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getPunish();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getForever();
        n12 = 16;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getForever();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getPunish_endtime();
        n12 = 17;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getPunish_endtime();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getCircle_name();
        n12 = 18;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getCircle_name();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = messageViolation.getSource();
        n12 = 19;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = messageViolation.getSource();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = messageViolation.getSource_id();
        supportSQLiteStatement.bindLong(20, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `MessageViolation` (`id`,`verb`,`refId`,`refType`,`content`,`createAt`,`isRead`,`build_time`,`degree`,`refuse_reason`,`appeal_id`,`appeal_status`,`has_punish`,`classify`,`punish`,`forever`,`punish_endtime`,`circle_name`,`source`,`source_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

