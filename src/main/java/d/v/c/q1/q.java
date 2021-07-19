/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.SetFragment;

public final class q
implements Observer {
    public final /* synthetic */ SetFragment a;

    public /* synthetic */ q(SetFragment setFragment) {
        this.a = setFragment;
    }

    public final void onChanged(Object object) {
        SetFragment setFragment = this.a;
        object = (String)object;
        setFragment.p((String)object);
    }
}

