/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.view.Surface
 */
package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import d.h.a.a.s0.a;
import d.h.a.a.s0.b;
import d.h.a.a.s0.c;
import d.h.a.a.s0.d;
import d.h.a.a.s0.e;
import d.h.a.a.s0.f;
import d.h.a.a.s0.g;
import d.h.a.a.s0.h;
import d.h.a.a.s0.i;

public final class VideoRendererEventListener$EventDispatcher {
    private final Handler handler;
    private final VideoRendererEventListener listener;

    public VideoRendererEventListener$EventDispatcher(Handler object, VideoRendererEventListener videoRendererEventListener) {
        object = videoRendererEventListener != null ? (Handler)Assertions.checkNotNull(object) : null;
        this.handler = object;
        this.listener = videoRendererEventListener;
    }

    private /* synthetic */ void a(String string2, long l10, long l11) {
        Object object = Util.castNonNull(this.listener);
        ((VideoRendererEventListener)object).onVideoDecoderInitialized(string2, l10, l11);
    }

    private /* synthetic */ void c(String string2) {
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onVideoDecoderReleased(string2);
    }

    private /* synthetic */ void e(DecoderCounters decoderCounters) {
        decoderCounters.ensureUpdated();
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onVideoDisabled(decoderCounters);
    }

    private /* synthetic */ void g(int n10, long l10) {
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onDroppedFrames(n10, l10);
    }

    private /* synthetic */ void i(DecoderCounters decoderCounters) {
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onVideoEnabled(decoderCounters);
    }

    private /* synthetic */ void k(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onVideoInputFormatChanged(format, decoderReuseEvaluation);
    }

    private /* synthetic */ void m(Surface surface) {
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onRenderedFirstFrame(surface);
    }

    private /* synthetic */ void o(long l10, int n10) {
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onVideoFrameProcessingOffset(l10, n10);
    }

    private /* synthetic */ void q(int n10, int n11, int n12, float f10) {
        ((VideoRendererEventListener)Util.castNonNull(this.listener)).onVideoSizeChanged(n10, n11, n12, f10);
    }

    public /* synthetic */ void b(String string2, long l10, long l11) {
        this.a(string2, l10, l11);
    }

    public /* synthetic */ void d(String string2) {
        this.c(string2);
    }

    public void decoderInitialized(String string2, long l10, long l11) {
        Handler handler = this.handler;
        if (handler != null) {
            f f10 = new f(this, string2, l10, l11);
            handler.post((Runnable)f10);
        }
    }

    public void decoderReleased(String string2) {
        Handler handler = this.handler;
        if (handler != null) {
            b b10 = new b(this, string2);
            handler.post((Runnable)b10);
        }
    }

    public void disabled(DecoderCounters decoderCounters) {
        decoderCounters.ensureUpdated();
        Handler handler = this.handler;
        if (handler != null) {
            a a10 = new a(this, decoderCounters);
            handler.post((Runnable)a10);
        }
    }

    public void droppedFrames(int n10, long l10) {
        Handler handler = this.handler;
        if (handler != null) {
            e e10 = new e(this, n10, l10);
            handler.post((Runnable)e10);
        }
    }

    public void enabled(DecoderCounters decoderCounters) {
        Handler handler = this.handler;
        if (handler != null) {
            c c10 = new c(this, decoderCounters);
            handler.post((Runnable)c10);
        }
    }

    public /* synthetic */ void f(DecoderCounters decoderCounters) {
        this.e(decoderCounters);
    }

    public /* synthetic */ void h(int n10, long l10) {
        this.g(n10, l10);
    }

    public void inputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        Handler handler = this.handler;
        if (handler != null) {
            g g10 = new g(this, format, decoderReuseEvaluation);
            handler.post((Runnable)g10);
        }
    }

    public /* synthetic */ void j(DecoderCounters decoderCounters) {
        this.i(decoderCounters);
    }

    public /* synthetic */ void l(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.k(format, decoderReuseEvaluation);
    }

    public /* synthetic */ void n(Surface surface) {
        this.m(surface);
    }

    public /* synthetic */ void p(long l10, int n10) {
        this.o(l10, n10);
    }

    public /* synthetic */ void r(int n10, int n11, int n12, float f10) {
        this.q(n10, n11, n12, f10);
    }

    public void renderedFirstFrame(Surface surface) {
        Handler handler = this.handler;
        if (handler != null) {
            d d10 = new d(this, surface);
            handler.post((Runnable)d10);
        }
    }

    public void reportVideoFrameProcessingOffset(long l10, int n10) {
        Handler handler = this.handler;
        if (handler != null) {
            i i10 = new i(this, l10, n10);
            handler.post((Runnable)i10);
        }
    }

    public void videoSizeChanged(int n10, int n11, int n12, float f10) {
        Handler handler = this.handler;
        if (handler != null) {
            h h10 = new h(this, n10, n11, n12, f10);
            handler.post((Runnable)h10);
        }
    }
}

