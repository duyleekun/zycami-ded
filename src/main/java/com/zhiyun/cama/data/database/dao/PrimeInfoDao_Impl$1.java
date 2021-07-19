/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao_Impl;
import com.zhiyun.cama.prime.model.PrimeInfo;

public class PrimeInfoDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ PrimeInfoDao_Impl this$0;

    public PrimeInfoDao_Impl$1(PrimeInfoDao_Impl primeInfoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = primeInfoDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, PrimeInfo primeInfo) {
        int n10 = primeInfo.errcode;
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = primeInfo.errmsg;
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            supportSQLiteStatement.bindString(n12, string2);
        }
        long l11 = primeInfo.getId();
        supportSQLiteStatement.bindLong(3, l11);
        l11 = primeInfo.getUserId();
        supportSQLiteStatement.bindLong(4, l11);
        l11 = primeInfo.getDeviceId();
        supportSQLiteStatement.bindLong(5, l11);
        n10 = 6;
        l11 = primeInfo.getPeriodTime();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = primeInfo.getActiveTime();
        n12 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = primeInfo.getActiveTime();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = primeInfo.getStartTime();
        n12 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = primeInfo.getStartTime();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = primeInfo.getEndTime();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = primeInfo.getEndTime();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = primeInfo.getHasRenew();
        supportSQLiteStatement.bindLong(10, l11);
        l11 = primeInfo.getStatus();
        supportSQLiteStatement.bindLong(11, l11);
        n10 = 12;
        l11 = primeInfo.getGetWay();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = primeInfo.getCreateAt();
        n12 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = primeInfo.getCreateAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = primeInfo.getUpdateAt();
        n12 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = primeInfo.getUpdateAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = primeInfo.getInactive();
        supportSQLiteStatement.bindLong(15, l11);
        l11 = primeInfo.getOverdueTime();
        supportSQLiteStatement.bindLong(16, l11);
        l11 = (long)primeInfo.getIsShowDialog();
        supportSQLiteStatement.bindLong(17, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `PrimeInfo` (`errcode`,`errmsg`,`id`,`userId`,`deviceId`,`periodTime`,`activeTime`,`startTime`,`endTime`,`hasRenew`,`status`,`getWay`,`createAt`,`updateAt`,`inactive`,`overdueTime`,`isShowDialog`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

