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
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$14;
import com.zhiyun.cama.data.database.model.MessageViolation;
import java.util.ArrayList;
import java.util.List;

public class MessageDao_Impl$14$1
extends LimitOffsetDataSource {
    public final /* synthetic */ MessageDao_Impl$14 this$1;

    public MessageDao_Impl$14$1(MessageDao_Impl$14 messageDao_Impl$14, RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl2, boolean bl3, String ... stringArray) {
        this.this$1 = messageDao_Impl$14;
        super(roomDatabase, roomSQLiteQuery, bl2, bl3, stringArray);
    }

    public List convertRows(Cursor cursor) {
        int n10;
        Object object = cursor;
        String string2 = "id";
        int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
        String string3 = "verb";
        int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
        String string4 = "refId";
        int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
        String string5 = "refType";
        int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
        String string6 = "content";
        int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
        String string7 = "createAt";
        int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
        String string8 = "isRead";
        int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
        String string9 = "build_time";
        int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
        String string10 = "degree";
        int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
        String string11 = "refuse_reason";
        int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
        String string12 = "appeal_id";
        int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
        String string13 = "appeal_status";
        int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
        String string14 = "has_punish";
        int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string14);
        String string15 = "classify";
        int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string15);
        int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "punish");
        int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "forever");
        int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "punish_endtime");
        int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "circle_name");
        int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "source");
        int n30 = n10 = CursorUtil.getColumnIndexOrThrow(cursor, "source_id");
        int n31 = n24;
        n24 = cursor.getCount();
        ArrayList<Cursor> arrayList = new ArrayList<Cursor>(n24);
        while ((n24 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
            String string16;
            String string17;
            int n32 = object.getInt(n11);
            n24 = (int)(object.isNull(n12) ? 1 : 0);
            String string18 = n24 != 0 ? null : (string15 = object.getString(n12));
            int n33 = object.getInt(n13);
            n24 = (int)(object.isNull(n14) ? 1 : 0);
            String string19 = n24 != 0 ? null : (string15 = object.getString(n14));
            n24 = (int)(object.isNull(n15) ? 1 : 0);
            String string20 = n24 != 0 ? null : (string15 = object.getString(n15));
            n24 = (int)(object.isNull(n16) ? 1 : 0);
            String string21 = n24 != 0 ? null : (string15 = object.getString(n16));
            int n34 = object.getInt(n17);
            n24 = (int)(object.isNull(n18) ? 1 : 0);
            String string22 = n24 != 0 ? null : (string15 = object.getString(n18));
            n24 = (int)(object.isNull(n19) ? 1 : 0);
            String string23 = n24 != 0 ? null : (string15 = object.getString(n19));
            n24 = (int)(object.isNull(n20) ? 1 : 0);
            String string24 = n24 != 0 ? null : (string15 = object.getString(n20));
            n24 = (int)(object.isNull(n21) ? 1 : 0);
            String string25 = n24 != 0 ? null : (string15 = object.getString(n21));
            n24 = (int)(object.isNull(n22) ? 1 : 0);
            String string26 = n24 != 0 ? null : (string15 = object.getString(n22));
            n24 = (int)(object.isNull(n23) ? 1 : 0);
            if (n24 != 0) {
                n24 = n31;
                string17 = null;
            } else {
                string17 = string15 = object.getString(n23);
                n24 = n31;
            }
            n31 = (int)(object.isNull(n24) ? 1 : 0);
            String string27 = n31 != 0 ? null : (string16 = object.getString(n24));
            int n35 = n25;
            n25 = n11;
            n11 = n35;
            n31 = (int)(object.isNull(n35) ? 1 : 0);
            String string28 = n31 != 0 ? null : (string16 = object.getString(n35));
            n35 = n26;
            n26 = n11;
            n11 = n35;
            n31 = (int)(object.isNull(n35) ? 1 : 0);
            String string29 = n31 != 0 ? null : (string16 = object.getString(n35));
            n35 = n27;
            n27 = n11;
            n11 = n35;
            n31 = (int)(object.isNull(n35) ? 1 : 0);
            String string30 = n31 != 0 ? null : (string16 = object.getString(n35));
            n35 = n28;
            n28 = n11;
            n11 = n35;
            n31 = (int)(object.isNull(n35) ? 1 : 0);
            String string31 = n31 != 0 ? null : (string16 = object.getString(n35));
            n35 = n29;
            n29 = n11;
            n11 = n35;
            n31 = (int)(object.isNull(n35) ? 1 : 0);
            String string32 = n31 != 0 ? null : (string16 = object.getString(n35));
            n35 = n30;
            n30 = n11;
            n11 = n35;
            long l10 = object.getLong(n35);
            object = new MessageViolation(n32, string18, n33, string19, string20, string21, n34, string22, string23, string24, string25, string26, string17, string27, string28, string29, string30, string31, string32, l10);
            arrayList.add((Cursor)object);
            object = cursor;
            n31 = n24;
            n35 = n30;
            n30 = n11;
            n11 = n25;
            n25 = n26;
            n26 = n27;
            n27 = n28;
            n28 = n29;
            n29 = n35;
        }
        return arrayList;
    }
}

