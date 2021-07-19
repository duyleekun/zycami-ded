/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import java.util.List;

public class DisconnectInfo
implements IMessageEntity {
    public List apiNameList;
    public List scopeList;

    public DisconnectInfo() {
    }

    public DisconnectInfo(List list, List list2) {
        this.scopeList = list;
        this.apiNameList = list2;
    }

    public List getApiNameList() {
        return this.apiNameList;
    }

    public List getScopeList() {
        return this.scopeList;
    }
}

