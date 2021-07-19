/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class FilterDataDao_Impl$10
implements Callable {
    public final /* synthetic */ FilterDataDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public FilterDataDao_Impl$10(FilterDataDao_Impl filterDataDao_Impl, List list) {
        this.this$0 = filterDataDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = FilterDataDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = FilterDataDao_Impl.access$100((FilterDataDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = FilterDataDao_Impl.access$000((FilterDataDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            FilterDataDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

