/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl;

public class StickerFileDao_Impl$6
extends SharedSQLiteStatement {
    public final /* synthetic */ StickerFileDao_Impl this$0;

    public StickerFileDao_Impl$6(StickerFileDao_Impl stickerFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = stickerFileDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "delete from sticker_file where hash < 0";
    }
}

