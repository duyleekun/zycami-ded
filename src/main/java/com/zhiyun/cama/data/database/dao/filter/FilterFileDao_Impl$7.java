/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class FilterFileDao_Impl$7
implements Callable {
    public final /* synthetic */ FilterFileDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public FilterFileDao_Impl$7(FilterFileDao_Impl filterFileDao_Impl, List list) {
        this.this$0 = filterFileDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = FilterFileDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = FilterFileDao_Impl.access$200((FilterFileDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = FilterFileDao_Impl.access$000((FilterFileDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            FilterFileDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

