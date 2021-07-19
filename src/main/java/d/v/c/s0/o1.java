/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class o1
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ o1(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (String)object;
        cameraFragment.Z3((String)object);
    }
}

