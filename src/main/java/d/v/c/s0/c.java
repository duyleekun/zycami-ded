/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s0;

import android.view.View;
import com.zhiyun.cama.camera.CameraActivity;

public final class c
implements Runnable {
    public final /* synthetic */ CameraActivity a;
    public final /* synthetic */ View b;

    public /* synthetic */ c(CameraActivity cameraActivity, View view) {
        this.a = cameraActivity;
        this.b = view;
    }

    public final void run() {
        CameraActivity cameraActivity = this.a;
        View view = this.b;
        cameraActivity.f(view);
    }
}

