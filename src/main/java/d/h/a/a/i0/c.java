/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$OnFrameRenderedListener
 */
package d.h.a.a.i0;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$OnFrameRenderedListener;

public final class c
implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ AsynchronousMediaCodecAdapter a;
    public final /* synthetic */ MediaCodecAdapter$OnFrameRenderedListener b;

    public /* synthetic */ c(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener) {
        this.a = asynchronousMediaCodecAdapter;
        this.b = mediaCodecAdapter$OnFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long l10, long l11) {
        AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = this.a;
        MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener = this.b;
        asynchronousMediaCodecAdapter.b(mediaCodecAdapter$OnFrameRenderedListener, mediaCodec, l10, l11);
    }
}

