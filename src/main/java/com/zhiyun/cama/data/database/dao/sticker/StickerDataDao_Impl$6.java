/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl;

public class StickerDataDao_Impl$6
extends SharedSQLiteStatement {
    public final /* synthetic */ StickerDataDao_Impl this$0;

    public StickerDataDao_Impl$6(StickerDataDao_Impl stickerDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = stickerDataDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM sticker_data WHERE res_id > 0";
    }
}

