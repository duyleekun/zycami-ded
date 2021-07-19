/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.ContiguousDataSource;
import androidx.paging.ContiguousPagedList;
import androidx.paging.DataSource;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PagedList;
import androidx.paging.PagedList$Config;
import java.util.concurrent.Executor;

public class ContiguousPagedList$2
implements Runnable {
    public final /* synthetic */ ContiguousPagedList this$0;
    public final /* synthetic */ Object val$item;
    public final /* synthetic */ int val$position;

    public ContiguousPagedList$2(ContiguousPagedList contiguousPagedList, int n10, Object object) {
        this.this$0 = contiguousPagedList;
        this.val$position = n10;
        this.val$item = object;
    }

    public void run() {
        Object object = this.this$0;
        boolean bl2 = ((PagedList)object).isDetached();
        if (bl2) {
            return;
        }
        object = this.this$0.mDataSource;
        bl2 = ((DataSource)object).isInvalid();
        if (bl2) {
            object = this.this$0;
            ((PagedList)object).detach();
        } else {
            object = this.this$0;
            ContiguousDataSource contiguousDataSource = ((ContiguousPagedList)object).mDataSource;
            int n10 = this.val$position;
            Object object2 = this.val$item;
            PagedList$Config pagedList$Config = ((PagedList)object).mConfig;
            int n11 = pagedList$Config.pageSize;
            Executor executor = ((PagedList)object).mMainThreadExecutor;
            PageResult.Receiver receiver = ((ContiguousPagedList)object).mReceiver;
            contiguousDataSource.dispatchLoadBefore(n10, object2, n11, executor, receiver);
        }
    }
}

