/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2$DataSetChangeObserver;
import androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider;

public class ViewPager2$PageAwareAccessibilityProvider$3
extends ViewPager2$DataSetChangeObserver {
    public final /* synthetic */ ViewPager2$PageAwareAccessibilityProvider this$1;

    public ViewPager2$PageAwareAccessibilityProvider$3(ViewPager2$PageAwareAccessibilityProvider viewPager2$PageAwareAccessibilityProvider) {
        this.this$1 = viewPager2$PageAwareAccessibilityProvider;
        super(null);
    }

    public void onChanged() {
        this.this$1.updatePageAccessibilityActions();
    }
}

