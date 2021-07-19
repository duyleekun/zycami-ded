/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.VideoCapture$OutputFileResults;
import androidx.camera.core.VideoCapture$VideoSavedListenerWrapper;

public final class n1
implements Runnable {
    public final /* synthetic */ VideoCapture$VideoSavedListenerWrapper a;
    public final /* synthetic */ VideoCapture$OutputFileResults b;

    public /* synthetic */ n1(VideoCapture$VideoSavedListenerWrapper videoCapture$VideoSavedListenerWrapper, VideoCapture$OutputFileResults videoCapture$OutputFileResults) {
        this.a = videoCapture$VideoSavedListenerWrapper;
        this.b = videoCapture$OutputFileResults;
    }

    public final void run() {
        VideoCapture$VideoSavedListenerWrapper videoCapture$VideoSavedListenerWrapper = this.a;
        VideoCapture$OutputFileResults videoCapture$OutputFileResults = this.b;
        videoCapture$VideoSavedListenerWrapper.d(videoCapture$OutputFileResults);
    }
}

