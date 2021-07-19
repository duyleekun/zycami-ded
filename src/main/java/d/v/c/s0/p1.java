/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.CameraFragment;
import d.v.c.s0.z6.a;

public final class p1
implements Runnable {
    public final /* synthetic */ CameraFragment a;
    public final /* synthetic */ a b;

    public /* synthetic */ p1(CameraFragment cameraFragment, a a10) {
        this.a = cameraFragment;
        this.b = a10;
    }

    public final void run() {
        CameraFragment cameraFragment = this.a;
        a a10 = this.b;
        cameraFragment.O5(a10);
    }
}

