/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.u0;

import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import d.v.c.s0.h7.u0.k;

public class k$a
extends GridLayoutManager$SpanSizeLookup {
    public final /* synthetic */ int a;
    public final /* synthetic */ k b;

    public k$a(k k10, int n10) {
        this.b = k10;
        this.a = n10;
    }

    public int getSpanSize(int n10) {
        int n11;
        k k10 = this.b;
        if ((n10 = k10.getItemViewType(n10)) == (n11 = 1)) {
            return this.a;
        }
        return n11;
    }
}

