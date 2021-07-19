/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.adapter;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer;

public class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3
implements LifecycleEventObserver {
    public final /* synthetic */ FragmentStateAdapter$FragmentMaxLifecycleEnforcer this$1;

    public FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(FragmentStateAdapter$FragmentMaxLifecycleEnforcer fragmentStateAdapter$FragmentMaxLifecycleEnforcer) {
        this.this$1 = fragmentStateAdapter$FragmentMaxLifecycleEnforcer;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        this.this$1.updateFragmentMaxLifecycle(false);
    }
}

