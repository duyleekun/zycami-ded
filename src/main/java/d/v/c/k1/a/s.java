/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package d.v.c.k1.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;

public class s
extends RecyclerView$ItemDecoration {
    private int a;
    private int b;
    private int c;

    public s(int n10, int n11, int n12) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView object, RecyclerView$State recyclerView$State) {
        int n10 = ((RecyclerView)object).getChildAdapterPosition(view);
        if (n10 == 0) {
            rect.left = n10 = this.b;
            rect.right = n10 = this.a;
        } else {
            int n11 = ((RecyclerView$Adapter)(object = ((RecyclerView)object).getAdapter())).getItemCount() + -1;
            rect.right = n10 == n11 ? (n10 = this.c) : (n10 = this.a);
        }
    }
}

