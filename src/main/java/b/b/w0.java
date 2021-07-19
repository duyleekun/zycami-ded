/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.room.InvalidationTracker;

public final class w0
implements Runnable {
    public final /* synthetic */ InvalidationTracker a;

    public /* synthetic */ w0(InvalidationTracker invalidationTracker) {
        this.a = invalidationTracker;
    }

    public final void run() {
        this.a.onAutoCloseCallback();
    }
}

