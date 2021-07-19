/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package d.v.c.s0;

import android.graphics.RectF;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class d3
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ d3(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (RectF)object;
        cameraFragment.c3((RectF)object);
    }
}

