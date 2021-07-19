/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

public class PagedList$Config {
    public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
    public final boolean enablePlaceholders;
    public final int initialLoadSizeHint;
    public final int maxSize;
    public final int pageSize;
    public final int prefetchDistance;

    public PagedList$Config(int n10, int n11, boolean bl2, int n12, int n13) {
        this.pageSize = n10;
        this.prefetchDistance = n11;
        this.enablePlaceholders = bl2;
        this.initialLoadSizeHint = n12;
        this.maxSize = n13;
    }
}

