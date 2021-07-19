/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.ble.BleViewModel$PanoramaState;

public final class u2
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ u2(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (BleViewModel$PanoramaState)((Object)object);
        cameraFragment.g3((BleViewModel$PanoramaState)((Object)object));
    }
}

