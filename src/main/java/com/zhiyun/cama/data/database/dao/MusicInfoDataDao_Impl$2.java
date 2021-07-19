/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;

public class MusicInfoDataDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ MusicInfoDataDao_Impl this$0;

    public MusicInfoDataDao_Impl$2(MusicInfoDataDao_Impl musicInfoDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = musicInfoDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, MusicInfoData musicInfoData) {
        int n10 = musicInfoData.getId();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = musicInfoData.getMusicName();
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = musicInfoData.getMusicName();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 3;
        long l11 = musicInfoData.getAlbumType();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = musicInfoData.getAlbumName();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = musicInfoData.getAlbumName();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = musicInfoData.getMusicPath();
        n12 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = musicInfoData.getMusicPath();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = musicInfoData.getMusicUrl();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = musicInfoData.getMusicUrl();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = musicInfoData.getMusicImage();
        n12 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = musicInfoData.getMusicImage();
            supportSQLiteStatement.bindString(n12, string2);
        }
        l11 = musicInfoData.getDuration();
        supportSQLiteStatement.bindLong(8, l11);
        l11 = musicInfoData.getSize();
        supportSQLiteStatement.bindLong(9, l11);
        l11 = musicInfoData.getImportTimestamp();
        supportSQLiteStatement.bindLong(10, l11);
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `music_info_data` (`id`,`musicName`,`albumType`,`albumName`,`musicPath`,`musicUrl`,`musicImage`,`duration`,`size`,`import_timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
    }
}

