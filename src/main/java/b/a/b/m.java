/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class m
implements Runnable {
    public final /* synthetic */ CameraX a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;

    public /* synthetic */ m(CameraX cameraX, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = cameraX;
        this.b = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        CameraX cameraX = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        CameraX.p(cameraX, callbackToFutureAdapter$Completer);
    }
}

