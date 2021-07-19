/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl;
import com.zhiyun.cama.data.database.model.music.AlbumData;

public class AlbumDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ AlbumDao_Impl this$0;

    public AlbumDao_Impl$3(AlbumDao_Impl albumDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = albumDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, AlbumData albumData) {
        long l10 = albumData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `album_data` WHERE `id` = ?";
    }
}

