/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.account;

import android.view.View;
import androidx.core.app.ActivityCompat;
import com.zhiyun.account.SimpleWebViewActivity;

public class SimpleWebViewActivity$c {
    public final /* synthetic */ SimpleWebViewActivity a;

    public SimpleWebViewActivity$c(SimpleWebViewActivity simpleWebViewActivity) {
        this.a = simpleWebViewActivity;
    }

    public void a(View view) {
        ActivityCompat.finishAfterTransition(this.a);
    }
}

