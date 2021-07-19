/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.s0;

import android.view.View;
import android.view.ViewGroup;
import com.zhiyun.cama.camera.CameraActivity;
import d.v.c.s0.i7.k$f;

public final class d
implements k$f {
    public final /* synthetic */ CameraActivity a;

    public /* synthetic */ d(CameraActivity cameraActivity) {
        this.a = cameraActivity;
    }

    public final void onInflateFinished(View view, int n10, ViewGroup viewGroup) {
        this.a.i(view, n10, viewGroup);
    }
}

