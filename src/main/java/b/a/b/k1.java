/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.VideoCapture;
import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.camera.core.VideoCapture$OutputFileOptions;
import java.util.concurrent.Executor;

public final class k1
implements Runnable {
    public final /* synthetic */ VideoCapture a;
    public final /* synthetic */ VideoCapture$OutputFileOptions b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ VideoCapture$OnVideoSavedCallback d;

    public /* synthetic */ k1(VideoCapture videoCapture, VideoCapture$OutputFileOptions videoCapture$OutputFileOptions, Executor executor, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.a = videoCapture;
        this.b = videoCapture$OutputFileOptions;
        this.c = executor;
        this.d = videoCapture$OnVideoSavedCallback;
    }

    public final void run() {
        VideoCapture videoCapture = this.a;
        VideoCapture$OutputFileOptions videoCapture$OutputFileOptions = this.b;
        Executor executor = this.c;
        VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback = this.d;
        videoCapture.e(videoCapture$OutputFileOptions, executor, videoCapture$OnVideoSavedCallback);
    }
}

