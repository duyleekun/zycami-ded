/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.facebook;

import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

public class Facebook$2
implements PlatformActionListener {
    public final /* synthetic */ Platform$ShareParams a;
    public final /* synthetic */ Facebook b;

    public Facebook$2(Facebook facebook, Platform$ShareParams platform$ShareParams) {
        this.b = facebook;
        this.a = platform$ShareParams;
    }

    public void onCancel(Platform object, int n10) {
        object = Facebook.k(this.b);
        if (object != null) {
            object = Facebook.l(this.b);
            Facebook facebook = this.b;
            int n11 = 9;
            object.onCancel(facebook, n11);
        }
    }

    public void onComplete(Platform object, int n10, HashMap hashMap) {
        object = Facebook.i(this.b);
        if (object != null) {
            object = this.a;
            hashMap.put("ShareParams", object);
            object = Facebook.j(this.b);
            Facebook facebook = this.b;
            int n11 = 9;
            object.onComplete(facebook, n11, hashMap);
        }
    }

    public void onError(Platform object, int n10, Throwable throwable) {
        object = Facebook.g(this.b);
        if (object != null) {
            object = Facebook.h(this.b);
            Facebook facebook = this.b;
            int n11 = 9;
            object.onError(facebook, n11, throwable);
        }
    }
}

