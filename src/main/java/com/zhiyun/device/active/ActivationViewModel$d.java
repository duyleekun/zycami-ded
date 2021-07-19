/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.active;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.protocol.message.bl.active.ActiveState;
import d.v.e.i.h;
import d.v.e0.ie.l;

public class ActivationViewModel$d
implements l {
    public final /* synthetic */ ActivationViewModel a;

    public ActivationViewModel$d(ActivationViewModel activationViewModel) {
        this.a = activationViewModel;
    }

    public void onFailed(Throwable throwable) {
        Object object = ActivationViewModel.r(this.a);
        Object[] objectArray = Integer.valueOf(29400);
        h.g((MutableLiveData)object, objectArray);
        object = ActivationViewModel.d(this.a);
        objectArray = -1;
        h.g((MutableLiveData)object, objectArray);
        object = this.a;
        objectArray = new Object[]{};
        ActivationViewModel.f((ActivationViewModel)object, "\u53d1\u9001\u6fc0\u6d3b\u4fe1\u606f\u5230\u8bbe\u5907\uff0c\u4f46\u8fd4\u56de\u5931\u8d25", throwable, objectArray);
    }

    public void s(ActiveState object) {
        Object object2 = ActiveState.INACTIVATED;
        if (object != object2) {
            object = this.a;
            ActivationViewModel.g((ActivationViewModel)object);
        } else {
            object = ActivationViewModel.r(this.a);
            object2 = 29500;
            h.g((MutableLiveData)object, object2);
            object = ActivationViewModel.d(this.a);
            object2 = -1;
            h.g((MutableLiveData)object, object2);
            object = this.a;
            object2 = new Object[]{};
            String string2 = "\u53d1\u9001\u6fc0\u6d3b\u4fe1\u606f\u5230\u8bbe\u5907\uff0c\u4f46\u8fd4\u56de\u672a\u6fc0\u6d3b";
            ActivationViewModel.p((ActivationViewModel)object, string2, object2);
        }
    }
}

