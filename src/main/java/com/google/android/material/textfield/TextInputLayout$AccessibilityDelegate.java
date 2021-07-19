/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 */
package com.google.android.material.textfield;

import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputLayout$AccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final TextInputLayout layout;

    public TextInputLayout$AccessibilityDelegate(TextInputLayout textInputLayout) {
        this.layout = textInputLayout;
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean bl2;
        super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        object = this.layout.getEditText();
        object = object != null ? object.getText() : null;
        CharSequence charSequence = this.layout.getHint();
        CharSequence charSequence2 = this.layout.getError();
        CharSequence charSequence3 = this.layout.getCounterOverflowDescription();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        boolean bl4 = true;
        bl3 ^= bl4;
        boolean bl5 = TextUtils.isEmpty((CharSequence)charSequence) ^ bl4;
        boolean bl6 = TextUtils.isEmpty((CharSequence)charSequence2) ^ bl4;
        boolean bl7 = false;
        bl2 = !bl6 && (bl2 = TextUtils.isEmpty((CharSequence)charSequence3)) ? false : bl4;
        if (bl3) {
            accessibilityNodeInfoCompat.setText((CharSequence)object);
        } else if (bl5) {
            accessibilityNodeInfoCompat.setText(charSequence);
        }
        if (bl5) {
            accessibilityNodeInfoCompat.setHintText(charSequence);
            if (!bl3 && bl5) {
                bl7 = bl4;
            }
            accessibilityNodeInfoCompat.setShowingHintText(bl7);
        }
        if (bl2) {
            if (!bl6) {
                charSequence2 = charSequence3;
            }
            accessibilityNodeInfoCompat.setError(charSequence2);
            accessibilityNodeInfoCompat.setContentInvalid(bl4);
        }
    }

    public void onPopulateAccessibilityEvent(View object, AccessibilityEvent object2) {
        super.onPopulateAccessibilityEvent((View)object, (AccessibilityEvent)object2);
        object = this.layout.getEditText();
        object = object != null ? object.getText() : null;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.layout.getHint();
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object2 = object2.getText();
            object2.add(object);
        }
    }
}

