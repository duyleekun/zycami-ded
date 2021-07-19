/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class MusicDao_Impl$12
implements Callable {
    public final /* synthetic */ MusicDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public MusicDao_Impl$12(MusicDao_Impl musicDao_Impl, List list) {
        this.this$0 = musicDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = MusicDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = MusicDao_Impl.access$100((MusicDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = MusicDao_Impl.access$000((MusicDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            MusicDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

