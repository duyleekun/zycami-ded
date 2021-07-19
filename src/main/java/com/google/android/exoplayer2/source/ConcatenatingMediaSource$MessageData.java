/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.ConcatenatingMediaSource$HandlerAndRunnable;

public final class ConcatenatingMediaSource$MessageData {
    public final Object customData;
    public final int index;
    public final ConcatenatingMediaSource$HandlerAndRunnable onCompletionAction;

    public ConcatenatingMediaSource$MessageData(int n10, Object object, ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable) {
        this.index = n10;
        this.customData = object;
        this.onCompletionAction = concatenatingMediaSource$HandlerAndRunnable;
    }
}

