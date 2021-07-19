/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.MapTypeConverters;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicBeatData;

public class MusicBeatDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ MusicBeatDao_Impl this$0;

    public MusicBeatDao_Impl$3(MusicBeatDao_Impl musicBeatDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicBeatDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicBeatData musicBeatData) {
        long l10 = musicBeatData.getId();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = musicBeatData.getMusicPath();
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = musicBeatData.getMusicPath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = MapTypeConverters.fromHashMap(musicBeatData.getBeatMaps());
        n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = musicBeatData.getId();
        supportSQLiteStatement.bindLong(4, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `music_beat_data` SET `id` = ?,`music_path` = ?,`beat_map` = ? WHERE `id` = ?";
    }
}

