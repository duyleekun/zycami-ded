/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.style.ClickableSpan
 *  android.view.View
 */
package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public final class AccessibilityClickableSpanCompat
extends ClickableSpan {
    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
    private final int mClickableSpanActionId;
    private final AccessibilityNodeInfoCompat mNodeInfoCompat;
    private final int mOriginalClickableSpanId;

    public AccessibilityClickableSpanCompat(int n10, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int n11) {
        this.mOriginalClickableSpanId = n10;
        this.mNodeInfoCompat = accessibilityNodeInfoCompat;
        this.mClickableSpanActionId = n11;
    }

    public void onClick(View view) {
        view = new Bundle();
        int n10 = this.mOriginalClickableSpanId;
        view.putInt(SPAN_ID, n10);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.mNodeInfoCompat;
        int n11 = this.mClickableSpanActionId;
        accessibilityNodeInfoCompat.performAction(n11, (Bundle)view);
    }
}

