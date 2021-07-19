/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl;
import com.zhiyun.cama.data.database.model.sticker.StickerType;

public class StickerTypeDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ StickerTypeDao_Impl this$0;

    public StickerTypeDao_Impl$1(StickerTypeDao_Impl stickerTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = stickerTypeDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerType stickerType) {
        long l10 = stickerType.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = stickerType.getResId();
        int n10 = 2;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = stickerType.getLabel();
        int n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerType.getLabel();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerType.getLabel_tw();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerType.getLabel_tw();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = stickerType.getLabel_en();
        n11 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = stickerType.getLabel_en();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = stickerType.getSort();
        supportSQLiteStatement.bindLong(6, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `sticker_type` (`id`,`res_id`,`label`,`label_tw`,`label_en`,`sort`) VALUES (nullif(?, 0),?,?,?,?,?)";
    }
}

