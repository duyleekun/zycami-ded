/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.twitter;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.twitter.c;
import com.mob.tools.log.NLog;

public class c$1
implements SSOListener {
    public final /* synthetic */ AuthorizeListener a;
    public final /* synthetic */ c b;

    public c$1(c c10, AuthorizeListener authorizeListener) {
        this.b = c10;
        this.a = authorizeListener;
    }

    public void onCancel() {
        AuthorizeListener authorizeListener = this.a;
        try {
            authorizeListener.onCancel();
        }
        catch (Exception exception) {
            NLog nLog = SSDKLog.b();
            nLog.d(exception);
        }
    }

    public void onComplete(Bundle bundle) {
        AuthorizeListener authorizeListener = this.a;
        try {
            authorizeListener.onComplete(bundle);
        }
        catch (Throwable throwable) {
            this.onFailed(throwable);
        }
    }

    public void onFailed(Throwable object) {
        object = this.b;
        AuthorizeListener authorizeListener = this.a;
        c.a((c)object, authorizeListener);
    }
}

