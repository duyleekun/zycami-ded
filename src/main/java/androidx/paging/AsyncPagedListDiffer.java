/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.AsyncPagedListDiffer$1;
import androidx.paging.AsyncPagedListDiffer$2;
import androidx.paging.AsyncPagedListDiffer$PagedListListener;
import androidx.paging.PagedList;
import androidx.paging.PagedList$Callback;
import androidx.paging.PagedStorage;
import androidx.paging.PagedStorageDiffHelper;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncDifferConfig$Builder;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncPagedListDiffer {
    public final AsyncDifferConfig mConfig;
    private boolean mIsContiguous;
    private final List mListeners;
    public Executor mMainThreadExecutor;
    public int mMaxScheduledGeneration;
    private PagedList mPagedList;
    private PagedList$Callback mPagedListCallback;
    private PagedList mSnapshot;
    public final ListUpdateCallback mUpdateCallback;

    public AsyncPagedListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig asyncDifferConfig) {
        Object object = ArchTaskExecutor.getMainThreadExecutor();
        this.mMainThreadExecutor = object;
        object = new CopyOnWriteArrayList();
        this.mListeners = object;
        this.mPagedListCallback = object = new AsyncPagedListDiffer$1(this);
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
    }

    public AsyncPagedListDiffer(RecyclerView$Adapter object, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        Object object2 = ArchTaskExecutor.getMainThreadExecutor();
        this.mMainThreadExecutor = object2;
        object2 = new CopyOnWriteArrayList();
        this.mListeners = object2;
        this.mPagedListCallback = object2 = new AsyncPagedListDiffer$1(this);
        this.mUpdateCallback = object2 = new AdapterListUpdateCallback((RecyclerView$Adapter)object);
        object = new AsyncDifferConfig$Builder(diffUtil$ItemCallback);
        this.mConfig = object = ((AsyncDifferConfig$Builder)object).build();
    }

    private void onCurrentListChanged(PagedList pagedList, PagedList pagedList2, Runnable runnable) {
        boolean bl2;
        Iterator iterator2 = this.mListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            AsyncPagedListDiffer$PagedListListener asyncPagedListDiffer$PagedListListener = (AsyncPagedListDiffer$PagedListListener)iterator2.next();
            asyncPagedListDiffer$PagedListListener.onCurrentListChanged(pagedList, pagedList2);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addPagedListListener(AsyncPagedListDiffer$PagedListListener asyncPagedListDiffer$PagedListListener) {
        this.mListeners.add(asyncPagedListDiffer$PagedListListener);
    }

    public PagedList getCurrentList() {
        PagedList pagedList = this.mSnapshot;
        if (pagedList != null) {
            return pagedList;
        }
        return this.mPagedList;
    }

    public Object getItem(int n10) {
        PagedList pagedList = this.mPagedList;
        if (pagedList == null) {
            pagedList = this.mSnapshot;
            if (pagedList != null) {
                return pagedList.get(n10);
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
            throw indexOutOfBoundsException;
        }
        pagedList.loadAround(n10);
        return this.mPagedList.get(n10);
    }

    public int getItemCount() {
        int n10;
        PagedList pagedList = this.mPagedList;
        if (pagedList != null) {
            return pagedList.size();
        }
        pagedList = this.mSnapshot;
        if (pagedList == null) {
            n10 = 0;
            pagedList = null;
        } else {
            n10 = pagedList.size();
        }
        return n10;
    }

    public void latchPagedList(PagedList object, PagedList abstractList, DiffUtil$DiffResult diffUtil$DiffResult, int n10, Runnable runnable) {
        Object object2;
        PagedList pagedList = this.mSnapshot;
        if (pagedList != null && (object2 = this.mPagedList) == null) {
            this.mPagedList = object;
            this.mSnapshot = null;
            object2 = this.mUpdateCallback;
            PagedStorage pagedStorage = pagedList.mStorage;
            PagedStorage pagedStorage2 = ((PagedList)object).mStorage;
            PagedStorageDiffHelper.dispatchDiff((ListUpdateCallback)object2, pagedStorage, pagedStorage2, diffUtil$DiffResult);
            object2 = this.mPagedListCallback;
            ((PagedList)object).addWeakCallback(abstractList, (PagedList$Callback)object2);
            object = this.mPagedList;
            boolean n11 = ((AbstractCollection)object).isEmpty();
            if (!n11) {
                object = pagedList.mStorage;
                abstractList = ((PagedList)abstractList).mStorage;
                int n12 = PagedStorageDiffHelper.transformAnchorIndex(diffUtil$DiffResult, (PagedStorage)object, (PagedStorage)abstractList, n10);
                abstractList = this.mPagedList;
                diffUtil$DiffResult = null;
                n10 = ((PagedList)abstractList).size() + -1;
                int n14 = Math.min(n10, n12);
                n14 = Math.max(0, n14);
                ((PagedList)abstractList).loadAround(n14);
            }
            object = this.mPagedList;
            this.onCurrentListChanged(pagedList, (PagedList)object, runnable);
            return;
        }
        object = new IllegalStateException("must be in snapshot state to apply diff");
        throw object;
    }

    public void removePagedListListener(AsyncPagedListDiffer$PagedListListener asyncPagedListDiffer$PagedListListener) {
        this.mListeners.remove(asyncPagedListDiffer$PagedListListener);
    }

    public void submitList(PagedList pagedList) {
        this.submitList(pagedList, null);
    }

    public void submitList(PagedList object, Runnable runnable) {
        int n10;
        int n11;
        int n12;
        Object object2;
        if (object != null) {
            object2 = this.mPagedList;
            if (object2 == null && (object2 = this.mSnapshot) == null) {
                n12 = (int)(((PagedList)object).isContiguous() ? 1 : 0);
                this.mIsContiguous = n12;
            } else {
                n12 = (int)(((PagedList)object).isContiguous() ? 1 : 0);
                if (n12 != (n11 = this.mIsContiguous)) {
                    object = new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
                    throw object;
                }
            }
        }
        n12 = this.mMaxScheduledGeneration;
        this.mMaxScheduledGeneration = n10 = n12 + 1;
        object2 = this.mPagedList;
        if (object == object2) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        Object object3 = this.mSnapshot;
        Object object4 = object3 != null ? object3 : object2;
        PagedList pagedList = null;
        Object object5 = null;
        if (object == null) {
            int n13 = this.getItemCount();
            object2 = this.mPagedList;
            if (object2 != null) {
                object3 = this.mPagedListCallback;
                ((PagedList)object2).removeWeakCallback((PagedList$Callback)object3);
                this.mPagedList = null;
            } else {
                object2 = this.mSnapshot;
                if (object2 != null) {
                    this.mSnapshot = null;
                }
            }
            this.mUpdateCallback.onRemoved(0, n13);
            this.onCurrentListChanged((PagedList)object4, null, runnable);
            return;
        }
        if (object2 == null && object3 == null) {
            this.mPagedList = object;
            object2 = this.mPagedListCallback;
            ((PagedList)object).addWeakCallback(null, (PagedList$Callback)object2);
            object2 = this.mUpdateCallback;
            n11 = ((PagedList)object).size();
            object2.onInserted(0, n11);
            this.onCurrentListChanged(null, (PagedList)object, runnable);
            return;
        }
        if (object2 != null) {
            object3 = this.mPagedListCallback;
            ((PagedList)object2).removeWeakCallback((PagedList$Callback)object3);
            this.mSnapshot = object2 = (PagedList)this.mPagedList.snapshot();
            this.mPagedList = null;
        }
        if ((pagedList = this.mSnapshot) != null && (object2 = this.mPagedList) == null) {
            AsyncPagedListDiffer$2 asyncPagedListDiffer$2;
            object5 = object2 = ((PagedList)object).snapshot();
            object5 = (PagedList)object2;
            object2 = this.mConfig.getBackgroundThreadExecutor();
            object3 = asyncPagedListDiffer$2;
            object4 = this;
            asyncPagedListDiffer$2 = new AsyncPagedListDiffer$2(this, pagedList, (PagedList)object5, n10, (PagedList)object, runnable);
            object2.execute(asyncPagedListDiffer$2);
            return;
        }
        object = new IllegalStateException("must be in snapshot state to diff");
        throw object;
    }
}

