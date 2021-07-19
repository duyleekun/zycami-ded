/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package d.v.c.s0;

import android.graphics.RectF;
import androidx.core.util.Consumer;
import com.zhiyun.cama.camera.CameraFragment;

public final class q3
implements Consumer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ q3(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void accept(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (RectF)object;
        CameraFragment.B0(cameraFragment, (RectF)object);
    }
}

