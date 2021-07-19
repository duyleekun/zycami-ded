/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer;

public final class ObservableReplay$SizeBoundReplayBuffer
extends ObservableReplay$BoundedReplayBuffer {
    private static final long serialVersionUID = -5898283885385201806L;
    public final int limit;

    public ObservableReplay$SizeBoundReplayBuffer(int n10) {
        this.limit = n10;
    }

    public void truncate() {
        int n10 = this.size;
        int n11 = this.limit;
        if (n10 > n11) {
            this.removeFirst();
        }
    }
}

