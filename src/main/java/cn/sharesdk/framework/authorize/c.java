/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 */
package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.a;
import cn.sharesdk.framework.g;
import com.mob.tools.FakeActivity;

public abstract class c
extends g {
    public cn.sharesdk.framework.authorize.g activity;
    public AuthorizeListener listener;
    public String redirectUri;

    public c(cn.sharesdk.framework.authorize.g object) {
        String string2;
        this.activity = object;
        object = ((a)object).a();
        this.redirectUri = string2 = object.getRedirectUri();
        this.listener = object = object.getAuthorizeListener();
    }

    public abstract void onComplete(String var1);

    public void onReceivedError(WebView object, int n10, String object2, String string2) {
        object.stopLoading();
        object = this.activity.a().getAuthorizeListener();
        Object object3 = this.activity;
        ((FakeActivity)object3).finish();
        if (object != null) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" (");
            ((StringBuilder)object3).append(n10);
            ((StringBuilder)object3).append("): ");
            ((StringBuilder)object3).append(string2);
            String string3 = ((StringBuilder)object3).toString();
            object2 = new Throwable(string3);
            object.onError((Throwable)object2);
        }
    }
}

