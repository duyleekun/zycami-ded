/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.v.c.s0;

import android.net.Uri;
import com.zhiyun.cama.camera.CameraFragment;
import e.a.v0.g;

public final class s2
implements g {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ s2(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void accept(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (Uri)object;
        cameraFragment.u4((Uri)object);
    }
}

