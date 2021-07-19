/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl;

public class MusicInfoDataDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ MusicInfoDataDao_Impl this$0;

    public MusicInfoDataDao_Impl$5(MusicInfoDataDao_Impl musicInfoDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicInfoDataDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM music_info_data";
    }
}

