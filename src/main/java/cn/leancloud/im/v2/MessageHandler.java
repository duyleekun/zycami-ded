/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.AVIMEventHandler;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMMessage;

public abstract class MessageHandler
extends AVIMEventHandler {
    private void processMessage(int n10, Object object, Object object2, AVIMConversation aVIMConversation) {
        switch (n10) {
            default: {
                break;
            }
            case 50001: {
                if (object == null) {
                    object2 = (AVIMMessage)object2;
                    AVIMClient aVIMClient = aVIMConversation.client;
                    this.onMessageReceipt((AVIMMessage)object2, aVIMConversation, aVIMClient);
                    break;
                }
                object2 = (AVIMMessage)object2;
                object = (String)object;
                AVIMClient aVIMClient = aVIMConversation.client;
                this.onMessageReceiptEx((AVIMMessage)object2, (String)object, aVIMConversation, aVIMClient);
                break;
            }
            case 50000: {
                object2 = (AVIMMessage)object2;
                AVIMClient aVIMClient = aVIMConversation.client;
                this.onMessage((AVIMMessage)object2, aVIMConversation, aVIMClient);
            }
        }
    }

    public abstract void onMessage(AVIMMessage var1, AVIMConversation var2, AVIMClient var3);

    public abstract void onMessageReceipt(AVIMMessage var1, AVIMConversation var2, AVIMClient var3);

    public abstract void onMessageReceiptEx(AVIMMessage var1, String var2, AVIMConversation var3, AVIMClient var4);

    public final void processEvent0(int n10, Object object, Object object2, Object object3) {
        object3 = (AVIMConversation)object3;
        this.processMessage(n10, object, object2, (AVIMConversation)object3);
    }
}

