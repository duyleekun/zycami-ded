/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;

public final class s3
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ s3(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (CameraSet$StoryState)((Object)object);
        cameraFragment.k2((CameraSet$StoryState)((Object)object));
    }
}

