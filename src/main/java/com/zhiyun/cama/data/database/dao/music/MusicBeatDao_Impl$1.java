/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.MapTypeConverters;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicBeatData;

public class MusicBeatDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ MusicBeatDao_Impl this$0;

    public MusicBeatDao_Impl$1(MusicBeatDao_Impl musicBeatDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicBeatDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicBeatData object) {
        long l10 = ((MusicBeatData)object).getId();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = ((MusicBeatData)object).getMusicPath();
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((MusicBeatData)object).getMusicPath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        object = MapTypeConverters.fromHashMap(((MusicBeatData)object).getBeatMaps());
        int n12 = 3;
        if (object == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            supportSQLiteStatement.bindString(n12, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `music_beat_data` (`id`,`music_path`,`beat_map`) VALUES (nullif(?, 0),?,?)";
    }
}

