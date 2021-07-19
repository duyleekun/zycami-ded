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
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl;
import com.zhiyun.cama.data.database.model.filter.FilterType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class FilterTypeDao_Impl$10
implements Callable {
    public final /* synthetic */ FilterTypeDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public FilterTypeDao_Impl$10(FilterTypeDao_Impl filterTypeDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = filterTypeDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        RoomDatabase roomDatabase = FilterTypeDao_Impl.access$000(this.this$0);
        Object object = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object, false, null);
        object = "thumb";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object);
            string2 = "id";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            String string3 = "res_id";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            String string4 = "label";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
            String string5 = "label_tw";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
            String string6 = "label_en";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string6);
            String string7 = "sort";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string7);
            int n17 = roomDatabase.getCount();
            ArrayList<FilterType> arrayList = new ArrayList<FilterType>(n17);
            while ((n17 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                String string8;
                FilterType filterType = new FilterType();
                int n18 = roomDatabase.isNull(n11);
                if (n18 != 0) {
                    n18 = 0;
                    string8 = null;
                } else {
                    string8 = roomDatabase.getString(n11);
                }
                filterType.setThumb(string8);
                long l10 = roomDatabase.getLong(n10);
                filterType.setId(l10);
                l10 = roomDatabase.getLong(n12);
                filterType.setResId(l10);
                n18 = roomDatabase.isNull(n13);
                if (n18 != 0) {
                    n18 = 0;
                    string8 = null;
                } else {
                    string8 = roomDatabase.getString(n13);
                }
                filterType.setLabel(string8);
                n18 = roomDatabase.isNull(n14);
                if (n18 != 0) {
                    n18 = 0;
                    string8 = null;
                } else {
                    string8 = roomDatabase.getString(n14);
                }
                filterType.setLabel_tw(string8);
                n18 = roomDatabase.isNull(n15);
                if (n18 != 0) {
                    n18 = 0;
                    string8 = null;
                } else {
                    string8 = roomDatabase.getString(n15);
                }
                filterType.setLabel_en(string8);
                n18 = roomDatabase.getInt(n16);
                filterType.setSort(n18);
                arrayList.add(filterType);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

