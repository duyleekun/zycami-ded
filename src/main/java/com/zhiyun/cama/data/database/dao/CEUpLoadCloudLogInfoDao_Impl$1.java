/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.CEUpLoadCloudLogInfoDao_Impl;
import d.v.c.t0.h0;

public class CEUpLoadCloudLogInfoDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ CEUpLoadCloudLogInfoDao_Impl this$0;

    public CEUpLoadCloudLogInfoDao_Impl$1(CEUpLoadCloudLogInfoDao_Impl cEUpLoadCloudLogInfoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = cEUpLoadCloudLogInfoDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, h0 h02) {
        String string2 = h02.e();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = h02.e();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = h02.h();
        n10 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = h02.h();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = h02.c();
        n10 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = h02.c();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = h02.b();
        n10 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = h02.b();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = h02.g();
        n10 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = h02.g();
            supportSQLiteStatement.bindString(n10, string2);
        }
        long l10 = h02.f();
        supportSQLiteStatement.bindLong(6, l10);
        l10 = h02.a();
        supportSQLiteStatement.bindLong(7, l10);
        l10 = h02.d();
        supportSQLiteStatement.bindLong(8, l10);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `CEUpLoadCloudLogInfo` (`startedAt`,`version`,`longitude`,`latitude`,`url`,`status`,`duration`,`operation`) VALUES (?,?,?,?,?,?,?,?)";
    }
}

