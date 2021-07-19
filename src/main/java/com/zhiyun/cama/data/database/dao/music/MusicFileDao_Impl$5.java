/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl;

public class MusicFileDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ MusicFileDao_Impl this$0;

    public MusicFileDao_Impl$5(MusicFileDao_Impl musicFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicFileDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM music_file WHERE hash < 0";
    }
}

