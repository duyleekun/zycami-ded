/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import java.util.List;

public class AVIMOperationFailure {
    public int code = 0;
    public List memberIds = null;
    public String reason = "";

    public int getCode() {
        return this.code;
    }

    public int getMemberIdCount() {
        int n10;
        List list = this.memberIds;
        if (list == null) {
            n10 = 0;
            list = null;
        } else {
            n10 = list.size();
        }
        return n10;
    }

    public List getMemberIds() {
        return this.memberIds;
    }

    public String getReason() {
        return this.reason;
    }

    public void setCode(int n10) {
        this.code = n10;
    }

    public void setMemberIds(List list) {
        this.memberIds = list;
    }

    public void setReason(String string2) {
        this.reason = string2;
    }
}

