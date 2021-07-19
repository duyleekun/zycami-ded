/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.VideoCapture$VideoSavedListenerWrapper;

public final class m1
implements Runnable {
    public final /* synthetic */ VideoCapture$VideoSavedListenerWrapper a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Throwable d;

    public /* synthetic */ m1(VideoCapture$VideoSavedListenerWrapper videoSavedListenerWrapper, int n10, String string2, Throwable throwable) {
        this.a = videoSavedListenerWrapper;
        this.b = n10;
        this.c = string2;
        this.d = throwable;
    }

    public final void run() {
        VideoCapture$VideoSavedListenerWrapper videoCapture$VideoSavedListenerWrapper = this.a;
        int n10 = this.b;
        String string2 = this.c;
        Throwable throwable = this.d;
        videoCapture$VideoSavedListenerWrapper.b(n10, string2, throwable);
    }
}

