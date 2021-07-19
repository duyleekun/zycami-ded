/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl;
import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.cama.data.database.model.SplashAdWatch;

public class SplashAdDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ SplashAdDao_Impl this$0;

    public SplashAdDao_Impl$1(SplashAdDao_Impl splashAdDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = splashAdDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, SplashAd object) {
        int n10 = ((SplashAd)object).getId();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = ((SplashAd)object).getCode();
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getCode();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((SplashAd)object).getText();
        n12 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getText();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((SplashAd)object).getImage();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getImage();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((SplashAd)object).getUrl();
        n12 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getUrl();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((SplashAd)object).getRefType();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getRefType();
            supportSQLiteStatement.bindString(n12, string2);
        }
        long l11 = ((SplashAd)object).getRefId();
        supportSQLiteStatement.bindLong(7, l11);
        l11 = ((SplashAd)object).getType();
        supportSQLiteStatement.bindLong(8, l11);
        n10 = 9;
        l11 = ((SplashAd)object).getPeriod();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((SplashAd)object).getRegion();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getRegion();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((SplashAd)object).getStartAt();
        n12 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getStartAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((SplashAd)object).getEndAt();
        n12 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getEndAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = ((SplashAd)object).getStartUnix();
        supportSQLiteStatement.bindLong(13, l11);
        n10 = 14;
        l11 = ((SplashAd)object).getEndUnix();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((SplashAd)object).getFilePath();
        n12 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getFilePath();
            supportSQLiteStatement.bindString(n12, string2);
        }
        long l12 = (long)((SplashAd)object).isVideo();
        supportSQLiteStatement.bindLong(16, l12);
        n10 = (int)(((SplashAd)object).isAutoDisappear() ? 1 : 0);
        l12 = n10;
        supportSQLiteStatement.bindLong(17, l12);
        string2 = ((SplashAd)object).getLang();
        n12 = 18;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((SplashAd)object).getLang();
            supportSQLiteStatement.bindString(n12, string2);
        }
        object = ((SplashAd)object).getSplashAdWatch();
        n10 = 21;
        n12 = 20;
        n11 = 19;
        if (object != null) {
            int n13 = ((SplashAdWatch)object).getWatchId();
            long l13 = n13;
            supportSQLiteStatement.bindLong(n11, l13);
            n11 = (int)(((SplashAdWatch)object).isWatched() ? 1 : 0);
            l12 = n11;
            supportSQLiteStatement.bindLong(n12, l12);
            l11 = ((SplashAdWatch)object).getWatchTime();
            supportSQLiteStatement.bindLong(n10, l11);
        } else {
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n10);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `SplashAd` (`id`,`code`,`text`,`image`,`url`,`refType`,`refId`,`type`,`period`,`region`,`startAt`,`endAt`,`startUnix`,`endUnix`,`filePath`,`isVideo`,`isAutoDisappear`,`lang`,`watchId`,`isWatched`,`watchTime`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

