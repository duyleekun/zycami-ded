/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 */
package com.zhiyun.cama.camera;

import android.widget.SeekBar;
import com.zhiyun.cama.camera.CameraFragment;
import d.v.c.b2.s;
import d.v.c.s0.x6;
import d.v.d.i.f.z;
import m.a.a;

public class CameraFragment$c
implements s {
    public final /* synthetic */ CameraFragment a;

    public CameraFragment$c(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public void onProgressChanged(SeekBar object, int n10, boolean bl2) {
        if (bl2) {
            object = CameraFragment.w(this.a).getPreviewWt();
            x6 x62 = CameraFragment.H((CameraFragment)this.a).a;
            Float f10 = x62.o(n10);
            ((z)object).x(f10);
        }
    }

    public void onStartTrackingTouch(SeekBar objectArray) {
        objectArray = new Object[]{};
        m.a.a.b("onStartTrackingTouch", objectArray);
        CameraFragment.P(this.a).d0();
    }

    public void onStopTrackingTouch(SeekBar objectArray) {
        objectArray = new Object[]{};
        m.a.a.b("onStopTrackingTouch", objectArray);
        CameraFragment.P(this.a).e0();
    }
}

