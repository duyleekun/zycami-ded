/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.adapter;

import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;

public class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1
extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ FragmentStateAdapter$FragmentMaxLifecycleEnforcer this$1;

    public FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1(FragmentStateAdapter$FragmentMaxLifecycleEnforcer fragmentStateAdapter$FragmentMaxLifecycleEnforcer) {
        this.this$1 = fragmentStateAdapter$FragmentMaxLifecycleEnforcer;
    }

    public void onPageScrollStateChanged(int n10) {
        this.this$1.updateFragmentMaxLifecycle(false);
    }

    public void onPageSelected(int n10) {
        this.this$1.updateFragmentMaxLifecycle(false);
    }
}

