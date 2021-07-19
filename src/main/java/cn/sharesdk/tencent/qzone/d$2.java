/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 */
package cn.sharesdk.tencent.qzone;

import android.webkit.WebView;
import cn.sharesdk.framework.g;
import cn.sharesdk.tencent.qzone.d;

public class d$2
extends g {
    public final /* synthetic */ d a;

    public d$2(d d10) {
        this.a = d10;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        Object object;
        boolean bl2;
        if (string2 != null && (bl2 = string2.startsWith((String)(object = d.b(this.a))))) {
            object = this.a;
            d.a((d)object, string2);
        } else if (string2 != null && (bl2 = string2.startsWith((String)(object = "mqzone://")))) {
            object = this.a;
            d.b((d)object, string2);
        }
        return super.shouldOverrideUrlLoading(webView, string2);
    }
}

