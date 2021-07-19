/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.arch.core.util.Function;
import androidx.camera.view.PreviewStreamStateObserver;

public final class e
implements Function {
    public final /* synthetic */ PreviewStreamStateObserver a;

    public /* synthetic */ e(PreviewStreamStateObserver previewStreamStateObserver) {
        this.a = previewStreamStateObserver;
    }

    public final Object apply(Object object) {
        PreviewStreamStateObserver previewStreamStateObserver = this.a;
        object = (Void)object;
        return previewStreamStateObserver.d((Void)object);
    }
}

