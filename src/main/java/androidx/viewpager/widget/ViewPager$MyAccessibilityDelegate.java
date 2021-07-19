/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.viewpager.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPager$MyAccessibilityDelegate
extends AccessibilityDelegateCompat {
    public final /* synthetic */ ViewPager this$0;

    public ViewPager$MyAccessibilityDelegate(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    private boolean canScroll() {
        int n10;
        PagerAdapter pagerAdapter = this.this$0.mAdapter;
        int n11 = 1;
        if (pagerAdapter == null || (n10 = pagerAdapter.getCount()) <= n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void onInitializeAccessibilityEvent(View object, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent((View)object, accessibilityEvent);
        object = ViewPager.class.getName();
        accessibilityEvent.setClassName((CharSequence)object);
        int n10 = this.canScroll();
        accessibilityEvent.setScrollable(n10 != 0);
        n10 = accessibilityEvent.getEventType();
        int n11 = 4096;
        if (n10 == n11 && (object = this.this$0.mAdapter) != null) {
            n10 = object.getCount();
            accessibilityEvent.setItemCount(n10);
            n10 = this.this$0.mCurItem;
            accessibilityEvent.setFromIndex(n10);
            object = this.this$0;
            n10 = object.mCurItem;
            accessibilityEvent.setToIndex(n10);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean bl2;
        super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        object = ViewPager.class.getName();
        accessibilityNodeInfoCompat.setClassName((CharSequence)object);
        boolean n10 = this.canScroll();
        accessibilityNodeInfoCompat.setScrollable(n10);
        object = this.this$0;
        int n11 = 1;
        boolean bl3 = ((ViewPager)((Object)object)).canScrollHorizontally(n11);
        if (bl3) {
            int n12 = 4096;
            accessibilityNodeInfoCompat.addAction(n12);
        }
        if (bl2 = ((ViewPager)((Object)(object = this.this$0))).canScrollHorizontally(n11 = -1)) {
            int n13 = 8192;
            accessibilityNodeInfoCompat.addAction(n13);
        }
    }

    public boolean performAccessibilityAction(View object, int n10, Bundle bundle) {
        int n11 = super.performAccessibilityAction((View)object, n10, bundle);
        int n12 = 1;
        if (n11 != 0) {
            return n12 != 0;
        }
        n11 = 4096;
        if (n10 != n11) {
            n11 = 8192;
            if (n10 != n11) {
                return false;
            }
            object = this.this$0;
            n10 = -1;
            n11 = (int)(object.canScrollHorizontally(n10) ? 1 : 0);
            if (n11 != 0) {
                object = this.this$0;
                n10 = object.mCurItem - n12;
                object.setCurrentItem(n10);
                return n12 != 0;
            }
            return false;
        }
        object = this.this$0;
        n11 = (int)(object.canScrollHorizontally(n12) ? 1 : 0);
        if (n11 != 0) {
            object = this.this$0;
            n10 = object.mCurItem + n12;
            object.setCurrentItem(n10);
            return n12 != 0;
        }
        return false;
    }
}

