/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetVideoFragment;
import com.zhiyun.cama.data.database.model.CameraParam;

public final class d0
implements Observer {
    public final /* synthetic */ SetVideoFragment a;

    public /* synthetic */ d0(SetVideoFragment setVideoFragment) {
        this.a = setVideoFragment;
    }

    public final void onChanged(Object object) {
        SetVideoFragment setVideoFragment = this.a;
        object = (CameraParam)object;
        setVideoFragment.Q((CameraParam)object);
    }
}

