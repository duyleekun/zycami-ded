/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.tabs;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$OnAdapterChangeListener;
import com.google.android.material.tabs.TabLayout;

public class TabLayout$AdapterChangeListener
implements ViewPager$OnAdapterChangeListener {
    private boolean autoRefresh;
    public final /* synthetic */ TabLayout this$0;

    public TabLayout$AdapterChangeListener(TabLayout tabLayout) {
        this.this$0 = tabLayout;
    }

    public void onAdapterChanged(ViewPager viewPager, PagerAdapter object, PagerAdapter pagerAdapter) {
        object = this.this$0;
        ViewPager viewPager2 = ((TabLayout)object).viewPager;
        if (viewPager2 == viewPager) {
            boolean bl2 = this.autoRefresh;
            ((TabLayout)((Object)object)).setPagerAdapter(pagerAdapter, bl2);
        }
    }

    public void setAutoRefresh(boolean bl2) {
        this.autoRefresh = bl2;
    }
}

