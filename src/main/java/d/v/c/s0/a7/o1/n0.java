/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetWorkingModeFragment;
import com.zhiyun.protocol.constants.WorkingMode;

public final class n0
implements Observer {
    public final /* synthetic */ SetWorkingModeFragment a;

    public /* synthetic */ n0(SetWorkingModeFragment setWorkingModeFragment) {
        this.a = setWorkingModeFragment;
    }

    public final void onChanged(Object object) {
        SetWorkingModeFragment setWorkingModeFragment = this.a;
        object = (WorkingMode)((Object)object);
        setWorkingModeFragment.n((WorkingMode)((Object)object));
    }
}

