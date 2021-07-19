/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.core.util.Supplier;
import com.zhiyun.cama.camera.CameraFragment;

public final class m1
implements Supplier {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ m1(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final Object get() {
        return CameraFragment.s0(this.a);
    }
}

