/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;

public final class v
implements Observer {
    public final /* synthetic */ SetStabilizerFragment a;

    public /* synthetic */ v(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public final void onChanged(Object object) {
        SetStabilizerFragment setStabilizerFragment = this.a;
        object = (Integer)object;
        setStabilizerFragment.F((Integer)object);
    }
}

