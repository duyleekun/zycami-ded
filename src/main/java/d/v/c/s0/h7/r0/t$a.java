/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s0.h7.r0;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d.v.c.s0.h7.r0.t;
import d.v.c.s0.h7.r0.t$b;

public class t$a
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ t a;

    public t$a(t t10) {
        this.a = t10;
    }

    public void onScrollStateChanged(RecyclerView object, int n10) {
        super.onScrollStateChanged((RecyclerView)object, n10);
        if (n10 == 0) {
            LinearSnapHelper linearSnapHelper = t.k(this.a);
            Object object2 = t.j(this.a);
            if ((linearSnapHelper = linearSnapHelper.findSnapView((RecyclerView$LayoutManager)object2)) != null) {
                object2 = t.l((t)this.a).d;
                int n11 = ((RecyclerView)object).getChildLayoutPosition((View)linearSnapHelper);
                object = n11;
                ((MutableLiveData)object2).setValue(object);
                object = t.m(this.a);
                if (object != null) {
                    object = t.m(this.a);
                    ((RecyclerView$Adapter)object).notifyDataSetChanged();
                }
                object = this.a;
                t.n((t)object);
            }
        } else {
            object = t.m(this.a);
            t$b.e((t$b)object);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int n10, int n11) {
        super.onScrolled(recyclerView, n10, n11);
    }
}

