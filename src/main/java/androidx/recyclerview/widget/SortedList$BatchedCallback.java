/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.BatchingListUpdateCallback;
import androidx.recyclerview.widget.SortedList$Callback;

public class SortedList$BatchedCallback
extends SortedList$Callback {
    private final BatchingListUpdateCallback mBatchingListUpdateCallback;
    public final SortedList$Callback mWrappedCallback;

    public SortedList$BatchedCallback(SortedList$Callback sortedList$Callback) {
        BatchingListUpdateCallback batchingListUpdateCallback;
        this.mWrappedCallback = sortedList$Callback;
        this.mBatchingListUpdateCallback = batchingListUpdateCallback = new BatchingListUpdateCallback(sortedList$Callback);
    }

    public boolean areContentsTheSame(Object object, Object object2) {
        return this.mWrappedCallback.areContentsTheSame(object, object2);
    }

    public boolean areItemsTheSame(Object object, Object object2) {
        return this.mWrappedCallback.areItemsTheSame(object, object2);
    }

    public int compare(Object object, Object object2) {
        return this.mWrappedCallback.compare(object, object2);
    }

    public void dispatchLastEvent() {
        this.mBatchingListUpdateCallback.dispatchLastEvent();
    }

    public Object getChangePayload(Object object, Object object2) {
        return this.mWrappedCallback.getChangePayload(object, object2);
    }

    public void onChanged(int n10, int n11) {
        this.mBatchingListUpdateCallback.onChanged(n10, n11, null);
    }

    public void onChanged(int n10, int n11, Object object) {
        this.mBatchingListUpdateCallback.onChanged(n10, n11, object);
    }

    public void onInserted(int n10, int n11) {
        this.mBatchingListUpdateCallback.onInserted(n10, n11);
    }

    public void onMoved(int n10, int n11) {
        this.mBatchingListUpdateCallback.onMoved(n10, n11);
    }

    public void onRemoved(int n10, int n11) {
        this.mBatchingListUpdateCallback.onRemoved(n10, n11);
    }
}

