/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class MusicInfoDataDao_Impl$6
implements Callable {
    public final /* synthetic */ MusicInfoDataDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public MusicInfoDataDao_Impl$6(MusicInfoDataDao_Impl musicInfoDataDao_Impl, List list) {
        this.this$0 = musicInfoDataDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = MusicInfoDataDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = MusicInfoDataDao_Impl.access$100((MusicInfoDataDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = MusicInfoDataDao_Impl.access$000((MusicInfoDataDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            MusicInfoDataDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

