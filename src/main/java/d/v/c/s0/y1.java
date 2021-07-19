/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;

public final class y1
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ y1(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (CameraSet$DelayInterval)((Object)object);
        cameraFragment.J3((CameraSet$DelayInterval)((Object)object));
    }
}

