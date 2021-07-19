/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.sina.weibo.g;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;

public class g$1
implements WbAuthListener {
    public final /* synthetic */ g a;

    public g$1(g g10) {
        this.a = g10;
    }

    public void onCancel() {
        g.a(this.a).onCancel();
        this.a.finish();
    }

    public void onComplete(Oauth2AccessToken object) {
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
        g.a(this.a).onComplete(bundle);
        this.a.finish();
    }

    public void onError(UiError object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errorCode: ");
        int n10 = ((UiError)object).errorCode;
        stringBuilder.append(n10);
        stringBuilder.append(" errorMessage: ");
        String string2 = ((UiError)object).errorMessage;
        stringBuilder.append(string2);
        stringBuilder.append(" errorDetail: ");
        object = ((UiError)object).errorDetail;
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Throwable throwable = new Throwable((String)object);
        g.a(this.a).onError(throwable);
        this.a.finish();
    }
}

