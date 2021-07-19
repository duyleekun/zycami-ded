/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$f;

public class DynamicZoomViewModel$d
implements Runnable {
    public final /* synthetic */ DynamicZoomViewModel a;

    public DynamicZoomViewModel$d(DynamicZoomViewModel dynamicZoomViewModel) {
        this.a = dynamicZoomViewModel;
    }

    public void run() {
        DynamicZoomViewModel$f dynamicZoomViewModel$f = DynamicZoomViewModel.c(this.a);
        if (dynamicZoomViewModel$f != null) {
            dynamicZoomViewModel$f = DynamicZoomViewModel.c(this.a);
            String string2 = "sdk lost rect for 1.5 seconds.";
            dynamicZoomViewModel$f.a(string2);
        }
        DynamicZoomViewModel.f(this.a, false);
    }
}

