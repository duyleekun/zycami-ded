/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.webkit.WebView
 */
package cn.sharesdk.facebook;

import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.facebook.g$1;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class g
extends c {
    public g(cn.sharesdk.framework.authorize.g g10) {
        super(g10);
    }

    public static /* synthetic */ cn.sharesdk.framework.authorize.g a(g g10) {
        return g10.activity;
    }

    public void onComplete(String object) {
        Object object2;
        Object object3 = ResHelper.urlToBundle((String)object);
        Object object4 = object3.getString("error_message");
        if (object4 != null && (object2 = this.listener) != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("error_message ==>>");
            ((StringBuilder)object2).append((String)object4);
            ((StringBuilder)object2).append("\nerror_code ==>>");
            object4 = object3.getString("error_code");
            ((StringBuilder)object2).append((String)object4);
            object4 = ((StringBuilder)object2).toString();
            object2 = this.listener;
            Throwable throwable = new Throwable((String)object);
            object2.onError(throwable);
        }
        if (object4 == null) {
            object = object3.getString("access_token");
            object4 = "expires_in";
            boolean bl2 = object3.containsKey((String)object4);
            object3 = bl2 ? object3.getString((String)object4) : "-1";
            object4 = this.listener;
            if (object4 != null) {
                int n10;
                object4 = new Bundle();
                object4.putString("oauth_token", (String)object);
                object = "oauth_token_secret";
                object2 = "";
                object4.putString((String)object, (String)object2);
                try {
                    n10 = ResHelper.parseInt((String)object3);
                }
                catch (Throwable throwable) {
                    object3 = SSDKLog.b();
                    object3.d(throwable);
                    n10 = -1;
                }
                object3 = "oauth_token_expires";
                object4.putInt((String)object3, n10);
                object = this.listener;
                object.onComplete((Bundle)object4);
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        block7: {
            Object object = this.redirectUri;
            if (object == null) break block7;
            boolean bl2 = string2.startsWith((String)object);
            if (!bl2) break block7;
            webView.stopLoading();
            object = new g$1(this);
            long l10 = 500L;
            webView.postDelayed((Runnable)object, l10);
            try {
                this.onComplete(string2);
                return true;
            }
            catch (Exception exception) {
                NLog nLog = SSDKLog.b();
                String string3 = exception.getMessage();
                Object[] objectArray = new Object[]{};
                nLog.e(string3, objectArray);
            }
        }
        return super.shouldOverrideUrlLoading(webView, string2);
    }
}

