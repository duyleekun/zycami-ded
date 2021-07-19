/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;
import java.util.List;

public class AVConversationHolder$10
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ List val$copyMembers;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;
    public final /* synthetic */ boolean val$isMuted;
    public final /* synthetic */ String val$operator;

    public AVConversationHolder$10(AVConversationHolder aVConversationHolder, boolean bl2, AVIMConversationEventHandler aVIMConversationEventHandler, String string2, List list, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$isMuted = bl2;
        this.val$handler = aVIMConversationEventHandler;
        this.val$operator = string2;
        this.val$copyMembers = list;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        boolean bl2 = this.val$isMuted;
        if (bl2) {
            AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
            int n10 = 50020;
            String string2 = this.val$operator;
            List list = this.val$copyMembers;
            AVIMConversation aVIMConversation = this.val$conversation;
            aVIMConversationEventHandler.processEvent(n10, string2, list, aVIMConversation);
        } else {
            AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
            int n11 = 50021;
            String string3 = this.val$operator;
            List list = this.val$copyMembers;
            AVIMConversation aVIMConversation = this.val$conversation;
            aVIMConversationEventHandler.processEvent(n11, string3, list, aVIMConversation);
        }
    }
}

