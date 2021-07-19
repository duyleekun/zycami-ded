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
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl;
import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.cama.data.database.model.SplashAdWatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SplashAdDao_Impl$4
implements Callable {
    public final /* synthetic */ SplashAdDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public SplashAdDao_Impl$4(SplashAdDao_Impl splashAdDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = splashAdDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        ArrayList<Object> arrayList = this;
        Object object = SplashAdDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        Object object2 = null;
        int n11 = 0;
        String string2 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "id";
        try {
            int n12;
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            String string3 = "code";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "text";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "image";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "url";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "refType";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "refId";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "type";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "period";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "region";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            String string12 = "startAt";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            String string13 = "endAt";
            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
            object2 = "startUnix";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            string2 = "endUnix";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            arrayList = "filePath";
            int n25 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "isVideo";
            int n26 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "isAutoDisappear";
            int n27 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "lang";
            int n28 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "watchId";
            int n29 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "isWatched";
            int n30 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "watchTime";
            int n31 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            int n32 = n11;
            n11 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n11);
            while ((n11 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                Object object3;
                int n33;
                int n34;
                int n35;
                int n36;
                String string14;
                int n37;
                int n38;
                String string15;
                long l10;
                long l11;
                String string16;
                String string17;
                String string18;
                int n39;
                int n40;
                long l12;
                String string19;
                String string20;
                String string21;
                String string22;
                String string23;
                int n41;
                block17: {
                    int n42;
                    int n43;
                    block16: {
                        block15: {
                            block14: {
                                n41 = roomSQLiteQuery.getInt(n13);
                                n11 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                                string23 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n14));
                                n11 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                string22 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n15));
                                n11 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                                string21 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n16));
                                n11 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0);
                                string20 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n17));
                                n11 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                                string19 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n18));
                                l12 = roomSQLiteQuery.getLong(n19);
                                n40 = roomSQLiteQuery.getInt(n20);
                                n39 = roomSQLiteQuery.getInt(n21);
                                n11 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0);
                                string18 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n22));
                                n11 = (int)(roomSQLiteQuery.isNull(n23) ? 1 : 0);
                                string17 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n23));
                                n11 = (int)(roomSQLiteQuery.isNull(n24) ? 1 : 0);
                                string16 = n11 != 0 ? null : (string2 = roomSQLiteQuery.getString(n24));
                                l11 = roomSQLiteQuery.getLong(n10);
                                n11 = n32;
                                l10 = roomSQLiteQuery.getLong(n32);
                                n32 = n13;
                                n13 = n25;
                                if ((n25 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0)) != 0) {
                                    n25 = n13;
                                    n13 = n26;
                                    string15 = null;
                                } else {
                                    String string24;
                                    string15 = string24 = roomSQLiteQuery.getString(n13);
                                    n25 = n13;
                                    n13 = n26;
                                }
                                n26 = roomSQLiteQuery.getInt(n13);
                                n43 = 1;
                                if (n26 != 0) {
                                    n26 = n13;
                                    n13 = n27;
                                    n38 = n43;
                                } else {
                                    n26 = n13;
                                    n13 = n27;
                                    n38 = 0;
                                }
                                n27 = roomSQLiteQuery.getInt(n13);
                                if (n27 != 0) {
                                    n27 = n13;
                                    n13 = n28;
                                    n37 = n43;
                                } else {
                                    n27 = n13;
                                    n13 = n28;
                                    n37 = 0;
                                }
                                n28 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                                if (n28 != 0) {
                                    n28 = n13;
                                    n13 = n29;
                                    string14 = null;
                                } else {
                                    String string25;
                                    string14 = string25 = roomSQLiteQuery.getString(n13);
                                    n28 = n13;
                                    n13 = n29;
                                }
                                n29 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                                if (n29 == 0) break block14;
                                n29 = n10;
                                n10 = n30;
                                if ((n30 = (int)(roomSQLiteQuery.isNull(n30) ? 1 : 0)) == 0) break block15;
                                n30 = n11;
                                n11 = n31;
                                if ((n31 = (int)(roomSQLiteQuery.isNull(n31) ? 1 : 0)) == 0) break block16;
                                n36 = n13;
                                n35 = n10;
                                n31 = n14;
                                n34 = n15;
                                n33 = n16;
                                n42 = 0;
                                object3 = null;
                                break block17;
                            }
                            n29 = n10;
                            n10 = n30;
                        }
                        n30 = n11;
                        n11 = n31;
                    }
                    n31 = n14;
                    n14 = roomSQLiteQuery.getInt(n13);
                    n42 = roomSQLiteQuery.getInt(n10);
                    n36 = n13;
                    n34 = n15;
                    n33 = n16;
                    if (n42 != 0) {
                        n13 = n43;
                    } else {
                        n13 = 0;
                        object = null;
                    }
                    long l13 = roomSQLiteQuery.getLong(n11);
                    n35 = n10;
                    object3 = object2 = new SplashAdWatch(n14, n13 != 0, l13);
                }
                object = new SplashAd(n41, string23, string22, string21, string20, string19, l12, n40, n39, string18, string17, string16, l11, l10, string15, n38 != 0, n37 != 0, string14, (SplashAdWatch)object3);
                arrayList.add(object);
                n10 = n29;
                n14 = n31;
                n13 = n32;
                n29 = n36;
                n15 = n34;
                n16 = n33;
                n31 = n11;
                n32 = n30;
                n30 = n35;
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

