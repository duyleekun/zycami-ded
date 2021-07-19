/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import d.v.c.h1.s;

public class s$a
extends GridLayoutManager$SpanSizeLookup {
    public final /* synthetic */ int a;
    public final /* synthetic */ s b;

    public s$a(s s10, int n10) {
        this.b = s10;
        this.a = n10;
    }

    public int getSpanSize(int n10) {
        int n11;
        s s10 = this.b;
        if ((n10 = s10.getItemViewType(n10)) == (n11 = 1)) {
            return this.a;
        }
        return n11;
    }
}

