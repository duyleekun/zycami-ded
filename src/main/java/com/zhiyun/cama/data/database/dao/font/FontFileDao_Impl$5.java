/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl;

public class FontFileDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ FontFileDao_Impl this$0;

    public FontFileDao_Impl$5(FontFileDao_Impl fontFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = fontFileDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM font_file WHERE hash < 0";
    }
}

