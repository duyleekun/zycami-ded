/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class StickerDataDao_Impl$11
implements Callable {
    public final /* synthetic */ StickerDataDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public StickerDataDao_Impl$11(StickerDataDao_Impl stickerDataDao_Impl, List list) {
        this.this$0 = stickerDataDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = StickerDataDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = StickerDataDao_Impl.access$200((StickerDataDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = StickerDataDao_Impl.access$000((StickerDataDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            StickerDataDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

