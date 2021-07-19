/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.VideoCapture;

public final class p1
implements Runnable {
    public final /* synthetic */ VideoCapture a;

    public /* synthetic */ p1(VideoCapture videoCapture) {
        this.a = videoCapture;
    }

    public final void run() {
        this.a.h();
    }
}

