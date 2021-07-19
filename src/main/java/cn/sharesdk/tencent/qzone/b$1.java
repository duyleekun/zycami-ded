/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.tencent.qzone.b;

public class b$1
implements SSOListener {
    public final /* synthetic */ AuthorizeListener a;
    public final /* synthetic */ b b;

    public b$1(b b10, AuthorizeListener authorizeListener) {
        this.b = b10;
        this.a = authorizeListener;
    }

    public void onCancel() {
        this.a.onCancel();
    }

    public void onComplete(Bundle bundle) {
        this.a.onComplete(bundle);
    }

    public void onFailed(Throwable object) {
        if (object != null) {
            AuthorizeListener authorizeListener = this.a;
            authorizeListener.onError((Throwable)object);
        } else {
            object = this.a;
            String string2 = "Unknown Throwable!";
            Throwable throwable = new Throwable(string2);
            object.onError(throwable);
        }
    }
}

