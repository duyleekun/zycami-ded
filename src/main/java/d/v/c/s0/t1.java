/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class t1
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ t1(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Boolean)object;
        cameraFragment.M1((Boolean)object);
    }
}

