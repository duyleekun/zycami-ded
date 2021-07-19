/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;

public class MediaCodecVideoDecoderException
extends MediaCodecDecoderException {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public MediaCodecVideoDecoderException(Throwable throwable, MediaCodecInfo mediaCodecInfo, Surface surface) {
        super(throwable, mediaCodecInfo);
        int n10;
        this.surfaceIdentityHashCode = n10 = System.identityHashCode(surface);
        if (surface != null && (n10 = (int)(surface.isValid() ? 1 : 0)) == 0) {
            n10 = 0;
            throwable = null;
        } else {
            n10 = 1;
        }
        this.isSurfaceValid = n10;
    }
}

