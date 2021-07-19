/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import java.util.List;

public class ConnectInfo
implements IMessageEntity {
    private List apiNameList;
    private String fingerprint;
    private List scopeList;
    private String subAppID;

    public ConnectInfo() {
    }

    public ConnectInfo(List list, List list2, String string2, String string3) {
        this.apiNameList = list;
        this.scopeList = list2;
        this.fingerprint = string2;
        this.subAppID = string3;
    }

    public List getApiNameList() {
        return this.apiNameList;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public List getScopeList() {
        return this.scopeList;
    }

    public String getSubAppID() {
        return this.subAppID;
    }

    public void setApiNameList(List list) {
        this.apiNameList = list;
    }

    public void setFingerprint(String string2) {
        this.fingerprint = string2;
    }

    public void setScopeList(List list) {
        this.scopeList = list;
    }

    public void setSubAppID(String string2) {
        this.subAppID = string2;
    }
}

