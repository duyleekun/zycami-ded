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

public class DeviceBindViewModel$g
extends a {
    public final /* synthetic */ DeviceBindViewModel a;

    public DeviceBindViewModel$g(DeviceBindViewModel deviceBindViewModel) {
        this.a = deviceBindViewModel;
    }

    public void a(BindDeviceInfoEntity object) {
        BindDeviceInfo bindDeviceInfo;
        if (object != null && (bindDeviceInfo = ((BindDeviceInfoEntity)object).getBindDeviceInfo()) != null) {
            boolean bl2;
            bindDeviceInfo = ((BindDeviceInfoEntity)object).getBindDeviceInfo();
            Object object2 = this.a;
            boolean bl3 = ((DeviceBindViewModel)object2).A();
            if (bl3 || (bl2 = ((String)(object = ((BindDeviceInfoEntity)object).getBindDeviceInfo().getSn())).equalsIgnoreCase((String)(object2 = DeviceBindViewModel.i(this.a))))) {
                object = DeviceBindViewModel.g(this.a);
                bindDeviceInfo.setFirmwareVersion((String)object);
                bl2 = true;
                bindDeviceInfo.setFetchSuccess(bl2);
                object = this.a.b;
                h.g((MutableLiveData)object, bindDeviceInfo);
            }
            object = this.a.a;
            h.g((MutableLiveData)object, bindDeviceInfo);
        }
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }
}

