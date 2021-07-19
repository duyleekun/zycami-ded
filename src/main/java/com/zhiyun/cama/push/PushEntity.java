/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.push;

import com.zhiyun.cama.push.PushEntity$Alert;
import com.zhiyun.cama.push.PushEntity$MsgInfo;

public class PushEntity {
    private String action;
    private PushEntity$Alert alert;
    private String badge;
    private PushEntity$Alert description;
    private PushEntity$MsgInfo msgInfo;

    public String getAction() {
        return this.action;
    }

    public PushEntity$Alert getAlert() {
        return this.alert;
    }

    public String getBadge() {
        return this.badge;
    }

    public PushEntity$Alert getDescription() {
        return this.description;
    }

    public PushEntity$MsgInfo getMsgInfo() {
        return this.msgInfo;
    }

    public void setAction(String string2) {
        this.action = string2;
    }

    public void setAlert(PushEntity$Alert pushEntity$Alert) {
        this.alert = pushEntity$Alert;
    }

    public void setBadge(String string2) {
        this.badge = string2;
    }

    public void setDescription(PushEntity$Alert pushEntity$Alert) {
        this.description = pushEntity$Alert;
    }

    public void setMsgInfo(PushEntity$MsgInfo pushEntity$MsgInfo) {
        this.msgInfo = pushEntity$MsgInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PushEntity{alert=");
        Object object = this.alert;
        stringBuilder.append(object);
        stringBuilder.append(", action='");
        object = this.action;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", badge='");
        String string2 = this.badge;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", msgInfo=");
        object = this.msgInfo;
        stringBuilder.append(object);
        stringBuilder.append(", description=");
        object = this.description;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

