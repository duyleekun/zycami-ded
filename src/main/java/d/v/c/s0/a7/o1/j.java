/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;
import com.zhiyun.protocol.constants.WorkingMode;

public final class j
implements Observer {
    public final /* synthetic */ SetStabilizerFragment a;

    public /* synthetic */ j(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public final void onChanged(Object object) {
        SetStabilizerFragment setStabilizerFragment = this.a;
        object = (WorkingMode)((Object)object);
        setStabilizerFragment.t((WorkingMode)((Object)object));
    }
}

