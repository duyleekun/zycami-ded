/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageManagerHelper;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;

public class AVConversationHolder$16
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ String val$from;
    public final /* synthetic */ AVIMMessage val$message;

    public AVConversationHolder$16(AVConversationHolder aVConversationHolder, AVIMMessage aVIMMessage, String string2) {
        this.this$0 = aVConversationHolder;
        this.val$message = aVIMMessage;
        this.val$from = string2;
        super(null);
    }

    public void done() {
        AVIMMessage aVIMMessage = this.val$message;
        AVIMClient aVIMClient = AVIMClient.getInstance(this.this$0.session.getSelfPeerId());
        String string2 = this.val$from;
        AVIMMessageManagerHelper.processMessageReceipt(aVIMMessage, aVIMClient, string2);
    }
}

