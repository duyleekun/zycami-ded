/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$DelayTime;

public final class l4
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ l4(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (CameraSet$DelayTime)((Object)object);
        cameraFragment.L3((CameraSet$DelayTime)((Object)object));
    }
}

