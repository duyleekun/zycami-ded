/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.active.ActivationPrepareFragment;
import com.zhiyun.device.active.ActivationViewModel$ProcessStatus;

public final class d
implements Observer {
    public final /* synthetic */ ActivationPrepareFragment a;

    public /* synthetic */ d(ActivationPrepareFragment activationPrepareFragment) {
        this.a = activationPrepareFragment;
    }

    public final void onChanged(Object object) {
        ActivationPrepareFragment activationPrepareFragment = this.a;
        object = (ActivationViewModel$ProcessStatus)((Object)object);
        activationPrepareFragment.y((ActivationViewModel$ProcessStatus)((Object)object));
    }
}

