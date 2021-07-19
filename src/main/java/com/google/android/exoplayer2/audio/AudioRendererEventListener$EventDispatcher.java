/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.f0.a;
import d.h.a.a.f0.b;
import d.h.a.a.f0.c;
import d.h.a.a.f0.d;
import d.h.a.a.f0.e;
import d.h.a.a.f0.f;
import d.h.a.a.f0.g;
import d.h.a.a.f0.h;
import d.h.a.a.f0.i;

public final class AudioRendererEventListener$EventDispatcher {
    private final Handler handler;
    private final AudioRendererEventListener listener;

    public AudioRendererEventListener$EventDispatcher(Handler object, AudioRendererEventListener audioRendererEventListener) {
        object = audioRendererEventListener != null ? (Handler)Assertions.checkNotNull(object) : null;
        this.handler = object;
        this.listener = audioRendererEventListener;
    }

    private /* synthetic */ void a(Exception exception) {
        ((AudioRendererEventListener)Util.castNonNull(this.listener)).onAudioSinkError(exception);
    }

    private /* synthetic */ void c(String string2, long l10, long l11) {
        Object object = Util.castNonNull(this.listener);
        ((AudioRendererEventListener)object).onAudioDecoderInitialized(string2, l10, l11);
    }

    private /* synthetic */ void e(String string2) {
        ((AudioRendererEventListener)Util.castNonNull(this.listener)).onAudioDecoderReleased(string2);
    }

    private /* synthetic */ void g(DecoderCounters decoderCounters) {
        decoderCounters.ensureUpdated();
        ((AudioRendererEventListener)Util.castNonNull(this.listener)).onAudioDisabled(decoderCounters);
    }

    private /* synthetic */ void i(DecoderCounters decoderCounters) {
        ((AudioRendererEventListener)Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters);
    }

    private /* synthetic */ void k(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        ((AudioRendererEventListener)Util.castNonNull(this.listener)).onAudioInputFormatChanged(format, decoderReuseEvaluation);
    }

    private /* synthetic */ void m(long l10) {
        ((AudioRendererEventListener)Util.castNonNull(this.listener)).onAudioPositionAdvancing(l10);
    }

    private /* synthetic */ void o(boolean bl2) {
        ((AudioRendererEventListener)Util.castNonNull(this.listener)).onSkipSilenceEnabledChanged(bl2);
    }

    private /* synthetic */ void q(int n10, long l10, long l11) {
        Object object = Util.castNonNull(this.listener);
        ((AudioRendererEventListener)object).onAudioUnderrun(n10, l10, l11);
    }

    public void audioSinkError(Exception exception) {
        Handler handler = this.handler;
        if (handler != null) {
            c c10 = new c(this, exception);
            handler.post((Runnable)c10);
        }
    }

    public /* synthetic */ void b(Exception exception) {
        this.a(exception);
    }

    public /* synthetic */ void d(String string2, long l10, long l11) {
        this.c(string2, l10, l11);
    }

    public void decoderInitialized(String string2, long l10, long l11) {
        Handler handler = this.handler;
        if (handler != null) {
            e e10 = new e(this, string2, l10, l11);
            handler.post((Runnable)e10);
        }
    }

    public void decoderReleased(String string2) {
        Handler handler = this.handler;
        if (handler != null) {
            f f10 = new f(this, string2);
            handler.post((Runnable)f10);
        }
    }

    public void disabled(DecoderCounters decoderCounters) {
        decoderCounters.ensureUpdated();
        Handler handler = this.handler;
        if (handler != null) {
            b b10 = new b(this, decoderCounters);
            handler.post((Runnable)b10);
        }
    }

    public void enabled(DecoderCounters decoderCounters) {
        Handler handler = this.handler;
        if (handler != null) {
            i i10 = new i(this, decoderCounters);
            handler.post((Runnable)i10);
        }
    }

    public /* synthetic */ void f(String string2) {
        this.e(string2);
    }

    public /* synthetic */ void h(DecoderCounters decoderCounters) {
        this.g(decoderCounters);
    }

    public void inputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        Handler handler = this.handler;
        if (handler != null) {
            d d10 = new d(this, format, decoderReuseEvaluation);
            handler.post((Runnable)d10);
        }
    }

    public /* synthetic */ void j(DecoderCounters decoderCounters) {
        this.i(decoderCounters);
    }

    public /* synthetic */ void l(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.k(format, decoderReuseEvaluation);
    }

    public /* synthetic */ void n(long l10) {
        this.m(l10);
    }

    public /* synthetic */ void p(boolean bl2) {
        this.o(bl2);
    }

    public void positionAdvancing(long l10) {
        Handler handler = this.handler;
        if (handler != null) {
            g g10 = new g(this, l10);
            handler.post((Runnable)g10);
        }
    }

    public /* synthetic */ void r(int n10, long l10, long l11) {
        this.q(n10, l10, l11);
    }

    public void skipSilenceEnabledChanged(boolean bl2) {
        Handler handler = this.handler;
        if (handler != null) {
            a a10 = new a(this, bl2);
            handler.post((Runnable)a10);
        }
    }

    public void underrun(int n10, long l10, long l11) {
        Handler handler = this.handler;
        if (handler != null) {
            h h10 = new h(this, n10, l10, l11);
            handler.post((Runnable)h10);
        }
    }
}

