/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.sina.weibo.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.WbShareCallback;

public interface IWBAPI {
    public void authorize(WbAuthListener var1);

    public void authorizeCallback(int var1, int var2, Intent var3);

    public void authorizeClient(WbAuthListener var1);

    public void authorizeWeb(WbAuthListener var1);

    public void doResultIntent(Intent var1, WbShareCallback var2);

    public boolean isWBAppInstalled();

    public boolean isWBAppSupportMultipleImage();

    public void registerApp(Context var1, AuthInfo var2);

    public void setLoggerEnable(boolean var1);

    public void shareMessage(WeiboMultiMessage var1, boolean var2);

    public void shareStory(StoryMessage var1);
}

