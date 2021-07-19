/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicBeatData;

public class MusicBeatDao_Impl$2
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ MusicBeatDao_Impl this$0;

    public MusicBeatDao_Impl$2(MusicBeatDao_Impl musicBeatDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicBeatDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicBeatData musicBeatData) {
        long l10 = musicBeatData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `music_beat_data` WHERE `id` = ?";
    }
}

