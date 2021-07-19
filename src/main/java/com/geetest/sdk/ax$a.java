/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.aw;
import com.geetest.sdk.ax;
import com.geetest.sdk.ay;

public class ax$a
implements Runnable {
    public final /* synthetic */ aw a;
    public final /* synthetic */ ay b;
    public final /* synthetic */ ax c;

    public ax$a(ax ax2, aw aw2, ay ay2) {
        this.c = ax2;
        this.a = aw2;
        this.b = ay2;
    }

    public void run() {
        ax ax2 = this.c;
        aw aw2 = this.a;
        ay ay2 = this.b;
        ax2.b(aw2, ay2);
    }
}

