/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.View
 */
package androidx.viewpager2.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$AccessibilityProvider;

public class ViewPager2$LinearLayoutManagerImpl
extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$LinearLayoutManagerImpl(ViewPager2 viewPager2, Context context) {
        this.this$0 = viewPager2;
        super(context);
    }

    public void calculateExtraLayoutSpace(RecyclerView$State recyclerView$State, int[] nArray) {
        int n10;
        int n11;
        ViewPager2 viewPager2 = this.this$0;
        int n12 = viewPager2.getOffscreenPageLimit();
        if (n12 == (n11 = -1)) {
            super.calculateExtraLayoutSpace(recyclerView$State, nArray);
            return;
        }
        nArray[0] = n10 = this.this$0.getPageSize() * n12;
        nArray[1] = n10;
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recyclerView$Recycler, recyclerView$State, accessibilityNodeInfoCompat);
        this.this$0.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
    }

    public boolean performAccessibilityAction(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int n10, Bundle bundle) {
        ViewPager2$AccessibilityProvider viewPager2$AccessibilityProvider = this.this$0.mAccessibilityProvider;
        boolean bl2 = viewPager2$AccessibilityProvider.handlesLmPerformAccessibilityAction(n10);
        if (bl2) {
            return this.this$0.mAccessibilityProvider.onLmPerformAccessibilityAction(n10);
        }
        return super.performAccessibilityAction(recyclerView$Recycler, recyclerView$State, n10, bundle);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean bl2, boolean bl3) {
        return false;
    }
}

