/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageManagerHelper;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;

public class AVConversationHolder$17
extends AVConversationHolder$SimpleCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ AVIMClient val$client;
    public final /* synthetic */ boolean val$hasMore;
    public final /* synthetic */ boolean val$isTransient;
    public final /* synthetic */ AVIMMessage val$message;

    public AVConversationHolder$17(AVConversationHolder aVConversationHolder, AVIMMessage aVIMMessage, AVIMClient aVIMClient, boolean bl2, boolean bl3) {
        this.this$0 = aVConversationHolder;
        this.val$message = aVIMMessage;
        this.val$client = aVIMClient;
        this.val$hasMore = bl2;
        this.val$isTransient = bl3;
        super(null);
    }

    public void done() {
        AVIMMessage aVIMMessage = this.val$message;
        int n10 = this.this$0.convType;
        AVIMClient aVIMClient = this.val$client;
        boolean bl2 = this.val$hasMore;
        boolean bl3 = this.val$isTransient;
        AVIMMessageManagerHelper.processMessage(aVIMMessage, n10, aVIMClient, bl2, bl3);
    }
}

