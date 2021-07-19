/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl;

public class MusicDao_Impl$6
extends SharedSQLiteStatement {
    public final /* synthetic */ MusicDao_Impl this$0;

    public MusicDao_Impl$6(MusicDao_Impl musicDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM music_data WHERE album_id >= 0 AND album_id = ?";
    }
}

