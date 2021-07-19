/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local.dao;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao_Impl;

public class AlbumCustomizeDao_Impl$4
extends SharedSQLiteStatement {
    public final /* synthetic */ AlbumCustomizeDao_Impl this$0;

    public AlbumCustomizeDao_Impl$4(AlbumCustomizeDao_Impl albumCustomizeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = albumCustomizeDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "delete from AlbumCustomizeData where albumId = ?";
    }
}

