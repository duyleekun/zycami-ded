/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.drawerlayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerLayout$AccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final Rect mTmpRect;
    public final /* synthetic */ DrawerLayout this$0;

    public DrawerLayout$AccessibilityDelegate(DrawerLayout drawerLayout) {
        this.this$0 = drawerLayout;
        this.mTmpRect = drawerLayout;
    }

    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
        int n10 = viewGroup.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = viewGroup.getChildAt(i10);
            boolean bl2 = DrawerLayout.includeChildForAccessibility(view);
            if (!bl2) continue;
            accessibilityNodeInfoCompat.addChild(view);
        }
    }

    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
        Object object = this.mTmpRect;
        accessibilityNodeInfoCompat2.getBoundsInScreen((Rect)object);
        accessibilityNodeInfoCompat.setBoundsInScreen((Rect)object);
        boolean bl2 = accessibilityNodeInfoCompat2.isVisibleToUser();
        accessibilityNodeInfoCompat.setVisibleToUser(bl2);
        object = accessibilityNodeInfoCompat2.getPackageName();
        accessibilityNodeInfoCompat.setPackageName((CharSequence)object);
        object = accessibilityNodeInfoCompat2.getClassName();
        accessibilityNodeInfoCompat.setClassName((CharSequence)object);
        object = accessibilityNodeInfoCompat2.getContentDescription();
        accessibilityNodeInfoCompat.setContentDescription((CharSequence)object);
        bl2 = accessibilityNodeInfoCompat2.isEnabled();
        accessibilityNodeInfoCompat.setEnabled(bl2);
        bl2 = accessibilityNodeInfoCompat2.isFocused();
        accessibilityNodeInfoCompat.setFocused(bl2);
        bl2 = accessibilityNodeInfoCompat2.isAccessibilityFocused();
        accessibilityNodeInfoCompat.setAccessibilityFocused(bl2);
        bl2 = accessibilityNodeInfoCompat2.isSelected();
        accessibilityNodeInfoCompat.setSelected(bl2);
        int n10 = accessibilityNodeInfoCompat2.getActions();
        accessibilityNodeInfoCompat.addAction(n10);
    }

    public boolean dispatchPopulateAccessibilityEvent(View object, AccessibilityEvent object2) {
        int n10;
        int n11 = object2.getEventType();
        if (n11 == (n10 = 32)) {
            int n12;
            DrawerLayout drawerLayout;
            object = object2.getText();
            object2 = this.this$0.findVisibleDrawer();
            if (object2 != null && (object2 = (drawerLayout = this.this$0).getDrawerTitle(n12 = this.this$0.getDrawerViewAbsoluteGravity((View)object2))) != null) {
                object.add(object2);
            }
            return true;
        }
        return super.dispatchPopulateAccessibilityEvent((View)object, (AccessibilityEvent)object2);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)"androidx.drawerlayout.widget.DrawerLayout");
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean bl2 = DrawerLayout.CAN_HIDE_DESCENDANTS;
        if (bl2) {
            super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        } else {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat2);
            accessibilityNodeInfoCompat.setSource((View)object);
            ViewParent viewParent = ViewCompat.getParentForAccessibility(object);
            boolean bl3 = viewParent instanceof View;
            if (bl3) {
                viewParent = (View)viewParent;
                accessibilityNodeInfoCompat.setParent((View)viewParent);
            }
            this.copyNodeInfoNoChildren(accessibilityNodeInfoCompat, accessibilityNodeInfoCompat2);
            accessibilityNodeInfoCompat2.recycle();
            object = (ViewGroup)object;
            this.addChildrenForAccessibility(accessibilityNodeInfoCompat, (ViewGroup)object);
        }
        accessibilityNodeInfoCompat.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        accessibilityNodeInfoCompat.setFocusable(false);
        accessibilityNodeInfoCompat.setFocused(false);
        object = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_FOCUS;
        accessibilityNodeInfoCompat.removeAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object);
        object = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_CLEAR_FOCUS;
        accessibilityNodeInfoCompat.removeAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean bl2 = DrawerLayout.CAN_HIDE_DESCENDANTS;
        if (!bl2 && !(bl2 = DrawerLayout.includeChildForAccessibility(view))) {
            return false;
        }
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}

