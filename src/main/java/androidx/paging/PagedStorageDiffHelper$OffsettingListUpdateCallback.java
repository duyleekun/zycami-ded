/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;

public class PagedStorageDiffHelper$OffsettingListUpdateCallback
implements ListUpdateCallback {
    private final ListUpdateCallback mCallback;
    private final int mOffset;

    public PagedStorageDiffHelper$OffsettingListUpdateCallback(int n10, ListUpdateCallback listUpdateCallback) {
        this.mOffset = n10;
        this.mCallback = listUpdateCallback;
    }

    public void onChanged(int n10, int n11, Object object) {
        ListUpdateCallback listUpdateCallback = this.mCallback;
        int n12 = this.mOffset;
        listUpdateCallback.onChanged(n10 += n12, n11, object);
    }

    public void onInserted(int n10, int n11) {
        ListUpdateCallback listUpdateCallback = this.mCallback;
        int n12 = this.mOffset;
        listUpdateCallback.onInserted(n10 += n12, n11);
    }

    public void onMoved(int n10, int n11) {
        ListUpdateCallback listUpdateCallback = this.mCallback;
        int n12 = this.mOffset;
        listUpdateCallback.onMoved(n10 += n12, n11 += n12);
    }

    public void onRemoved(int n10, int n11) {
        ListUpdateCallback listUpdateCallback = this.mCallback;
        int n12 = this.mOffset;
        listUpdateCallback.onRemoved(n10 += n12, n11);
    }
}

