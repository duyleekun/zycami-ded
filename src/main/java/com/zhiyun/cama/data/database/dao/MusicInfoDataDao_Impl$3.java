/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;

public class MusicInfoDataDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ MusicInfoDataDao_Impl this$0;

    public MusicInfoDataDao_Impl$3(MusicInfoDataDao_Impl musicInfoDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicInfoDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicInfoData musicInfoData) {
        long l10 = musicInfoData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `music_info_data` WHERE `id` = ?";
    }
}

