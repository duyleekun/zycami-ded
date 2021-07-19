/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.transition;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.transition.TransitionData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TransitionDataDao_Impl$11
implements Callable {
    public final /* synthetic */ TransitionDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public TransitionDataDao_Impl$11(TransitionDataDao_Impl transitionDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = transitionDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        Object object2 = TransitionDataDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        int n11 = 0;
        String string3 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "size";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            string2 = "path";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string4 = "hash";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "thumb";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "littleThumb";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "transitionType";
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
                String string19;
                long l10 = roomSQLiteQuery.getLong(n12);
                n18 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                if (n18 != 0) {
                    string19 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n10);
                    string19 = object3;
                }
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
                int n28 = roomSQLiteQuery.getInt(n19);
                long l11 = roomSQLiteQuery.getLong(n21);
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
                int n29 = roomSQLiteQuery.getInt(n24);
                object3 = new TransitionData(l11, string15, string14, string13, n29, l10, string19, string18, string17, string16, n28);
                int n30 = n12;
                n12 = roomSQLiteQuery.getInt(n16);
                ((TransitionData)object3).setTransitionType(n12);
                n12 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0);
                if (n12 != 0) {
                    n12 = 0;
                    object2 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n17);
                }
                ((TransitionData)object3).setLicensePath((String)object2);
                n12 = n26;
                n26 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0);
                if (n26 != 0) {
                    n27 = n12;
                    n12 = 0;
                    object2 = null;
                } else {
                    String string20 = roomSQLiteQuery.getString(n12);
                    n27 = n12;
                    object2 = string20;
                }
                ((TransitionData)object3).setLicenseName((String)object2);
                n26 = n11;
                n12 = n25;
                n25 = n10;
                long l12 = roomSQLiteQuery.getLong(n12);
                ((ResourceData)object3).setId(l12);
                arrayList.add(object3);
                n26 = n27;
                n25 = n12;
                n12 = n30;
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

