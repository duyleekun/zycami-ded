/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$f;

public class DynamicZoomViewModel$b
implements Runnable {
    public final /* synthetic */ DynamicZoomViewModel a;

    public DynamicZoomViewModel$b(DynamicZoomViewModel dynamicZoomViewModel) {
        this.a = dynamicZoomViewModel;
    }

    public void run() {
        DynamicZoomViewModel$f dynamicZoomViewModel$f = DynamicZoomViewModel.c(this.a);
        if (dynamicZoomViewModel$f != null) {
            dynamicZoomViewModel$f = DynamicZoomViewModel.c(this.a);
            DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = (DynamicZoomViewModel$TargetModel)((Object)DynamicZoomViewModel.d(this.a).getValue());
            dynamicZoomViewModel$f.b(dynamicZoomViewModel$TargetModel, false);
        }
        DynamicZoomViewModel.b(this.a, false);
    }
}

