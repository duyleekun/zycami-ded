/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;
import com.zhiyun.cama.camera.widget.StringScrollView$c;
import d.v.c.s0.a7.y0;

public final class i
implements StringScrollView$c {
    public final /* synthetic */ y0 a;
    public final /* synthetic */ CameraSet$DelayInterval[] b;

    public /* synthetic */ i(y0 y02, CameraSet$DelayInterval[] cameraSet$DelayIntervalArray) {
        this.a = y02;
        this.b = cameraSet$DelayIntervalArray;
    }

    public final void a(int n10) {
        y0 y02 = this.a;
        CameraSet$DelayInterval[] cameraSet$DelayIntervalArray = this.b;
        y02.K(cameraSet$DelayIntervalArray, n10);
    }
}

