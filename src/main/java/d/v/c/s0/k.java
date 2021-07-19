/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class k
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ k(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Boolean)object;
        cameraFragment.E1((Boolean)object);
    }
}

