/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$HitchcockGuide;

public final class q4
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ q4(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (CameraSet$HitchcockGuide)((Object)object);
        cameraFragment.u3((CameraSet$HitchcockGuide)((Object)object));
    }
}

