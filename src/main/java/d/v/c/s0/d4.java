/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$Guide;

public final class d4
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ d4(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (CameraSet$Guide)((Object)object);
        cameraFragment.D0((CameraSet$Guide)((Object)object));
    }
}

