/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.music;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.music.AlbumData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class AlbumDao_Impl$10
implements Callable {
    public final /* synthetic */ AlbumDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public AlbumDao_Impl$10(AlbumDao_Impl albumDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = albumDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = AlbumDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "cover_url";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            string2 = "song_count";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string3 = "id";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "res_id";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "label";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "label_tw";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "label_en";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "sort";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            int n18 = roomSQLiteQuery.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n18);
            while ((n18 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                String string9;
                String string10;
                String string11;
                Object object2;
                String string12;
                n18 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                if (n18 != 0) {
                    string12 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n11);
                    string12 = object2;
                }
                int n19 = roomSQLiteQuery.getInt(n10);
                long l10 = roomSQLiteQuery.getLong(n13);
                n18 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                if (n18 != 0) {
                    string11 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n14);
                    string11 = object2;
                }
                n18 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                if (n18 != 0) {
                    string10 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n15);
                    string10 = object2;
                }
                n18 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                if (n18 != 0) {
                    string9 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n16);
                    string9 = object2;
                }
                int n20 = roomSQLiteQuery.getInt(n17);
                object2 = new AlbumData(l10, string11, string10, string9, n20, string12, n19);
                long l11 = roomSQLiteQuery.getLong(n12);
                ((ResourceData)object2).setId(l11);
                arrayList.add(object2);
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

