/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.account.data.database.dao.UserInfoDao_Impl;
import com.zhiyun.account.data.database.model.UserInfo;

public class UserInfoDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ UserInfoDao_Impl this$0;

    public UserInfoDao_Impl$1(UserInfoDao_Impl userInfoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = userInfoDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, UserInfo userInfo) {
        int n10 = userInfo.errcode;
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = userInfo.errmsg;
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 3;
        long l11 = userInfo.getId();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = userInfo.getAvatar();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getAvatar();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = userInfo.getNickname();
        n12 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getNickname();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = userInfo.getBirthday();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getBirthday();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = userInfo.getCountry();
        n12 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getCountry();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = userInfo.getCity();
        n12 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getCity();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = userInfo.getIntroduction();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getIntroduction();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = userInfo.getHobby();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getHobby();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = userInfo.getSex();
        supportSQLiteStatement.bindLong(11, l11);
        l11 = userInfo.getShare_post_count();
        supportSQLiteStatement.bindLong(12, l11);
        l11 = userInfo.getFollows_count();
        supportSQLiteStatement.bindLong(13, l11);
        n10 = 14;
        l11 = userInfo.getFollowers_count();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = userInfo.getToken();
        n12 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getToken();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = userInfo.getFollowed();
        supportSQLiteStatement.bindLong(16, l11);
        n10 = 17;
        l11 = userInfo.getVerified();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = userInfo.getMobile();
        n12 = 18;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getMobile();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = userInfo.getMail();
        n12 = 19;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getMail();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 20;
        l11 = userInfo.getAdnotification();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = userInfo.getStatus();
        n12 = 21;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = userInfo.getStatus();
            supportSQLiteStatement.bindString(n12, string2);
        }
        double d10 = userInfo.getLongitude();
        supportSQLiteStatement.bindDouble(22, d10);
        d10 = userInfo.getLatitude();
        supportSQLiteStatement.bindDouble(23, d10);
        l11 = userInfo.getMemberId();
        supportSQLiteStatement.bindLong(24, l11);
        l11 = userInfo.getApplicantId();
        supportSQLiteStatement.bindLong(25, l11);
        l11 = userInfo.getActivity();
        supportSQLiteStatement.bindLong(26, l11);
        l11 = userInfo.getRank();
        supportSQLiteStatement.bindLong(27, l11);
        long l12 = (long)userInfo.isAgree();
        supportSQLiteStatement.bindLong(28, l12);
        l11 = userInfo.getBlocked();
        supportSQLiteStatement.bindLong(29, l11);
        l11 = userInfo.getPrime();
        supportSQLiteStatement.bindLong(30, l11);
        l11 = userInfo.getPrimeId();
        supportSQLiteStatement.bindLong(31, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `UserInfo` (`errcode`,`errmsg`,`id`,`avatar`,`nickname`,`birthday`,`country`,`city`,`introduction`,`hobby`,`sex`,`share_post_count`,`follows_count`,`followers_count`,`token`,`followed`,`verified`,`mobile`,`mail`,`adnotification`,`status`,`longitude`,`latitude`,`memberId`,`applicantId`,`activity`,`rank`,`isAgree`,`blocked`,`prime`,`primeId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

