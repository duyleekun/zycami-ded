/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class TransitionFileDao_Impl$7
implements Callable {
    public final /* synthetic */ TransitionFileDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public TransitionFileDao_Impl$7(TransitionFileDao_Impl transitionFileDao_Impl, List list) {
        this.this$0 = transitionFileDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = TransitionFileDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = TransitionFileDao_Impl.access$100((TransitionFileDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = TransitionFileDao_Impl.access$000((TransitionFileDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            TransitionFileDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

