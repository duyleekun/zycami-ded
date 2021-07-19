/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.viewpager2.adapter;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

public class FragmentStateAdapter$2
implements LifecycleEventObserver {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ FragmentViewHolder val$holder;

    public FragmentStateAdapter$2(FragmentStateAdapter fragmentStateAdapter, FragmentViewHolder fragmentViewHolder) {
        this.this$0 = fragmentStateAdapter;
        this.val$holder = fragmentViewHolder;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event object2) {
        object2 = this.this$0;
        boolean bl2 = ((FragmentStateAdapter)object2).shouldDelayFragmentTransactions();
        if (bl2) {
            return;
        }
        object.getLifecycle().removeObserver(this);
        object = this.val$holder.getContainer();
        boolean bl3 = ViewCompat.isAttachedToWindow((View)object);
        if (bl3) {
            object = this.this$0;
            object2 = this.val$holder;
            ((FragmentStateAdapter)object).placeFragmentInViewHolder((FragmentViewHolder)object2);
        }
    }
}

