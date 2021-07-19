/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class StickerFileDao_Impl$8
implements Callable {
    public final /* synthetic */ StickerFileDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public StickerFileDao_Impl$8(StickerFileDao_Impl stickerFileDao_Impl, List list) {
        this.this$0 = stickerFileDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = StickerFileDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = StickerFileDao_Impl.access$200((StickerFileDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = StickerFileDao_Impl.access$000((StickerFileDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            StickerFileDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

