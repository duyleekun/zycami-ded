/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local;

import androidx.room.RoomDatabase;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao;

public abstract class MediaDatabaseComm
extends RoomDatabase {
    public abstract AlbumCustomizeDao albumCustomizeDao();
}

