/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.ContiguousDataSource;
import androidx.paging.ContiguousPagedList$1;
import androidx.paging.ContiguousPagedList$2;
import androidx.paging.ContiguousPagedList$3;
import androidx.paging.DataSource;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PagedList;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Callback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedStorage;
import androidx.paging.PagedStorage$Callback;
import java.util.AbstractCollection;
import java.util.concurrent.Executor;

public class ContiguousPagedList
extends PagedList
implements PagedStorage$Callback {
    private static final int DONE_FETCHING = 2;
    private static final int FETCHING = 1;
    public static final int LAST_LOAD_UNSPECIFIED = 255;
    private static final int READY_TO_FETCH;
    public int mAppendItemsRequested;
    public int mAppendWorkerState;
    public final ContiguousDataSource mDataSource;
    public int mPrependItemsRequested;
    public int mPrependWorkerState;
    public PageResult$Receiver mReceiver;
    public boolean mReplacePagesWithNulls;
    public final boolean mShouldTrim;

    public ContiguousPagedList(ContiguousDataSource object, Executor executor, Executor object2, PagedList$BoundaryCallback pagedList$BoundaryCallback, PagedList$Config pagedList$Config, Object object3, int n10) {
        Object object4 = new PagedStorage();
        Object object5 = pagedList$Config;
        super((PagedStorage)object4, executor, (Executor)object2, pagedList$BoundaryCallback, pagedList$Config);
        boolean bl2 = false;
        executor = null;
        this.mPrependWorkerState = 0;
        this.mAppendWorkerState = 0;
        this.mPrependItemsRequested = 0;
        this.mAppendItemsRequested = 0;
        this.mReplacePagesWithNulls = false;
        this.mReceiver = object2 = new ContiguousPagedList$1(this);
        this.mDataSource = object;
        this.mLastLoad = n10;
        boolean n11 = ((DataSource)object).isInvalid();
        if (n11) {
            this.detach();
        } else {
            object2 = this.mConfig;
            int n12 = ((PagedList$Config)object2).initialLoadSizeHint;
            int n13 = ((PagedList$Config)object2).pageSize;
            boolean bl3 = ((PagedList$Config)object2).enablePlaceholders;
            object5 = this.mMainThreadExecutor;
            PageResult$Receiver pageResult$Receiver = this.mReceiver;
            object4 = object3;
            ((ContiguousDataSource)object).dispatchLoadInitial(object3, n12, n13, bl3, (Executor)object5, pageResult$Receiver);
        }
        boolean bl4 = ((ContiguousDataSource)object).supportsPageDropping();
        if (bl4) {
            object = this.mConfig;
            int n14 = ((PagedList$Config)object).maxSize;
            int n15 = -1 >>> 1;
            if (n14 != n15) {
                bl2 = true;
            }
        }
        this.mShouldTrim = bl2;
    }

    public static int getAppendItemsRequested(int n10, int n11, int n12) {
        return n11 + n10 + 1 - n12;
    }

    public static int getPrependItemsRequested(int n10, int n11, int n12) {
        return n10 - (n11 -= n12);
    }

    private void scheduleAppend() {
        int n10 = this.mAppendWorkerState;
        if (n10 != 0) {
            return;
        }
        this.mAppendWorkerState = n10 = 1;
        int n11 = this.mStorage.getLeadingNullCount();
        int n12 = this.mStorage.getStorageCount();
        n11 = n11 + n12 - n10;
        n10 = this.mStorage.getPositionOffset();
        Object object = this.mStorage.getLastLoadedItem();
        Executor executor = this.mBackgroundThreadExecutor;
        ContiguousPagedList$3 contiguousPagedList$3 = new ContiguousPagedList$3(this, n11 += n10, object);
        executor.execute(contiguousPagedList$3);
    }

    private void schedulePrepend() {
        int n10 = this.mPrependWorkerState;
        if (n10 != 0) {
            return;
        }
        this.mPrependWorkerState = 1;
        n10 = this.mStorage.getLeadingNullCount();
        int n11 = this.mStorage.getPositionOffset();
        Object object = this.mStorage.getFirstLoadedItem();
        Executor executor = this.mBackgroundThreadExecutor;
        ContiguousPagedList$2 contiguousPagedList$2 = new ContiguousPagedList$2(this, n10 += n11, object);
        executor.execute(contiguousPagedList$2);
    }

    public void dispatchUpdatesSinceSnapshot(PagedList object, PagedList$Callback pagedList$Callback) {
        int n10;
        int n11;
        int n12;
        PagedStorage pagedStorage;
        int n13;
        object = ((PagedList)object).mStorage;
        PagedStorage pagedStorage2 = this.mStorage;
        int n112 = pagedStorage2.getNumberAppended();
        int n122 = ((PagedStorage)object).getNumberAppended();
        n112 -= n122;
        PagedStorage pagedStorage3 = this.mStorage;
        n122 = pagedStorage3.getNumberPrepended();
        int n132 = ((PagedStorage)object).getNumberPrepended();
        n122 -= n132;
        n132 = ((PagedStorage)object).getTrailingNullCount();
        int n14 = ((PagedStorage)object).getLeadingNullCount();
        boolean n15 = ((AbstractCollection)object).isEmpty();
        if (!n15 && n112 >= 0 && n122 >= 0 && (n13 = (pagedStorage = this.mStorage).getTrailingNullCount()) == (n12 = Math.max(n132 - n112, 0)) && (n11 = (pagedStorage = this.mStorage).getLeadingNullCount()) == (n12 = Math.max(n14 - n122, 0)) && (n10 = (pagedStorage = this.mStorage).getStorageCount()) == (n12 = ((PagedStorage)object).getStorageCount() + n112 + n122)) {
            int n16;
            if (n112 != 0) {
                n132 = Math.min(n132, n112);
                n112 -= n132;
                int n17 = ((PagedStorage)object).getLeadingNullCount();
                n16 = ((PagedStorage)object).getStorageCount();
                int n18 = n17 + n16;
                if (n132 != 0) {
                    pagedList$Callback.onChanged(n18, n132);
                }
                if (n112 != 0) {
                    int n19 = n18 + n132;
                    pagedList$Callback.onInserted(n19, n112);
                }
            }
            if (n122 != 0) {
                n16 = Math.min(n14, n122);
                n122 -= n16;
                if (n16 != 0) {
                    pagedList$Callback.onChanged(n14, n16);
                }
                if (n122 != 0) {
                    pagedList$Callback.onInserted(0, n122);
                }
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
        ContiguousDataSource contiguousDataSource = this.mDataSource;
        int n10 = this.mLastLoad;
        Object object = this.mLastItem;
        return contiguousDataSource.getKey(n10, object);
    }

    public boolean isContiguous() {
        return true;
    }

    public void loadAroundInternal(int n10) {
        PagedList$Config pagedList$Config = this.mConfig;
        int n11 = pagedList$Config.prefetchDistance;
        int n12 = this.mStorage.getLeadingNullCount();
        n11 = ContiguousPagedList.getPrependItemsRequested(n11, n10, n12);
        PagedList$Config pagedList$Config2 = this.mConfig;
        n12 = pagedList$Config2.prefetchDistance;
        PagedStorage pagedStorage = this.mStorage;
        int n13 = pagedStorage.getLeadingNullCount();
        PagedStorage pagedStorage2 = this.mStorage;
        int n14 = pagedStorage2.getStorageCount();
        n10 = ContiguousPagedList.getAppendItemsRequested(n12, n10, n13 += n14);
        n12 = this.mPrependItemsRequested;
        this.mPrependItemsRequested = n11 = Math.max(n11, n12);
        if (n11 > 0) {
            this.schedulePrepend();
        }
        n11 = this.mAppendItemsRequested;
        this.mAppendItemsRequested = n10 = Math.max(n10, n11);
        if (n10 > 0) {
            this.scheduleAppend();
        }
    }

    public void onEmptyAppend() {
        this.mAppendWorkerState = 2;
    }

    public void onEmptyPrepend() {
        this.mPrependWorkerState = 2;
    }

    public void onInitialized(int n10) {
        boolean bl2 = false;
        this.notifyInserted(0, n10);
        PagedStorage pagedStorage = this.mStorage;
        n10 = pagedStorage.getLeadingNullCount();
        if (n10 > 0 || (n10 = (pagedStorage = this.mStorage).getTrailingNullCount()) > 0) {
            bl2 = true;
        }
        this.mReplacePagesWithNulls = bl2;
    }

    public void onPageAppended(int n10, int n11, int n12) {
        int n13;
        this.mAppendItemsRequested = n13 = this.mAppendItemsRequested - n11 - n12;
        this.mAppendWorkerState = 0;
        if (n13 > 0) {
            this.scheduleAppend();
        }
        this.notifyChanged(n10, n11);
        this.notifyInserted(n10 += n11, n12);
    }

    public void onPageInserted(int n10, int n11) {
        IllegalStateException illegalStateException = new IllegalStateException("Tiled callback on ContiguousPagedList");
        throw illegalStateException;
    }

    public void onPagePlaceholderInserted(int n10) {
        IllegalStateException illegalStateException = new IllegalStateException("Tiled callback on ContiguousPagedList");
        throw illegalStateException;
    }

    public void onPagePrepended(int n10, int n11, int n12) {
        int n13;
        this.mPrependItemsRequested = n13 = this.mPrependItemsRequested - n11 - n12;
        this.mPrependWorkerState = 0;
        if (n13 > 0) {
            this.schedulePrepend();
        }
        this.notifyChanged(n10, n11);
        this.notifyInserted(0, n12);
        this.offsetAccessIndices(n12);
    }

    public void onPagesRemoved(int n10, int n11) {
        this.notifyRemoved(n10, n11);
    }

    public void onPagesSwappedToPlaceholder(int n10, int n11) {
        this.notifyChanged(n10, n11);
    }
}

