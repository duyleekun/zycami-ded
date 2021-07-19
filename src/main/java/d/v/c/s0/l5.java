/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class l5
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ l5(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (String)object;
        CameraFragment.P5(cameraFragment, (String)object);
    }
}

