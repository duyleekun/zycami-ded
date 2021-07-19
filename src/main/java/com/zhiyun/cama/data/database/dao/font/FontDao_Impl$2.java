/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl;
import com.zhiyun.cama.data.database.model.font.FontData;

public class FontDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ FontDao_Impl this$0;

    public FontDao_Impl$2(FontDao_Impl fontDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = fontDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FontData fontData) {
        long l10 = fontData.getSize();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = fontData.getPath();
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = fontData.getPath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = fontData.getHash();
        n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = fontData.getHash();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = fontData.getThumb();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = fontData.getThumb();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = fontData.getRequiredPrime();
        supportSQLiteStatement.bindLong(5, l11);
        l11 = fontData.getId();
        supportSQLiteStatement.bindLong(6, l11);
        int n12 = 7;
        l11 = fontData.getResId();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = fontData.getLabel();
        n11 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = fontData.getLabel();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = fontData.getLabel_tw();
        n11 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = fontData.getLabel_tw();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = fontData.getLabel_en();
        n11 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = fontData.getLabel_en();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = fontData.getSort();
        supportSQLiteStatement.bindLong(11, l11);
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `font_data` (`size`,`path`,`hash`,`thumb`,`requiredPrime`,`id`,`res_id`,`label`,`label_tw`,`label_en`,`sort`) VALUES (?,?,?,?,?,nullif(?, 0),?,?,?,?,?)";
    }
}

