/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.zhiyun.cama.set.bind;

import android.util.Base64;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;
import com.zhiyun.stabilizer.entities.ActiveInfo;
import d.v.e.i.h;
import d.v.e0.ie.l;
import d.v.e0.td;

public class DeviceBindViewModel$b
implements l {
    public final /* synthetic */ ActiveInfo a;
    public final /* synthetic */ DeviceBindViewModel b;

    public DeviceBindViewModel$b(DeviceBindViewModel deviceBindViewModel, ActiveInfo activeInfo) {
        this.b = deviceBindViewModel;
        this.a = activeInfo;
    }

    public void onFailed(Throwable object) {
        object = DeviceBindViewModel.e(this.b);
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_DEVICE_ERROR;
        h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
    }

    public void s(td object) {
        if (object != null) {
            DeviceBindViewModel deviceBindViewModel;
            Object object2 = this.a;
            if (object2 != null && (object2 = (Object)((ActiveInfo)object2).activeCode) != null) {
                deviceBindViewModel = null;
                object2 = Base64.encodeToString((byte[])object2, (int)0);
            } else {
                object2 = "";
            }
            deviceBindViewModel = this.b;
            object = ((td)object).e;
            DeviceBindViewModel.d(deviceBindViewModel, (String)object, (String)object2);
        } else {
            object = DeviceBindViewModel.e(this.b);
            DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_DEVICE_ERROR;
            h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
        }
    }
}

