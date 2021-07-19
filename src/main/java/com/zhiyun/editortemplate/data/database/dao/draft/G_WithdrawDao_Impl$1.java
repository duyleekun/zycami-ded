/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;

public class G_WithdrawDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ G_WithdrawDao_Impl this$0;

    public G_WithdrawDao_Impl$1(G_WithdrawDao_Impl g_WithdrawDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_WithdrawDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Withdraw withdraw) {
        long l10 = withdraw.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = withdraw.getBackId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = withdraw.createTime;
        supportSQLiteStatement.bindLong(3, l10);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `withdraw` (`id`,`back_id`,`create_time`) VALUES (nullif(?, 0),?,?)";
    }
}

