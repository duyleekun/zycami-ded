/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.support.api.entity.push;

import android.content.Context;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.s;
import com.huawei.hms.utils.Util;

public class SubscribeReq
implements IMessageEntity {
    public String appId;
    public boolean isFastApp = false;
    public String operation;
    public String packageName;
    public String projectId;
    public String subjectId;
    public String token;
    public String topic;

    public SubscribeReq() {
    }

    public SubscribeReq(Context object, String string2, String string3) {
        String string4;
        this.packageName = string4 = object.getPackageName();
        this.operation = string2;
        this.topic = string3;
        this.appId = string2 = Util.getAppId(object);
        object = s.c(object);
        this.projectId = object;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public String getToken() {
        return this.token;
    }

    public String getTopic() {
        return this.topic;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public void setAppId(String string2) {
        this.appId = string2;
    }

    public void setFastApp(boolean bl2) {
        this.isFastApp = bl2;
    }

    public void setOperation(String string2) {
        this.operation = string2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public void setProjectId(String string2) {
        this.projectId = string2;
    }

    public void setSubjectId(String string2) {
        this.subjectId = string2;
    }

    public void setToken(String string2) {
        this.token = string2;
    }

    public void setTopic(String string2) {
        this.topic = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubscribeReq{");
        stringBuilder.append("packageName='");
        String string2 = this.packageName;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", operation='");
        String string3 = this.operation;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

