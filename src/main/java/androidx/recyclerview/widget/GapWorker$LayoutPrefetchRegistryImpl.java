/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import java.util.Arrays;

public class GapWorker$LayoutPrefetchRegistryImpl
implements RecyclerView$LayoutManager$LayoutPrefetchRegistry {
    public int mCount;
    public int[] mPrefetchArray;
    public int mPrefetchDx;
    public int mPrefetchDy;

    public void addPosition(int n10, int n11) {
        if (n10 >= 0) {
            if (n11 >= 0) {
                int n12 = this.mCount * 2;
                int[] nArray = this.mPrefetchArray;
                if (nArray == null) {
                    int n13 = 4;
                    this.mPrefetchArray = nArray = new int[n13];
                    int n14 = -1;
                    Arrays.fill(nArray, n14);
                } else {
                    int n15 = nArray.length;
                    if (n12 >= n15) {
                        n15 = n12 * 2;
                        int[] nArray2 = new int[n15];
                        this.mPrefetchArray = nArray2;
                        int n16 = nArray.length;
                        System.arraycopy(nArray, 0, nArray2, 0, n16);
                    }
                }
                nArray = this.mPrefetchArray;
                nArray[n12] = n10;
                nArray[++n12] = n11;
                this.mCount = n10 = this.mCount + 1;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Pixel distance must be non-negative");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Layout positions must be non-negative");
        throw illegalArgumentException;
    }

    public void clearPrefetchPositions() {
        int[] nArray = this.mPrefetchArray;
        if (nArray != null) {
            int n10 = -1;
            Arrays.fill(nArray, n10);
        }
        this.mCount = 0;
    }

    public void collectPrefetchPositionsFromView(RecyclerView object, boolean bl2) {
        int n10;
        this.mCount = 0;
        Object object2 = this.mPrefetchArray;
        if (object2 != null) {
            n10 = -1;
            Arrays.fill(object2, n10);
        }
        object2 = ((RecyclerView)object).mLayout;
        Object object3 = ((RecyclerView)object).mAdapter;
        if (object3 != null && object2 != null && (n10 = (int)(object2.isItemPrefetchEnabled() ? 1 : 0)) != 0) {
            int n11;
            if (bl2) {
                object3 = ((RecyclerView)object).mAdapterHelper;
                n10 = (int)(((AdapterHelper)object3).hasPendingUpdates() ? 1 : 0);
                if (n10 == 0) {
                    object3 = ((RecyclerView)object).mAdapter;
                    n10 = ((RecyclerView$Adapter)object3).getItemCount();
                    object2.collectInitialPrefetchPositions(n10, this);
                }
            } else {
                n10 = (int)(((RecyclerView)object).hasPendingAdapterUpdates() ? 1 : 0);
                if (n10 == 0) {
                    n10 = this.mPrefetchDx;
                    n11 = this.mPrefetchDy;
                    RecyclerView$State recyclerView$State = ((RecyclerView)object).mState;
                    object2.collectAdjacentPrefetchPositions(n10, n11, recyclerView$State, this);
                }
            }
            if ((n10 = this.mCount) > (n11 = object2.mPrefetchMaxCountObserved)) {
                object2.mPrefetchMaxCountObserved = n10;
                object2.mPrefetchMaxObservedInInitialPrefetch = bl2;
                object = ((RecyclerView)object).mRecycler;
                ((RecyclerView$Recycler)object).updateViewCacheSize();
            }
        }
    }

    public boolean lastPrefetchIncludedPosition(int n10) {
        int[] nArray = this.mPrefetchArray;
        if (nArray != null) {
            int n11 = this.mCount * 2;
            for (int i10 = 0; i10 < n11; i10 += 2) {
                int[] nArray2 = this.mPrefetchArray;
                int n12 = nArray2[i10];
                if (n12 != n10) continue;
                return true;
            }
        }
        return false;
    }

    public void setPrefetchVector(int n10, int n11) {
        this.mPrefetchDx = n10;
        this.mPrefetchDy = n11;
    }
}

