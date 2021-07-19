/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;

public class AbstractMessageEntity
implements IMessageEntity {
    private Status commonStatus;

    public Status getCommonStatus() {
        return this.commonStatus;
    }

    public void setCommonStatus(Status status) {
        this.commonStatus = status;
    }
}

