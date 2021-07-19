/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PagedList$Config;

public final class PagedList$Config$Builder {
    public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
    private boolean mEnablePlaceholders;
    private int mInitialLoadSizeHint;
    private int mMaxSize;
    private int mPageSize;
    private int mPrefetchDistance;

    public PagedList$Config$Builder() {
        int n10;
        this.mPageSize = n10 = -1;
        this.mPrefetchDistance = n10;
        this.mInitialLoadSizeHint = n10;
        this.mEnablePlaceholders = true;
        this.mMaxSize = -1 >>> 1;
    }

    public PagedList$Config build() {
        PagedList$Config pagedList$Config;
        boolean bl2;
        int n10 = this.mPrefetchDistance;
        if (n10 < 0) {
            this.mPrefetchDistance = n10 = this.mPageSize;
        }
        if ((n10 = this.mInitialLoadSizeHint) < 0) {
            this.mInitialLoadSizeHint = n10 = this.mPageSize * 3;
        }
        if (!(bl2 = this.mEnablePlaceholders) && (n10 = this.mPrefetchDistance) == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            throw illegalArgumentException;
        }
        int n11 = this.mMaxSize;
        n10 = -1 >>> 1;
        if (n11 != n10) {
            n10 = this.mPageSize;
            int n12 = this.mPrefetchDistance * 2;
            if (n11 < (n10 += n12)) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=");
                int n13 = this.mPageSize;
                charSequence.append(n13);
                charSequence.append(", prefetchDist=");
                n13 = this.mPrefetchDistance;
                charSequence.append(n13);
                charSequence.append(", maxSize=");
                n13 = this.mMaxSize;
                charSequence.append(n13);
                charSequence = charSequence.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
                throw illegalArgumentException;
            }
        }
        int n14 = this.mPageSize;
        int n15 = this.mPrefetchDistance;
        int n16 = this.mInitialLoadSizeHint;
        PagedList$Config pagedList$Config2 = pagedList$Config;
        pagedList$Config = new PagedList$Config(n14, n15, bl2, n16, n11);
        return pagedList$Config;
    }

    public PagedList$Config$Builder setEnablePlaceholders(boolean bl2) {
        this.mEnablePlaceholders = bl2;
        return this;
    }

    public PagedList$Config$Builder setInitialLoadSizeHint(int n10) {
        this.mInitialLoadSizeHint = n10;
        return this;
    }

    public PagedList$Config$Builder setMaxSize(int n10) {
        this.mMaxSize = n10;
        return this;
    }

    public PagedList$Config$Builder setPageSize(int n10) {
        int n11 = 1;
        if (n10 >= n11) {
            this.mPageSize = n10;
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Page size must be a positive number");
        throw illegalArgumentException;
    }

    public PagedList$Config$Builder setPrefetchDistance(int n10) {
        this.mPrefetchDistance = n10;
        return this;
    }
}

