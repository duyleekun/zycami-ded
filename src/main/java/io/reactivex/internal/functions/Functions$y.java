/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.o;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Functions$y
implements o {
    public final Comparator a;

    public Functions$y(Comparator comparator) {
        this.a = comparator;
    }

    public List a(List list) {
        Comparator comparator = this.a;
        Collections.sort(list, comparator);
        return list;
    }
}

