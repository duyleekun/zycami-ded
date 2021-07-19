/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.widget.FrameLayout
 */
package androidx.viewpager2.adapter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

public class FragmentStateAdapter$1
implements View.OnLayoutChangeListener {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ FrameLayout val$container;
    public final /* synthetic */ FragmentViewHolder val$holder;

    public FragmentStateAdapter$1(FragmentStateAdapter fragmentStateAdapter, FrameLayout frameLayout, FragmentViewHolder fragmentViewHolder) {
        this.this$0 = fragmentStateAdapter;
        this.val$container = frameLayout;
        this.val$holder = fragmentViewHolder;
    }

    public void onLayoutChange(View object, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        object = this.val$container.getParent();
        if (object != null) {
            this.val$container.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
            object = this.this$0;
            FragmentViewHolder fragmentViewHolder = this.val$holder;
            ((FragmentStateAdapter)object).placeFragmentInViewHolder(fragmentViewHolder);
        }
    }
}

