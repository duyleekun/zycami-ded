/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.a;
import cn.sharesdk.framework.authorize.d;
import cn.sharesdk.framework.authorize.g;

public abstract class e
implements AuthorizeHelper {
    public Platform a;
    private AuthorizeListener b;
    private SSOListener c;

    public e(Platform platform) {
        this.a = platform;
    }

    public void a(SSOListener sSOListener) {
        this.c = sSOListener;
        d d10 = new d();
        d10.a(sSOListener);
        d10.a(this);
    }

    public void b(AuthorizeListener object) {
        this.b = object;
        object = new g();
        AuthorizeListener authorizeListener = this.b;
        ((g)object).a(authorizeListener);
        ((a)object).a(this);
    }

    public int c() {
        return this.a.getPlatformId();
    }

    public AuthorizeListener getAuthorizeListener() {
        return this.b;
    }

    public Platform getPlatform() {
        return this.a;
    }

    public SSOListener getSSOListener() {
        return this.c;
    }

    public cn.sharesdk.framework.authorize.e getSSOProcessor(d d10) {
        return null;
    }
}

