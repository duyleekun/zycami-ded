/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.data.CameraSet$CountDownTime;
import d.v.c.s0.a7.w0$b;

public final class o0
implements w0$b {
    public final /* synthetic */ CameraFragment$j a;
    public final /* synthetic */ CameraSet$CountDownTime[] b;

    public /* synthetic */ o0(CameraFragment$j cameraFragment$j, CameraSet$CountDownTime[] cameraSet$CountDownTimeArray) {
        this.a = cameraFragment$j;
        this.b = cameraSet$CountDownTimeArray;
    }

    public final void a(int n10) {
        CameraFragment$j cameraFragment$j = this.a;
        CameraSet$CountDownTime[] cameraSet$CountDownTimeArray = this.b;
        cameraFragment$j.y(cameraSet$CountDownTimeArray, n10);
    }
}

