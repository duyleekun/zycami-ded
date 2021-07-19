/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.viewpager2.widget;

import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.viewpager2.widget.CompositeOnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$1;

public abstract class ViewPager2$AccessibilityProvider {
    public final /* synthetic */ ViewPager2 this$0;

    private ViewPager2$AccessibilityProvider(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public /* synthetic */ ViewPager2$AccessibilityProvider(ViewPager2 viewPager2, ViewPager2.1 var2_2) {
        this(viewPager2);
    }

    public boolean handlesGetAccessibilityClassName() {
        return false;
    }

    public boolean handlesLmPerformAccessibilityAction(int n10) {
        return false;
    }

    public boolean handlesPerformAccessibilityAction(int n10, Bundle bundle) {
        return false;
    }

    public boolean handlesRvGetAccessibilityClassName() {
        return false;
    }

    public void onAttachAdapter(RecyclerView$Adapter recyclerView$Adapter) {
    }

    public void onDetachAdapter(RecyclerView$Adapter recyclerView$Adapter) {
    }

    public String onGetAccessibilityClassName() {
        IllegalStateException illegalStateException = new IllegalStateException("Not implemented.");
        throw illegalStateException;
    }

    public void onInitialize(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public boolean onLmPerformAccessibilityAction(int n10) {
        IllegalStateException illegalStateException = new IllegalStateException("Not implemented.");
        throw illegalStateException;
    }

    public boolean onPerformAccessibilityAction(int n10, Bundle bundle) {
        IllegalStateException illegalStateException = new IllegalStateException("Not implemented.");
        throw illegalStateException;
    }

    public void onRestorePendingState() {
    }

    public CharSequence onRvGetAccessibilityClassName() {
        IllegalStateException illegalStateException = new IllegalStateException("Not implemented.");
        throw illegalStateException;
    }

    public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    public void onSetLayoutDirection() {
    }

    public void onSetNewCurrentItem() {
    }

    public void onSetOrientation() {
    }

    public void onSetUserInputEnabled() {
    }
}

