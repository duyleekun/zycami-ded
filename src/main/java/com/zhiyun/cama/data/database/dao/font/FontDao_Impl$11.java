/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.font;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.font.FontData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class FontDao_Impl$11
implements Callable {
    public final /* synthetic */ FontDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public FontDao_Impl$11(FontDao_Impl fontDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = fontDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = FontDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "size";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            string2 = "path";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string3 = "hash";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "thumb";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "requiredPrime";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "id";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "res_id";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "label";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "label_tw";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "label_en";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "sort";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            int n21 = roomSQLiteQuery.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n21);
            while ((n21 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                String string12;
                String string13;
                String string14;
                String string15;
                String string16;
                Object object2;
                String string17;
                long l10 = roomSQLiteQuery.getLong(n11);
                n21 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                if (n21 != 0) {
                    string17 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n10);
                    string17 = object2;
                }
                n21 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                if (n21 != 0) {
                    string16 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n12);
                    string16 = object2;
                }
                n21 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                if (n21 != 0) {
                    string15 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n13);
                    string15 = object2;
                }
                int n22 = roomSQLiteQuery.getInt(n14);
                long l11 = roomSQLiteQuery.getLong(n16);
                n21 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0);
                if (n21 != 0) {
                    string14 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n17);
                    string14 = object2;
                }
                n21 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                if (n21 != 0) {
                    string13 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n18);
                    string13 = object2;
                }
                n21 = (int)(roomSQLiteQuery.isNull(n19) ? 1 : 0);
                if (n21 != 0) {
                    string12 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n19);
                    string12 = object2;
                }
                int n23 = roomSQLiteQuery.getInt(n20);
                object2 = new FontData(l11, string14, string13, string12, n23, l10, string17, string16, string15, n22);
                long l12 = roomSQLiteQuery.getLong(n15);
                ((ResourceData)object2).setId(l12);
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

