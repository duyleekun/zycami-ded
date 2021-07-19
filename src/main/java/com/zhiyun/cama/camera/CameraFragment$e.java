/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 */
package com.zhiyun.cama.camera;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$f;
import d.v.c.s0.p;
import d.v.c.s0.q;
import d.v.f.i.g;

public class CameraFragment$e
implements DynamicZoomViewModel$f {
    public final /* synthetic */ CameraFragment a;

    public CameraFragment$e(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    private /* synthetic */ void c(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel, boolean bl2) {
        Object object = CameraFragment.w(this.a).getRecordStatus();
        boolean bl3 = object.q();
        if (bl3) {
            object = DynamicZoomViewModel$TargetModel.FAR;
            if (dynamicZoomViewModel$TargetModel == object) {
                dynamicZoomViewModel$TargetModel = CameraFragment.M((CameraFragment)this.a).k.x;
                object = this.a.getResources();
                int n10 = 2131952605;
                object = g.o((Resources)object, n10);
                dynamicZoomViewModel$TargetModel.setText((CharSequence)object);
            } else {
                dynamicZoomViewModel$TargetModel = CameraFragment.M((CameraFragment)this.a).k.x;
                object = this.a.getResources();
                int n11 = 2131952606;
                object = g.o((Resources)object, n11);
                dynamicZoomViewModel$TargetModel.setText((CharSequence)object);
            }
        } else {
            dynamicZoomViewModel$TargetModel = CameraFragment.M((CameraFragment)this.a).k.x;
            object = this.a.getResources();
            int n12 = 2131952618;
            object = g.o((Resources)object, n12);
            dynamicZoomViewModel$TargetModel.setText((CharSequence)object);
        }
        CameraFragment.m(this.a).I(bl2);
    }

    private /* synthetic */ void e() {
        CameraFragment.N(this.a);
    }

    public void a(String object) {
        object = this.a.getActivity();
        if (object != null) {
            object = this.a.getActivity();
            q q10 = new q(this);
            object.runOnUiThread((Runnable)q10);
        }
    }

    public void b(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel, boolean bl2) {
        FragmentActivity fragmentActivity = this.a.getActivity();
        if (fragmentActivity != null) {
            fragmentActivity = this.a.getActivity();
            p p10 = new p(this, dynamicZoomViewModel$TargetModel, bl2);
            fragmentActivity.runOnUiThread(p10);
        }
    }

    public /* synthetic */ void d(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel, boolean bl2) {
        this.c(dynamicZoomViewModel$TargetModel, bl2);
    }

    public /* synthetic */ void f() {
        this.e();
    }
}

