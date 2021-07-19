/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.CameraFragment;

public final class g4
implements Runnable {
    public final /* synthetic */ CameraFragment a;
    public final /* synthetic */ Integer b;

    public /* synthetic */ g4(CameraFragment cameraFragment, Integer n10) {
        this.a = cameraFragment;
        this.b = n10;
    }

    public final void run() {
        CameraFragment cameraFragment = this.a;
        Integer n10 = this.b;
        cameraFragment.W4(n10);
    }
}

