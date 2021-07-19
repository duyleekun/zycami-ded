/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateFileRelationDao_Impl$8
implements Callable {
    public final /* synthetic */ G_TemplateFileRelationDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public G_TemplateFileRelationDao_Impl$8(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl, List list) {
        this.this$0 = g_TemplateFileRelationDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = G_TemplateFileRelationDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = G_TemplateFileRelationDao_Impl.access$200((G_TemplateFileRelationDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = G_TemplateFileRelationDao_Impl.access$000((G_TemplateFileRelationDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            G_TemplateFileRelationDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

