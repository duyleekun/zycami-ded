/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl;

public class CaptionStyleDao_Impl$7
extends SharedSQLiteStatement {
    public final /* synthetic */ CaptionStyleDao_Impl this$0;

    public CaptionStyleDao_Impl$7(CaptionStyleDao_Impl captionStyleDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = captionStyleDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "UPDATE caption_style_data SET path = ? WHERE hash = ?";
    }
}

