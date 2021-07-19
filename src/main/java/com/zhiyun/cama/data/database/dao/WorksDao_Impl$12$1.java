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
import com.zhiyun.cama.data.database.dao.WorksDao_Impl$12;
import com.zhiyun.cama.data.database.model.Likes;
import java.util.ArrayList;
import java.util.List;

public class WorksDao_Impl$12$1
extends LimitOffsetDataSource {
    public final /* synthetic */ WorksDao_Impl$12 this$1;

    public WorksDao_Impl$12$1(WorksDao_Impl$12 worksDao_Impl$12, RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl2, boolean bl3, String ... stringArray) {
        this.this$1 = worksDao_Impl$12;
        super(roomDatabase, roomSQLiteQuery, bl2, bl3, stringArray);
    }

    public List convertRows(Cursor cursor) {
        Cursor cursor2 = cursor;
        String string2 = "likeId";
        int n10 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
        String string3 = "user";
        int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
        String string4 = "id";
        int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
        String string5 = "sourceUrls";
        int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
        String string6 = "des";
        int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
        String string7 = "commentCnt";
        int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
        String string8 = "likeCnt";
        int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
        String string9 = "shareCnt";
        int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
        String string10 = "publishAt";
        int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
        String string11 = "pv";
        int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
        String string12 = "duration";
        int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
        String string13 = "thumbwh";
        int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
        String string14 = "userId";
        int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string14);
        int n23 = cursor.getCount();
        ArrayList<Object> arrayList = new ArrayList<Object>(n23);
        while ((n23 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
            String string15;
            String string16;
            String string17;
            String string18;
            String string19;
            String string20;
            String string21;
            String string22;
            Object object;
            String string23;
            long l10 = cursor2.getLong(n10);
            long l11 = cursor2.getLong(n11);
            long l12 = cursor2.getLong(n12);
            n23 = (int)(cursor2.isNull(n13) ? 1 : 0);
            if (n23 != 0) {
                string23 = null;
            } else {
                object = cursor2.getString(n13);
                string23 = object;
            }
            n23 = (int)(cursor2.isNull(n14) ? 1 : 0);
            if (n23 != 0) {
                string22 = null;
            } else {
                object = cursor2.getString(n14);
                string22 = object;
            }
            n23 = (int)(cursor2.isNull(n15) ? 1 : 0);
            if (n23 != 0) {
                string21 = null;
            } else {
                object = cursor2.getString(n15);
                string21 = object;
            }
            n23 = (int)(cursor2.isNull(n16) ? 1 : 0);
            if (n23 != 0) {
                string20 = null;
            } else {
                object = cursor2.getString(n16);
                string20 = object;
            }
            n23 = (int)(cursor2.isNull(n17) ? 1 : 0);
            if (n23 != 0) {
                string19 = null;
            } else {
                object = cursor2.getString(n17);
                string19 = object;
            }
            n23 = (int)(cursor2.isNull(n18) ? 1 : 0);
            if (n23 != 0) {
                string18 = null;
            } else {
                object = cursor2.getString(n18);
                string18 = object;
            }
            n23 = (int)(cursor2.isNull(n19) ? 1 : 0);
            if (n23 != 0) {
                string17 = null;
            } else {
                object = cursor2.getString(n19);
                string17 = object;
            }
            n23 = (int)(cursor2.isNull(n20) ? 1 : 0);
            if (n23 != 0) {
                string16 = null;
            } else {
                object = cursor2.getString(n20);
                string16 = object;
            }
            n23 = (int)(cursor2.isNull(n21) ? 1 : 0);
            if (n23 != 0) {
                string15 = null;
            } else {
                object = cursor2.getString(n21);
                string15 = object;
            }
            n23 = (int)(cursor2.isNull(n22) ? 1 : 0);
            Object object2 = n23 != 0 ? null : (object = cursor2.getString(n22));
            object = new Likes(l10, l11, l12, string23, string22, string21, string20, string19, string18, string17, string16, string15, (String)object2);
            arrayList.add(object);
        }
        return arrayList;
    }
}

