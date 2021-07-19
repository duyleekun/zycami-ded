/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl;
import com.zhiyun.cama.data.database.model.sticker.StickerType;

public class StickerTypeDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ StickerTypeDao_Impl this$0;

    public StickerTypeDao_Impl$3(StickerTypeDao_Impl stickerTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = stickerTypeDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerType stickerType) {
        long l10 = stickerType.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `sticker_type` WHERE `id` = ?";
    }
}

