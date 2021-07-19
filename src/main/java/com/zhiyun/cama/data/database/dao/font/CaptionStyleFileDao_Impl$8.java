/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class CaptionStyleFileDao_Impl$8
implements Callable {
    public final /* synthetic */ CaptionStyleFileDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public CaptionStyleFileDao_Impl$8(CaptionStyleFileDao_Impl captionStyleFileDao_Impl, List list) {
        this.this$0 = captionStyleFileDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = CaptionStyleFileDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = CaptionStyleFileDao_Impl.access$200((CaptionStyleFileDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = CaptionStyleFileDao_Impl.access$000((CaptionStyleFileDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            CaptionStyleFileDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

