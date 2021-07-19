/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl;
import com.zhiyun.cama.data.database.model.font.CaptionStyleFile;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class CaptionStyleFileDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ CaptionStyleFileDao_Impl this$0;

    public CaptionStyleFileDao_Impl$3(CaptionStyleFileDao_Impl captionStyleFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = captionStyleFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, CaptionStyleFile object) {
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
        return "DELETE FROM `caption_style_file` WHERE `hash` = ?";
    }
}

