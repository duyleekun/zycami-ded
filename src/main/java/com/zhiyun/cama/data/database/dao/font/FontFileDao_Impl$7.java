/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class FontFileDao_Impl$7
implements Callable {
    public final /* synthetic */ FontFileDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public FontFileDao_Impl$7(FontFileDao_Impl fontFileDao_Impl, List list) {
        this.this$0 = fontFileDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = FontFileDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = FontFileDao_Impl.access$100((FontFileDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = FontFileDao_Impl.access$000((FontFileDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            FontFileDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

