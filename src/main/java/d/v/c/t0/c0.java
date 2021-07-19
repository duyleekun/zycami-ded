/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package d.v.c.t0;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;

public class c0
extends RecyclerView$ItemDecoration {
    private int a;
    private int b;

    public c0(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State object) {
        int n10;
        int n11;
        rect.left = n11 = this.a;
        rect.right = n11;
        rect.bottom = n11;
        rect.top = n11;
        object = recyclerView.getAdapter();
        if (object == null) {
            return;
        }
        int n12 = recyclerView.getChildAdapterPosition(view);
        if (n12 == (n10 = ((RecyclerView$Adapter)object).getItemCount() + -1)) {
            rect.right = n12 = this.b;
        }
    }
}

