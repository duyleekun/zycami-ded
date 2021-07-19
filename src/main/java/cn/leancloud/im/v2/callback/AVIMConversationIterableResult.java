/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.utils.StringUtil;
import java.util.List;

public class AVIMConversationIterableResult {
    private List members = null;
    private String next = null;

    public List getMembers() {
        return this.members;
    }

    public String getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return StringUtil.isEmpty(this.next) ^ true;
    }

    public void setMembers(List list) {
        this.members = list;
    }

    public void setNext(String string2) {
        this.next = string2;
    }
}

