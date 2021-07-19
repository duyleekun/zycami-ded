/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class v1
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ v1(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Float)object;
        cameraFragment.l1((Float)object);
    }
}

