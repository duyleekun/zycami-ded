/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.active;

import com.zhiyun.cama.device.active.ActivationPrepareFragment;
import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.device.connection.BleConnection;
import d.v.g0.s;

public class ActivationPrepareFragment$c {
    public final /* synthetic */ ActivationPrepareFragment a;

    public ActivationPrepareFragment$c(ActivationPrepareFragment activationPrepareFragment) {
        this.a = activationPrepareFragment;
    }

    public void a() {
        Object object = BleConnection.W();
        boolean bl2 = ((BleConnection)object).c0();
        if (bl2) {
            s.o(this.a.requireActivity());
            object = ActivationPrepareFragment.j(this.a);
            ((ActivationViewModel)object).x();
        } else {
            object = this.a;
            ActivationPrepareFragment.k((ActivationPrepareFragment)object);
        }
    }
}

