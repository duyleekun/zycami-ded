/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;
import com.zhiyun.net.BaseEntity;
import d.v.e.i.h;
import m.a.a;

public class DeviceBindViewModel$e
extends d.v.a.f.b.a {
    public final /* synthetic */ DeviceBindViewModel a;

    public DeviceBindViewModel$e(DeviceBindViewModel deviceBindViewModel) {
        this.a = deviceBindViewModel;
    }

    public void onError(Throwable object, int n10, String objectArray) {
        objectArray = new Object[]{};
        String string2 = "----unBind device failed---";
        m.a.a.z((Throwable)object, string2, objectArray);
        int n11 = 10022;
        if (n10 == n11) {
            object = DeviceBindViewModel.e(this.a);
            DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_NOT_BIND;
            h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
        } else {
            object = DeviceBindViewModel.e(this.a);
            DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_UNBIND_FAIL;
            h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
        }
    }

    public void onSuccess(BaseEntity object) {
        object = DeviceBindViewModel.e(this.a);
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_UNBIND_SUCCESS;
        h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
    }
}

