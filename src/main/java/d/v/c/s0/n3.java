/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class n3
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ n3(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Float)object;
        cameraFragment.e2((Float)object);
    }
}

