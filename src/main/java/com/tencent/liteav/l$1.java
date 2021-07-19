/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.l;

public class l$1
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ l b;

    public l$1(l l10, String string2) {
        this.b = l10;
        this.a = string2;
    }

    public void run() {
        l l10 = this.b;
        String string2 = this.a;
        l.a(l10, string2);
        l.a(this.b);
    }
}

