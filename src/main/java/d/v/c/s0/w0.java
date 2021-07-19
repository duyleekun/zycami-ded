/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.core.util.Supplier;
import com.zhiyun.cama.camera.CameraFragment;

public final class w0
implements Supplier {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ w0(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final Object get() {
        return Float.valueOf(CameraFragment.r0(this.a));
    }
}

