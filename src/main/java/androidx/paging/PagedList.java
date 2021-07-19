/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.ContiguousDataSource;
import androidx.paging.ContiguousPagedList;
import androidx.paging.DataSource;
import androidx.paging.PagedList$1;
import androidx.paging.PagedList$2;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Callback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedStorage;
import androidx.paging.PositionalDataSource;
import androidx.paging.SnapshotPagedList;
import androidx.paging.TiledPagedList;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PagedList
extends AbstractList {
    public final Executor mBackgroundThreadExecutor;
    public final PagedList$BoundaryCallback mBoundaryCallback;
    public boolean mBoundaryCallbackBeginDeferred = false;
    public boolean mBoundaryCallbackEndDeferred = false;
    private final ArrayList mCallbacks;
    public final PagedList$Config mConfig;
    private final AtomicBoolean mDetached;
    private int mHighestIndexAccessed;
    public Object mLastItem = null;
    public int mLastLoad = 0;
    private int mLowestIndexAccessed = -1 >>> 1;
    public final Executor mMainThreadExecutor;
    public final int mRequiredRemainder;
    public final PagedStorage mStorage;

    public PagedList(PagedStorage pagedStorage, Executor executor, Executor executor2, PagedList$BoundaryCallback pagedList$BoundaryCallback, PagedList$Config pagedList$Config) {
        ArrayList arrayList;
        AtomicBoolean atomicBoolean;
        this.mHighestIndexAccessed = -1 << -1;
        this.mDetached = atomicBoolean = new AtomicBoolean(false);
        this.mCallbacks = arrayList = new ArrayList();
        this.mStorage = pagedStorage;
        this.mMainThreadExecutor = executor;
        this.mBackgroundThreadExecutor = executor2;
        this.mBoundaryCallback = pagedList$BoundaryCallback;
        this.mConfig = pagedList$Config;
        int n10 = pagedList$Config.prefetchDistance * 2;
        int n11 = pagedList$Config.pageSize;
        this.mRequiredRemainder = n10 += n11;
    }

    public static PagedList create(DataSource object, Executor executor, Executor executor2, PagedList$BoundaryCallback pagedList$BoundaryCallback, PagedList$Config pagedList$Config, Object object2) {
        int n10;
        Object object3;
        boolean bl2;
        boolean n102 = ((DataSource)object).isContiguous();
        if (!n102 && (bl2 = pagedList$Config.enablePlaceholders)) {
            TiledPagedList tiledPagedList;
            int n11;
            Object object4 = object;
            object4 = (PositionalDataSource)object;
            if (object2 != null) {
                object2 = (Integer)object2;
                n11 = (Integer)object2;
            } else {
                n11 = 0;
                object = null;
            }
            TiledPagedList tiledPagedList2 = tiledPagedList;
            tiledPagedList = new TiledPagedList((PositionalDataSource)object4, executor, executor2, pagedList$BoundaryCallback, pagedList$Config, n11);
            return tiledPagedList;
        }
        int n12 = -1;
        boolean bl3 = ((DataSource)object).isContiguous();
        if (!bl3) {
            object = ((PositionalDataSource)object).wrapAsContiguousWithoutPlaceholders();
            if (object2 != null) {
                object3 = object2;
                object3 = (Integer)object2;
                n10 = (Integer)object3;
            }
        }
        Object object5 = object;
        object5 = (ContiguousDataSource)object;
        object3 = object;
        Executor executor3 = executor;
        object = new ContiguousPagedList((ContiguousDataSource)object5, executor, executor2, pagedList$BoundaryCallback, pagedList$Config, object2, n10);
        return object;
    }

    public void addWeakCallback(List list, PagedList$Callback pagedList$Callback) {
        Object object;
        int n10;
        if (list != null && list != this) {
            int n11 = list.isEmpty();
            if (n11 != 0) {
                list = this.mStorage;
                n10 = (int)(((AbstractCollection)((Object)list)).isEmpty() ? 1 : 0);
                if (n10 == 0) {
                    n10 = 0;
                    list = null;
                    object = this.mStorage;
                    n11 = ((PagedStorage)object).size();
                    pagedList$Callback.onInserted(0, n11);
                }
            } else {
                list = (PagedList)list;
                this.dispatchUpdatesSinceSnapshot((PagedList)list, pagedList$Callback);
            }
        }
        list = this.mCallbacks;
        for (n10 = ((ArrayList)list).size() + -1; n10 >= 0; n10 += -1) {
            object = (PagedList$Callback)((WeakReference)this.mCallbacks.get(n10)).get();
            if (object != null) continue;
            object = this.mCallbacks;
            ((ArrayList)object).remove(n10);
        }
        list = this.mCallbacks;
        object = new WeakReference(pagedList$Callback);
        ((ArrayList)list).add(object);
    }

    public void deferBoundaryCallbacks(boolean bl2, boolean bl3, boolean bl4) {
        Object object = this.mBoundaryCallback;
        if (object != null) {
            int n10 = this.mLowestIndexAccessed;
            int n11 = -1 >>> 1;
            if (n10 == n11) {
                object = this.mStorage;
                this.mLowestIndexAccessed = n10 = ((PagedStorage)object).size();
            }
            if ((n10 = this.mHighestIndexAccessed) == (n11 = -1 << -1)) {
                n10 = 0;
                object = null;
                this.mHighestIndexAccessed = 0;
            }
            if (bl2 || bl3 || bl4) {
                object = this.mMainThreadExecutor;
                PagedList$1 pagedList$1 = new PagedList$1(this, bl2, bl3, bl4);
                object.execute(pagedList$1);
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't defer BoundaryCallback, no instance");
        throw illegalStateException;
    }

    public void detach() {
        this.mDetached.set(true);
    }

    public void dispatchBoundaryCallbacks(boolean bl2, boolean bl3) {
        PagedList$BoundaryCallback pagedList$BoundaryCallback;
        if (bl2) {
            pagedList$BoundaryCallback = this.mBoundaryCallback;
            Object object = this.mStorage.getFirstLoadedItem();
            pagedList$BoundaryCallback.onItemAtFrontLoaded(object);
        }
        if (bl3) {
            pagedList$BoundaryCallback = this.mBoundaryCallback;
            Object object = this.mStorage.getLastLoadedItem();
            pagedList$BoundaryCallback.onItemAtEndLoaded(object);
        }
    }

    public abstract void dispatchUpdatesSinceSnapshot(PagedList var1, PagedList$Callback var2);

    public Object get(int n10) {
        PagedStorage pagedStorage = this.mStorage;
        Object object = pagedStorage.get(n10);
        if (object != null) {
            this.mLastItem = object;
        }
        return object;
    }

    public PagedList$Config getConfig() {
        return this.mConfig;
    }

    public abstract DataSource getDataSource();

    public abstract Object getLastKey();

    public int getLoadedCount() {
        return this.mStorage.getLoadedCount();
    }

    public int getPositionOffset() {
        return this.mStorage.getPositionOffset();
    }

    public abstract boolean isContiguous();

    public boolean isDetached() {
        return this.mDetached.get();
    }

    public boolean isImmutable() {
        return this.isDetached();
    }

    public void loadAround(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size())) {
            this.mLastLoad = n11 = this.getPositionOffset() + n10;
            this.loadAroundInternal(n10);
            this.mLowestIndexAccessed = n11 = Math.min(this.mLowestIndexAccessed, n10);
            this.mHighestIndexAccessed = n10 = Math.max(this.mHighestIndexAccessed, n10);
            this.tryDispatchBoundaryCallbacks(true);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n10);
        stringBuilder.append(", Size: ");
        n10 = this.size();
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public abstract void loadAroundInternal(int var1);

    public void notifyChanged(int n10, int n11) {
        if (n11 != 0) {
            ArrayList arrayList = this.mCallbacks;
            for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
                PagedList$Callback pagedList$Callback = (PagedList$Callback)((WeakReference)this.mCallbacks.get(i10)).get();
                if (pagedList$Callback == null) continue;
                pagedList$Callback.onChanged(n10, n11);
            }
        }
    }

    public void notifyInserted(int n10, int n11) {
        if (n11 != 0) {
            ArrayList arrayList = this.mCallbacks;
            for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
                PagedList$Callback pagedList$Callback = (PagedList$Callback)((WeakReference)this.mCallbacks.get(i10)).get();
                if (pagedList$Callback == null) continue;
                pagedList$Callback.onInserted(n10, n11);
            }
        }
    }

    public void notifyRemoved(int n10, int n11) {
        if (n11 != 0) {
            ArrayList arrayList = this.mCallbacks;
            for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
                PagedList$Callback pagedList$Callback = (PagedList$Callback)((WeakReference)this.mCallbacks.get(i10)).get();
                if (pagedList$Callback == null) continue;
                pagedList$Callback.onRemoved(n10, n11);
            }
        }
    }

    public void offsetAccessIndices(int n10) {
        int n11;
        this.mLastLoad = n11 = this.mLastLoad + n10;
        this.mLowestIndexAccessed = n11 = this.mLowestIndexAccessed + n10;
        this.mHighestIndexAccessed = n11 = this.mHighestIndexAccessed + n10;
    }

    public void removeWeakCallback(PagedList$Callback pagedList$Callback) {
        ArrayList arrayList = this.mCallbacks;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            Object object = (PagedList$Callback)((WeakReference)this.mCallbacks.get(i10)).get();
            if (object != null && object != pagedList$Callback) continue;
            object = this.mCallbacks;
            ((ArrayList)object).remove(i10);
        }
    }

    public int size() {
        return this.mStorage.size();
    }

    public List snapshot() {
        boolean bl2 = this.isImmutable();
        if (bl2) {
            return this;
        }
        SnapshotPagedList snapshotPagedList = new SnapshotPagedList(this);
        return snapshotPagedList;
    }

    /*
     * Unable to fully structure code
     */
    public void tryDispatchBoundaryCallbacks(boolean var1_1) {
        block11: {
            block10: {
                var2_2 = this.mBoundaryCallbackBeginDeferred;
                var3_3 = 1;
                var4_4 = null;
                if (var2_2 == 0) ** GOTO lbl-1000
                var2_2 = this.mLowestIndexAccessed;
                var5_5 = this.mConfig;
                var6_6 = var5_5.prefetchDistance;
                if (var2_2 <= var6_6) {
                    var2_2 = var3_3;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = 0;
                }
                var6_6 = this.mBoundaryCallbackEndDeferred;
                if (var6_6 == 0) break block10;
                var6_6 = this.mHighestIndexAccessed;
                var7_7 = this.size() - var3_3;
                var8_8 = this.mConfig;
                var9_9 = var8_8.prefetchDistance;
                if (var6_6 >= (var7_7 -= var9_9)) break block11;
            }
            var3_3 = 0;
        }
        if (var2_2 == 0 && var3_3 == 0) {
            return;
        }
        if (var2_2 != 0) {
            this.mBoundaryCallbackBeginDeferred = false;
        }
        if (var3_3 != 0) {
            this.mBoundaryCallbackEndDeferred = false;
        }
        if (var1_1) {
            var10_10 = this.mMainThreadExecutor;
            var4_4 = new PagedList$2(this, (boolean)var2_2, (boolean)var3_3);
            var10_10.execute(var4_4);
        } else {
            this.dispatchBoundaryCallbacks((boolean)var2_2, (boolean)var3_3);
        }
    }
}

