/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.CameraFragment$e;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;

public final class p
implements Runnable {
    public final /* synthetic */ CameraFragment$e a;
    public final /* synthetic */ DynamicZoomViewModel$TargetModel b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ p(CameraFragment$e e10, DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel, boolean bl2) {
        this.a = e10;
        this.b = dynamicZoomViewModel$TargetModel;
        this.c = bl2;
    }

    public final void run() {
        CameraFragment$e cameraFragment$e = this.a;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = this.b;
        boolean bl2 = this.c;
        cameraFragment$e.d(dynamicZoomViewModel$TargetModel, bl2);
    }
}

