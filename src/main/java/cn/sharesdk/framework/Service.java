/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import com.mob.MobSDK;
import com.mob.tools.utils.DeviceHelper;

public abstract class Service {
    public String getDeviceKey() {
        return DeviceHelper.getInstance(MobSDK.getContext()).getDeviceKey();
    }

    public abstract int getServiceVersionInt();

    public abstract String getServiceVersionName();

    public void onBind() {
    }

    public void onUnbind() {
    }
}

