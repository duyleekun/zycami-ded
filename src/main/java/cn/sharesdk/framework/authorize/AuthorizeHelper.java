/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.authorize.d;
import cn.sharesdk.framework.authorize.e;
import cn.sharesdk.framework.authorize.g;

public interface AuthorizeHelper {
    public AuthorizeListener getAuthorizeListener();

    public String getAuthorizeUrl();

    public c getAuthorizeWebviewClient(g var1);

    public Platform getPlatform();

    public String getRedirectUri();

    public SSOListener getSSOListener();

    public e getSSOProcessor(d var1);
}

