/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.facebookmessenger;

import cn.sharesdk.facebookmessenger.FacebookMessenger;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

public class FacebookMessenger$1
implements PlatformActionListener {
    public final /* synthetic */ Platform$ShareParams a;
    public final /* synthetic */ FacebookMessenger b;

    public FacebookMessenger$1(FacebookMessenger facebookMessenger, Platform$ShareParams platform$ShareParams) {
        this.b = facebookMessenger;
        this.a = platform$ShareParams;
    }

    public void onCancel(Platform platform, int n10) {
        PlatformActionListener platformActionListener = FacebookMessenger.e(this.b);
        if (platformActionListener != null) {
            platformActionListener = FacebookMessenger.f(this.b);
            platformActionListener.onCancel(platform, n10);
        }
    }

    public void onComplete(Platform platform, int n10, HashMap hashMap) {
        hashMap = new HashMap<String, Platform$ShareParams>();
        Object object = this.a;
        String string2 = "ShareParams";
        hashMap.put(string2, (Platform$ShareParams)object);
        object = FacebookMessenger.c(this.b);
        if (object != null) {
            object = FacebookMessenger.d(this.b);
            object.onComplete(platform, n10, hashMap);
        }
    }

    public void onError(Platform platform, int n10, Throwable throwable) {
        PlatformActionListener platformActionListener = FacebookMessenger.a(this.b);
        if (platformActionListener != null) {
            platformActionListener = FacebookMessenger.b(this.b);
            platformActionListener.onError(platform, n10, throwable);
        }
    }
}

