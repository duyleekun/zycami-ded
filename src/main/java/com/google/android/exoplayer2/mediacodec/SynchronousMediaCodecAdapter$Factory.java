/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;

public final class SynchronousMediaCodecAdapter$Factory
implements MediaCodecAdapter$Factory {
    public MediaCodecAdapter createAdapter(MediaCodec mediaCodec) {
        SynchronousMediaCodecAdapter synchronousMediaCodecAdapter = new SynchronousMediaCodecAdapter(mediaCodec, null);
        return synchronousMediaCodecAdapter;
    }
}

