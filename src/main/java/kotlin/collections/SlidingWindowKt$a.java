/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.n2.m;
import java.util.Iterator;
import kotlin.collections.SlidingWindowKt;

public final class SlidingWindowKt$a
implements m {
    public final /* synthetic */ m a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public SlidingWindowKt$a(m m10, int n10, int n11, boolean bl2, boolean bl3) {
        this.a = m10;
        this.b = n10;
        this.c = n11;
        this.d = bl2;
        this.e = bl3;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.a.iterator();
        int n10 = this.b;
        int n11 = this.c;
        boolean bl2 = this.d;
        boolean bl3 = this.e;
        return SlidingWindowKt.b(iterator2, n10, n11, bl2, bl3);
    }
}

