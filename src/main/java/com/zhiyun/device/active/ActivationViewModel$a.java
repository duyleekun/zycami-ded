/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.active;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.device.active.ActivationViewModel$ProcessStatus;
import d.v.e.i.h;
import d.v.p.a;
import d.v.p.a$c;

public class ActivationViewModel$a
implements a$c {
    public final /* synthetic */ ActivationViewModel a;

    public ActivationViewModel$a(ActivationViewModel activationViewModel) {
        this.a = activationViewModel;
    }

    public void a() {
        Object object = ActivationViewModel.l(this.a);
        Object object2 = ActivationViewModel.k(this.a);
        ((a)object).f((a$c)object2);
        object = ActivationViewModel.j(this.a);
        object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_FAIL;
        h.g((MutableLiveData)object, object2);
    }

    public void b(double d10, double d11) {
        MutableLiveData mutableLiveData = ActivationViewModel.b(this.a);
        Object object = d11;
        h.g(mutableLiveData, object);
        object = ActivationViewModel.c(this.a);
        Object object2 = d10;
        h.g((MutableLiveData)object, object2);
        object2 = ActivationViewModel.j(this.a);
        Object object3 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_SUCCESS;
        h.g((MutableLiveData)object2, object3);
        object2 = ActivationViewModel.l(this.a);
        object3 = ActivationViewModel.k(this.a);
        ((a)object2).f((a$c)object3);
    }
}

