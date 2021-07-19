/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl;
import com.zhiyun.cama.data.database.model.font.CaptionStyleData;

public class CaptionStyleDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ CaptionStyleDao_Impl this$0;

    public CaptionStyleDao_Impl$2(CaptionStyleDao_Impl captionStyleDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = captionStyleDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, CaptionStyleData captionStyleData) {
        long l10 = captionStyleData.getSize();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = captionStyleData.getPath();
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getPath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = captionStyleData.getHash();
        n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getHash();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = captionStyleData.getThumb();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getThumb();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = captionStyleData.getLicensePath();
        n11 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getLicensePath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = captionStyleData.getLicenseName();
        n11 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getLicenseName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = captionStyleData.getRequiredPrime();
        supportSQLiteStatement.bindLong(7, l11);
        l11 = captionStyleData.getId();
        supportSQLiteStatement.bindLong(8, l11);
        int n12 = 9;
        l11 = captionStyleData.getResId();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = captionStyleData.getLabel();
        n11 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getLabel();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = captionStyleData.getLabel_tw();
        n11 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getLabel_tw();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = captionStyleData.getLabel_en();
        n11 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = captionStyleData.getLabel_en();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = captionStyleData.getSort();
        supportSQLiteStatement.bindLong(13, l11);
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `caption_style_data` (`size`,`path`,`hash`,`thumb`,`licensePath`,`licenseName`,`requiredPrime`,`id`,`res_id`,`label`,`label_tw`,`label_en`,`sort`) VALUES (?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?)";
    }
}

