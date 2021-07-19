/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class x3
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ x3(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        boolean bl2 = (Boolean)object;
        CameraFragment.m4(cameraFragment, bl2);
    }
}

