/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s0;

import android.view.View;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class e4
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ e4(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (View)object;
        cameraFragment.c5((View)object);
    }
}

