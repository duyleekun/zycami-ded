/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.camera.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.zhiyun.cama.camera.widget.StringScrollView;
import com.zhiyun.cama.camera.widget.StringScrollView$a;
import com.zhiyun.cama.list.CenterLayoutManager;

public class StringScrollView$d
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ StringScrollView a;

    private StringScrollView$d(StringScrollView stringScrollView) {
        this.a = stringScrollView;
    }

    public /* synthetic */ StringScrollView$d(StringScrollView stringScrollView, StringScrollView$a stringScrollView$a) {
        this(stringScrollView);
    }

    public void onScrollStateChanged(RecyclerView object, int n10) {
        super.onScrollStateChanged((RecyclerView)object, n10);
        if (n10 == 0) {
            int n11;
            Object object2 = StringScrollView.b(this.a);
            CenterLayoutManager centerLayoutManager = StringScrollView.a(this.a);
            if ((object2 = ((LinearSnapHelper)object2).findSnapView(centerLayoutManager)) != null && (n11 = ((RecyclerView)object).getChildLayoutPosition((View)object2) + -1) != (n10 = StringScrollView.g((StringScrollView)(object2 = this.a)))) {
                object2 = this.a;
                StringScrollView.h((StringScrollView)object2, n11);
                StringScrollView.i(this.a).notifyDataSetChanged();
                object = StringScrollView.j(this.a);
                if (object != null) {
                    object = StringScrollView.j(this.a);
                    object2 = this.a;
                    n10 = StringScrollView.g((StringScrollView)object2);
                    object.a(n10);
                }
            }
        }
    }

    public void onScrolled(RecyclerView recyclerView, int n10, int n11) {
        super.onScrolled(recyclerView, n10, n11);
    }
}

