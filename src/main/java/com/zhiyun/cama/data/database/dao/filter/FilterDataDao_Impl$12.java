/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.filter;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.filter.FilterData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class FilterDataDao_Impl$12
implements Callable {
    public final /* synthetic */ FilterDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public FilterDataDao_Impl$12(FilterDataDao_Impl filterDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = filterDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        Object object2 = FilterDataDao_Impl.access$000(this.this$0);
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
            String string4 = "path";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "thumb";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "hash";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "main_sort";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "licensePath";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            Object object3 = "licenseName";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
            String string9 = "requiredPrime";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            ArrayList<Object> arrayList = "id";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            String string10 = "res_id";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "label";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            String string12 = "label_tw";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            string3 = "label_en";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            object = "sort";
            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            int n25 = n20;
            int n26 = n18;
            n18 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n18);
            while ((n18 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                int n27;
                String string13;
                String string14;
                String string15;
                String string16;
                String string17;
                String string18;
                long l10 = roomSQLiteQuery.getLong(n12);
                long l11 = roomSQLiteQuery.getLong(n10);
                n18 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                if (n18 != 0) {
                    string18 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n13);
                    string18 = object3;
                }
                n18 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                if (n18 != 0) {
                    string17 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n14);
                    string17 = object3;
                }
                n18 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                if (n18 != 0) {
                    string16 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n15);
                    string16 = object3;
                }
                int n28 = roomSQLiteQuery.getInt(n16);
                int n29 = roomSQLiteQuery.getInt(n19);
                long l12 = roomSQLiteQuery.getLong(n21);
                n18 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0);
                if (n18 != 0) {
                    string15 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n22);
                    string15 = object3;
                }
                n18 = (int)(roomSQLiteQuery.isNull(n23) ? 1 : 0);
                if (n18 != 0) {
                    string14 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n23);
                    string14 = object3;
                }
                n18 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                if (n18 != 0) {
                    string13 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n11);
                    string13 = object3;
                }
                int n30 = roomSQLiteQuery.getInt(n24);
                Object object4 = object3;
                object3 = new FilterData(l12, string15, string14, string13, n30, l10, l11, string18, string17, string16, n28, n29);
                int n31 = roomSQLiteQuery.isNull(n17);
                if (n31 != 0) {
                    n27 = n12;
                    n12 = 0;
                    object2 = null;
                } else {
                    object4 = roomSQLiteQuery.getString(n17);
                    n27 = n12;
                    object2 = object4;
                }
                ((FilterData)object3).setLicensePath((String)object2);
                n12 = n26;
                n26 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0);
                if (n26 != 0) {
                    n31 = n12;
                    n12 = 0;
                    object2 = null;
                } else {
                    String string19 = roomSQLiteQuery.getString(n12);
                    n31 = n12;
                    object2 = string19;
                }
                ((FilterData)object3).setLicenseName((String)object2);
                n26 = n11;
                n12 = n25;
                n25 = n10;
                long l13 = roomSQLiteQuery.getLong(n12);
                ((ResourceData)object3).setId(l13);
                arrayList.add(object3);
                n26 = n31;
                n25 = n12;
                n12 = n27;
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

