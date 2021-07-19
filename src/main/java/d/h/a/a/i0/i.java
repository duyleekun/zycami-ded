/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$OnFrameRenderedListener
 */
package d.h.a.a.i0;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$OnFrameRenderedListener;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;

public final class i
implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ SynchronousMediaCodecAdapter a;
    public final /* synthetic */ MediaCodecAdapter$OnFrameRenderedListener b;

    public /* synthetic */ i(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener) {
        this.a = synchronousMediaCodecAdapter;
        this.b = mediaCodecAdapter$OnFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long l10, long l11) {
        SynchronousMediaCodecAdapter synchronousMediaCodecAdapter = this.a;
        MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener = this.b;
        synchronousMediaCodecAdapter.b(mediaCodecAdapter$OnFrameRenderedListener, mediaCodec, l10, l11);
    }
}

