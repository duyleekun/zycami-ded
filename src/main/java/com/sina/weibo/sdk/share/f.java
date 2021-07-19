/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.ShareTransActivity;
import java.lang.ref.WeakReference;

public final class f {
    public WeakReference g;

    public f(Activity activity) {
        WeakReference<Activity> weakReference;
        this.g = weakReference = new WeakReference<Activity>(activity);
    }

    public final void b(WeiboMultiMessage weiboMultiMessage) {
        Activity activity = (Activity)this.g.get();
        if (activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        CharSequence charSequence = new StringBuilder();
        long l10 = System.currentTimeMillis();
        charSequence.append(l10);
        charSequence = charSequence.toString();
        bundle.putString("_weibo_transaction", (String)charSequence);
        weiboMultiMessage = weiboMultiMessage.writeToBundle(bundle);
        bundle.putAll((Bundle)weiboMultiMessage);
        weiboMultiMessage = new Intent((Context)activity, ShareTransActivity.class);
        weiboMultiMessage.putExtra("start_flag", 0);
        weiboMultiMessage.putExtras(bundle);
        activity.startActivityForResult((Intent)weiboMultiMessage, 10001);
    }
}

