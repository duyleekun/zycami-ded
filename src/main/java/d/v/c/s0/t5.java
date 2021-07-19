/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import d.v.n.j.b;

public final class t5
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ t5(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (b)object;
        cameraFragment.X0((b)object);
    }
}

