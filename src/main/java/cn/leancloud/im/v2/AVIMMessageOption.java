/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMMessageOption$MessagePriority;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.StringUtil;
import java.util.Map;

public class AVIMMessageOption {
    private boolean isReceipt = false;
    private boolean isTransient = false;
    private boolean isWill = false;
    private AVIMMessageOption$MessagePriority priority = null;
    private String pushData;

    public static AVIMMessageOption parseJSONString(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        return (AVIMMessageOption)JSON.parseObject(string2, AVIMMessageOption.class);
    }

    public AVIMMessageOption$MessagePriority getPriority() {
        return this.priority;
    }

    public String getPushData() {
        return this.pushData;
    }

    public boolean isReceipt() {
        return this.isReceipt;
    }

    public boolean isTransient() {
        return this.isTransient;
    }

    public boolean isWill() {
        return this.isWill;
    }

    public void setPriority(AVIMMessageOption$MessagePriority aVIMMessageOption$MessagePriority) {
        this.priority = aVIMMessageOption$MessagePriority;
    }

    public void setPushData(String string2) {
        this.pushData = string2;
    }

    public void setPushDataEx(Map object) {
        if (object != null) {
            this.pushData = object = JSON.toJSONString(object);
        }
    }

    public void setReceipt(boolean bl2) {
        this.isReceipt = bl2;
    }

    public void setTransient(boolean bl2) {
        this.isTransient = bl2;
    }

    public void setWill(boolean bl2) {
        this.isWill = bl2;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

