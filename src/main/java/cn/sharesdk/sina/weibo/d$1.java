/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.sina.weibo.b;
import cn.sharesdk.sina.weibo.d;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;

public class d$1
implements WbAuthListener {
    public final /* synthetic */ d a;

    public d$1(d d10) {
        this.a = d10;
    }

    public void onCancel() {
        b.a().a(1);
        d.a(this.a).onCancel();
        this.a.finish();
    }

    public void onComplete(Oauth2AccessToken object) {
        b.a().a(1);
        Bundle bundle = new Bundle();
        String string2 = ((Oauth2AccessToken)object).getAccessToken();
        bundle.putString("access_token", string2);
        string2 = String.valueOf(((Oauth2AccessToken)object).getExpiresTime());
        bundle.putString("expires_in", string2);
        string2 = ((Oauth2AccessToken)object).getRefreshToken();
        bundle.putString("refresh_token", string2);
        string2 = ((Oauth2AccessToken)object).getScreenName();
        bundle.putString("username", string2);
        object = ((Oauth2AccessToken)object).getUid();
        bundle.putString("uid", (String)object);
        d.a(this.a).onComplete(bundle);
        this.a.finish();
    }

    public void onError(UiError object) {
        object = this.a;
        AuthorizeListener authorizeListener = d.a((d)object);
        d.a((d)object, authorizeListener);
        this.a.finish();
    }
}

