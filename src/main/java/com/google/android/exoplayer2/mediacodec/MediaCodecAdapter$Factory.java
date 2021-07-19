/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter$Factory;

public interface MediaCodecAdapter$Factory {
    public static final MediaCodecAdapter$Factory DEFAULT;

    static {
        SynchronousMediaCodecAdapter$Factory synchronousMediaCodecAdapter$Factory = new SynchronousMediaCodecAdapter$Factory();
        DEFAULT = synchronousMediaCodecAdapter$Factory;
    }

    public MediaCodecAdapter createAdapter(MediaCodec var1);
}

