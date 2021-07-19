/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.ExposureControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class l0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ExposureControl a;
    public final /* synthetic */ int b;

    public /* synthetic */ l0(ExposureControl exposureControl, int n10) {
        this.a = exposureControl;
        this.b = n10;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ExposureControl exposureControl = this.a;
        int n10 = this.b;
        return exposureControl.e(n10, callbackToFutureAdapter$Completer);
    }
}

