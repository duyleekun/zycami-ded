/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import com.zhiyun.cama.camera.CameraFragment;
import d.v.c.s0.h7.k0$d;
import d.v.c.s0.u6;
import d.v.d.i.f.a0;

public class CameraFragment$h
implements k0$d {
    public final /* synthetic */ CameraFragment a;

    public CameraFragment$h(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public void c() {
        CameraFragment.M((CameraFragment)this.a).b.setClickable(true);
        CameraFragment.M((CameraFragment)this.a).r.setVisibility(0);
        CameraFragment.M((CameraFragment)this.a).b.setVisibility(0);
    }

    public void d(float f10) {
        a0 a02 = CameraFragment.w(this.a).getPreviewZoom();
        Float f11 = Float.valueOf(f10);
        a02.v(f11);
    }

    public void e(int n10) {
        CameraFragment.u(this.a, n10);
    }

    public void f(String string2) {
        CameraFragment.w(this.a).getRecordPath().q(string2);
        string2 = CameraFragment.M((CameraFragment)this.a).r;
        int n10 = 4;
        string2.setVisibility(n10);
        CameraFragment.M((CameraFragment)this.a).b.setVisibility(n10);
        CameraFragment.H(this.a).W1(true);
    }

    public void g(boolean bl2) {
        CameraFragment.H(this.a).h2(bl2);
        if (bl2) {
            CameraFragment.v(this.a);
            CameraFragment.M((CameraFragment)this.a).b.setVisibility(0);
            u6 u62 = CameraFragment.H(this.a);
            u62.W1(false);
        } else {
            CameraFragment.M((CameraFragment)this.a).b.setClickable(false);
            CameraFragment cameraFragment = this.a;
            CameraFragment.x(cameraFragment);
        }
    }

    public void onCanceled() {
        CameraFragment.x(this.a);
    }
}

