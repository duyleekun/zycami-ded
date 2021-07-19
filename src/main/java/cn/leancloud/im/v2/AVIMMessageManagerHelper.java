/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMClientEventHandler;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageManager;
import cn.leancloud.im.v2.AVIMMessageStorage;

public class AVIMMessageManagerHelper {
    public static AVIMClientEventHandler getClientEventHandler() {
        return AVIMClient.getClientEventHandler();
    }

    public static AVIMConversationEventHandler getConversationEventHandler() {
        return AVIMMessageManager.getConversationEventHandler();
    }

    public static String getMessageToken(AVIMMessage aVIMMessage) {
        return aVIMMessage.getUniqueToken();
    }

    public static AVIMMessage parseTypedMessage(AVIMMessage aVIMMessage) {
        return AVIMMessageManager.parseTypedMessage(aVIMMessage);
    }

    public static void processMessage(AVIMMessage aVIMMessage, int n10, AVIMClient aVIMClient, boolean bl2, boolean bl3) {
        String string2 = aVIMClient.getClientId();
        aVIMMessage.setCurrentClient(string2);
        AVIMMessageManager.processMessage(aVIMMessage, n10, aVIMClient, bl2, bl3);
    }

    public static void processMessageReceipt(AVIMMessage aVIMMessage, AVIMClient aVIMClient, String string2) {
        AVIMMessageManager.processMessageReceipt(aVIMMessage, aVIMClient, string2);
    }

    public static void removeConversationCache(AVIMConversation object) {
        AVIMMessageStorage aVIMMessageStorage = ((AVIMConversation)object).storage;
        object = ((AVIMConversation)object).getConversationId();
        aVIMMessageStorage.deleteConversationData((String)object);
    }
}

