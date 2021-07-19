/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.CameraFragment;

public final class l
implements Runnable {
    public final /* synthetic */ CameraFragment a;
    public final /* synthetic */ int b;

    public /* synthetic */ l(CameraFragment cameraFragment, int n10) {
        this.a = cameraFragment;
        this.b = n10;
    }

    public final void run() {
        CameraFragment cameraFragment = this.a;
        int n10 = this.b;
        cameraFragment.A0(n10);
    }
}

