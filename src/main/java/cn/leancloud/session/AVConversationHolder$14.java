/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;
import java.util.List;

public class AVConversationHolder$14
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMConversation val$conversation;
    public final /* synthetic */ AVIMConversationEventHandler val$handler;
    public final /* synthetic */ List val$members;
    public final /* synthetic */ String val$removedBy;

    public AVConversationHolder$14(AVConversationHolder aVConversationHolder, AVIMConversationEventHandler aVIMConversationEventHandler, String string2, List list, AVIMConversation aVIMConversation) {
        this.this$0 = aVConversationHolder;
        this.val$handler = aVIMConversationEventHandler;
        this.val$removedBy = string2;
        this.val$members = list;
        this.val$conversation = aVIMConversation;
        super(null);
    }

    public void done() {
        AVIMConversationEventHandler aVIMConversationEventHandler = this.val$handler;
        String string2 = this.val$removedBy;
        List list = this.val$members;
        AVIMConversation aVIMConversation = this.val$conversation;
        aVIMConversationEventHandler.processEvent(50004, string2, list, aVIMConversation);
    }
}

