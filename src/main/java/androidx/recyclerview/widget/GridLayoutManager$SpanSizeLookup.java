/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package androidx.recyclerview.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup {
    private boolean mCacheSpanGroupIndices;
    private boolean mCacheSpanIndices;
    public final SparseIntArray mSpanGroupIndexCache;
    public final SparseIntArray mSpanIndexCache;

    public GridLayoutManager$SpanSizeLookup() {
        SparseIntArray sparseIntArray;
        this.mSpanIndexCache = sparseIntArray = new SparseIntArray();
        this.mSpanGroupIndexCache = sparseIntArray = new SparseIntArray();
        this.mCacheSpanIndices = false;
        this.mCacheSpanGroupIndices = false;
    }

    public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int n10) {
        int n11 = sparseIntArray.size() + -1;
        int n12 = 0;
        while (n12 <= n11) {
            int n13 = n12 + n11 >>> 1;
            int n14 = sparseIntArray.keyAt(n13);
            if (n14 < n10) {
                n12 = ++n13;
                continue;
            }
            n11 = n13 += -1;
        }
        if ((n12 += -1) >= 0 && n12 < (n10 = sparseIntArray.size())) {
            return sparseIntArray.keyAt(n12);
        }
        return -1;
    }

    public int getCachedSpanGroupIndex(int n10, int n11) {
        int n12 = this.mCacheSpanGroupIndices;
        if (n12 == 0) {
            return this.getSpanGroupIndex(n10, n11);
        }
        SparseIntArray sparseIntArray = this.mSpanGroupIndexCache;
        int n13 = -1;
        n12 = sparseIntArray.get(n10, n13);
        if (n12 != n13) {
            return n12;
        }
        n11 = this.getSpanGroupIndex(n10, n11);
        this.mSpanGroupIndexCache.put(n10, n11);
        return n11;
    }

    public int getCachedSpanIndex(int n10, int n11) {
        int n12 = this.mCacheSpanIndices;
        if (n12 == 0) {
            return this.getSpanIndex(n10, n11);
        }
        SparseIntArray sparseIntArray = this.mSpanIndexCache;
        int n13 = -1;
        n12 = sparseIntArray.get(n10, n13);
        if (n12 != n13) {
            return n12;
        }
        n11 = this.getSpanIndex(n10, n11);
        this.mSpanIndexCache.put(n10, n11);
        return n11;
    }

    public int getSpanGroupIndex(int n10, int n11) {
        int n12;
        int n13;
        SparseIntArray sparseIntArray;
        int n14;
        SparseIntArray sparseIntArray2;
        int n15 = this.mCacheSpanGroupIndices;
        if (n15 != 0 && (n15 = GridLayoutManager$SpanSizeLookup.findFirstKeyLessThan(sparseIntArray2 = this.mSpanGroupIndexCache, n10)) != (n14 = -1)) {
            sparseIntArray = this.mSpanGroupIndexCache;
            n14 = sparseIntArray.get(n15);
            n13 = n15 + 1;
            n12 = this.getCachedSpanIndex(n15, n11);
            if ((n12 += (n15 = this.getSpanSize(n15))) == n11) {
                ++n14;
                n12 = 0;
            }
        } else {
            n14 = 0;
            sparseIntArray = null;
            n13 = 0;
            n12 = 0;
        }
        n15 = this.getSpanSize(n10);
        while (n13 < n10) {
            int n16 = this.getSpanSize(n13);
            if ((n12 += n16) == n11) {
                ++n14;
                n12 = 0;
            } else if (n12 > n11) {
                ++n14;
                n12 = n16;
            }
            ++n13;
        }
        if ((n12 += n15) > n11) {
            ++n14;
        }
        return n14;
    }

    public int getSpanIndex(int n10, int n11) {
        int n12;
        int n13;
        SparseIntArray sparseIntArray;
        SparseIntArray sparseIntArray2;
        int n14 = this.getSpanSize(n10);
        if (n14 == n11) {
            return 0;
        }
        int n15 = this.mCacheSpanIndices;
        if (n15 != 0 && (n15 = GridLayoutManager$SpanSizeLookup.findFirstKeyLessThan(sparseIntArray2 = this.mSpanIndexCache, n10)) >= 0) {
            sparseIntArray = this.mSpanIndexCache;
            n13 = sparseIntArray.get(n15);
            n12 = this.getSpanSize(n15);
            n13 += n12;
        } else {
            sparseIntArray2 = null;
            n13 = 0;
            sparseIntArray = null;
        }
        for (n15 = 0; n15 < n10; ++n15) {
            n12 = this.getSpanSize(n15);
            if ((n13 += n12) == n11) {
                n13 = 0;
                sparseIntArray = null;
                continue;
            }
            if (n13 <= n11) continue;
            n13 = n12;
        }
        if ((n14 += n13) <= n11) {
            return n13;
        }
        return 0;
    }

    public abstract int getSpanSize(int var1);

    public void invalidateSpanGroupIndexCache() {
        this.mSpanGroupIndexCache.clear();
    }

    public void invalidateSpanIndexCache() {
        this.mSpanIndexCache.clear();
    }

    public boolean isSpanGroupIndexCacheEnabled() {
        return this.mCacheSpanGroupIndices;
    }

    public boolean isSpanIndexCacheEnabled() {
        return this.mCacheSpanIndices;
    }

    public void setSpanGroupIndexCacheEnabled(boolean bl2) {
        if (!bl2) {
            SparseIntArray sparseIntArray = this.mSpanGroupIndexCache;
            sparseIntArray.clear();
        }
        this.mCacheSpanGroupIndices = bl2;
    }

    public void setSpanIndexCacheEnabled(boolean bl2) {
        if (!bl2) {
            SparseIntArray sparseIntArray = this.mSpanGroupIndexCache;
            sparseIntArray.clear();
        }
        this.mCacheSpanIndices = bl2;
    }
}

