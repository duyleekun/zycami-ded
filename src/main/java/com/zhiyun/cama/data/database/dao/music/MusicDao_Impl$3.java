/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicData;

public class MusicDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ MusicDao_Impl this$0;

    public MusicDao_Impl$3(MusicDao_Impl musicDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicData musicData) {
        long l10 = musicData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `music_data` WHERE `id` = ?";
    }
}

