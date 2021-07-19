/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.b;

import cn.sharesdk.framework.b.b.c;
import cn.sharesdk.framework.b.d;

public class d$2
extends Thread {
    public final /* synthetic */ c a;
    public final /* synthetic */ d b;

    public d$2(d d10, c c10) {
        this.b = d10;
        this.a = c10;
    }

    public void run() {
        d d10 = this.b;
        c c10 = this.a;
        d10.b(c10);
    }
}

