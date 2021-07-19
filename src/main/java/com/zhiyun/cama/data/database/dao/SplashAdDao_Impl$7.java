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
import java.util.concurrent.Callable;

public class SplashAdDao_Impl$7
implements Callable {
    public final /* synthetic */ SplashAdDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public SplashAdDao_Impl$7(SplashAdDao_Impl splashAdDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = splashAdDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SplashAd call() {
        Object object = this;
        Object object2 = SplashAdDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        boolean bl2 = false;
        String string2 = null;
        int n10 = 0;
        Object object3 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            block12: {
                Object object4;
                Object object5;
                boolean bl3;
                boolean bl4;
                Object object6;
                long l10;
                long l11;
                Object object7;
                Object object8;
                Object object9;
                int n11;
                int n12;
                long l12;
                Object object10;
                Object object11;
                Object object12;
                Object object13;
                Object object14;
                int n13;
                block15: {
                    boolean bl5;
                    int n14;
                    int n15;
                    block14: {
                        int n16;
                        block13: {
                            n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                            String string3 = "code";
                            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
                            String string4 = "text";
                            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
                            String string5 = "image";
                            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                            String string6 = "url";
                            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                            String string7 = "refType";
                            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                            String string8 = "refId";
                            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                            String string9 = "type";
                            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                            String string10 = "period";
                            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                            String string11 = "region";
                            int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                            String string12 = "startAt";
                            int n26 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
                            String string13 = "endAt";
                            int n27 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
                            string2 = "startUnix";
                            int n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                            object3 = "endUnix";
                            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                            object = "filePath";
                            int n29 = n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            object = "isVideo";
                            int n30 = n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            object = "isAutoDisappear";
                            int n31 = n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            object = "lang";
                            int n32 = n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            object = "watchId";
                            int n33 = n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            object = "isWatched";
                            n16 = n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            object = "watchTime";
                            n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            boolean bl6 = roomSQLiteQuery.moveToFirst();
                            if (!bl6) break block12;
                            n13 = roomSQLiteQuery.getInt(n15);
                            n15 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0);
                            object14 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n17));
                            n15 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                            object13 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n18));
                            n15 = (int)(roomSQLiteQuery.isNull(n19) ? 1 : 0);
                            object12 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n19));
                            n15 = (int)(roomSQLiteQuery.isNull(n20) ? 1 : 0);
                            object11 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n20));
                            n15 = (int)(roomSQLiteQuery.isNull(n21) ? 1 : 0);
                            object10 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n21));
                            l12 = roomSQLiteQuery.getLong(n22);
                            n12 = roomSQLiteQuery.getInt(n23);
                            n11 = roomSQLiteQuery.getInt(n24);
                            n15 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0);
                            object9 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n25));
                            n15 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0);
                            object8 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n26));
                            n15 = (int)(roomSQLiteQuery.isNull(n27) ? 1 : 0);
                            object7 = n15 != 0 ? null : (object2 = roomSQLiteQuery.getString(n27));
                            l11 = roomSQLiteQuery.getLong(n28);
                            l10 = roomSQLiteQuery.getLong(n10);
                            n15 = n29;
                            boolean bl7 = roomSQLiteQuery.isNull(n29);
                            if (bl7) {
                                n15 = n30;
                                object6 = null;
                            } else {
                                object6 = object2 = roomSQLiteQuery.getString(n29);
                                n15 = n30;
                            }
                            n15 = roomSQLiteQuery.getInt(n15);
                            boolean bl8 = true;
                            if (n15 != 0) {
                                bl4 = bl8;
                                n15 = n31;
                            } else {
                                n15 = n31;
                                bl4 = false;
                            }
                            n15 = roomSQLiteQuery.getInt(n15);
                            if (n15 != 0) {
                                bl3 = bl8;
                                n15 = n32;
                            } else {
                                n15 = n32;
                                bl3 = false;
                            }
                            n10 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                            if (n10 != 0) {
                                n15 = n33;
                                object5 = null;
                            } else {
                                object5 = object2 = roomSQLiteQuery.getString(n15);
                                n15 = n33;
                            }
                            n10 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                            if (n10 == 0) break block13;
                            n10 = n16;
                            n17 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                            if (n17 == 0 || (n17 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0)) == 0) break block14;
                            object4 = null;
                            break block15;
                        }
                        n10 = n16;
                    }
                    n15 = roomSQLiteQuery.getInt(n15);
                    if ((n10 = roomSQLiteQuery.getInt(n10)) == 0) {
                        bl5 = false;
                        string2 = null;
                    }
                    long l13 = roomSQLiteQuery.getLong(n14);
                    object4 = object = new SplashAdWatch(n15, bl5, l13);
                }
                object3 = new SplashAd(n13, (String)object14, (String)object13, (String)object12, (String)object11, (String)object10, l12, n12, n11, (String)object9, (String)object8, (String)object7, l11, l10, (String)object6, bl4, bl3, (String)object5, (SplashAdWatch)object4);
                return object3;
            }
            n10 = 0;
            object3 = null;
            return object3;
        }
        finally {
            roomSQLiteQuery.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

