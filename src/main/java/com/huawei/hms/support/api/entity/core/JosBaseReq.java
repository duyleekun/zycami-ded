/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;

public class JosBaseReq
implements IMessageEntity {
    private String channelId;
    private String cpId;
    private String hmsSdkVersionName;

    private static Object get(Object object) {
        return object;
    }

    public String getChannelId() {
        return (String)JosBaseReq.get(this.channelId);
    }

    public String getCpID() {
        return (String)JosBaseReq.get(this.cpId);
    }

    public String getHmsSdkVersionName() {
        return (String)JosBaseReq.get(this.hmsSdkVersionName);
    }

    public void setChannelId(String string2) {
        this.channelId = string2;
    }

    public void setCpID(String string2) {
        this.cpId = string2;
    }

    public void setHmsSdkVersionName(String string2) {
        this.hmsSdkVersionName = string2;
    }
}

