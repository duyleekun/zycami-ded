/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;

public class AVConversationHolder$20
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ long val$deliveredAt;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;

    public AVConversationHolder$20(AVConversationHolder aVConversationHolder, AVIMConversationEventHandler aVIMConversationEventHandler, long l10, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$handler = aVIMConversationEventHandler;
        this.val$deliveredAt = l10;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
        Long l10 = this.val$deliveredAt;
        AVIMConversation aVIMConversation = this.val$conversation;
        aVIMConversationEventHandler.processEvent(50014, l10, null, aVIMConversation);
    }
}

