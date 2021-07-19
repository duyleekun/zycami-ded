/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;

public class AVConversationHolder$8
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;
    public final /* synthetic */ String val$invitedBy;

    public AVConversationHolder$8(AVConversationHolder aVConversationHolder, AVIMConversationEventHandler aVIMConversationEventHandler, String string2, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$handler = aVIMConversationEventHandler;
        this.val$invitedBy = string2;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
        String string2 = this.val$invitedBy;
        AVIMConversation aVIMConversation = this.val$conversation;
        aVIMConversationEventHandler.processEvent(50009, string2, null, aVIMConversation);
    }
}

