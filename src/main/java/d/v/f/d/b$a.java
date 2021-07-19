/*
 * Decompiled with CFR 0.151.
 */
package d.v.f.d;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableList$OnListChangedCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import d.v.f.d.b;
import java.util.ArrayList;

public class b$a
extends ObservableList$OnListChangedCallback {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    public void onChanged(ObservableList observableList) {
        this.a.notifyDataSetChanged();
    }

    public void onItemRangeChanged(ObservableList observableList, int n10, int n11) {
        this.a.notifyItemRangeChanged(n10, n11);
    }

    public void onItemRangeInserted(ObservableList observableList, int n10, int n11) {
        this.a.notifyItemRangeInserted(n10, n11);
    }

    public void onItemRangeMoved(ObservableList object, int n10, int n11, int n12) {
        int n13 = 1;
        if (n12 == n13) {
            object = this.a;
            ((RecyclerView$Adapter)object).notifyItemMoved(n10, n12);
        } else {
            object = this.a;
            ((RecyclerView$Adapter)object).notifyDataSetChanged();
        }
    }

    public void onItemRangeRemoved(ObservableList object, int n10, int n11) {
        this.a.notifyItemRangeRemoved(n10, n11);
        object = b.a(this.a);
        int n12 = ((ArrayList)object).size();
        if (n10 != n12) {
            object = this.a;
            ObservableArrayList observableArrayList = b.a((b)object);
            n11 = observableArrayList.size() - n10;
            ((RecyclerView$Adapter)object).notifyItemRangeChanged(n10, n11);
        }
    }
}

