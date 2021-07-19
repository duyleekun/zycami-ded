/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;

public final class z2
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ z2(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (DynamicZoomViewModel$TargetModel)((Object)object);
        cameraFragment.n1((DynamicZoomViewModel$TargetModel)((Object)object));
    }
}

