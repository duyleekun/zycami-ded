/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class s5
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ s5(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Pair)object;
        cameraFragment.P3((Pair)object);
    }
}

