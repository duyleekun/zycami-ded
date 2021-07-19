/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.MessageHandler;

public class AVIMMessageHandler
extends MessageHandler {
    public void onMessage(AVIMMessage aVIMMessage, AVIMConversation aVIMConversation, AVIMClient aVIMClient) {
    }

    public void onMessageReceipt(AVIMMessage aVIMMessage, AVIMConversation aVIMConversation, AVIMClient aVIMClient) {
    }

    public void onMessageReceiptEx(AVIMMessage aVIMMessage, String string2, AVIMConversation aVIMConversation, AVIMClient aVIMClient) {
        this.onMessageReceipt(aVIMMessage, aVIMConversation, aVIMClient);
    }
}

