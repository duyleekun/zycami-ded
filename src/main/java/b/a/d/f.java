/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.CameraInfo;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import java.util.List;

public final class f
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ PreviewStreamStateObserver a;
    public final /* synthetic */ CameraInfo b;
    public final /* synthetic */ List c;

    public /* synthetic */ f(PreviewStreamStateObserver previewStreamStateObserver, CameraInfo cameraInfo, List list) {
        this.a = previewStreamStateObserver;
        this.b = cameraInfo;
        this.c = list;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        PreviewStreamStateObserver previewStreamStateObserver = this.a;
        CameraInfo cameraInfo = this.b;
        List list = this.c;
        return previewStreamStateObserver.f(cameraInfo, list, callbackToFutureAdapter$Completer);
    }
}

