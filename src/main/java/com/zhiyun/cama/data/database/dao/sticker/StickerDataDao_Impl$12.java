/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.sticker;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.sticker.StickerData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class StickerDataDao_Impl$12
implements Callable {
    public final /* synthetic */ StickerDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public StickerDataDao_Impl$12(StickerDataDao_Impl stickerDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = stickerDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        Object object2 = StickerDataDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        int n11 = 0;
        String string3 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "type_id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            string2 = "size";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string4 = "name";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "scale";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "thumb";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "little_thumb";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "path";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "hash";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            ArrayList<Object> arrayList = "licensePath";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            String string10 = "licenseName";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "requiredPrime";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            String string12 = "id";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            String string13 = "res_id";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
            string3 = "label";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            object = "label_tw";
            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            int n25 = n22;
            string12 = "label_en";
            n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            int n26 = n20;
            string10 = "sort";
            n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            int n27 = n19;
            int n28 = n20;
            n20 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n20);
            while ((n20 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                int n29;
                String string14;
                long l10 = roomSQLiteQuery.getLong(n12);
                long l11 = roomSQLiteQuery.getLong(n10);
                n20 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                String string15 = n20 != 0 ? null : (string10 = roomSQLiteQuery.getString(n13));
                float f10 = roomSQLiteQuery.getFloat(n14);
                n20 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                String string16 = n20 != 0 ? null : (string10 = roomSQLiteQuery.getString(n15));
                n20 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                String string17 = n20 != 0 ? null : (string10 = roomSQLiteQuery.getString(n16));
                n20 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0);
                String string18 = n20 != 0 ? null : (string10 = roomSQLiteQuery.getString(n17));
                n20 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                String string19 = n20 != 0 ? null : (string10 = roomSQLiteQuery.getString(n18));
                int n30 = roomSQLiteQuery.getInt(n21);
                long l12 = roomSQLiteQuery.getLong(n23);
                n20 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                String string20 = n20 != 0 ? null : (string10 = roomSQLiteQuery.getString(n11));
                n20 = (int)(roomSQLiteQuery.isNull(n24) ? 1 : 0);
                String string21 = n20 != 0 ? null : (string10 = roomSQLiteQuery.getString(n24));
                n20 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0);
                if (n20 != 0) {
                    n20 = n28;
                    string14 = null;
                } else {
                    string14 = string10 = roomSQLiteQuery.getString(n22);
                    n20 = n28;
                }
                int n31 = roomSQLiteQuery.getInt(n20);
                n28 = n12;
                object2 = new StickerData(l12, string20, string21, string14, n31, l10, l11, string15, f10, string16, string17, string18, string19, n30);
                int n32 = n24;
                n24 = n27;
                n27 = (int)(roomSQLiteQuery.isNull(n27) ? 1 : 0);
                if (n27 != 0) {
                    n29 = n24;
                    n24 = 0;
                    object = null;
                } else {
                    String string22 = roomSQLiteQuery.getString(n24);
                    n29 = n24;
                    object = string22;
                }
                ((StickerData)object2).setLicensePath((String)object);
                n24 = n26;
                n26 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0);
                if (n26 != 0) {
                    n27 = n24;
                    n24 = 0;
                    object = null;
                } else {
                    String string23 = roomSQLiteQuery.getString(n24);
                    n27 = n24;
                    object = string23;
                }
                ((StickerData)object2).setLicenseName((String)object);
                n26 = n11;
                n24 = n25;
                n25 = n10;
                long l13 = roomSQLiteQuery.getLong(n24);
                ((ResourceData)object2).setId(l13);
                arrayList.add(object2);
                n26 = n27;
                n12 = n28;
                n27 = n29;
                n25 = n24;
                n28 = n20;
                n24 = n32;
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

