/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicFile;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class MusicFileDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ MusicFileDao_Impl this$0;

    public MusicFileDao_Impl$3(MusicFileDao_Impl musicFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicFile object) {
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
        return "DELETE FROM `music_file` WHERE `hash` = ?";
    }
}

