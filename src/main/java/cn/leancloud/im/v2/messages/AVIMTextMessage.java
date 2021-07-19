/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.im.v2.AVIMTypedMessage;
import java.util.Map;

public class AVIMTextMessage
extends AVIMTypedMessage {
    public Map attrs;
    public String text;

    public Map getAttrs() {
        return this.attrs;
    }

    public String getText() {
        return this.text;
    }

    public void setAttrs(Map map) {
        this.attrs = map;
    }

    public void setText(String string2) {
        this.text = string2;
    }
}

