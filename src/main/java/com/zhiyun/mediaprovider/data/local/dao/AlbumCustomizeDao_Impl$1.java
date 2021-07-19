/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao_Impl;
import com.zhiyun.mediaprovider.data.local.model.AlbumCustomizeData;

public class AlbumCustomizeDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ AlbumCustomizeDao_Impl this$0;

    public AlbumCustomizeDao_Impl$1(AlbumCustomizeDao_Impl albumCustomizeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = albumCustomizeDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, AlbumCustomizeData object) {
        int n10 = ((AlbumCustomizeData)object).getId();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = ((AlbumCustomizeData)object).getAlbumTag();
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((AlbumCustomizeData)object).getAlbumTag();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 3;
        long l11 = ((AlbumCustomizeData)object).getAlbumId();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((AlbumCustomizeData)object).getPath();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = ((AlbumCustomizeData)object).getPath();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `AlbumCustomizeData` (`id`,`albumTag`,`albumId`,`path`) VALUES (nullif(?, 0),?,?,?)";
    }
}

