/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;

public class AVConversationHolder$18
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;
    public final /* synthetic */ boolean val$isRecall;
    public final /* synthetic */ AVIMMessage val$message;

    public AVConversationHolder$18(AVConversationHolder aVConversationHolder, boolean bl2, AVIMConversationEventHandler aVIMConversationEventHandler, AVIMMessage aVIMMessage, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$isRecall = bl2;
        this.val$handler = aVIMConversationEventHandler;
        this.val$message = aVIMMessage;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        boolean bl2 = this.val$isRecall;
        if (bl2) {
            AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
            int n10 = 50016;
            AVIMMessage aVIMMessage = this.val$message;
            AVIMConversation aVIMConversation = this.val$conversation;
            aVIMConversationEventHandler.processEvent(n10, aVIMMessage, null, aVIMConversation);
        } else {
            AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
            int n11 = 50015;
            AVIMMessage aVIMMessage = this.val$message;
            AVIMConversation aVIMConversation = this.val$conversation;
            aVIMConversationEventHandler.processEvent(n11, aVIMMessage, null, aVIMConversation);
        }
    }
}

