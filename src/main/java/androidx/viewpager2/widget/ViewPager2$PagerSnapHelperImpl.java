/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPager2$PagerSnapHelperImpl
extends PagerSnapHelper {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$PagerSnapHelperImpl(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public View findSnapView(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        ViewPager2 viewPager2 = this.this$0;
        boolean bl2 = viewPager2.isFakeDragging();
        recyclerView$LayoutManager = bl2 ? null : super.findSnapView(recyclerView$LayoutManager);
        return recyclerView$LayoutManager;
    }
}

