/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;

public class OdidResp
extends AbstractMessageEntity {
    public String id;

    public String getId() {
        return this.id;
    }

    public void setId(String string2) {
        this.id = string2;
    }
}

