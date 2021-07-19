/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.facebook;

import android.os.Bundle;
import cn.sharesdk.facebook.h;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.utils.SSDKLog;

public class h$1
implements SSOListener {
    public final /* synthetic */ AuthorizeListener a;
    public final /* synthetic */ h b;

    public h$1(h h10, AuthorizeListener authorizeListener) {
        this.b = h10;
        this.a = authorizeListener;
    }

    public void onCancel() {
        this.a.onCancel();
    }

    public void onComplete(Bundle bundle) {
        this.a.onComplete(bundle);
    }

    public void onFailed(Throwable object) {
        SSDKLog.b().d((Throwable)object);
        object = this.b;
        AuthorizeListener authorizeListener = this.a;
        h.a((h)object, authorizeListener);
    }
}

