/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ListUpdateCallback;

public class BatchingListUpdateCallback
implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    public int mLastEventCount;
    public Object mLastEventPayload;
    public int mLastEventPosition;
    public int mLastEventType = 0;
    public final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        int n10;
        this.mLastEventPosition = n10 = -1;
        this.mLastEventCount = n10;
        this.mLastEventPayload = null;
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int n10 = this.mLastEventType;
        if (n10 == 0) {
            return;
        }
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11) {
                    ListUpdateCallback listUpdateCallback = this.mWrapped;
                    n11 = this.mLastEventPosition;
                    int n12 = this.mLastEventCount;
                    Object object = this.mLastEventPayload;
                    listUpdateCallback.onChanged(n11, n12, object);
                }
            } else {
                ListUpdateCallback listUpdateCallback = this.mWrapped;
                n11 = this.mLastEventPosition;
                int n13 = this.mLastEventCount;
                listUpdateCallback.onRemoved(n11, n13);
            }
        } else {
            ListUpdateCallback listUpdateCallback = this.mWrapped;
            n11 = this.mLastEventPosition;
            int n14 = this.mLastEventCount;
            listUpdateCallback.onInserted(n11, n14);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    public void onChanged(int n10, int n11, Object object) {
        Object object2;
        int n12;
        int n13;
        int n14 = this.mLastEventType;
        int n15 = 3;
        if (n14 == n15 && n10 <= (n13 = (n14 = this.mLastEventPosition) + (n12 = this.mLastEventCount)) && (n13 = n10 + n11) >= n14 && (object2 = this.mLastEventPayload) == object) {
            this.mLastEventPosition = n10 = Math.min(n10, n14);
            n10 = Math.max(n12 += n14, n13);
            n11 = this.mLastEventPosition;
            this.mLastEventCount = n10 -= n11;
            return;
        }
        this.dispatchLastEvent();
        this.mLastEventPosition = n10;
        this.mLastEventCount = n11;
        this.mLastEventPayload = object;
        this.mLastEventType = n15;
    }

    public void onInserted(int n10, int n11) {
        int n12;
        int n13;
        int n14 = this.mLastEventType;
        int n15 = 1;
        if (n14 == n15 && n10 >= (n14 = this.mLastEventPosition) && n10 <= (n13 = n14 + (n12 = this.mLastEventCount))) {
            this.mLastEventCount = n12 += n11;
            this.mLastEventPosition = n10 = Math.min(n10, n14);
            return;
        }
        this.dispatchLastEvent();
        this.mLastEventPosition = n10;
        this.mLastEventCount = n11;
        this.mLastEventType = n15;
    }

    public void onMoved(int n10, int n11) {
        this.dispatchLastEvent();
        this.mWrapped.onMoved(n10, n11);
    }

    public void onRemoved(int n10, int n11) {
        int n12;
        int n13 = this.mLastEventType;
        int n14 = 2;
        if (n13 == n14 && (n13 = this.mLastEventPosition) >= n10 && n13 <= (n12 = n10 + n11)) {
            this.mLastEventCount = n13 = this.mLastEventCount + n11;
            this.mLastEventPosition = n10;
            return;
        }
        this.dispatchLastEvent();
        this.mLastEventPosition = n10;
        this.mLastEventCount = n11;
        this.mLastEventType = n14;
    }
}

