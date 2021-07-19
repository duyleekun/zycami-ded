/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.MediaItem;

public interface Transformer$Listener {
    default public void onTransformationCompleted(MediaItem mediaItem) {
    }

    default public void onTransformationError(MediaItem mediaItem, Exception exception) {
    }
}

