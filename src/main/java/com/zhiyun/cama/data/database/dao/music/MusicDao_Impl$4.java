/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicData;

public class MusicDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ MusicDao_Impl this$0;

    public MusicDao_Impl$4(MusicDao_Impl musicDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicData musicData) {
        Object object = musicData.getAlbumId();
        int n10 = 1;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = musicData.getAlbumId();
            long l10 = (Long)object;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        object = musicData.getThumb();
        n10 = 2;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = musicData.getThumb();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        object = musicData.getHash();
        n10 = 3;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = musicData.getHash();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        long l11 = musicData.getDuration();
        supportSQLiteStatement.bindLong(4, l11);
        int n11 = 5;
        l11 = musicData.getSize();
        supportSQLiteStatement.bindLong(n11, l11);
        object = musicData.getPath();
        n10 = 6;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = musicData.getPath();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        l11 = musicData.getFileDownloadTimestamp();
        supportSQLiteStatement.bindLong(7, l11);
        l11 = musicData.getRequiredPrime();
        supportSQLiteStatement.bindLong(8, l11);
        l11 = musicData.getId();
        supportSQLiteStatement.bindLong(9, l11);
        n11 = 10;
        l11 = musicData.getResId();
        supportSQLiteStatement.bindLong(n11, l11);
        object = musicData.getLabel();
        n10 = 11;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = musicData.getLabel();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        object = musicData.getLabel_tw();
        n10 = 12;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = musicData.getLabel_tw();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        object = musicData.getLabel_en();
        n10 = 13;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = musicData.getLabel_en();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        l11 = musicData.getSort();
        supportSQLiteStatement.bindLong(14, l11);
        l11 = musicData.getId();
        supportSQLiteStatement.bindLong(15, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `music_data` SET `album_id` = ?,`thumb` = ?,`hash` = ?,`duration` = ?,`size` = ?,`path` = ?,`file_download_timestamp` = ?,`requiredPrime` = ?,`id` = ?,`res_id` = ?,`label` = ?,`label_tw` = ?,`label_en` = ?,`sort` = ? WHERE `id` = ?";
    }
}

