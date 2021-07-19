/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl;
import com.zhiyun.cama.data.database.model.sticker.StickerData;

public class StickerDataDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ StickerDataDao_Impl this$0;

    public StickerDataDao_Impl$1(StickerDataDao_Impl stickerDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = stickerDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerData stickerData) {
        long l10 = stickerData.getTypeId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = stickerData.getSize();
        int n10 = 2;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = stickerData.getName();
        int n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        int n12 = 4;
        double d10 = stickerData.getScale();
        supportSQLiteStatement.bindDouble(n12, d10);
        string2 = stickerData.getThumb();
        n11 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getThumb();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerData.getLittleThumb();
        n11 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getLittleThumb();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerData.getPath();
        n11 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getPath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerData.getHash();
        n11 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getHash();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerData.getLicensePath();
        n11 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getLicensePath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerData.getLicenseName();
        n11 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getLicenseName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = stickerData.getRequiredPrime();
        supportSQLiteStatement.bindLong(11, l11);
        l11 = stickerData.getId();
        supportSQLiteStatement.bindLong(12, l11);
        n12 = 13;
        l11 = stickerData.getResId();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = stickerData.getLabel();
        n11 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getLabel();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerData.getLabel_tw();
        n11 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getLabel_tw();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerData.getLabel_en();
        n11 = 16;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerData.getLabel_en();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = stickerData.getSort();
        supportSQLiteStatement.bindLong(17, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `sticker_data` (`type_id`,`size`,`name`,`scale`,`thumb`,`little_thumb`,`path`,`hash`,`licensePath`,`licenseName`,`requiredPrime`,`id`,`res_id`,`label`,`label_tw`,`label_en`,`sort`) VALUES (?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?)";
    }
}

