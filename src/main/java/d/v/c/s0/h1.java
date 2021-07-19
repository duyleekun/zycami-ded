/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import d.v.e.l.m2$c;

public final class h1
implements m2$c {
    public final /* synthetic */ CameraFragment a;
    public final /* synthetic */ CameraSet$Mode b;

    public /* synthetic */ h1(CameraFragment cameraFragment, CameraSet$Mode cameraSet$Mode) {
        this.a = cameraFragment;
        this.b = cameraSet$Mode;
    }

    public final void onComplete() {
        CameraFragment cameraFragment = this.a;
        CameraSet$Mode cameraSet$Mode = this.b;
        cameraFragment.y0(cameraSet$Mode);
    }
}

