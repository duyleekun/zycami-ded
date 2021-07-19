/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$Mode;

public final class u3
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ u3(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (CameraSet$Mode)((Object)object);
        cameraFragment.K1((CameraSet$Mode)((Object)object));
    }
}

