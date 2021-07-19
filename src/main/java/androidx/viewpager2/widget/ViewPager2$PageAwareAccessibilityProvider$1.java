/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.viewpager2.widget;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider;

public class ViewPager2$PageAwareAccessibilityProvider$1
implements AccessibilityViewCommand {
    public final /* synthetic */ ViewPager2$PageAwareAccessibilityProvider this$1;

    public ViewPager2$PageAwareAccessibilityProvider$1(ViewPager2$PageAwareAccessibilityProvider viewPager2$PageAwareAccessibilityProvider) {
        this.this$1 = viewPager2$PageAwareAccessibilityProvider;
    }

    public boolean perform(View object, AccessibilityViewCommand$CommandArguments object2) {
        object = (ViewPager2)((Object)object);
        object2 = this.this$1;
        int n10 = ((ViewPager2)((Object)object)).getCurrentItem();
        int n11 = 1;
        ((ViewPager2$PageAwareAccessibilityProvider)object2).setCurrentItemFromAccessibilityCommand(n10 += n11);
        return n11 != 0;
    }
}

