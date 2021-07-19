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
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$12;
import com.zhiyun.cama.data.database.model.MessageSystem;
import java.util.ArrayList;
import java.util.List;

public class MessageDao_Impl$12$1
extends LimitOffsetDataSource {
    public final /* synthetic */ MessageDao_Impl$12 this$1;

    public MessageDao_Impl$12$1(MessageDao_Impl$12 messageDao_Impl$12, RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl2, boolean bl3, String ... stringArray) {
        this.this$1 = messageDao_Impl$12;
        super(roomDatabase, roomSQLiteQuery, bl2, bl3, stringArray);
    }

    public List convertRows(Cursor cursor) {
        int n10;
        Object object = cursor;
        String string2 = "id";
        int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
        String string3 = "createAt";
        int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
        String string4 = "isRead";
        int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
        String string5 = "verb";
        int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
        String string6 = "objectId";
        int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
        String string7 = "objectType";
        int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
        String string8 = "title";
        int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
        String string9 = "content";
        int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
        String string10 = "nickname";
        int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
        String string11 = "sourceUrls";
        int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
        String string12 = "endAt";
        int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
        String string13 = "image";
        int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
        String string14 = "userId";
        int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string14);
        String string15 = "avatar";
        int n24 = n10 = CursorUtil.getColumnIndexOrThrow(cursor, string15);
        n10 = cursor.getCount();
        ArrayList<Cursor> arrayList = new ArrayList<Cursor>(n10);
        while ((n10 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
            String string16;
            int n25 = object.getInt(n11);
            n10 = (int)(object.isNull(n12) ? 1 : 0);
            String string17 = n10 != 0 ? null : (string15 = object.getString(n12));
            int n26 = object.getInt(n13);
            n10 = (int)(object.isNull(n14) ? 1 : 0);
            String string18 = n10 != 0 ? null : (string15 = object.getString(n14));
            int n27 = object.getInt(n15);
            n10 = (int)(object.isNull(n16) ? 1 : 0);
            String string19 = n10 != 0 ? null : (string15 = object.getString(n16));
            n10 = (int)(object.isNull(n17) ? 1 : 0);
            String string20 = n10 != 0 ? null : (string15 = object.getString(n17));
            n10 = (int)(object.isNull(n18) ? 1 : 0);
            String string21 = n10 != 0 ? null : (string15 = object.getString(n18));
            n10 = (int)(object.isNull(n19) ? 1 : 0);
            String string22 = n10 != 0 ? null : (string15 = object.getString(n19));
            n10 = (int)(object.isNull(n20) ? 1 : 0);
            String string23 = n10 != 0 ? null : (string15 = object.getString(n20));
            n10 = (int)(object.isNull(n21) ? 1 : 0);
            String string24 = n10 != 0 ? null : (string15 = object.getString(n21));
            n10 = (int)(object.isNull(n22) ? 1 : 0);
            String string25 = n10 != 0 ? null : (string15 = object.getString(n22));
            int n28 = object.getInt(n23);
            n10 = n24;
            n24 = (int)(object.isNull(n24) ? 1 : 0);
            String string26 = n24 != 0 ? null : (string16 = object.getString(n10));
            object = new MessageSystem(n25, string17, n26, string18, n27, string19, string20, string21, string22, string23, string24, string25, n28, string26);
            arrayList.add((Cursor)object);
            object = cursor;
            n24 = n10;
        }
        return arrayList;
    }
}

