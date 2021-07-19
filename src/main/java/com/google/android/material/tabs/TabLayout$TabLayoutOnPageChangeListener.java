/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.tabs;

import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$Tab;
import java.lang.ref.WeakReference;

public class TabLayout$TabLayoutOnPageChangeListener
implements ViewPager$OnPageChangeListener {
    private int previousScrollState;
    private int scrollState;
    private final WeakReference tabLayoutRef;

    public TabLayout$TabLayoutOnPageChangeListener(TabLayout tabLayout) {
        WeakReference<TabLayout> weakReference;
        this.tabLayoutRef = weakReference = new WeakReference<TabLayout>(tabLayout);
    }

    public void onPageScrollStateChanged(int n10) {
        int n11;
        this.previousScrollState = n11 = this.scrollState;
        this.scrollState = n10;
    }

    public void onPageScrolled(int n10, float f10, int n11) {
        TabLayout tabLayout = (TabLayout)((Object)this.tabLayoutRef.get());
        if (tabLayout != null) {
            boolean bl2;
            int n12 = this.scrollState;
            boolean bl3 = false;
            int n13 = 2;
            boolean bl4 = true;
            bl2 = n12 == n13 && (bl2 = this.previousScrollState) != bl4 ? false : bl4;
            if (n12 != n13 || (n12 = this.previousScrollState) != 0) {
                bl3 = bl4;
            }
            tabLayout.setScrollPosition(n10, f10, bl2, bl3);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void onPageSelected(int n10) {
        int n11;
        int n112;
        TabLayout tabLayout = (TabLayout)((Object)this.tabLayoutRef.get());
        if (tabLayout != null && (n112 = tabLayout.getSelectedTabPosition()) != n10 && n10 < (n11 = tabLayout.getTabCount())) {
            void var3_9;
            int n12;
            int n13;
            int n14 = this.scrollState;
            if (n14 != 0 && (n14 != (n13 = 2) || (n12 = this.previousScrollState) != 0)) {
                boolean bl2 = false;
            } else {
                boolean bl3 = true;
            }
            TabLayout$Tab tabLayout$Tab = tabLayout.getTabAt(n10);
            tabLayout.selectTab(tabLayout$Tab, (boolean)var3_9);
        }
    }

    public void reset() {
        this.scrollState = 0;
        this.previousScrollState = 0;
    }
}

