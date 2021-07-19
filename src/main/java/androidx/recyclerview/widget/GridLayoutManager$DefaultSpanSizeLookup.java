/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;

public final class GridLayoutManager$DefaultSpanSizeLookup
extends GridLayoutManager$SpanSizeLookup {
    public int getSpanIndex(int n10, int n11) {
        return n10 % n11;
    }

    public int getSpanSize(int n10) {
        return 1;
    }
}

