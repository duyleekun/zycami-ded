/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;
import java.util.AbstractMap;

public class AVConversationHolder$15
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;
    public final /* synthetic */ AVIMMessage val$msgCopy;
    public final /* synthetic */ AbstractMap.SimpleEntry val$unreadInfo;

    public AVConversationHolder$15(AVConversationHolder aVConversationHolder, AVIMConversationEventHandler aVIMConversationEventHandler, AVIMMessage aVIMMessage, AbstractMap.SimpleEntry simpleEntry, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$handler = aVIMConversationEventHandler;
        this.val$msgCopy = aVIMMessage;
        this.val$unreadInfo = simpleEntry;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
        AVIMMessage aVIMMessage = this.val$msgCopy;
        AbstractMap.SimpleEntry simpleEntry = this.val$unreadInfo;
        AVIMConversation aVIMConversation = this.val$conversation;
        aVIMConversationEventHandler.processEvent(50012, aVIMMessage, simpleEntry, aVIMConversation);
    }
}

