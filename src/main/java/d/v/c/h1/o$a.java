/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import d.v.c.h1.o;

public class o$a
extends GridLayoutManager$SpanSizeLookup {
    public final /* synthetic */ int a;
    public final /* synthetic */ o b;

    public o$a(o o10, int n10) {
        this.b = o10;
        this.a = n10;
    }

    public int getSpanSize(int n10) {
        o o10;
        int n11 = 1;
        o o11 = this.b;
        int n12 = o11.getItemViewType(n10);
        if (n11 != n12 && (n12 = 2) != (n10 = (o10 = this.b).getItemViewType(n10))) {
            return n11;
        }
        return this.a;
    }
}

