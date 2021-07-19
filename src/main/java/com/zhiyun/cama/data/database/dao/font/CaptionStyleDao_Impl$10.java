/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class CaptionStyleDao_Impl$10
implements Callable {
    public final /* synthetic */ CaptionStyleDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public CaptionStyleDao_Impl$10(CaptionStyleDao_Impl captionStyleDao_Impl, List list) {
        this.this$0 = captionStyleDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = CaptionStyleDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = CaptionStyleDao_Impl.access$200((CaptionStyleDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = CaptionStyleDao_Impl.access$000((CaptionStyleDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            CaptionStyleDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

