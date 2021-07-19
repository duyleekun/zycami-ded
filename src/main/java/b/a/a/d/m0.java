/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.ExposureControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class m0
implements Runnable {
    public final /* synthetic */ ExposureControl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;
    public final /* synthetic */ int c;

    public /* synthetic */ m0(ExposureControl exposureControl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, int n10) {
        this.a = exposureControl;
        this.b = callbackToFutureAdapter$Completer;
        this.c = n10;
    }

    public final void run() {
        ExposureControl exposureControl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        int n10 = this.c;
        exposureControl.c(callbackToFutureAdapter$Completer, n10);
    }
}

