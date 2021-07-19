/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;

public class RecyclerView$LayoutManager$2
implements ViewBoundsCheck$Callback {
    public final /* synthetic */ RecyclerView$LayoutManager this$0;

    public RecyclerView$LayoutManager$2(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        this.this$0 = recyclerView$LayoutManager;
    }

    public View getChildAt(int n10) {
        return this.this$0.getChildAt(n10);
    }

    public int getChildEnd(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        int n10 = this.this$0.getDecoratedBottom(view);
        int n11 = recyclerView$LayoutParams.bottomMargin;
        return n10 + n11;
    }

    public int getChildStart(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        int n10 = this.this$0.getDecoratedTop(view);
        int n11 = recyclerView$LayoutParams.topMargin;
        return n10 - n11;
    }

    public int getParentEnd() {
        int n10 = this.this$0.getHeight();
        int n11 = this.this$0.getPaddingBottom();
        return n10 - n11;
    }

    public int getParentStart() {
        return this.this$0.getPaddingTop();
    }
}

