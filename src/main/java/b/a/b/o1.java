/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 */
package b.a.b;

import android.media.MediaCodec;
import androidx.camera.core.VideoCapture;

public final class o1
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ MediaCodec b;

    public /* synthetic */ o1(boolean bl2, MediaCodec mediaCodec) {
        this.a = bl2;
        this.b = mediaCodec;
    }

    public final void run() {
        boolean bl2 = this.a;
        MediaCodec mediaCodec = this.b;
        VideoCapture.c(bl2, mediaCodec);
    }
}

