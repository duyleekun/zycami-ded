/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateDao_Impl$6
implements Callable {
    public final /* synthetic */ G_TemplateDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public G_TemplateDao_Impl$6(G_TemplateDao_Impl g_TemplateDao_Impl, List list) {
        this.this$0 = g_TemplateDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = G_TemplateDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = G_TemplateDao_Impl.access$200((G_TemplateDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = G_TemplateDao_Impl.access$000((G_TemplateDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            G_TemplateDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

