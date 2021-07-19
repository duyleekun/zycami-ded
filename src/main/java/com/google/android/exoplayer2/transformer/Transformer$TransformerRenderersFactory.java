/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.transformer;

import android.os.Handler;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.transformer.MuxerWrapper;
import com.google.android.exoplayer2.transformer.Transformation;
import com.google.android.exoplayer2.transformer.TransformerAudioRenderer;
import com.google.android.exoplayer2.transformer.TransformerMediaClock;
import com.google.android.exoplayer2.transformer.TransformerVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final class Transformer$TransformerRenderersFactory
implements RenderersFactory {
    private final TransformerMediaClock mediaClock;
    private final MuxerWrapper muxerWrapper;
    private final Transformation transformation;

    public Transformer$TransformerRenderersFactory(MuxerWrapper object, Transformation transformation) {
        this.muxerWrapper = object;
        this.transformation = transformation;
        this.mediaClock = object = new TransformerMediaClock();
    }

    public Renderer[] createRenderers(Handler object, VideoRendererEventListener object2, AudioRendererEventListener audioRendererEventListener, TextOutput rendererArray, MetadataOutput object3) {
        Object object4;
        int n10;
        object = this.transformation;
        boolean bl2 = object.removeAudio;
        int n11 = 1;
        n10 = !bl2 && (n10 = object.removeVideo) == 0 ? 2 : n11;
        rendererArray = new Renderer[n10];
        object3 = null;
        if (!bl2) {
            object4 = this.muxerWrapper;
            TransformerMediaClock transformerMediaClock = this.mediaClock;
            rendererArray[0] = object2 = new TransformerAudioRenderer((MuxerWrapper)object4, transformerMediaClock, (Transformation)object);
        } else {
            n11 = 0;
        }
        object = this.transformation;
        bl2 = object.removeVideo;
        if (!bl2) {
            object3 = this.muxerWrapper;
            object4 = this.mediaClock;
            rendererArray[n11] = object2 = new TransformerVideoRenderer((MuxerWrapper)object3, (TransformerMediaClock)object4, (Transformation)object);
        }
        return rendererArray;
    }
}

