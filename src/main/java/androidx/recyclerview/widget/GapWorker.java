/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker$1;
import androidx.recyclerview.widget.GapWorker$LayoutPrefetchRegistryImpl;
import androidx.recyclerview.widget.GapWorker$Task;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class GapWorker
implements Runnable {
    public static final ThreadLocal sGapWorker;
    public static Comparator sTaskComparator;
    public long mFrameIntervalNs;
    public long mPostTimeNs;
    public ArrayList mRecyclerViews;
    private ArrayList mTasks;

    static {
        Object object = new ThreadLocal();
        sGapWorker = object;
        sTaskComparator = object = new GapWorker$1();
    }

    public GapWorker() {
        ArrayList arrayList;
        this.mRecyclerViews = arrayList = new ArrayList();
        this.mTasks = arrayList = new ArrayList();
    }

    private void buildTaskList() {
        GapWorker$LayoutPrefetchRegistryImpl gapWorker$LayoutPrefetchRegistryImpl;
        int n10;
        Object object;
        int n11;
        ArrayList arrayList = this.mRecyclerViews;
        int n12 = arrayList.size();
        Comparator comparator = null;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            object = (RecyclerView)this.mRecyclerViews.get(n11);
            n10 = object.getWindowVisibility();
            if (n10 != 0) continue;
            gapWorker$LayoutPrefetchRegistryImpl = ((RecyclerView)object).mPrefetchRegistry;
            gapWorker$LayoutPrefetchRegistryImpl.collectPrefetchPositionsFromView((RecyclerView)object, false);
            object = ((RecyclerView)object).mPrefetchRegistry;
            int n14 = ((GapWorker$LayoutPrefetchRegistryImpl)object).mCount;
            n13 += n14;
        }
        this.mTasks.ensureCapacity(n13);
        n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            int n15;
            object = (RecyclerView)this.mRecyclerViews.get(n11);
            n10 = object.getWindowVisibility();
            if (n10 != 0) continue;
            gapWorker$LayoutPrefetchRegistryImpl = ((RecyclerView)object).mPrefetchRegistry;
            int n16 = Math.abs(gapWorker$LayoutPrefetchRegistryImpl.mPrefetchDx);
            int n17 = Math.abs(gapWorker$LayoutPrefetchRegistryImpl.mPrefetchDy);
            n16 += n17;
            for (n17 = 0; n17 < (n15 = gapWorker$LayoutPrefetchRegistryImpl.mCount * 2); n17 += 2) {
                Object object2;
                Object object3 = this.mTasks;
                n15 = ((ArrayList)object3).size();
                if (n13 >= n15) {
                    object3 = new GapWorker$Task();
                    object2 = this.mTasks;
                    ((ArrayList)object2).add(object3);
                } else {
                    object3 = (GapWorker$Task)this.mTasks.get(n13);
                }
                object2 = gapWorker$LayoutPrefetchRegistryImpl.mPrefetchArray;
                Object object4 = n17 + 1;
                object4 = object2[object4];
                boolean bl2 = object4 <= n16;
                ((GapWorker$Task)object3).immediate = bl2;
                ((GapWorker$Task)object3).viewVelocity = n16;
                ((GapWorker$Task)object3).distanceToItem = object4;
                ((GapWorker$Task)object3).view = object;
                Object object5 = object2[n17];
                ((GapWorker$Task)object3).position = (int)object5;
                ++n13;
            }
        }
        arrayList = this.mTasks;
        comparator = sTaskComparator;
        Collections.sort(arrayList, comparator);
    }

    private void flushTaskWithDeadline(GapWorker$Task object, long l10) {
        WeakReference weakReference;
        boolean bl2 = ((GapWorker$Task)object).immediate;
        long l11 = bl2 ? Long.MAX_VALUE : l10;
        RecyclerView recyclerView = ((GapWorker$Task)object).view;
        int n10 = ((GapWorker$Task)object).position;
        object = this.prefetchPositionWithDeadline(recyclerView, n10, l11);
        if (object != null && (weakReference = ((RecyclerView$ViewHolder)object).mNestedRecyclerView) != null && (bl2 = ((RecyclerView$ViewHolder)object).isBound()) && !(bl2 = ((RecyclerView$ViewHolder)object).isInvalid())) {
            object = (RecyclerView)((RecyclerView$ViewHolder)object).mNestedRecyclerView.get();
            this.prefetchInnerRecyclerViewWithDeadline((RecyclerView)object, l10);
        }
    }

    private void flushTasksWithDeadline(long l10) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mTasks)).size()); ++i10) {
            object = (GapWorker$Task)this.mTasks.get(i10);
            RecyclerView recyclerView = ((GapWorker$Task)object).view;
            if (recyclerView == null) break;
            this.flushTaskWithDeadline((GapWorker$Task)object, l10);
            ((GapWorker$Task)object).clear();
        }
    }

    public static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int n10) {
        ChildHelper childHelper = recyclerView.mChildHelper;
        int n11 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            boolean bl2;
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i10));
            int n12 = recyclerView$ViewHolder.mPosition;
            if (n12 != n10 || (bl2 = recyclerView$ViewHolder.isInvalid())) continue;
            return true;
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(RecyclerView recyclerView, long l10) {
        Object object;
        if (recyclerView == null) {
            return;
        }
        int n10 = recyclerView.mDataSetHasChangedAfterLayout;
        if (n10 != 0 && (n10 = ((ChildHelper)(object = recyclerView.mChildHelper)).getUnfilteredChildCount()) != 0) {
            recyclerView.removeAndRecycleViews();
        }
        object = recyclerView.mPrefetchRegistry;
        ((GapWorker$LayoutPrefetchRegistryImpl)object).collectPrefetchPositionsFromView(recyclerView, true);
        int n11 = ((GapWorker$LayoutPrefetchRegistryImpl)object).mCount;
        if (n11 != 0) {
            Object object2 = "RV Nested Prefetch";
            TraceCompat.beginSection((String)object2);
            object2 = recyclerView.mState;
            Object object3 = recyclerView.mAdapter;
            try {
                ((RecyclerView$State)object2).prepareForNestedPrefetch((RecyclerView$Adapter)object3);
                n11 = 0;
                object2 = null;
            }
            catch (Throwable throwable) {
                TraceCompat.endSection();
                throw throwable;
            }
            while (true) {
                Object object4 = ((GapWorker$LayoutPrefetchRegistryImpl)object).mCount * 2;
                if (n11 >= object4) break;
                object3 = ((GapWorker$LayoutPrefetchRegistryImpl)object).mPrefetchArray;
                object4 = object3[n11];
                this.prefetchPositionWithDeadline(recyclerView, (int)object4, l10);
                n11 += 2;
                continue;
                break;
            }
            TraceCompat.endSection();
        }
    }

    private RecyclerView$ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int n10, long l10) {
        RecyclerView$ViewHolder recyclerView$ViewHolder;
        block11: {
            boolean bl2 = GapWorker.isPrefetchPositionAttached(recyclerView, n10);
            if (bl2) {
                return null;
            }
            RecyclerView$Recycler recyclerView$Recycler = recyclerView.mRecycler;
            recyclerView.onEnterLayoutOrScroll();
            recyclerView$ViewHolder = recyclerView$Recycler.tryGetViewHolderForPositionByDeadline(n10, false, l10);
            if (recyclerView$ViewHolder == null) break block11;
            boolean bl3 = recyclerView$ViewHolder.isBound();
            if (bl3 && !(bl3 = recyclerView$ViewHolder.isInvalid())) {
                View view = recyclerView$ViewHolder.itemView;
                recyclerView$Recycler.recycleView(view);
                break block11;
            }
            recyclerView$Recycler.addViewHolderToRecycledViewPool(recyclerView$ViewHolder, false);
        }
        return recyclerView$ViewHolder;
        finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    public void postFromTraversal(RecyclerView recyclerView, int n10, int n11) {
        long l10;
        long l11;
        long l12;
        boolean bl2 = recyclerView.isAttachedToWindow();
        if (bl2 && !(bl2 = (l12 = (l11 = this.mPostTimeNs) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            this.mPostTimeNs = l11 = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(n10, n11);
    }

    public void prefetch(long l10) {
        this.buildTaskList();
        this.flushTasksWithDeadline(l10);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        long l10 = 0L;
        Object object = "RV Prefetch";
        TraceCompat.beginSection((String)object);
        object = this.mRecyclerViews;
        int n10 = ((ArrayList)object).isEmpty();
        if (n10 != 0) {
            return;
        }
        object = this.mRecyclerViews;
        n10 = ((ArrayList)object).size();
        long l11 = l10;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = this.mRecyclerViews;
            object2 = ((ArrayList)object2).get(i10);
            int n11 = (object2 = (RecyclerView)object2).getWindowVisibility();
            if (n11 != 0) continue;
            long l12 = object2.getDrawingTime();
            l11 = Math.max(l12, l11);
        }
        n10 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        if (n10 == 0) {
            return;
        }
        object = TimeUnit.MILLISECONDS;
        long l13 = ((TimeUnit)((Object)object)).toNanos(l11);
        l11 = this.mFrameIntervalNs;
        this.prefetch(l13 += l11);
        return;
    }
}

