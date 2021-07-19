/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.me.MeFragment;
import d.v.j.e.h.k;

public final class h
implements Observer {
    public final /* synthetic */ MeFragment a;

    public /* synthetic */ h(MeFragment meFragment) {
        this.a = meFragment;
    }

    public final void onChanged(Object object) {
        MeFragment meFragment = this.a;
        object = (k)object;
        meFragment.B((k)object);
    }
}

