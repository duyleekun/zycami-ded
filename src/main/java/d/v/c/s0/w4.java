/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class w4
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ w4(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object integerArray) {
        CameraFragment cameraFragment = this.a;
        integerArray = integerArray;
        cameraFragment.h4(integerArray);
    }
}

