/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.CameraFragment;
import java.util.concurrent.Callable;

public final class b0
implements Callable {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ b0(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final Object call() {
        return CameraFragment.q0(this.a);
    }
}

