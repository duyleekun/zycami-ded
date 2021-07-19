/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.widget;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$AccessibilityProvider;

public class ViewPager2$BasicAccessibilityProvider
extends ViewPager2$AccessibilityProvider {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$BasicAccessibilityProvider(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
        super(viewPager2, null);
    }

    public boolean handlesLmPerformAccessibilityAction(int n10) {
        ViewPager2 viewPager2;
        int n11 = 8192;
        if ((n10 == n11 || n10 == (n11 = 4096)) && (n10 = (int)((viewPager2 = this.this$0).isUserInputEnabled() ? 1 : 0)) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            viewPager2 = null;
        }
        return n10 != 0;
    }

    public boolean handlesRvGetAccessibilityClassName() {
        return true;
    }

    public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object object = this.this$0;
        boolean bl2 = object.isUserInputEnabled();
        if (!bl2) {
            object = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_BACKWARD;
            accessibilityNodeInfoCompat.removeAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object);
            object = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_FORWARD;
            accessibilityNodeInfoCompat.removeAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object);
            bl2 = false;
            object = null;
            accessibilityNodeInfoCompat.setScrollable(false);
        }
    }

    public boolean onLmPerformAccessibilityAction(int n10) {
        if ((n10 = (int)(this.handlesLmPerformAccessibilityAction(n10) ? 1 : 0)) != 0) {
            return false;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public CharSequence onRvGetAccessibilityClassName() {
        boolean bl2 = this.handlesRvGetAccessibilityClassName();
        if (bl2) {
            return "androidx.viewpager.widget.ViewPager";
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

