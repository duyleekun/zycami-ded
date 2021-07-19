/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.BindDeviceInfoList;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$Status;
import d.v.e.i.h;
import java.util.List;
import m.a.a;

public class DeviceBindViewModel$d
extends d.v.a.f.b.a {
    public final /* synthetic */ DeviceBindViewModel a;

    public DeviceBindViewModel$d(DeviceBindViewModel deviceBindViewModel) {
        this.a = deviceBindViewModel;
    }

    public void a(BindDeviceInfoList object) {
        Object object2 = ((BindDeviceInfoList)object).getList();
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = this.a.d;
            DeviceBindViewModel$Status deviceBindViewModel$Status = DeviceBindViewModel$Status.SUCCESS_OK;
            h.g((MutableLiveData)object2, (Object)deviceBindViewModel$Status);
            object2 = this.a;
            object = ((BindDeviceInfoList)object).getList();
            DeviceBindViewModel.f((DeviceBindViewModel)object2, (List)object);
        } else {
            object = this.a.d;
            object2 = DeviceBindViewModel$Status.SUCCESS_EMPTY;
            h.g((MutableLiveData)object, object2);
        }
    }

    public void onError(Throwable throwable, int n10, String object) {
        Object[] objectArray = this.a.d;
        object = DeviceBindViewModel$Status.FAILED;
        h.g((MutableLiveData)objectArray, object);
        objectArray = new Object[]{};
        m.a.a.z(throwable, "----get bind device list fail---", objectArray);
    }
}

