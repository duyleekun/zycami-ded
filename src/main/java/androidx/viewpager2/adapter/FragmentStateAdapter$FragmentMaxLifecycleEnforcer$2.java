/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.adapter;

import androidx.viewpager2.adapter.FragmentStateAdapter$DataSetChangeObserver;
import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer;

public class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2
extends FragmentStateAdapter$DataSetChangeObserver {
    public final /* synthetic */ FragmentStateAdapter$FragmentMaxLifecycleEnforcer this$1;

    public FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2(FragmentStateAdapter$FragmentMaxLifecycleEnforcer fragmentStateAdapter$FragmentMaxLifecycleEnforcer) {
        this.this$1 = fragmentStateAdapter$FragmentMaxLifecycleEnforcer;
        super(null);
    }

    public void onChanged() {
        this.this$1.updateFragmentMaxLifecycle(true);
    }
}

