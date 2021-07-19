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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;

public class r
extends RecyclerView$ItemDecoration {
    private int a;
    private int b;
    private boolean c;
    private int d;
    private int e;

    public r(int n10, int n11, boolean bl2) {
        this.a = n10;
        this.b = n11;
        this.c = bl2;
    }

    public r(int n10, int n11, boolean bl2, int n12, int n13) {
        this(n10, n11, bl2);
        this.d = n12;
        this.e = n13;
    }

    private boolean a(int n10, int n11, RecyclerView object) {
        object = ((RecyclerView)object).getLayoutManager();
        boolean bl2 = object instanceof GridLayoutManager;
        boolean bl3 = false;
        if (bl2 && n10 < n11) {
            bl3 = true;
        }
        return bl3;
    }

    private boolean b(int n10, int n11, RecyclerView object) {
        Object object2 = ((RecyclerView)object).getLayoutManager();
        int n12 = object2 instanceof GridLayoutManager;
        int n13 = 0;
        if (n12 != 0) {
            int n14;
            object2 = ((RecyclerView)object).getAdapter();
            if (object2 == null) {
                n14 = 0;
                object = null;
            } else {
                object = ((RecyclerView)object).getAdapter();
                n14 = ((RecyclerView$Adapter)object).getItemCount();
            }
            n12 = n14 % n11;
            int n15 = 1;
            n14 /= n11;
            if (n12 != 0) {
                n14 += n15;
            }
            n12 = (n14 + -1) * n11;
            if (n10 >= n12 && n10 < (n14 *= n11)) {
                n13 = n15;
            }
        }
        return n13 != 0;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        int n10;
        int n11 = recyclerView.getChildAdapterPosition(view);
        int n12 = this.a;
        int n13 = n11 % n12;
        if ((n12 = (int)(this.a(n11, n12, recyclerView) ? 1 : 0)) != 0) {
            rect.top = n12 = this.d;
        }
        if ((n10 = this.b(n11, n12 = this.a, recyclerView)) != 0) {
            rect.bottom = n10 = this.e;
        }
        if ((n10 = (int)(this.c ? 1 : 0)) != 0) {
            n10 = this.b;
            n12 = n13 * n10;
            int n14 = this.a;
            n12 /= n14;
            rect.left = n12 = n10 - n12;
            rect.right = n13 = (n13 + 1) * n10 / n14;
            if (n11 < n14) {
                rect.top = n10;
            }
            rect.bottom = n10;
        } else {
            n10 = this.b;
            n12 = n13 * n10;
            int n15 = this.a;
            rect.left = n12 /= n15;
            n13 = (n13 + 1) * n10 / n15;
            rect.right = n12 = n10 - n13;
            if (n11 >= n15) {
                rect.top = n10;
            }
        }
    }
}

