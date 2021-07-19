/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$Span;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaggeredGridLayoutManager$LazySpanLookup {
    private static final int MIN_SIZE = 10;
    public int[] mData;
    public List mFullSpanItems;

    private int invalidateFullSpansAfter(int n10) {
        int n11;
        int n12;
        block5: {
            List list;
            Object object = this.mFullSpanItems;
            n12 = -1;
            if (object == null) {
                return n12;
            }
            object = this.getFullSpanItem(n10);
            if (object != null) {
                list = this.mFullSpanItems;
                list.remove(object);
            }
            object = this.mFullSpanItems;
            int n13 = object.size();
            list = null;
            for (n11 = 0; n11 < n13; ++n11) {
                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(n11);
                int n14 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
                if (n14 < n10) {
                    continue;
                }
                break block5;
            }
            n11 = n12;
        }
        if (n11 != n12) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(n11);
            this.mFullSpanItems.remove(n11);
            return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
        }
        return n12;
    }

    private void offsetFullSpansForAddition(int n10, int n11) {
        List list = this.mFullSpanItems;
        if (list == null) {
            return;
        }
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(i10);
            int n12 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (n12 < n10) continue;
            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = n12 += n11;
        }
    }

    private void offsetFullSpansForRemoval(int n10, int n11) {
        List list = this.mFullSpanItems;
        if (list == null) {
            return;
        }
        int n12 = n10 + n11;
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            Object object = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(i10);
            int n13 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).mPosition;
            if (n13 < n10) continue;
            if (n13 < n12) {
                object = this.mFullSpanItems;
                object.remove(i10);
                continue;
            }
            ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).mPosition = n13 -= n11;
        }
    }

    public void addFullSpanItem(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem) {
        ArrayList arrayList = this.mFullSpanItems;
        if (arrayList == null) {
            this.mFullSpanItems = arrayList = new ArrayList();
        }
        arrayList = this.mFullSpanItems;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(i10);
            int n12 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.mPosition;
            int n13 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (n12 == n13) {
                List list = this.mFullSpanItems;
                list.remove(i10);
            }
            if ((n11 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.mPosition) < (n12 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition)) continue;
            this.mFullSpanItems.add(i10, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
            return;
        }
        this.mFullSpanItems.add(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
    }

    public void clear() {
        int[] nArray = this.mData;
        if (nArray != null) {
            int n10 = -1;
            Arrays.fill(nArray, n10);
        }
        this.mFullSpanItems = null;
    }

    public void ensureSize(int n10) {
        int[] nArray = this.mData;
        int n11 = -1;
        if (nArray == null) {
            int n12 = 10;
            n10 = Math.max(n10, n12) + 1;
            int[] nArray2 = new int[n10];
            this.mData = nArray2;
            Arrays.fill(nArray2, n11);
        } else {
            int n13 = nArray.length;
            if (n10 >= n13) {
                n10 = this.sizeForPosition(n10);
                int[] nArray3 = new int[n10];
                this.mData = nArray3;
                n13 = nArray.length;
                System.arraycopy(nArray, 0, nArray3, 0, n13);
                nArray3 = this.mData;
                int n14 = nArray.length;
                n13 = nArray3.length;
                Arrays.fill(nArray3, n14, n13, n11);
            }
        }
    }

    public int forceInvalidateAfter(int n10) {
        List list = this.mFullSpanItems;
        if (list != null) {
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Object object = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(i10);
                int n11 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).mPosition;
                if (n11 < n10) continue;
                object = this.mFullSpanItems;
                object.remove(i10);
            }
        }
        return this.invalidateAfter(n10);
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem getFirstFullSpanItemInRange(int n10, int n11, int n12, boolean bl2) {
        List list = this.mFullSpanItems;
        if (list == null) {
            return null;
        }
        int n13 = list.size();
        for (int i10 = 0; i10 < n13; ++i10) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(i10);
            int n14 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (n14 >= n11) {
                return null;
            }
            if (n14 < n10 || n12 != 0 && (n14 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapDir) != n12 && (!bl2 || (n14 = (int)(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mHasUnwantedGapAfter ? 1 : 0)) == 0)) continue;
            return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
        }
        return null;
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem getFullSpanItem(int n10) {
        List list = this.mFullSpanItems;
        if (list == null) {
            return null;
        }
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(i10);
            int n11 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (n11 != n10) continue;
            return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
        }
        return null;
    }

    public int getSpan(int n10) {
        int n11;
        int[] nArray = this.mData;
        if (nArray != null && n10 < (n11 = nArray.length)) {
            return nArray[n10];
        }
        return -1;
    }

    public int invalidateAfter(int n10) {
        int[] nArray = this.mData;
        int n11 = -1;
        if (nArray == null) {
            return n11;
        }
        int n12 = nArray.length;
        if (n10 >= n12) {
            return n11;
        }
        n12 = this.invalidateFullSpansAfter(n10);
        if (n12 == n11) {
            nArray = this.mData;
            int n13 = nArray.length;
            Arrays.fill(nArray, n10, n13, n11);
            return this.mData.length;
        }
        ++n12;
        int n14 = this.mData.length;
        n12 = Math.min(n12, n14);
        Arrays.fill(this.mData, n10, n12, n11);
        return n12;
    }

    public void offsetForAddition(int n10, int n11) {
        int n12;
        int[] nArray = this.mData;
        if (nArray != null && n10 < (n12 = nArray.length)) {
            n12 = n10 + n11;
            this.ensureSize(n12);
            int[] nArray2 = this.mData;
            int n13 = nArray2.length - n10 - n11;
            System.arraycopy(nArray2, n10, nArray2, n12, n13);
            nArray2 = this.mData;
            n13 = -1;
            Arrays.fill(nArray2, n10, n12, n13);
            this.offsetFullSpansForAddition(n10, n11);
        }
    }

    public void offsetForRemoval(int n10, int n11) {
        int n12;
        int[] nArray = this.mData;
        if (nArray != null && n10 < (n12 = nArray.length)) {
            n12 = n10 + n11;
            this.ensureSize(n12);
            int[] nArray2 = this.mData;
            int n13 = nArray2.length - n10 - n11;
            System.arraycopy(nArray2, n12, nArray2, n10, n13);
            nArray = this.mData;
            int n14 = nArray.length - n11;
            n13 = nArray.length;
            int n15 = -1;
            Arrays.fill(nArray, n14, n13, n15);
            this.offsetFullSpansForRemoval(n10, n11);
        }
    }

    public void setSpan(int n10, StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span) {
        int n11;
        this.ensureSize(n10);
        int[] nArray = this.mData;
        nArray[n10] = n11 = staggeredGridLayoutManager$Span.mIndex;
    }

    public int sizeForPosition(int n10) {
        int n11;
        int[] nArray = this.mData;
        for (n11 = nArray.length; n11 <= n10; n11 *= 2) {
        }
        return n11;
    }
}

