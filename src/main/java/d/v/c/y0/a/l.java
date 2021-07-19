/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.active.ActivationSuccessFragment;

public final class l
implements Observer {
    public final /* synthetic */ ActivationSuccessFragment a;

    public /* synthetic */ l(ActivationSuccessFragment activationSuccessFragment) {
        this.a = activationSuccessFragment;
    }

    public final void onChanged(Object object) {
        ActivationSuccessFragment activationSuccessFragment = this.a;
        object = (Boolean)object;
        activationSuccessFragment.n((Boolean)object);
    }
}

