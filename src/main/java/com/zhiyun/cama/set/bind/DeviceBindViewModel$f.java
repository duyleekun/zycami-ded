/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.data.api.entity.BindDeviceInfoEntity;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import d.v.a.f.b.a;
import d.v.e.i.h;

public class DeviceBindViewModel$f
extends a {
    public final /* synthetic */ DeviceBindViewModel a;

    public DeviceBindViewModel$f(DeviceBindViewModel deviceBindViewModel) {
        this.a = deviceBindViewModel;
    }

    public void a(BindDeviceInfoEntity object) {
        Object object2;
        if (object != null && (object2 = ((BindDeviceInfoEntity)object).getBindDeviceInfo()) != null) {
            object2 = ((BindDeviceInfoEntity)object).getBindDeviceInfo();
            String string2 = DeviceBindViewModel.g(this.a);
            ((BindDeviceInfo)object2).setFirmwareVersion(string2);
            boolean bl2 = true;
            ((BindDeviceInfo)object2).setFetchSuccess(bl2);
            object2 = this.a.b;
            object = ((BindDeviceInfoEntity)object).getBindDeviceInfo();
            h.g((MutableLiveData)object2, object);
        }
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }
}

