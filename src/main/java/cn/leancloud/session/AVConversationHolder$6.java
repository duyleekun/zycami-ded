/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.conversation.AVIMConversationMemberInfo;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;

public class AVConversationHolder$6
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;
    public final /* synthetic */ AVIMConversationMemberInfo val$memberInfo;
    public final /* synthetic */ String val$operator;

    public AVConversationHolder$6(AVConversationHolder aVConversationHolder, AVIMConversationEventHandler aVIMConversationEventHandler, String string2, AVIMConversationMemberInfo aVIMConversationMemberInfo, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$handler = aVIMConversationEventHandler;
        this.val$operator = string2;
        this.val$memberInfo = aVIMConversationMemberInfo;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
        String string2 = this.val$operator;
        AVIMConversationMemberInfo aVIMConversationMemberInfo = this.val$memberInfo;
        AVIMConversation aVIMConversation = this.val$conversation;
        aVIMConversationEventHandler.processEvent(50017, string2, aVIMConversationMemberInfo, aVIMConversation);
    }
}

