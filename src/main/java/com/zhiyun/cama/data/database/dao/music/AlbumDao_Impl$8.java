/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class AlbumDao_Impl$8
implements Callable {
    public final /* synthetic */ AlbumDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public AlbumDao_Impl$8(AlbumDao_Impl albumDao_Impl, List list) {
        this.this$0 = albumDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = AlbumDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = AlbumDao_Impl.access$100((AlbumDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = AlbumDao_Impl.access$000((AlbumDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            AlbumDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

