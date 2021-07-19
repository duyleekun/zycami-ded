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
import com.sina.weibo.sdk.share.ShareStoryActivity;

public final class ShareStoryActivity$1
extends Handler {
    public final /* synthetic */ ShareStoryActivity B;

    public ShareStoryActivity$1(ShareStoryActivity shareStoryActivity, Looper looper) {
        this.B = shareStoryActivity;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ShareStoryActivity.a(this.B, "cancel");
    }
}

