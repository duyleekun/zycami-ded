/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.active;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.net.BaseEntity;
import d.v.e.i.h;
import d.v.g.d.a;

public class ActivationViewModel$e
extends a {
    public final /* synthetic */ ActivationViewModel c;

    public ActivationViewModel$e(ActivationViewModel activationViewModel) {
        this.c = activationViewModel;
    }

    public void a(BaseEntity object) {
        object = ActivationViewModel.d(this.c);
        Integer n10 = 4;
        h.g((MutableLiveData)object, n10);
    }

    public void onError(Throwable object, int n10, String string2) {
        object = ActivationViewModel.d(this.c);
        Object[] objectArray = Integer.valueOf(4);
        h.g((MutableLiveData)object, objectArray);
        object = this.c;
        objectArray = new Object[]{};
        ActivationViewModel.p((ActivationViewModel)object, "\u8bbe\u5907\u5df2\u6fc0\u6d3b\uff0c\u4e0a\u4f20\u6fc0\u6d3b\u4fe1\u606f\u5931\u8d25\uff0c\u7b49\u5f85\u4e0b\u6b21\u8fde\u63a5\u4e0a\u4f20", objectArray);
    }
}

