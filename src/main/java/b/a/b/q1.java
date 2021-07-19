/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package b.a.b;

import android.util.Size;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class q1
implements Runnable {
    public final /* synthetic */ VideoCapture a;
    public final /* synthetic */ VideoCapture$OnVideoSavedCallback b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Size d;
    public final /* synthetic */ CallbackToFutureAdapter$Completer e;

    public /* synthetic */ q1(VideoCapture videoCapture, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback, String string2, Size size, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = videoCapture;
        this.b = videoCapture$OnVideoSavedCallback;
        this.c = string2;
        this.d = size;
        this.e = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        VideoCapture videoCapture = this.a;
        VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback = this.b;
        String string2 = this.c;
        Size size = this.d;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.e;
        videoCapture.l(videoCapture$OnVideoSavedCallback, string2, size, callbackToFutureAdapter$Completer);
    }
}

