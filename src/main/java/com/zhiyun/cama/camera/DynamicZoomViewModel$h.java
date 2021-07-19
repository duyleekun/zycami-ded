/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;

public class DynamicZoomViewModel$h {
    public DynamicZoomViewModel$TargetModel a;
    public boolean b;
    public boolean c;
    public float d;
    public float e;

    public DynamicZoomViewModel$h() {
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel;
        this.a = dynamicZoomViewModel$TargetModel = DynamicZoomViewModel$TargetModel.FAR;
        this.b = true;
        this.c = false;
        this.d = 0.0f;
        this.e = 0.0f;
    }

    public boolean a() {
        float f10 = this.d;
        float f11 = this.e;
        float f12 = (f10 = Math.abs(f10 - f11)) - (f11 = 0.18f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object >= 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public void b() {
        this.c = false;
    }
}

