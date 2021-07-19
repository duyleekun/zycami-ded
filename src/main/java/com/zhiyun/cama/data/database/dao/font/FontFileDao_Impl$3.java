/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl;
import com.zhiyun.cama.data.database.model.font.FontFile;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class FontFileDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ FontFileDao_Impl this$0;

    public FontFileDao_Impl$3(FontFileDao_Impl fontFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = fontFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FontFile object) {
        String string2 = ((FileData)object).getHash();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((FileData)object).getHash();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "DELETE FROM `font_file` WHERE `hash` = ?";
    }
}

