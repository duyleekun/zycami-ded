/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_WithdrawDao_Impl$11
implements Callable {
    public final /* synthetic */ G_WithdrawDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_WithdrawDao_Impl$11(G_WithdrawDao_Impl g_WithdrawDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_WithdrawDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        RoomDatabase roomDatabase = G_WithdrawDao_Impl.access$000(this.this$0);
        Object object = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        int n11 = 0;
        String string3 = null;
        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object, false, null);
        object = "id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object);
            string2 = "back_id";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            string3 = "create_time";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            int n13 = roomDatabase.getCount();
            ArrayList<Withdraw> arrayList = new ArrayList<Withdraw>(n13);
            while ((n13 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                Withdraw withdraw = new Withdraw();
                long l10 = roomDatabase.getLong(n12);
                withdraw.setId(l10);
                l10 = roomDatabase.getLong(n10);
                withdraw.setBackId(l10);
                withdraw.createTime = l10 = roomDatabase.getLong(n11);
                arrayList.add(withdraw);
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

