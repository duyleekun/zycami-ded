/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.x1;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.List;

public final class a
implements Runnable {
    public final /* synthetic */ List a;

    public /* synthetic */ a(List list) {
        this.a = list;
    }

    public final void run() {
        CameraUseCaseAdapter.a(this.a);
    }
}

