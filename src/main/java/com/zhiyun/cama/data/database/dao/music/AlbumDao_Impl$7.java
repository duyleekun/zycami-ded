/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl;

public class AlbumDao_Impl$7
extends SharedSQLiteStatement {
    public final /* synthetic */ AlbumDao_Impl this$0;

    public AlbumDao_Impl$7(AlbumDao_Impl albumDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = albumDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM album_data";
    }
}

