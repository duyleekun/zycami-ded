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
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.music.MusicData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MusicDao_Impl$16
implements Callable {
    public final /* synthetic */ MusicDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public MusicDao_Impl$16(MusicDao_Impl musicDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = musicDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        ArrayList<Object> arrayList = this;
        Object object = MusicDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        int n11 = 0;
        String string3 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "album_id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            string2 = "thumb";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string4 = "hash";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "duration";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "size";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "path";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "file_download_timestamp";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "requiredPrime";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            Object object2 = "id";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            String string10 = "res_id";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "label";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            String string12 = "label_tw";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            String string13 = "label_en";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
            string3 = "sort";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            int n24 = n19;
            n19 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n19);
            while ((n19 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                Object object3;
                n19 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                if (n19 != 0) {
                    object3 = null;
                } else {
                    long l10 = roomSQLiteQuery.getLong(n12);
                    object3 = object2 = Long.valueOf(l10);
                }
                n19 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                Object object4 = n19 != 0 ? null : (object2 = roomSQLiteQuery.getString(n10));
                n19 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                Object object5 = n19 != 0 ? null : (object2 = roomSQLiteQuery.getString(n13));
                long l11 = roomSQLiteQuery.getLong(n14);
                long l12 = roomSQLiteQuery.getLong(n15);
                n19 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                Object object6 = n19 != 0 ? null : (object2 = roomSQLiteQuery.getString(n16));
                int n25 = roomSQLiteQuery.getInt(n18);
                long l13 = roomSQLiteQuery.getLong(n20);
                n19 = (int)(roomSQLiteQuery.isNull(n21) ? 1 : 0);
                Object object7 = n19 != 0 ? null : (object2 = roomSQLiteQuery.getString(n21));
                n19 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0);
                Object object8 = n19 != 0 ? null : (object2 = roomSQLiteQuery.getString(n22));
                n19 = (int)(roomSQLiteQuery.isNull(n23) ? 1 : 0);
                Object object9 = n19 != 0 ? null : (object2 = roomSQLiteQuery.getString(n23));
                int n26 = roomSQLiteQuery.getInt(n11);
                object2 = new MusicData(l13, (Long)object3, (String)object7, (String)object8, (String)object9, n26, (String)object5, l11, l12, (String)object6, (String)object4, n25);
                int n27 = n10;
                long l14 = roomSQLiteQuery.getLong(n17);
                ((MusicData)object2).setFileDownloadTimestamp(l14);
                n10 = n24;
                n24 = n13;
                long l15 = roomSQLiteQuery.getLong(n10);
                ((ResourceData)object2).setId(l15);
                arrayList.add(object2);
                n24 = n10;
                n10 = n27;
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

