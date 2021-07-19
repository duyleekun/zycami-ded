/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.network.k$2;
import com.tencent.liteav.network.k$a;

public class k$2$4
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ k$2 c;

    public k$2$4(k$2 k$2, int n10, String string2) {
        this.c = k$2;
        this.a = n10;
        this.b = string2;
    }

    public void run() {
        k$a k$a = this.c.f;
        if (k$a != null) {
            int n10 = this.a;
            String string2 = this.b;
            k$a.a(n10, string2, null);
        }
    }
}

