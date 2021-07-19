/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class o3
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ o3(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Boolean)object;
        cameraFragment.b4((Boolean)object);
    }
}

