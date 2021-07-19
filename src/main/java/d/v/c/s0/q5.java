/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.data.database.model.CameraParam;

public final class q5
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ q5(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (CameraParam)object;
        cameraFragment.q2((CameraParam)object);
    }
}

