/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$AccessibilityProvider;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;

public class ViewPager2$2
extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$2(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public void onPageScrollStateChanged(int n10) {
        if (n10 == 0) {
            ViewPager2 viewPager2 = this.this$0;
            viewPager2.updateCurrentItem();
        }
    }

    public void onPageSelected(int n10) {
        ViewPager2 viewPager2 = this.this$0;
        int n11 = viewPager2.mCurrentItem;
        if (n11 != n10) {
            viewPager2.mCurrentItem = n10;
            ViewPager2$AccessibilityProvider viewPager2$AccessibilityProvider = viewPager2.mAccessibilityProvider;
            viewPager2$AccessibilityProvider.onSetNewCurrentItem();
        }
    }
}

