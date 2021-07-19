/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 */
package d.v.c.s0;

import android.view.View;
import com.zhiyun.cama.camera.CameraActivity;

public final class b
implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ CameraActivity a;
    public final /* synthetic */ View b;

    public /* synthetic */ b(CameraActivity cameraActivity, View view) {
        this.a = cameraActivity;
        this.b = view;
    }

    public final void onSystemUiVisibilityChange(int n10) {
        CameraActivity cameraActivity = this.a;
        View view = this.b;
        cameraActivity.k(view, n10);
    }
}

