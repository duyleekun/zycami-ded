/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl;

public class CaptionStyleFileDao_Impl$6
extends SharedSQLiteStatement {
    public final /* synthetic */ CaptionStyleFileDao_Impl this$0;

    public CaptionStyleFileDao_Impl$6(CaptionStyleFileDao_Impl captionStyleFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = captionStyleFileDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM caption_style_file";
    }
}

