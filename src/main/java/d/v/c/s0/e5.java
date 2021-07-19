/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.ble.BleViewModel$MoveState;

public final class e5
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ e5(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (BleViewModel$MoveState)((Object)object);
        cameraFragment.k3((BleViewModel$MoveState)((Object)object));
    }
}

