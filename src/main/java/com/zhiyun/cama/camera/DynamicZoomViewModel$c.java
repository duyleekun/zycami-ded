/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$f;

public class DynamicZoomViewModel$c
implements Runnable {
    public final /* synthetic */ DynamicZoomViewModel a;

    public DynamicZoomViewModel$c(DynamicZoomViewModel dynamicZoomViewModel) {
        this.a = dynamicZoomViewModel;
    }

    public void run() {
        DynamicZoomViewModel$f dynamicZoomViewModel$f = DynamicZoomViewModel.c(this.a);
        if (dynamicZoomViewModel$f != null) {
            dynamicZoomViewModel$f = DynamicZoomViewModel.c(this.a);
            String string2 = "beyond the safe rect for 5 seconds.";
            dynamicZoomViewModel$f.a(string2);
        }
        DynamicZoomViewModel.e(this.a, false);
    }
}

