/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.TypeListStringConverters;
import com.zhiyun.cama.data.database.TypePublishStateConverters;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;
import com.zhiyun.cama.data.database.model.PublishWorks;

public class WorksDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ WorksDao_Impl this$0;

    public WorksDao_Impl$2(WorksDao_Impl worksDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = worksDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, PublishWorks object) {
        String string2 = ((PublishWorks)object).getFilePath();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getFilePath();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((PublishWorks)object).getCoverPath();
        n10 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getCoverPath();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((PublishWorks)object).getFileDuration();
        n10 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getFileDuration();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((PublishWorks)object).getWorksDes();
        n10 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getWorksDes();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = TypePublishStateConverters.StringToPublishState(((PublishWorks)object).getState());
        n10 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, string2);
        }
        int n11 = 6;
        long l10 = ((PublishWorks)object).getPercent();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = ((PublishWorks)object).getTitle();
        n10 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getTitle();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = TypeListStringConverters.stringListToString(((PublishWorks)object).getTags());
        n10 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = TypeListStringConverters.stringListToString(((PublishWorks)object).getDevices());
        n10 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((PublishWorks)object).getAddress();
        n10 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getAddress();
            supportSQLiteStatement.bindString(n10, string2);
        }
        l10 = ((PublishWorks)object).getActiveId();
        supportSQLiteStatement.bindLong(11, l10);
        l10 = ((PublishWorks)object).getThemeId();
        supportSQLiteStatement.bindLong(12, l10);
        n11 = (int)(((PublishWorks)object).isNeedToDelete() ? 1 : 0);
        long l11 = n11;
        supportSQLiteStatement.bindLong(13, l11);
        string2 = ((PublishWorks)object).getConfig();
        n10 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getConfig();
            supportSQLiteStatement.bindString(n10, string2);
        }
        l10 = ((PublishWorks)object).getPublishFromType();
        supportSQLiteStatement.bindLong(15, l10);
        n11 = 16;
        l10 = ((PublishWorks)object).getWorksId();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = ((PublishWorks)object).getPostUrl();
        n10 = 17;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getPostUrl();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((PublishWorks)object).getSmallImgUrl();
        n10 = 18;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getSmallImgUrl();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((PublishWorks)object).getFileUrl();
        n10 = 19;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getFileUrl();
            supportSQLiteStatement.bindString(n10, string2);
        }
        l10 = ((PublishWorks)object).getCircleId();
        supportSQLiteStatement.bindLong(20, l10);
        n11 = 21;
        l10 = ((PublishWorks)object).getType();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = ((PublishWorks)object).getArchive();
        n10 = 22;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getArchive();
            supportSQLiteStatement.bindString(n10, string2);
        }
        n11 = 23;
        l10 = ((PublishWorks)object).getShareToKwai();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = ((PublishWorks)object).getKwaiToken();
        n10 = 24;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getKwaiToken();
            supportSQLiteStatement.bindString(n10, string2);
        }
        n11 = 25;
        l10 = ((PublishWorks)object).getResolution();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = ((PublishWorks)object).getCoverObjectKey();
        n10 = 26;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((PublishWorks)object).getCoverObjectKey();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((PublishWorks)object).getFileObjectKey();
        n10 = 27;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((PublishWorks)object).getFileObjectKey();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `PublishWorks` (`filePath`,`coverPath`,`fileDuration`,`worksDes`,`state`,`percent`,`title`,`tags`,`devices`,`address`,`activeId`,`themeId`,`needToDelete`,`config`,`publishFromType`,`worksId`,`postUrl`,`smallImgUrl`,`fileUrl`,`circleId`,`type`,`archive`,`shareToKwai`,`kwaiToken`,`resolution`,`coverObjectKey`,`fileObjectKey`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

