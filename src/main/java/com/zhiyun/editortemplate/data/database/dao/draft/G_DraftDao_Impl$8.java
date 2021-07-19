/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;
import java.util.concurrent.Callable;

public class G_DraftDao_Impl$8
implements Callable {
    public final /* synthetic */ G_DraftDao_Impl this$0;
    public final /* synthetic */ String val$desc;
    public final /* synthetic */ long val$draftId;

    public G_DraftDao_Impl$8(G_DraftDao_Impl g_DraftDao_Impl, String string2, long l10) {
        this.this$0 = g_DraftDao_Impl;
        this.val$desc = string2;
        this.val$draftId = l10;
    }

    public Integer call() {
        SupportSQLiteStatement supportSQLiteStatement = G_DraftDao_Impl.access$300(this.this$0).acquire();
        Object object = this.val$desc;
        int n10 = 1;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        int n11 = 2;
        long l10 = this.val$draftId;
        supportSQLiteStatement.bindLong(n11, l10);
        object = G_DraftDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            n11 = supportSQLiteStatement.executeUpdateDelete();
            object = n11;
            Object object2 = this.this$0;
            object2 = G_DraftDao_Impl.access$000((G_DraftDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            G_DraftDao_Impl.access$000(this.this$0).endTransaction();
            G_DraftDao_Impl.access$300(this.this$0).release(supportSQLiteStatement);
        }
    }
}

