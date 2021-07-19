/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main.me;

import com.zhiyun.cama.data.me.remote.SharePlatformManager$OnShareCallback;
import com.zhiyun.cama.main.me.WebViewFragment;
import d.v.f.i.g;

public class WebViewFragment$a
implements SharePlatformManager$OnShareCallback {
    public final /* synthetic */ WebViewFragment a;

    public WebViewFragment$a(WebViewFragment webViewFragment) {
        this.a = webViewFragment;
    }

    public void onShareFailed(String string2) {
        WebViewFragment.H(this.a, string2);
    }

    public void onShareSuccess() {
        WebViewFragment webViewFragment = this.a;
        String string2 = g.m(webViewFragment.requireContext(), 2131952944);
        WebViewFragment.H(webViewFragment, string2);
    }
}

