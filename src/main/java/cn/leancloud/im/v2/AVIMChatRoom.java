/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;

public class AVIMChatRoom
extends AVIMConversation {
    public AVIMChatRoom(AVIMClient aVIMClient, String string2) {
        super(aVIMClient, string2);
        this.setTransientForInit(true);
    }
}

