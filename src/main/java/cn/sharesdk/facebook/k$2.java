/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 */
package cn.sharesdk.facebook;

import android.webkit.WebView;
import cn.sharesdk.facebook.k;
import cn.sharesdk.framework.g;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public class k$2
extends g {
    public final /* synthetic */ k a;

    public k$2(k k10) {
        this.a = k10;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        block5: {
            if (string2 != null) {
                Object object = "fbconnect://success";
                boolean bl2 = string2.startsWith((String)object);
                if (!bl2) break block5;
                object = this.a;
                try {
                    k.a((k)object, string2);
                }
                catch (Exception exception) {
                    NLog nLog = SSDKLog.b();
                    String string3 = exception.getMessage();
                    Object[] objectArray = new Object[]{};
                    nLog.d(string3, objectArray);
                }
            }
        }
        return super.shouldOverrideUrlLoading(webView, string2);
    }
}

