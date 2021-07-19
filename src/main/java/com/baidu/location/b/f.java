/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.d$b;
import java.util.Timer;
import java.util.TimerTask;

public class f
extends TimerTask {
    public final /* synthetic */ Timer a;
    public final /* synthetic */ d$b b;

    public f(d$b d$b, Timer timer) {
        this.b = d$b;
        this.a = timer;
    }

    public void run() {
        d$b d$b = this.b;
        boolean bl2 = d$b.d;
        if (!bl2) {
            d$b.a(d$b);
        }
        this.a.cancel();
    }
}

