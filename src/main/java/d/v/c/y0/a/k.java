/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.active.ActivationStateFragment;

public final class k
implements Observer {
    public final /* synthetic */ ActivationStateFragment a;

    public /* synthetic */ k(ActivationStateFragment activationStateFragment) {
        this.a = activationStateFragment;
    }

    public final void onChanged(Object object) {
        ActivationStateFragment activationStateFragment = this.a;
        object = (Integer)object;
        activationStateFragment.n((Integer)object);
    }
}

