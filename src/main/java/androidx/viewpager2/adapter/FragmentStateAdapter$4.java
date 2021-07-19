/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.adapter;

import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentStateAdapter$4
implements Runnable {
    public final /* synthetic */ FragmentStateAdapter this$0;

    public FragmentStateAdapter$4(FragmentStateAdapter fragmentStateAdapter) {
        this.this$0 = fragmentStateAdapter;
    }

    public void run() {
        FragmentStateAdapter fragmentStateAdapter = this.this$0;
        fragmentStateAdapter.mIsInGracePeriod = false;
        fragmentStateAdapter.gcFragments();
    }
}

