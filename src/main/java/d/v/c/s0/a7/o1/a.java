/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.GestureModeFragment;

public final class a
implements Observer {
    public final /* synthetic */ GestureModeFragment a;

    public /* synthetic */ a(GestureModeFragment gestureModeFragment) {
        this.a = gestureModeFragment;
    }

    public final void onChanged(Object object) {
        GestureModeFragment gestureModeFragment = this.a;
        object = (Integer)object;
        gestureModeFragment.p((Integer)object);
    }
}

