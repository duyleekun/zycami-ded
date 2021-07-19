/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMTypedMessage;
import cn.leancloud.im.v2.MessageHandler;

public class AVIMTypedMessageHandler
extends MessageHandler {
    public void onMessage(AVIMTypedMessage aVIMTypedMessage, AVIMConversation aVIMConversation, AVIMClient aVIMClient) {
    }

    public void onMessageReceipt(AVIMTypedMessage aVIMTypedMessage, AVIMConversation aVIMConversation, AVIMClient aVIMClient) {
    }

    public void onMessageReceiptEx(AVIMTypedMessage aVIMTypedMessage, String string2, AVIMConversation aVIMConversation, AVIMClient aVIMClient) {
        this.onMessageReceipt(aVIMTypedMessage, aVIMConversation, aVIMClient);
    }
}

