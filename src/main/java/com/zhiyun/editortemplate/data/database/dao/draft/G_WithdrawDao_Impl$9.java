/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao_Impl;
import java.util.concurrent.Callable;

public class G_WithdrawDao_Impl$9
implements Callable {
    public final /* synthetic */ G_WithdrawDao_Impl this$0;

    public G_WithdrawDao_Impl$9(G_WithdrawDao_Impl g_WithdrawDao_Impl) {
        this.this$0 = g_WithdrawDao_Impl;
    }

    public Integer call() {
        SupportSQLiteStatement supportSQLiteStatement = G_WithdrawDao_Impl.access$300(this.this$0).acquire();
        Object object = G_WithdrawDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            int n10 = supportSQLiteStatement.executeUpdateDelete();
            object = n10;
            Object object2 = this.this$0;
            object2 = G_WithdrawDao_Impl.access$000((G_WithdrawDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            G_WithdrawDao_Impl.access$000(this.this$0).endTransaction();
            G_WithdrawDao_Impl.access$300(this.this$0).release(supportSQLiteStatement);
        }
    }
}

