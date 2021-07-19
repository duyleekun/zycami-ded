/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.View
 */
package d.v.c.p0.p;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public final class g$a
extends RecyclerView$ViewHolder {
    private SparseArray a;

    public g$a(View view) {
        super(view);
        super();
        this.a = view;
    }

    public View getView(int n10) {
        View view = (View)this.a.get(n10);
        if (view == null) {
            view = this.itemView.findViewById(n10);
            SparseArray sparseArray = this.a;
            sparseArray.put(n10, (Object)view);
        }
        return view;
    }
}

