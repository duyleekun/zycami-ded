/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.w.b;

import com.zhiyun.cama.data.database.model.SplashAd;
import d.v.c.v0.w.b.h;

public final class c
implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ SplashAd b;
    public final /* synthetic */ String c;

    public /* synthetic */ c(h h10, SplashAd splashAd, String string2) {
        this.a = h10;
        this.b = splashAd;
        this.c = string2;
    }

    public final void run() {
        h h10 = this.a;
        SplashAd splashAd = this.b;
        String string2 = this.c;
        h10.r(splashAd, string2);
    }
}

