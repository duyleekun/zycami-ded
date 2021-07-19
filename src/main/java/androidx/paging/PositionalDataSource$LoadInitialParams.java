/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

public class PositionalDataSource$LoadInitialParams {
    public final int pageSize;
    public final boolean placeholdersEnabled;
    public final int requestedLoadSize;
    public final int requestedStartPosition;

    public PositionalDataSource$LoadInitialParams(int n10, int n11, int n12, boolean bl2) {
        this.requestedStartPosition = n10;
        this.requestedLoadSize = n11;
        this.pageSize = n12;
        this.placeholdersEnabled = bl2;
    }
}

