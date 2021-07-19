/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.view.PreviewStreamStateObserver;
import com.google.common.util.concurrent.ListenableFuture;

public final class g
implements AsyncFunction {
    public final /* synthetic */ PreviewStreamStateObserver a;

    public /* synthetic */ g(PreviewStreamStateObserver previewStreamStateObserver) {
        this.a = previewStreamStateObserver;
    }

    public final ListenableFuture apply(Object object) {
        PreviewStreamStateObserver previewStreamStateObserver = this.a;
        object = (Void)object;
        return previewStreamStateObserver.b((Void)object);
    }
}

