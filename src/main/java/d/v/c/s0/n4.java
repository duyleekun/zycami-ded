/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;

public final class n4
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ n4(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (DeviceViewModel$NetWorkEvent)((Object)object);
        cameraFragment.y3((DeviceViewModel$NetWorkEvent)((Object)object));
    }
}

