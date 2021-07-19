/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PagedList;
import androidx.paging.PagedList$Config;
import androidx.paging.PositionalDataSource;
import androidx.paging.TiledPagedList;
import java.util.concurrent.Executor;

public class TiledPagedList$2
implements Runnable {
    public final /* synthetic */ TiledPagedList this$0;
    public final /* synthetic */ int val$pageIndex;

    public TiledPagedList$2(TiledPagedList tiledPagedList, int n10) {
        this.this$0 = tiledPagedList;
        this.val$pageIndex = n10;
    }

    public void run() {
        Object object = this.this$0;
        boolean n10 = ((PagedList)object).isDetached();
        if (n10) {
            return;
        }
        object = this.this$0;
        PagedList$Config pagedList$Config = ((PagedList)object).mConfig;
        int n11 = pagedList$Config.pageSize;
        object = ((TiledPagedList)object).mDataSource;
        boolean bl2 = ((DataSource)object).isInvalid();
        if (bl2) {
            object = this.this$0;
            ((PagedList)object).detach();
        } else {
            int n12 = this.val$pageIndex * n11;
            int n13 = this.this$0.mStorage.size() - n12;
            int n14 = Math.min(n11, n13);
            object = this.this$0;
            PositionalDataSource positionalDataSource = ((TiledPagedList)object).mDataSource;
            int n15 = 3;
            Executor executor = ((PagedList)object).mMainThreadExecutor;
            PageResult$Receiver pageResult$Receiver = ((TiledPagedList)object).mReceiver;
            positionalDataSource.dispatchLoadRange(n15, n12, n14, executor, pageResult$Receiver);
        }
    }
}

