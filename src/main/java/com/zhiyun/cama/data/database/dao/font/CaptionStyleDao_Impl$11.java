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
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.font.CaptionStyleData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CaptionStyleDao_Impl$11
implements Callable {
    public final /* synthetic */ CaptionStyleDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public CaptionStyleDao_Impl$11(CaptionStyleDao_Impl captionStyleDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = captionStyleDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        Object object2 = CaptionStyleDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        ArrayList<Object> arrayList = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "size";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            string2 = "path";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string3 = "hash";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "thumb";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "licensePath";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "licenseName";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "requiredPrime";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "id";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "res_id";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "label";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "label_tw";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            String string12 = "label_en";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            String string13 = "sort";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
            int n23 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n23);
            while ((n23 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                int n24;
                long l10 = roomSQLiteQuery.getLong(n11);
                n23 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                Object object3 = n23 != 0 ? null : (object = roomSQLiteQuery.getString(n10));
                n23 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                Object object4 = n23 != 0 ? null : (object = roomSQLiteQuery.getString(n12));
                n23 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                Object object5 = n23 != 0 ? null : (object = roomSQLiteQuery.getString(n13));
                int n25 = roomSQLiteQuery.getInt(n16);
                long l11 = roomSQLiteQuery.getLong(n18);
                n23 = (int)(roomSQLiteQuery.isNull(n19) ? 1 : 0);
                Object object6 = n23 != 0 ? null : (object = roomSQLiteQuery.getString(n19));
                n23 = (int)(roomSQLiteQuery.isNull(n20) ? 1 : 0);
                Object object7 = n23 != 0 ? null : (object = roomSQLiteQuery.getString(n20));
                n23 = (int)(roomSQLiteQuery.isNull(n21) ? 1 : 0);
                Object object8 = n23 != 0 ? null : (object = roomSQLiteQuery.getString(n21));
                int n26 = roomSQLiteQuery.getInt(n22);
                Object object9 = object;
                object = new CaptionStyleData(l11, (String)object6, (String)object7, (String)object8, n26, l10, (String)object3, (String)object4, (String)object5, n25);
                int n27 = roomSQLiteQuery.isNull(n14);
                if (n27 != 0) {
                    n24 = n11;
                    n11 = 0;
                    object2 = null;
                } else {
                    object9 = roomSQLiteQuery.getString(n14);
                    n24 = n11;
                    object2 = object9;
                }
                ((CaptionStyleData)object).setLicensePath((String)object2);
                n11 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    object2 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n15);
                }
                ((CaptionStyleData)object).setLicenseName((String)object2);
                n11 = n12;
                n27 = n13;
                long l12 = roomSQLiteQuery.getLong(n17);
                ((ResourceData)object).setId(l12);
                arrayList.add(object);
                n11 = n24;
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

