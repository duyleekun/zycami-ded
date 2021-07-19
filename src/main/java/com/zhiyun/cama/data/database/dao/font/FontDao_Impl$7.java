/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl;

public class FontDao_Impl$7
extends SharedSQLiteStatement {
    public final /* synthetic */ FontDao_Impl this$0;

    public FontDao_Impl$7(FontDao_Impl fontDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = fontDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "UPDATE font_data SET path = ? WHERE hash = ?";
    }
}

