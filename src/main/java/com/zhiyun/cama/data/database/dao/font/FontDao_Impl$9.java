/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class FontDao_Impl$9
implements Callable {
    public final /* synthetic */ FontDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public FontDao_Impl$9(FontDao_Impl fontDao_Impl, List list) {
        this.this$0 = fontDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = FontDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = FontDao_Impl.access$100((FontDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = FontDao_Impl.access$000((FontDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            FontDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

