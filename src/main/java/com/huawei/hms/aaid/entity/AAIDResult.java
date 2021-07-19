/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;

public class AAIDResult
implements IMessageEntity {
    public String id;

    public String getId() {
        return this.id;
    }

    public void setId(String string2) {
        this.id = string2;
    }
}

