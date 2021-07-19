/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class FilterTypeDao_Impl$9
implements Callable {
    public final /* synthetic */ FilterTypeDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public FilterTypeDao_Impl$9(FilterTypeDao_Impl filterTypeDao_Impl, List list) {
        this.this$0 = filterTypeDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = FilterTypeDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = FilterTypeDao_Impl.access$200((FilterTypeDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = FilterTypeDao_Impl.access$000((FilterTypeDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            FilterTypeDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

