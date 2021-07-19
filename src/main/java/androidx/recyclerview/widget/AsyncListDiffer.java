/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncDifferConfig$Builder;
import androidx.recyclerview.widget.AsyncListDiffer$1;
import androidx.recyclerview.widget.AsyncListDiffer$ListListener;
import androidx.recyclerview.widget.AsyncListDiffer$MainThreadExecutor;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class AsyncListDiffer {
    private static final Executor sMainThreadExecutor;
    public final AsyncDifferConfig mConfig;
    private List mList;
    private final List mListeners;
    public Executor mMainThreadExecutor;
    public int mMaxScheduledGeneration;
    private List mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    static {
        AsyncListDiffer$MainThreadExecutor asyncListDiffer$MainThreadExecutor = new AsyncListDiffer$MainThreadExecutor();
        sMainThreadExecutor = asyncListDiffer$MainThreadExecutor;
    }

    public AsyncListDiffer(ListUpdateCallback object, AsyncDifferConfig asyncDifferConfig) {
        List<Object> list;
        this.mListeners = list = new List<Object>();
        this.mReadOnlyList = list = Collections.emptyList();
        this.mUpdateCallback = object;
        this.mConfig = asyncDifferConfig;
        object = asyncDifferConfig.getMainThreadExecutor();
        this.mMainThreadExecutor = object != null ? (object = asyncDifferConfig.getMainThreadExecutor()) : (object = sMainThreadExecutor);
    }

    public AsyncListDiffer(RecyclerView$Adapter object, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        AdapterListUpdateCallback adapterListUpdateCallback = new AdapterListUpdateCallback((RecyclerView$Adapter)object);
        object = new AsyncDifferConfig$Builder(diffUtil$ItemCallback);
        object = ((AsyncDifferConfig$Builder)object).build();
        this(adapterListUpdateCallback, (AsyncDifferConfig)object);
    }

    private void onCurrentListChanged(List list, Runnable runnable) {
        boolean bl2;
        Iterator iterator2 = this.mListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            AsyncListDiffer$ListListener asyncListDiffer$ListListener = (AsyncListDiffer$ListListener)iterator2.next();
            List list2 = this.mReadOnlyList;
            asyncListDiffer$ListListener.onCurrentListChanged(list, list2);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(AsyncListDiffer$ListListener asyncListDiffer$ListListener) {
        this.mListeners.add(asyncListDiffer$ListListener);
    }

    public List getCurrentList() {
        return this.mReadOnlyList;
    }

    public void latchList(List object, DiffUtil$DiffResult diffUtil$DiffResult, Runnable runnable) {
        List list = this.mReadOnlyList;
        this.mList = object;
        object = Collections.unmodifiableList(object);
        this.mReadOnlyList = object;
        object = this.mUpdateCallback;
        diffUtil$DiffResult.dispatchUpdatesTo((ListUpdateCallback)object);
        this.onCurrentListChanged(list, runnable);
    }

    public void removeListListener(AsyncListDiffer$ListListener asyncListDiffer$ListListener) {
        this.mListeners.remove(asyncListDiffer$ListListener);
    }

    public void submitList(List list) {
        this.submitList(list, null);
    }

    public void submitList(List list, Runnable runnable) {
        int n10;
        int n11 = this.mMaxScheduledGeneration;
        this.mMaxScheduledGeneration = n10 = n11 + 1;
        List list2 = this.mList;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        Object object = this.mReadOnlyList;
        if (list == null) {
            List list3;
            int n12 = list2.size();
            this.mList = null;
            this.mReadOnlyList = list3 = Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, n12);
            this.onCurrentListChanged((List)object, runnable);
            return;
        }
        if (list2 == null) {
            this.mList = list;
            Object object2 = Collections.unmodifiableList(list);
            this.mReadOnlyList = object2;
            object2 = this.mUpdateCallback;
            int n13 = list.size();
            object2.onInserted(0, n13);
            this.onCurrentListChanged((List)object, runnable);
            return;
        }
        object = this.mConfig.getBackgroundThreadExecutor();
        AsyncListDiffer asyncListDiffer = this;
        AsyncListDiffer$1 asyncListDiffer$1 = new AsyncListDiffer$1(this, list2, list, n10, runnable);
        object.execute(asyncListDiffer$1);
    }
}

