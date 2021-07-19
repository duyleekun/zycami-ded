/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.c;

import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.device.data.local.entity.ActivationData;

public final class c
implements Runnable {
    public final /* synthetic */ ActivationViewModel a;
    public final /* synthetic */ ActivationData b;

    public /* synthetic */ c(ActivationViewModel activationViewModel, ActivationData activationData) {
        this.a = activationViewModel;
        this.b = activationData;
    }

    public final void run() {
        ActivationViewModel activationViewModel = this.a;
        ActivationData activationData = this.b;
        activationViewModel.X(activationData);
    }
}

