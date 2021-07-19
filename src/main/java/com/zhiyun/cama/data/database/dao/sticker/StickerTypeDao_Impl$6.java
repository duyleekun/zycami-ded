/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl;

public class StickerTypeDao_Impl$6
extends SharedSQLiteStatement {
    public final /* synthetic */ StickerTypeDao_Impl this$0;

    public StickerTypeDao_Impl$6(StickerTypeDao_Impl stickerTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = stickerTypeDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM sticker_type WHERE res_id > 0";
    }
}

