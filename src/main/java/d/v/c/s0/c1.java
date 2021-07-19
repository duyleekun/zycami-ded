/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package d.v.c.s0;

import android.view.MotionEvent;
import com.zhiyun.cama.camera.CameraFragment;
import d.v.b.c0.e$a;

public final class c1
implements e$a {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ c1(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void a(Object object, int n10) {
        CameraFragment cameraFragment = this.a;
        object = (MotionEvent)object;
        cameraFragment.H0((MotionEvent)object, n10);
    }
}

