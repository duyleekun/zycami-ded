/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.viewpager2.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$AccessibilityProvider;

public class ViewPager2$RecyclerViewImpl
extends RecyclerView {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$RecyclerViewImpl(ViewPager2 viewPager2, Context context) {
        this.this$0 = viewPager2;
        super(context);
    }

    public CharSequence getAccessibilityClassName() {
        ViewPager2$AccessibilityProvider viewPager2$AccessibilityProvider = this.this$0.mAccessibilityProvider;
        boolean bl2 = viewPager2$AccessibilityProvider.handlesRvGetAccessibilityClassName();
        if (bl2) {
            return this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName();
        }
        return super.getAccessibilityClassName();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        int n10 = this.this$0.mCurrentItem;
        accessibilityEvent.setFromIndex(n10);
        n10 = this.this$0.mCurrentItem;
        accessibilityEvent.setToIndex(n10);
        this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        ViewPager2 viewPager2 = this.this$0;
        boolean bl3 = viewPager2.isUserInputEnabled();
        if (bl3 && (bl2 = super.onInterceptTouchEvent(motionEvent))) {
            bl2 = true;
        } else {
            bl2 = false;
            motionEvent = null;
        }
        return bl2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        ViewPager2 viewPager2 = this.this$0;
        boolean bl3 = viewPager2.isUserInputEnabled();
        if (bl3 && (bl2 = super.onTouchEvent(motionEvent))) {
            bl2 = true;
        } else {
            bl2 = false;
            motionEvent = null;
        }
        return bl2;
    }
}

