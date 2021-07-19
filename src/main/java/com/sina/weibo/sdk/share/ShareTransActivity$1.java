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
import com.sina.weibo.sdk.share.ShareTransActivity;

public final class ShareTransActivity$1
extends Handler {
    public final /* synthetic */ ShareTransActivity D;

    public ShareTransActivity$1(ShareTransActivity shareTransActivity, Looper looper) {
        this.D = shareTransActivity;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ShareTransActivity.a(this.D);
    }
}

