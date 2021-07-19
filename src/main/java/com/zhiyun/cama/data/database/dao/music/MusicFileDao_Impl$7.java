/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class MusicFileDao_Impl$7
implements Callable {
    public final /* synthetic */ MusicFileDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public MusicFileDao_Impl$7(MusicFileDao_Impl musicFileDao_Impl, List list) {
        this.this$0 = musicFileDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = MusicFileDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = MusicFileDao_Impl.access$100((MusicFileDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = MusicFileDao_Impl.access$000((MusicFileDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            MusicFileDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

