/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.net.BaseEntity;

public class BindDeviceInfoEntity
extends BaseEntity {
    private BindDeviceInfo data;

    public BindDeviceInfo getBindDeviceInfo() {
        return this.data;
    }

    public void setBindDeviceInfo(BindDeviceInfo bindDeviceInfo) {
        this.data = bindDeviceInfo;
    }
}

