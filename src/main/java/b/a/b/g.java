/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import java.util.concurrent.Executor;

public final class g
implements Runnable {
    public final /* synthetic */ CameraX a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ long c;
    public final /* synthetic */ CallbackToFutureAdapter$Completer d;

    public /* synthetic */ g(CameraX cameraX, Executor executor, long l10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = cameraX;
        this.b = executor;
        this.c = l10;
        this.d = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        CameraX cameraX = this.a;
        Executor executor = this.b;
        long l10 = this.c;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.d;
        cameraX.d(executor, l10, callbackToFutureAdapter$Completer);
    }
}

