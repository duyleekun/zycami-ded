/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;

public class UpSendMsgReq
implements IMessageEntity {
    public String collapseKey;
    public String data;
    public String msgId;
    public String msgType;
    public String packageName;
    public int receiptMode;
    public int sendMode;
    public String to;
    public String token;
    public int ttl;

    public String getCollapseKey() {
        return this.collapseKey;
    }

    public String getData() {
        return this.data;
    }

    public String getMessageId() {
        return this.msgId;
    }

    public String getMessageType() {
        return this.msgType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getReceiptMode() {
        return this.receiptMode;
    }

    public int getSendMode() {
        return this.sendMode;
    }

    public String getTo() {
        return this.to;
    }

    public String getToken() {
        return this.token;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setCollapseKey(String string2) {
        this.collapseKey = string2;
    }

    public void setData(String string2) {
        this.data = string2;
    }

    public void setMessageId(String string2) {
        this.msgId = string2;
    }

    public void setMessageType(String string2) {
        this.msgType = string2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public void setReceiptMode(int n10) {
        this.receiptMode = n10;
    }

    public void setSendMode(int n10) {
        this.sendMode = n10;
    }

    public void setTo(String string2) {
        this.to = string2;
    }

    public void setToken(String string2) {
        this.token = string2;
    }

    public void setTtl(int n10) {
        this.ttl = n10;
    }
}

