/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.data.CameraSet$Theme;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment;

public final class c
implements Observer {
    public final /* synthetic */ SetGeneralFragment a;

    public /* synthetic */ c(SetGeneralFragment setGeneralFragment) {
        this.a = setGeneralFragment;
    }

    public final void onChanged(Object object) {
        SetGeneralFragment setGeneralFragment = this.a;
        object = (CameraSet$Theme)((Object)object);
        setGeneralFragment.A((CameraSet$Theme)((Object)object));
    }
}

