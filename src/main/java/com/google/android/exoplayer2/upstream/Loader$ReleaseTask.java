/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Loader$ReleaseCallback;

public final class Loader$ReleaseTask
implements Runnable {
    private final Loader$ReleaseCallback callback;

    public Loader$ReleaseTask(Loader$ReleaseCallback loader$ReleaseCallback) {
        this.callback = loader$ReleaseCallback;
    }

    public void run() {
        this.callback.onLoaderReleased();
    }
}

