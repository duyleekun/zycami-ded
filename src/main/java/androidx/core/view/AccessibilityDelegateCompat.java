/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.style.ClickableSpan
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE;
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    static {
        View.AccessibilityDelegate accessibilityDelegate;
        DEFAULT_DELEGATE = accessibilityDelegate = new View.AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        View.AccessibilityDelegate accessibilityDelegate = DEFAULT_DELEGATE;
        this(accessibilityDelegate);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        super(this);
        this.mBridge = accessibilityDelegate;
    }

    public static List getActionList(View object) {
        int n10 = R$id.tag_accessibility_actions;
        if ((object = (List)object.getTag(n10)) == null) {
            object = Collections.emptyList();
        }
        return object;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View clickableSpanArray) {
        if (clickableSpan != null) {
            int n10;
            clickableSpanArray = AccessibilityNodeInfoCompat.getClickableSpans(clickableSpanArray.createAccessibilityNodeInfo().getText());
            for (int i10 = 0; clickableSpanArray != null && i10 < (n10 = clickableSpanArray.length); ++i10) {
                ClickableSpan clickableSpan2 = clickableSpanArray[i10];
                n10 = (int)(clickableSpan.equals(clickableSpan2) ? 1 : 0);
                if (n10 == 0) continue;
                return true;
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int n10, View view) {
        WeakReference weakReference;
        int n11 = R$id.tag_accessibility_clickable_spans;
        SparseArray sparseArray = (SparseArray)view.getTag(n11);
        if (sparseArray != null && (weakReference = (WeakReference)sparseArray.get(n10)) != null && (n11 = (int)(this.isSpanStillValid((ClickableSpan)(weakReference = (ClickableSpan)weakReference.get()), view) ? 1 : 0)) != 0) {
            weakReference.onClick(view);
            return true;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11 && (view = (object = this.mOriginalDelegate).getAccessibilityNodeProvider(view)) != null) {
            object = new AccessibilityNodeProviderCompat(view);
            return object;
        }
        return null;
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
        accessibilityNodeInfoCompat = accessibilityNodeInfoCompat.unwrap();
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)accessibilityNodeInfoCompat);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int n10, Bundle bundle) {
        int n11;
        int n12;
        int n13;
        Object object = AccessibilityDelegateCompat.getActionList(view);
        boolean bl2 = false;
        for (n13 = 0; n13 < (n12 = object.size()); ++n13) {
            AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object.get(n13);
            int n14 = accessibilityNodeInfoCompat$AccessibilityActionCompat.getId();
            if (n14 != n10) continue;
            bl2 = accessibilityNodeInfoCompat$AccessibilityActionCompat.perform(view, bundle);
            break;
        }
        if (!bl2 && (n11 = Build.VERSION.SDK_INT) >= (n13 = 16)) {
            object = this.mOriginalDelegate;
            bl2 = object.performAccessibilityAction(view, n10, bundle);
        }
        if (!bl2 && n10 == (n11 = R$id.accessibility_action_clickable_span)) {
            object = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
            n10 = bundle.getInt((String)object, -1);
            bl2 = this.performClickableSpanAction(n10, view);
        }
        return bl2;
    }

    public void sendAccessibilityEvent(View view, int n10) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, n10);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}

