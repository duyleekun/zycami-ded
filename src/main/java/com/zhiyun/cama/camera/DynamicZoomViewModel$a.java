/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;

public class DynamicZoomViewModel$a
implements Runnable {
    public final /* synthetic */ DynamicZoomViewModel a;

    public DynamicZoomViewModel$a(DynamicZoomViewModel dynamicZoomViewModel) {
        this.a = dynamicZoomViewModel;
    }

    public void run() {
        Object object = this.a;
        boolean bl2 = true;
        DynamicZoomViewModel.b((DynamicZoomViewModel)object, bl2);
        object = DynamicZoomViewModel.c(this.a);
        if (object != null) {
            object = DynamicZoomViewModel.c(this.a);
            DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = (DynamicZoomViewModel$TargetModel)((Object)DynamicZoomViewModel.d(this.a).getValue());
            object.b(dynamicZoomViewModel$TargetModel, bl2);
        }
    }
}

