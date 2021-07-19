/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.c;

import androidx.lifecycle.Observer;
import com.zhiyun.device.active.ActivationViewModel;

public final class b
implements Observer {
    public final /* synthetic */ ActivationViewModel a;

    public /* synthetic */ b(ActivationViewModel activationViewModel) {
        this.a = activationViewModel;
    }

    public final void onChanged(Object object) {
        ActivationViewModel activationViewModel = this.a;
        object = (Integer)object;
        activationViewModel.T((Integer)object);
    }
}

