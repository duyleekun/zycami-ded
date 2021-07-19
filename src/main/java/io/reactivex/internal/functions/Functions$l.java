/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.g;
import i.g.e;

public class Functions$l
implements g {
    public final int a;

    public Functions$l(int n10) {
        this.a = n10;
    }

    public void a(e e10) {
        long l10 = this.a;
        e10.request(l10);
    }
}

