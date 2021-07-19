/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.active;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.device.active.ActivationViewModel$ProcessStatus;
import com.zhiyun.device.data.remote.entity.FreeLoginData;
import d.v.e.i.h;
import d.v.g.d.a;

public class ActivationViewModel$b
extends a {
    public final /* synthetic */ ActivationViewModel c;

    public ActivationViewModel$b(ActivationViewModel activationViewModel) {
        this.c = activationViewModel;
    }

    public void a(FreeLoginData object) {
        int n10;
        Object object2 = ActivationViewModel.m(this.c);
        int n11 = ((FreeLoginData)object).getActiveVisitor();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        object = n10 != 0;
        h.g(object2, object);
        object = ActivationViewModel.n(this.c);
        object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_SUCCESS;
        h.g((MutableLiveData)object, object2);
    }

    public void onError(Throwable object, int n10, String string2) {
        object = ActivationViewModel.n(this.c);
        ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus = ActivationViewModel$ProcessStatus.PROCESS_STATUS_FAIL;
        h.g((MutableLiveData)object, (Object)activationViewModel$ProcessStatus);
    }
}

