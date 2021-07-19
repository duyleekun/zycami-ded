/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

import com.zhiyun.live.data.api.entity.LiveKwaiUserInfo$UserInfo;

public class LiveKwaiUserInfo {
    public String error;
    public String error_msg;
    public int result;
    public LiveKwaiUserInfo$UserInfo userInfo;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LiveKwaiUserInfo{result=");
        int c10 = this.result;
        stringBuilder.append(c10);
        stringBuilder.append(", error='");
        Object object = this.error;
        stringBuilder.append((String)object);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", error_msg='");
        String string2 = this.error_msg;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", userInfo=");
        object = this.userInfo;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

