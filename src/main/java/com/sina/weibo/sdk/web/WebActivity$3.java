/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.sina.weibo.sdk.web;

import android.view.View;
import com.sina.weibo.sdk.web.WebActivity;

public final class WebActivity$3
implements View.OnClickListener {
    public final /* synthetic */ WebActivity az;

    public WebActivity$3(WebActivity webActivity) {
        this.az = webActivity;
    }

    public final void onClick(View view) {
        WebActivity.d(this.az);
        WebActivity.b(this.az).reload();
    }
}

