/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.data.remote.entity;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.net.BaseEntity;
import java.util.List;

public class FirmwareEntity
extends BaseEntity {
    private List firmwares;

    public FirmwareInfo getFirmwareInfo() {
        boolean bl2;
        List list = this.firmwares;
        if (list != null && !(bl2 = list.isEmpty())) {
            return (FirmwareInfo)this.firmwares.get(0);
        }
        return null;
    }

    public List getFirmwares() {
        return this.firmwares;
    }

    public void setFirmwares(List list) {
        this.firmwares = list;
    }
}

