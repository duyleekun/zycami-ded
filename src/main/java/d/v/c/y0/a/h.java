/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.active.ActivationPrepareFragment;
import com.zhiyun.device.active.ActivationViewModel$ProcessStatus;

public final class h
implements Observer {
    public final /* synthetic */ ActivationPrepareFragment a;

    public /* synthetic */ h(ActivationPrepareFragment activationPrepareFragment) {
        this.a = activationPrepareFragment;
    }

    public final void onChanged(Object object) {
        ActivationPrepareFragment activationPrepareFragment = this.a;
        object = (ActivationViewModel$ProcessStatus)((Object)object);
        activationPrepareFragment.w((ActivationViewModel$ProcessStatus)((Object)object));
    }
}

