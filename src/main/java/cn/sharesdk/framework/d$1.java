/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.f;
import cn.sharesdk.framework.d;

public class d$1
implements Runnable {
    public final /* synthetic */ d a;

    public d$1(d d10) {
        this.a = d10;
    }

    public void run() {
        f f10 = f.c();
        try {
            f10.d();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

