/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$Span;

public class StaggeredGridLayoutManager$LayoutParams
extends RecyclerView$LayoutParams {
    public static final int INVALID_SPAN_ID = 255;
    public boolean mFullSpan;
    public StaggeredGridLayoutManager$Span mSpan;

    public StaggeredGridLayoutManager$LayoutParams(int n10, int n11) {
        super(n10, n11);
    }

    public StaggeredGridLayoutManager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StaggeredGridLayoutManager$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public StaggeredGridLayoutManager$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public StaggeredGridLayoutManager$LayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        super(recyclerView$LayoutParams);
    }

    public final int getSpanIndex() {
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpan;
        if (staggeredGridLayoutManager$Span == null) {
            return -1;
        }
        return staggeredGridLayoutManager$Span.mIndex;
    }

    public boolean isFullSpan() {
        return this.mFullSpan;
    }

    public void setFullSpan(boolean bl2) {
        this.mFullSpan = bl2;
    }
}

