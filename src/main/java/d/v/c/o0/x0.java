/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package d.v.c.o0;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;

public class x0
extends RecyclerView$ItemDecoration {
    private int a;

    public x0(int n10) {
        this.a = n10;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        int n10;
        rect.left = n10 = this.a;
        rect.right = n10;
        rect.bottom = n10;
        rect.top = n10;
    }
}

