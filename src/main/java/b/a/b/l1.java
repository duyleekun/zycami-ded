/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.VideoCapture;
import androidx.camera.core.VideoCapture$OnVideoSavedCallback;

public final class l1
implements Runnable {
    public final /* synthetic */ VideoCapture a;
    public final /* synthetic */ VideoCapture$OnVideoSavedCallback b;

    public /* synthetic */ l1(VideoCapture videoCapture, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.a = videoCapture;
        this.b = videoCapture$OnVideoSavedCallback;
    }

    public final void run() {
        VideoCapture videoCapture = this.a;
        VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback = this.b;
        videoCapture.j(videoCapture$OnVideoSavedCallback);
    }
}

