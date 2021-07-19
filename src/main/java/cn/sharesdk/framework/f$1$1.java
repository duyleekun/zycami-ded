/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.f$1;

public class f$1$1
extends Thread {
    public final /* synthetic */ f$1 a;

    public f$1$1(f$1 var1_1) {
        this.a = var1_1;
    }

    public void run() {
        super.run();
        Platform platform = f.a(this.a.b);
        Platform$ShareParams platform$ShareParams = this.a.a;
        platform.doShare(platform$ShareParams);
    }
}

