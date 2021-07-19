/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;

public class AVConversationHolder$11
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;
    public final /* synthetic */ boolean val$isBlocked;
    public final /* synthetic */ String val$operator;

    public AVConversationHolder$11(AVConversationHolder aVConversationHolder, boolean bl2, AVIMConversationEventHandler aVIMConversationEventHandler, String string2, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$isBlocked = bl2;
        this.val$handler = aVIMConversationEventHandler;
        this.val$operator = string2;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        boolean bl2 = this.val$isBlocked;
        if (bl2) {
            AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
            int n10 = 50022;
            String string2 = this.val$operator;
            AVIMConversation aVIMConversation = this.val$conversation;
            aVIMConversationEventHandler.processEvent(n10, string2, null, aVIMConversation);
        } else {
            AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
            int n11 = 50023;
            String string3 = this.val$operator;
            AVIMConversation aVIMConversation = this.val$conversation;
            aVIMConversationEventHandler.processEvent(n11, string3, null, aVIMConversation);
        }
    }
}

