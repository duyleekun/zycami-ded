/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class z1
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ z1(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Pair)object;
        cameraFragment.z1((Pair)object);
    }
}

