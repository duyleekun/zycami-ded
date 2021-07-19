/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.cloud_engine.CECompositeFinishFragment;
import d.v.c.t0.l0;

public final class f
implements Observer {
    public final /* synthetic */ CECompositeFinishFragment a;

    public /* synthetic */ f(CECompositeFinishFragment cECompositeFinishFragment) {
        this.a = cECompositeFinishFragment;
    }

    public final void onChanged(Object object) {
        CECompositeFinishFragment cECompositeFinishFragment = this.a;
        object = (l0)object;
        CECompositeFinishFragment.s(cECompositeFinishFragment, (l0)object);
    }
}

