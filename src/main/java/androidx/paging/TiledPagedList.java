/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PagedList;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Callback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedStorage;
import androidx.paging.PagedStorage$Callback;
import androidx.paging.PositionalDataSource;
import androidx.paging.TiledPagedList$1;
import androidx.paging.TiledPagedList$2;
import java.util.AbstractCollection;
import java.util.concurrent.Executor;

public class TiledPagedList
extends PagedList
implements PagedStorage$Callback {
    public final PositionalDataSource mDataSource;
    public PageResult$Receiver mReceiver;

    public TiledPagedList(PositionalDataSource positionalDataSource, Executor object, Executor executor, PagedList$BoundaryCallback pagedList$BoundaryCallback, PagedList$Config pagedList$Config, int n10) {
        PagedStorage pagedStorage = new PagedStorage();
        Object object2 = pagedList$Config;
        super(pagedStorage, (Executor)object, executor, pagedList$BoundaryCallback, pagedList$Config);
        this.mReceiver = object = new TiledPagedList$1(this);
        this.mDataSource = positionalDataSource;
        object = this.mConfig;
        int n11 = ((PagedList$Config)object).pageSize;
        this.mLastLoad = n10;
        int n12 = positionalDataSource.isInvalid();
        if (n12 != 0) {
            this.detach();
        } else {
            n12 = this.mConfig.initialLoadSizeHint / n11;
            int n13 = 2;
            int n14 = Math.max(n12, n13) * n11;
            n12 = n14 / 2;
            n10 -= n12;
            n12 = 0;
            object = null;
            n10 = n10 / n11 * n11;
            int n15 = Math.max(0, n10);
            boolean bl2 = true;
            object2 = this.mMainThreadExecutor;
            PageResult$Receiver pageResult$Receiver = this.mReceiver;
            positionalDataSource.dispatchLoadInitial(bl2, n15, n14, n11, (Executor)object2, pageResult$Receiver);
        }
    }

    public void dispatchUpdatesSinceSnapshot(PagedList object, PagedList$Callback pagedList$Callback) {
        int n10;
        Object object2;
        int n11;
        object = ((PagedList)object).mStorage;
        boolean n112 = ((AbstractCollection)object).isEmpty();
        if (!n112 && (n11 = ((PagedStorage)(object2 = this.mStorage)).size()) == (n10 = ((PagedStorage)object).size())) {
            object2 = this.mConfig;
            int n12 = ((PagedList$Config)object2).pageSize;
            PagedStorage pagedStorage = this.mStorage;
            n10 = pagedStorage.getLeadingNullCount() / n12;
            PagedStorage pagedStorage2 = this.mStorage;
            int n13 = pagedStorage2.getPageCount();
            for (int i10 = 0; i10 < n13; ++i10) {
                int n14;
                PagedStorage pagedStorage3;
                int n15;
                int n16;
                int n17 = i10 + n10;
                for (n16 = 0; n16 < (n15 = (pagedStorage3 = this.mStorage).getPageCount()) && (n15 = (int)((pagedStorage3 = this.mStorage).hasPage(n12, n14 = n17 + n16) ? 1 : 0)) != 0 && (n15 = (int)(((PagedStorage)object).hasPage(n12, n14) ? 1 : 0)) == 0; ++n16) {
                }
                if (n16 <= 0) continue;
                n15 = n12 * n16;
                pagedList$Callback.onChanged(n17 *= n12, n15);
                i10 += (n16 += -1);
            }
            return;
        }
        object = new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        throw object;
    }

    public DataSource getDataSource() {
        return this.mDataSource;
    }

    public Object getLastKey() {
        return this.mLastLoad;
    }

    public boolean isContiguous() {
        return false;
    }

    public void loadAroundInternal(int n10) {
        PagedStorage pagedStorage = this.mStorage;
        PagedList$Config pagedList$Config = this.mConfig;
        int n11 = pagedList$Config.prefetchDistance;
        int n12 = pagedList$Config.pageSize;
        pagedStorage.allocatePlaceholders(n10, n11, n12, this);
    }

    public void onEmptyAppend() {
        IllegalStateException illegalStateException = new IllegalStateException("Contiguous callback on TiledPagedList");
        throw illegalStateException;
    }

    public void onEmptyPrepend() {
        IllegalStateException illegalStateException = new IllegalStateException("Contiguous callback on TiledPagedList");
        throw illegalStateException;
    }

    public void onInitialized(int n10) {
        this.notifyInserted(0, n10);
    }

    public void onPageAppended(int n10, int n11, int n12) {
        IllegalStateException illegalStateException = new IllegalStateException("Contiguous callback on TiledPagedList");
        throw illegalStateException;
    }

    public void onPageInserted(int n10, int n11) {
        this.notifyChanged(n10, n11);
    }

    public void onPagePlaceholderInserted(int n10) {
        Executor executor = this.mBackgroundThreadExecutor;
        TiledPagedList$2 tiledPagedList$2 = new TiledPagedList$2(this, n10);
        executor.execute(tiledPagedList$2);
    }

    public void onPagePrepended(int n10, int n11, int n12) {
        IllegalStateException illegalStateException = new IllegalStateException("Contiguous callback on TiledPagedList");
        throw illegalStateException;
    }

    public void onPagesRemoved(int n10, int n11) {
        this.notifyRemoved(n10, n11);
    }

    public void onPagesSwappedToPlaceholder(int n10, int n11) {
        this.notifyChanged(n10, n11);
    }
}

