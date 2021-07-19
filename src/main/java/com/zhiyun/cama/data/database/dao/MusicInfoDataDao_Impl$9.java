/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MusicInfoDataDao_Impl$9
implements Callable {
    public final /* synthetic */ MusicInfoDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public MusicInfoDataDao_Impl$9(MusicInfoDataDao_Impl musicInfoDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = musicInfoDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = MusicInfoDataDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "id";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            string2 = "musicName";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string3 = "albumType";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "albumName";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "musicPath";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "musicUrl";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "musicImage";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "duration";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "size";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "import_timestamp";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            int n20 = roomSQLiteQuery.getCount();
            ArrayList<MusicInfoData> arrayList = new ArrayList<MusicInfoData>(n20);
            while ((n20 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                String string11;
                MusicInfoData musicInfoData = new MusicInfoData();
                int n21 = roomSQLiteQuery.getInt(n11);
                musicInfoData.setId(n21);
                n21 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                if (n21 != 0) {
                    n21 = 0;
                    string11 = null;
                } else {
                    string11 = roomSQLiteQuery.getString(n10);
                }
                musicInfoData.setMusicName(string11);
                n21 = roomSQLiteQuery.getInt(n12);
                musicInfoData.setAlbumType(n21);
                n21 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                if (n21 != 0) {
                    n21 = 0;
                    string11 = null;
                } else {
                    string11 = roomSQLiteQuery.getString(n13);
                }
                musicInfoData.setAlbumName(string11);
                n21 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                if (n21 != 0) {
                    n21 = 0;
                    string11 = null;
                } else {
                    string11 = roomSQLiteQuery.getString(n14);
                }
                musicInfoData.setMusicPath(string11);
                n21 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                if (n21 != 0) {
                    n21 = 0;
                    string11 = null;
                } else {
                    string11 = roomSQLiteQuery.getString(n15);
                }
                musicInfoData.setMusicUrl(string11);
                n21 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                if (n21 != 0) {
                    n21 = 0;
                    string11 = null;
                } else {
                    string11 = roomSQLiteQuery.getString(n16);
                }
                musicInfoData.setMusicImage(string11);
                long l10 = roomSQLiteQuery.getLong(n17);
                musicInfoData.setDuration(l10);
                l10 = roomSQLiteQuery.getLong(n18);
                musicInfoData.setSize(l10);
                l10 = roomSQLiteQuery.getLong(n19);
                musicInfoData.setImportTimestamp(l10);
                arrayList.add(musicInfoData);
            }
            return arrayList;
        }
        finally {
            roomSQLiteQuery.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

