/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;

public class EnableNotifyReq
implements IMessageEntity {
    public boolean enable;
    public String packageName;

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean bl2) {
        this.enable = bl2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("EnableNotifyReq{");
        stringBuilder.append("packageName='");
        String string2 = this.packageName;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", enable=");
        boolean bl2 = this.enable;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

