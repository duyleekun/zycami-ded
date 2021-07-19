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
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import java.util.concurrent.Callable;

public class MessageDao_Impl$13
implements Callable {
    public final /* synthetic */ MessageDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public MessageDao_Impl$13(MessageDao_Impl messageDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = messageDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public MessageUnReadCount call() {
        MessageUnReadCount messageUnReadCount;
        RoomSQLiteQuery roomSQLiteQuery;
        block21: {
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            boolean bl2;
            block22: {
                Object object = MessageDao_Impl.access$000(this.this$0);
                roomSQLiteQuery = this.val$_statement;
                bl2 = false;
                messageUnReadCount = null;
                roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
                object = "id";
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                String string2 = "message";
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                String string3 = "comment";
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
                String string4 = "follow";
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
                String string5 = "like";
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                String string6 = "personal";
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                String string7 = "notice";
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                String string8 = "punished";
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                boolean bl3 = roomSQLiteQuery.moveToFirst();
                if (!bl3) break block21;
                n16 = roomSQLiteQuery.getInt(n17);
                n15 = roomSQLiteQuery.getInt(n18);
                n14 = roomSQLiteQuery.getInt(n19);
                n13 = roomSQLiteQuery.getInt(n20);
                n12 = roomSQLiteQuery.getInt(n21);
                n11 = roomSQLiteQuery.getInt(n22);
                n10 = roomSQLiteQuery.getInt(n23);
                n17 = roomSQLiteQuery.getInt(n24);
                if (n17 == 0) break block22;
                bl2 = true;
            }
            messageUnReadCount = new MessageUnReadCount(n16, n15, n14, n13, n12, n11, n10, bl2);
        }
        return messageUnReadCount;
        finally {
            roomSQLiteQuery.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

