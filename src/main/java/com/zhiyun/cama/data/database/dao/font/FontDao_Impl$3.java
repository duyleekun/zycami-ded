/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl;
import com.zhiyun.cama.data.database.model.font.FontData;

public class FontDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ FontDao_Impl this$0;

    public FontDao_Impl$3(FontDao_Impl fontDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = fontDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FontData fontData) {
        long l10 = fontData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `font_data` WHERE `id` = ?";
    }
}

