/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;

public class RecyclerView$RecycledViewPool {
    private static final int DEFAULT_MAX_SCRAP = 5;
    private int mAttachCount;
    public SparseArray mScrap;

    public RecyclerView$RecycledViewPool() {
        SparseArray sparseArray;
        this.mScrap = sparseArray = new SparseArray();
        this.mAttachCount = 0;
    }

    private RecyclerView$RecycledViewPool$ScrapData getScrapDataForType(int n10) {
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = (RecyclerView$RecycledViewPool$ScrapData)this.mScrap.get(n10);
        if (recyclerView$RecycledViewPool$ScrapData == null) {
            recyclerView$RecycledViewPool$ScrapData = new RecyclerView$RecycledViewPool$ScrapData();
            SparseArray sparseArray = this.mScrap;
            sparseArray.put(n10, (Object)recyclerView$RecycledViewPool$ScrapData);
        }
        return recyclerView$RecycledViewPool$ScrapData;
    }

    public void attach() {
        int n10;
        this.mAttachCount = n10 = this.mAttachCount + 1;
    }

    public void clear() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.mScrap).size()); ++i10) {
            object = ((RecyclerView$RecycledViewPool$ScrapData)this.mScrap.valueAt((int)i10)).mScrapHeap;
            ((ArrayList)object).clear();
        }
    }

    public void detach() {
        int n10;
        this.mAttachCount = n10 = this.mAttachCount + -1;
    }

    public void factorInBindTime(int n10, long l10) {
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = this.getScrapDataForType(n10);
        long l11 = recyclerView$RecycledViewPool$ScrapData.mBindRunningAverageNs;
        recyclerView$RecycledViewPool$ScrapData.mBindRunningAverageNs = l10 = this.runningAverage(l11, l10);
    }

    public void factorInCreateTime(int n10, long l10) {
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = this.getScrapDataForType(n10);
        long l11 = recyclerView$RecycledViewPool$ScrapData.mCreateRunningAverageNs;
        recyclerView$RecycledViewPool$ScrapData.mCreateRunningAverageNs = l10 = this.runningAverage(l11, l10);
    }

    public RecyclerView$ViewHolder getRecycledView(int n10) {
        int n11;
        Object object = this.mScrap;
        Object object2 = (RecyclerView$RecycledViewPool$ScrapData)object.get(n10);
        if (object2 != null && (n11 = ((ArrayList)(object = ((RecyclerView$RecycledViewPool$ScrapData)object2).mScrapHeap)).isEmpty()) == 0) {
            object2 = ((RecyclerView$RecycledViewPool$ScrapData)object2).mScrapHeap;
            for (n11 = ((ArrayList)object2).size() + -1; n11 >= 0; n11 += -1) {
                RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)((ArrayList)object2).get(n11);
                boolean bl2 = recyclerView$ViewHolder.isAttachedToTransitionOverlay();
                if (bl2) continue;
                return (RecyclerView$ViewHolder)((ArrayList)object2).remove(n11);
            }
        }
        return null;
    }

    public int getRecycledViewCount(int n10) {
        return this.getScrapDataForType((int)n10).mScrapHeap.size();
    }

    public void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2, boolean bl2) {
        int n10;
        if (recyclerView$Adapter != null) {
            this.detach();
        }
        if (!bl2 && (n10 = this.mAttachCount) == 0) {
            this.clear();
        }
        if (recyclerView$Adapter2 != null) {
            this.attach();
        }
    }

    public void putRecycledView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10 = recyclerView$ViewHolder.getItemViewType();
        ArrayList arrayList = this.getScrapDataForType((int)n10).mScrapHeap;
        SparseArray sparseArray = this.mScrap;
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = (RecyclerView$RecycledViewPool$ScrapData)sparseArray.get(n10);
        n10 = recyclerView$RecycledViewPool$ScrapData.mMaxScrap;
        int n11 = arrayList.size();
        if (n10 <= n11) {
            return;
        }
        recyclerView$ViewHolder.resetInternal();
        arrayList.add(recyclerView$ViewHolder);
    }

    public long runningAverage(long l10, long l11) {
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return l11;
        }
        l12 = 4;
        l10 = l10 / l12 * (long)3;
        return l10 + (l11 /= l12);
    }

    public void setMaxRecycledViews(int n10, int n11) {
        int n12;
        Object object = this.getScrapDataForType(n10);
        ((RecyclerView$RecycledViewPool$ScrapData)object).mMaxScrap = n11;
        object = ((RecyclerView$RecycledViewPool$ScrapData)object).mScrapHeap;
        while ((n12 = ((ArrayList)object).size()) > n11) {
            n12 = ((ArrayList)object).size() + -1;
            ((ArrayList)object).remove(n12);
        }
    }

    public int size() {
        Object object;
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = (object = this.mScrap).size()); ++i10) {
            object = ((RecyclerView$RecycledViewPool$ScrapData)this.mScrap.valueAt((int)i10)).mScrapHeap;
            if (object == null) continue;
            n10 = ((ArrayList)object).size();
            n11 += n10;
        }
        return n11;
    }

    public boolean willBindInTime(int n10, long l10, long l11) {
        long l12;
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = this.getScrapDataForType(n10);
        long l13 = recyclerView$RecycledViewPool$ScrapData.mBindRunningAverageNs;
        long l14 = 0L;
        long l15 = l13 - l14;
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 != 0 && (n10 = (int)((l12 = (l10 += l13) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
            n10 = 0;
            recyclerView$RecycledViewPool$ScrapData = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public boolean willCreateInTime(int n10, long l10, long l11) {
        long l12;
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = this.getScrapDataForType(n10);
        long l13 = recyclerView$RecycledViewPool$ScrapData.mCreateRunningAverageNs;
        long l14 = 0L;
        long l15 = l13 - l14;
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 != 0 && (n10 = (int)((l12 = (l10 += l13) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
            n10 = 0;
            recyclerView$RecycledViewPool$ScrapData = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }
}

