/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.b;

import cn.sharesdk.framework.authorize.f;
import cn.sharesdk.framework.b.d;

public class d$3
implements Runnable {
    public final /* synthetic */ d a;

    public d$3(d d10) {
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

