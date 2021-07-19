/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.sina.weibo.sdk.share;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sina.weibo.sdk.share.ShareChatActivity;

public final class ShareChatActivity$1
extends Handler {
    public final /* synthetic */ ShareChatActivity y;

    public ShareChatActivity$1(ShareChatActivity shareChatActivity, Looper looper) {
        this.y = shareChatActivity;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ShareChatActivity.a(this.y);
    }
}

