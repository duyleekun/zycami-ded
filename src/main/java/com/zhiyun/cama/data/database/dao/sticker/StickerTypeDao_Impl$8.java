/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class StickerTypeDao_Impl$8
implements Callable {
    public final /* synthetic */ StickerTypeDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public StickerTypeDao_Impl$8(StickerTypeDao_Impl stickerTypeDao_Impl, List list) {
        this.this$0 = stickerTypeDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = StickerTypeDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = StickerTypeDao_Impl.access$200((StickerTypeDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = StickerTypeDao_Impl.access$000((StickerTypeDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            StickerTypeDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

