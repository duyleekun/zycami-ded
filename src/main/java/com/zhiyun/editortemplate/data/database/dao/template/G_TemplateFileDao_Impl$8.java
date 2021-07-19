/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;
import java.util.concurrent.Callable;

public class G_TemplateFileDao_Impl$8
implements Callable {
    public final /* synthetic */ G_TemplateFileDao_Impl this$0;

    public G_TemplateFileDao_Impl$8(G_TemplateFileDao_Impl g_TemplateFileDao_Impl) {
        this.this$0 = g_TemplateFileDao_Impl;
    }

    public Integer call() {
        SupportSQLiteStatement supportSQLiteStatement = G_TemplateFileDao_Impl.access$300(this.this$0).acquire();
        Object object = G_TemplateFileDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            int n10 = supportSQLiteStatement.executeUpdateDelete();
            object = n10;
            Object object2 = this.this$0;
            object2 = G_TemplateFileDao_Impl.access$000((G_TemplateFileDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            G_TemplateFileDao_Impl.access$000(this.this$0).endTransaction();
            G_TemplateFileDao_Impl.access$300(this.this$0).release(supportSQLiteStatement);
        }
    }
}

