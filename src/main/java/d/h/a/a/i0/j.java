/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 */
package d.h.a.a.i0;

import android.media.MediaCodec;

public final class j
implements Runnable {
    public final /* synthetic */ MediaCodec a;

    public /* synthetic */ j(MediaCodec mediaCodec) {
        this.a = mediaCodec;
    }

    public final void run() {
        this.a.start();
    }
}

