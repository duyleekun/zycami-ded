/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.i0;

import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecCallback;

public final class d
implements Runnable {
    public final /* synthetic */ AsynchronousMediaCodecCallback a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ d(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback, Runnable runnable) {
        this.a = asynchronousMediaCodecCallback;
        this.b = runnable;
    }

    public final void run() {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.a;
        Runnable runnable = this.b;
        asynchronousMediaCodecCallback.b(runnable);
    }
}

