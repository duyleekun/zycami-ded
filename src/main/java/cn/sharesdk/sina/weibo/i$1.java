/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.sina.weibo.i;
import java.util.HashMap;

public class i$1
implements AuthorizeListener {
    public final /* synthetic */ PlatformActionListener a;
    public final /* synthetic */ Platform$ShareParams b;
    public final /* synthetic */ i c;

    public i$1(i i10, PlatformActionListener platformActionListener, Platform$ShareParams platform$ShareParams) {
        this.c = i10;
        this.a = platformActionListener;
        this.b = platform$ShareParams;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            Platform platform = i.c(this.c);
            int n10 = 9;
            platformActionListener.onCancel(platform, n10);
        }
    }

    public void onComplete(Bundle object) {
        object = this.a;
        if (object != null) {
            object = new HashMap();
            Object object2 = this.b;
            ((HashMap)object).put("ShareParams", object2);
            object2 = this.a;
            Platform platform = i.b(this.c);
            int n10 = 9;
            object2.onComplete(platform, n10, (HashMap)object);
        }
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            Platform platform = i.a(this.c);
            int n10 = 9;
            platformActionListener.onError(platform, n10, throwable);
        }
    }
}

