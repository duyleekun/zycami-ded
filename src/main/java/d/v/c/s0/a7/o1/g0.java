/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetVideoFragment;

public final class g0
implements Observer {
    public final /* synthetic */ SetVideoFragment a;

    public /* synthetic */ g0(SetVideoFragment setVideoFragment) {
        this.a = setVideoFragment;
    }

    public final void onChanged(Object object) {
        SetVideoFragment setVideoFragment = this.a;
        object = (Boolean)object;
        setVideoFragment.o((Boolean)object);
    }
}

