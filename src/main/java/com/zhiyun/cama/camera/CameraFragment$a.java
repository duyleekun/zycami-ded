/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package com.zhiyun.cama.camera;

import android.graphics.RectF;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.widget.TrackView;
import com.zhiyun.cama.camera.widget.TrackView$b;
import d.v.c.s0.w6;
import d.v.d.i.c.c;
import d.v.d.i.f.h;

public class CameraFragment$a
extends TrackView$b {
    public final /* synthetic */ CameraFragment a;

    public CameraFragment$a(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public void a(RectF rectF, RectF rectF2) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode = CameraFragment.H(this.a).I();
        Object object = CameraSet$Mode.dolly_zoom;
        boolean bl3 = true;
        if (cameraSet$Mode != object) {
            bl2 = bl3;
        } else {
            bl2 = false;
            cameraSet$Mode = null;
        }
        object = CameraFragment.j(this.a);
        int n10 = CameraFragment.L(this.a);
        rectF = ((w6)object).Z(n10, rectF, rectF2, bl2);
        this.a.z6(rectF);
        CameraFragment.M((CameraFragment)this.a).L.i(bl3);
    }

    public void b() {
        super.b();
        Object object = this.a;
        boolean bl2 = true;
        CameraFragment.k((CameraFragment)object, bl2, bl2);
        object = CameraFragment.M((CameraFragment)this.a).L;
        bl2 = false;
        ((TrackView)((Object)object)).i(false);
        object = CameraFragment.H(this.a).I();
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.dolly_zoom;
        if (object == cameraSet$Mode) {
            object = CameraFragment.j(this.a);
            boolean bl3 = ((w6)object).m();
            if (bl3) {
                object = CameraFragment.j(this.a);
                ((w6)object).V();
            }
            object = this.a;
            CameraFragment.N((CameraFragment)object);
        }
    }

    public void c() {
        super.c();
        Object object = CameraFragment.j(this.a);
        boolean bl2 = ((w6)object).n();
        boolean bl3 = true;
        if (bl2) {
            object = this.a;
            CameraFragment.k((CameraFragment)object, bl3, false);
        }
        if (bl2 = ((c)(object = CameraFragment.w(this.a).getDeviceStatus())).r()) {
            object = CameraFragment.w(this.a).getPreviewFace();
            ((h)object).m(bl3);
        }
    }
}

