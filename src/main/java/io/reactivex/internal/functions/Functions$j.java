/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class Functions$j
implements Callable {
    public final int a;

    public Functions$j(int n10) {
        this.a = n10;
    }

    public List a() {
        int n10 = this.a;
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }
}

