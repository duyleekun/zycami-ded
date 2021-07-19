/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;

public final class o
implements Observer {
    public final /* synthetic */ SetStabilizerFragment a;

    public /* synthetic */ o(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public final void onChanged(Object object) {
        SetStabilizerFragment setStabilizerFragment = this.a;
        object = (Boolean)object;
        setStabilizerFragment.B((Boolean)object);
    }
}

