/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import java.util.List;

public final class g2
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ g2(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (List)object;
        cameraFragment.i3((List)object);
    }
}

