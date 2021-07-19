/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl;
import com.zhiyun.cama.data.database.model.font.CaptionStyleData;

public class CaptionStyleDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ CaptionStyleDao_Impl this$0;

    public CaptionStyleDao_Impl$3(CaptionStyleDao_Impl captionStyleDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = captionStyleDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, CaptionStyleData captionStyleData) {
        long l10 = captionStyleData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `caption_style_data` WHERE `id` = ?";
    }
}

