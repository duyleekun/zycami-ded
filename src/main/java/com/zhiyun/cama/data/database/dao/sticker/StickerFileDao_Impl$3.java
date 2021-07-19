/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl;
import com.zhiyun.cama.data.database.model.sticker.StickerFile;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class StickerFileDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ StickerFileDao_Impl this$0;

    public StickerFileDao_Impl$3(StickerFileDao_Impl stickerFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = stickerFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerFile object) {
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
        return "DELETE FROM `sticker_file` WHERE `hash` = ?";
    }
}

