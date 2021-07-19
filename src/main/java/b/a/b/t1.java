/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.VideoCapture;

public final class t1
implements Runnable {
    public final /* synthetic */ VideoCapture a;

    public /* synthetic */ t1(VideoCapture videoCapture) {
        this.a = videoCapture;
    }

    public final void run() {
        this.a.b();
    }
}

