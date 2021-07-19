/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Loader$1;

public final class Loader$LoadErrorAction {
    private final long retryDelayMillis;
    private final int type;

    private Loader$LoadErrorAction(int n10, long l10) {
        this.type = n10;
        this.retryDelayMillis = l10;
    }

    public /* synthetic */ Loader$LoadErrorAction(int n10, long l10, Loader$1 loader$1) {
        this(n10, l10);
    }

    public static /* synthetic */ int access$300(Loader$LoadErrorAction loader$LoadErrorAction) {
        return loader$LoadErrorAction.type;
    }

    public static /* synthetic */ long access$400(Loader$LoadErrorAction loader$LoadErrorAction) {
        return loader$LoadErrorAction.retryDelayMillis;
    }

    public boolean isRetry() {
        int n10 = this.type;
        int n11 = 1;
        if (n10 != 0 && n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

