/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig;
import com.chad.library.adapter.base.diff.BrvahListUpdateCallback;
import com.chad.library.adapter.base.diff.DifferImp;
import com.chad.library.adapter.base.diff.ListChangeListener;
import f.h2.t.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public final class BrvahAsyncDiffer
implements DifferImp {
    private final BaseQuickAdapter adapter;
    private final BrvahAsyncDifferConfig config;
    private final List mListeners;
    private Executor mMainThreadExecutor;
    private int mMaxScheduledGeneration;
    private final ListUpdateCallback mUpdateCallback;
    private final Executor sMainThreadExecutor;

    public BrvahAsyncDiffer(BaseQuickAdapter copyOnWriteArrayList, BrvahAsyncDifferConfig object) {
        f0.q(copyOnWriteArrayList, "adapter");
        f0.q(object, "config");
        this.adapter = copyOnWriteArrayList;
        this.config = object;
        BrvahListUpdateCallback brvahListUpdateCallback = new BrvahListUpdateCallback((BaseQuickAdapter)((Object)copyOnWriteArrayList));
        this.mUpdateCallback = brvahListUpdateCallback;
        copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.sMainThreadExecutor = copyOnWriteArrayList;
        object = ((BrvahAsyncDifferConfig)object).getMainThreadExecutor();
        if (object != null) {
            copyOnWriteArrayList = object;
        }
        this.mMainThreadExecutor = copyOnWriteArrayList;
        this.mListeners = copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

    public static final /* synthetic */ BrvahAsyncDifferConfig access$getConfig$p(BrvahAsyncDiffer brvahAsyncDiffer) {
        return brvahAsyncDiffer.config;
    }

    public static final /* synthetic */ Executor access$getMMainThreadExecutor$p(BrvahAsyncDiffer brvahAsyncDiffer) {
        return brvahAsyncDiffer.mMainThreadExecutor;
    }

    public static final /* synthetic */ int access$getMMaxScheduledGeneration$p(BrvahAsyncDiffer brvahAsyncDiffer) {
        return brvahAsyncDiffer.mMaxScheduledGeneration;
    }

    public static final /* synthetic */ void access$latchList(BrvahAsyncDiffer brvahAsyncDiffer, List list, DiffUtil$DiffResult diffUtil$DiffResult, Runnable runnable) {
        brvahAsyncDiffer.latchList(list, diffUtil$DiffResult, runnable);
    }

    public static final /* synthetic */ void access$setMMainThreadExecutor$p(BrvahAsyncDiffer brvahAsyncDiffer, Executor executor) {
        brvahAsyncDiffer.mMainThreadExecutor = executor;
    }

    public static final /* synthetic */ void access$setMMaxScheduledGeneration$p(BrvahAsyncDiffer brvahAsyncDiffer, int n10) {
        brvahAsyncDiffer.mMaxScheduledGeneration = n10;
    }

    private final void latchList(List object, DiffUtil$DiffResult diffUtil$DiffResult, Runnable runnable) {
        List list = this.adapter.getData();
        this.adapter.setData$com_github_CymChad_brvah((List)object);
        object = this.mUpdateCallback;
        diffUtil$DiffResult.dispatchUpdatesTo((ListUpdateCallback)object);
        this.onCurrentListChanged(list, runnable);
    }

    private final void onCurrentListChanged(List list, Runnable runnable) {
        boolean bl2;
        Iterator iterator2 = this.mListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            ListChangeListener listChangeListener = (ListChangeListener)iterator2.next();
            List list2 = this.adapter.getData();
            listChangeListener.onCurrentListChanged(list, list2);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void submitList$default(BrvahAsyncDiffer brvahAsyncDiffer, List list, Runnable runnable, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            runnable = null;
        }
        brvahAsyncDiffer.submitList(list, runnable);
    }

    public final void addData(int n10, Object object) {
        List list = this.adapter.getData();
        this.adapter.getData().add(n10, object);
        this.mUpdateCallback.onInserted(n10, 1);
        this.onCurrentListChanged(list, null);
    }

    public final void addData(Object object) {
        List list = this.adapter.getData();
        this.adapter.getData().add(object);
        object = this.mUpdateCallback;
        int n10 = list.size();
        object.onInserted(n10, 1);
        this.onCurrentListChanged(list, null);
    }

    public final void addList(List list) {
        if (list == null) {
            return;
        }
        List list2 = this.adapter.getData();
        this.adapter.getData().addAll(list);
        ListUpdateCallback listUpdateCallback = this.mUpdateCallback;
        int n10 = list2.size();
        int n11 = list.size();
        listUpdateCallback.onInserted(n10, n11);
        this.onCurrentListChanged(list2, null);
    }

    public void addListListener(ListChangeListener listChangeListener) {
        f0.q(listChangeListener, "listener");
        this.mListeners.add(listChangeListener);
    }

    public final void changeData(int n10, Object object, Object object2) {
        List list = this.adapter.getData();
        this.adapter.getData().set(n10, object);
        this.mUpdateCallback.onChanged(n10, 1, object2);
        this.onCurrentListChanged(list, null);
    }

    public final void clearAllListListener() {
        this.mListeners.clear();
    }

    public final void remove(Object object) {
        int n10;
        List list = this.adapter.getData();
        List list2 = this.adapter.getData();
        int n11 = list2.indexOf(object);
        if (n11 == (n10 = -1)) {
            return;
        }
        this.adapter.getData().remove(n11);
        this.mUpdateCallback.onRemoved(n11, 1);
        this.onCurrentListChanged(list, null);
    }

    public final void removeAt(int n10) {
        List list = this.adapter.getData();
        this.adapter.getData().remove(n10);
        this.mUpdateCallback.onRemoved(n10, 1);
        this.onCurrentListChanged(list, null);
    }

    public final void removeListListener(ListChangeListener listChangeListener) {
        f0.q(listChangeListener, "listener");
        this.mListeners.remove(listChangeListener);
    }

    public final void submitList(List list) {
        BrvahAsyncDiffer.submitList$default(this, list, null, 2, null);
    }

    public final void submitList(List list, Runnable runnable) {
        BrvahAsyncDiffer$submitList$1 brvahAsyncDiffer$submitList$1;
        int n10;
        int n11 = this.mMaxScheduledGeneration;
        this.mMaxScheduledGeneration = n10 = n11 + 1;
        Object object = this.adapter.getData();
        if (list == object) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        List list2 = this.adapter.getData();
        n11 = 0;
        object = null;
        if (list == null) {
            int n12 = this.adapter.getData().size();
            BaseQuickAdapter baseQuickAdapter = this.adapter;
            ArrayList arrayList = new ArrayList();
            baseQuickAdapter.setData$com_github_CymChad_brvah(arrayList);
            this.mUpdateCallback.onRemoved(0, n12);
            this.onCurrentListChanged(list2, runnable);
            return;
        }
        Object object2 = this.adapter.getData();
        boolean bl2 = object2.isEmpty();
        if (bl2) {
            this.adapter.setData$com_github_CymChad_brvah(list);
            object2 = this.mUpdateCallback;
            int n13 = list.size();
            object2.onInserted(0, n13);
            this.onCurrentListChanged(list2, runnable);
            return;
        }
        object = this.config.getBackgroundThreadExecutor();
        object2 = brvahAsyncDiffer$submitList$1;
        BrvahAsyncDiffer brvahAsyncDiffer = this;
        brvahAsyncDiffer$submitList$1 = new BrvahAsyncDiffer$submitList$1(this, list2, list, n10, runnable);
        object.execute(brvahAsyncDiffer$submitList$1);
    }
}

