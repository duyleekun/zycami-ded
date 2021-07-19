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
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$11;
import com.zhiyun.cama.data.database.model.MessageLike;
import java.util.ArrayList;
import java.util.List;

public class MessageDao_Impl$11$1
extends LimitOffsetDataSource {
    public final /* synthetic */ MessageDao_Impl$11 this$1;

    public MessageDao_Impl$11$1(MessageDao_Impl$11 messageDao_Impl$11, RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl2, boolean bl3, String ... stringArray) {
        this.this$1 = messageDao_Impl$11;
        super(roomDatabase, roomSQLiteQuery, bl2, bl3, stringArray);
    }

    public List convertRows(Cursor cursor) {
        Cursor cursor2 = cursor;
        String string2 = "id";
        int n10 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
        String string3 = "userId";
        int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
        String string4 = "nickname";
        int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
        String string5 = "avatar";
        int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
        String string6 = "verified";
        int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
        String string7 = "workType";
        int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
        String string8 = "circleArticleId";
        int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
        String string9 = "postId";
        int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
        String string10 = "sourceUrls";
        int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
        String string11 = "createAt";
        int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
        String string12 = "isRead";
        int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
        String string13 = "targetText";
        int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
        int n22 = cursor.getCount();
        ArrayList<Object> arrayList = new ArrayList<Object>(n22);
        while ((n22 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
            String string14;
            String string15;
            String string16;
            String string17;
            Object object;
            String string18;
            int n23 = cursor2.getInt(n10);
            int n24 = cursor2.getInt(n11);
            n22 = (int)(cursor2.isNull(n12) ? 1 : 0);
            if (n22 != 0) {
                string18 = null;
            } else {
                object = cursor2.getString(n12);
                string18 = object;
            }
            n22 = (int)(cursor2.isNull(n13) ? 1 : 0);
            if (n22 != 0) {
                string17 = null;
            } else {
                object = cursor2.getString(n13);
                string17 = object;
            }
            int n25 = cursor2.getInt(n14);
            n22 = (int)(cursor2.isNull(n15) ? 1 : 0);
            if (n22 != 0) {
                string16 = null;
            } else {
                object = cursor2.getString(n15);
                string16 = object;
            }
            int n26 = cursor2.getInt(n16);
            int n27 = cursor2.getInt(n17);
            n22 = (int)(cursor2.isNull(n18) ? 1 : 0);
            if (n22 != 0) {
                string15 = null;
            } else {
                object = cursor2.getString(n18);
                string15 = object;
            }
            n22 = (int)(cursor2.isNull(n19) ? 1 : 0);
            if (n22 != 0) {
                string14 = null;
            } else {
                object = cursor2.getString(n19);
                string14 = object;
            }
            int n28 = cursor2.getInt(n20);
            n22 = (int)(cursor2.isNull(n21) ? 1 : 0);
            Object object2 = n22 != 0 ? null : (object = cursor2.getString(n21));
            object = new MessageLike(n23, n24, string18, string17, n25, string16, n26, n27, string15, string14, n28, (String)object2);
            arrayList.add(object);
        }
        return arrayList;
    }
}

