/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package cn.sharesdk.framework.authorize;

import android.content.Intent;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.a;
import cn.sharesdk.framework.authorize.e;

public class d
extends a {
    public SSOListener b;
    private e c;

    public void a(SSOListener sSOListener) {
        this.b = sSOListener;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        this.c.a(n10, n11, intent);
    }

    public void onCreate() {
        Object object = this.a.getSSOProcessor(this);
        this.c = object;
        if (object == null) {
            this.finish();
            object = this.a.getAuthorizeListener();
            if (object != null) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Failed to start SSO for ");
                Object object2 = this.a.getPlatform().getName();
                charSequence.append((String)object2);
                charSequence = charSequence.toString();
                object2 = new Throwable((String)charSequence);
                object.onError((Throwable)object2);
            }
            return;
        }
        ((e)object).a(32973);
        this.c.a();
    }

    public void onNewIntent(Intent intent) {
        this.c.a(intent);
    }
}

