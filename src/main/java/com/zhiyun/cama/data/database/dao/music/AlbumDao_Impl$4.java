/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl;
import com.zhiyun.cama.data.database.model.music.AlbumData;

public class AlbumDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ AlbumDao_Impl this$0;

    public AlbumDao_Impl$4(AlbumDao_Impl albumDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = albumDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, AlbumData albumData) {
        String string2 = albumData.getCoverUrl();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = albumData.getCoverUrl();
            supportSQLiteStatement.bindString(n10, string2);
        }
        long l10 = albumData.getSongCount();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = albumData.getId();
        supportSQLiteStatement.bindLong(3, l10);
        int n11 = 4;
        l10 = albumData.getResId();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = albumData.getLabel();
        n10 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = albumData.getLabel();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = albumData.getLabel_tw();
        n10 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = albumData.getLabel_tw();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = albumData.getLabel_en();
        n10 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = albumData.getLabel_en();
            supportSQLiteStatement.bindString(n10, string2);
        }
        l10 = albumData.getSort();
        supportSQLiteStatement.bindLong(8, l10);
        l10 = albumData.getId();
        supportSQLiteStatement.bindLong(9, l10);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `album_data` SET `cover_url` = ?,`song_count` = ?,`id` = ?,`res_id` = ?,`label` = ?,`label_tw` = ?,`label_en` = ?,`sort` = ? WHERE `id` = ?";
    }
}

