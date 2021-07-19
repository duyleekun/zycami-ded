/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class m1
implements Runnable {
    public final /* synthetic */ ZoomControl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;
    public final /* synthetic */ ZoomState c;

    public /* synthetic */ m1(ZoomControl zoomControl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ZoomState zoomState) {
        this.a = zoomControl;
        this.b = callbackToFutureAdapter$Completer;
        this.c = zoomState;
    }

    public final void run() {
        ZoomControl zoomControl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        ZoomState zoomState = this.c;
        zoomControl.b(callbackToFutureAdapter$Completer, zoomState);
    }
}

